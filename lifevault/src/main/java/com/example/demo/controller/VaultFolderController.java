package com.example.demo.controller;

import com.example.demo.dto.VaultFolderMapper;
import com.example.demo.dto.VaultFolderResponseDTO;
import com.example.demo.entity.VaultFolder;
import com.example.demo.service.VaultFolderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/folders")
public class VaultFolderController {

    private final VaultFolderService vaultFolderService;

    public VaultFolderController(VaultFolderService vaultFolderService) {
        this.vaultFolderService = vaultFolderService;
    }

    @PostMapping
    public VaultFolderResponseDTO createFolder(@RequestParam Long ownerId,
                                               @RequestParam String folderName) {

        VaultFolder folder =
                vaultFolderService.createFolder(ownerId, folderName);

        return VaultFolderMapper.toDto(folder);
    }

    @GetMapping("/owner/{ownerId}")
    public List<VaultFolderResponseDTO> getFolders(@PathVariable Long ownerId) {

        return vaultFolderService.getFoldersByOwner(ownerId)
                .stream()
                .map(VaultFolderMapper::toDto)
                .collect(Collectors.toList());
    }
}
