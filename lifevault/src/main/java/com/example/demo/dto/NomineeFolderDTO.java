package com.example.demo.dto;

import java.time.LocalDateTime;

public class NomineeFolderDTO {

    private Long folderId;
    private String folderName;
    private LocalDateTime releasedAt;

    public NomineeFolderDTO(Long folderId, String folderName, LocalDateTime releasedAt) {
        this.folderId = folderId;
        this.folderName = folderName;
        this.releasedAt = releasedAt;
    }

    public Long getFolderId() { return folderId; }
    public String getFolderName() { return folderName; }
    public LocalDateTime getReleasedAt() { return releasedAt; }
}
