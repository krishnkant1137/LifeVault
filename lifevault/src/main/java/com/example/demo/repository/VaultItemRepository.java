package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.VaultItem;

import java.util.List;

public interface VaultItemRepository extends JpaRepository<VaultItem, Long> {

    List<VaultItem> findByFolderId(Long folderId);
}