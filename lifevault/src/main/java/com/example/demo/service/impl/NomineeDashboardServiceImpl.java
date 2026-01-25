package com.example.demo.service.impl;

import com.example.demo.dto.NomineeFolderDTO;
import com.example.demo.entity.OwnerNominee;
import com.example.demo.entity.VaultFolder;
import com.example.demo.repository.OwnerNomineeRepository;
import com.example.demo.repository.VaultFolderRepository;
import com.example.demo.service.NomineeDashboardService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NomineeDashboardServiceImpl implements NomineeDashboardService {

    private final OwnerNomineeRepository ownerNomineeRepository;
    private final VaultFolderRepository vaultFolderRepository;

    public NomineeDashboardServiceImpl(
            OwnerNomineeRepository ownerNomineeRepository,
            VaultFolderRepository vaultFolderRepository
    ) {
        this.ownerNomineeRepository = ownerNomineeRepository;
        this.vaultFolderRepository = vaultFolderRepository;
    }

    @Override
    public List<NomineeFolderDTO> getReleasedFolders(Long nomineeId) {

        List<OwnerNominee> mappings =
                ownerNomineeRepository.findByNomineeId(nomineeId);

        List<NomineeFolderDTO> response = new ArrayList<>();

        for (OwnerNominee mapping : mappings) {
            Long ownerId = mapping.getOwner().getId();

            List<VaultFolder> releasedFolders =
                    vaultFolderRepository.findByOwnerIdAndIsReleasedTrue(ownerId);

            for (VaultFolder folder : releasedFolders) {
                response.add(new NomineeFolderDTO(
                        folder.getId(),
                        folder.getFolderName(),
                        folder.getCreatedAt()
                ));
            }
        }

        return response;
    }
}
