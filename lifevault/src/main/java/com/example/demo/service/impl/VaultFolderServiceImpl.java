package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.entity.VaultFolder;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.VaultFolderRepository;
import com.example.demo.service.VaultFolderService;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VaultFolderServiceImpl implements VaultFolderService {

    private final VaultFolderRepository folderRepository;
    private final UserRepository userRepository;

    public VaultFolderServiceImpl(VaultFolderRepository folderRepository,
                                  UserRepository userRepository) {
        this.folderRepository = folderRepository;
        this.userRepository = userRepository;
    }

    @PreAuthorize("hasRole('OWNER')")
    @Override
    public VaultFolder createFolder(Long ownerId, String folderName) {

        User owner = userRepository.findById(ownerId)
        		 .orElseThrow(() -> new ResourceNotFoundException("Owner not found"));
        VaultFolder folder = new VaultFolder();
        folder.setOwner(owner);
        folder.setFolderName(folderName);

        return folderRepository.save(folder);
    }

    @Override
    public List<VaultFolder> getFoldersByOwner(Long ownerId) {
        return folderRepository.findByOwnerId(ownerId);
    }
}
