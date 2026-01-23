package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.VaultFolder;

public interface VaultFolderService {

    VaultFolder createFolder(Long ownerId, String folderName);

    List<VaultFolder> getFoldersByOwner(Long ownerId);
}