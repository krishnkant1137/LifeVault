package com.example.demo.dto;

import java.util.List;

public class OwnerDashboardResponseDTO {

    private List<VaultFolderResponseDTO> folders;
    private List<OwnerNomineeDTO> nominees;

    public OwnerDashboardResponseDTO(
            List<VaultFolderResponseDTO> folders,
            List<OwnerNomineeDTO> nominees
    ) {
        this.folders = folders;
        this.nominees = nominees;
    }

    public List<VaultFolderResponseDTO> getFolders() {
        return folders;
    }

    public List<OwnerNomineeDTO> getNominees() {
        return nominees;
    }
}
