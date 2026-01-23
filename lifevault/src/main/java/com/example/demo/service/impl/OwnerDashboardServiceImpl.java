package com.example.demo.service.impl;

import com.example.demo.dto.*;
import com.example.demo.entity.OwnerNominee;
import com.example.demo.repository.OwnerNomineeRepository;
import com.example.demo.repository.VaultFolderRepository;
import com.example.demo.service.OwnerDashboardService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OwnerDashboardServiceImpl implements OwnerDashboardService {

    private final VaultFolderRepository folderRepository;
    private final OwnerNomineeRepository ownerNomineeRepository;

    public OwnerDashboardServiceImpl(
            VaultFolderRepository folderRepository,
            OwnerNomineeRepository ownerNomineeRepository
    ) {
        this.folderRepository = folderRepository;
        this.ownerNomineeRepository = ownerNomineeRepository;
    }

    @Override
    public OwnerDashboardResponseDTO getDashboard(Long ownerId) {

        // folders
        List<VaultFolderResponseDTO> folders =
                folderRepository.findByOwnerId(ownerId)
                        .stream()
                        .map(VaultFolderMapper::toDto)
                        .collect(Collectors.toList());

        // nominees
        List<OwnerNomineeDTO> nominees =
                ownerNomineeRepository.findByOwnerId(ownerId)
                        .stream()
                        .map(this::mapNominee)
                        .collect(Collectors.toList());

        return new OwnerDashboardResponseDTO(folders, nominees);
    }

    private OwnerNomineeDTO mapNominee(OwnerNominee on) {
        return new OwnerNomineeDTO(
                on.getNominee().getId(),
                on.getNominee().getFullName(),
                on.getNominee().getEmail(),
                on.getRelationship()
        );
    }
}
