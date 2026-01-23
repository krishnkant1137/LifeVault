package com.example.demo.dto;

import java.time.LocalDateTime;

public class VaultFolderResponseDTO {

    private Long id;
    private String folderName;
    private Boolean isReleased;
    private LocalDateTime createdAt;

    public VaultFolderResponseDTO(Long id, String folderName,
                                  Boolean isReleased, LocalDateTime createdAt) {
        this.id = id;
        this.folderName = folderName;
        this.isReleased = isReleased;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public String getFolderName() {
        return folderName;
    }

    public Boolean getIsReleased() {
        return isReleased;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
