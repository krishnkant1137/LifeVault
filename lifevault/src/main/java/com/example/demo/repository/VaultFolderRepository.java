package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.VaultFolder;

import java.util.List;

public interface VaultFolderRepository extends JpaRepository<VaultFolder, Long> {

    List<VaultFolder> findByOwnerId(Long ownerId);
    List<VaultFolder> findByOwnerIdAndIsReleasedTrue(Long ownerId);

}