package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "vault_folders")
public class VaultFolder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;

    @Column(name = "folder_name", nullable = false)
    private String folderName;

    @Column(name = "is_released")
    private Boolean isReleased = false;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    public VaultFolder() {}

    public Long getId() {
        return id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    public Boolean getIsReleased() {
        return isReleased;
    }

    public void setIsReleased(Boolean released) {
        isReleased = released;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}

