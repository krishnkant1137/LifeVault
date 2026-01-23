package com.example.demo.dto;

import com.example.demo.entity.VaultFolder;

public class VaultFolderMapper {

    public static VaultFolderResponseDTO toDto(VaultFolder folder) {
        return new VaultFolderResponseDTO(
                folder.getId(),
                folder.getFolderName().trim(),
                folder.getIsReleased(),
                folder.getCreatedAt()
        );
    }
}
