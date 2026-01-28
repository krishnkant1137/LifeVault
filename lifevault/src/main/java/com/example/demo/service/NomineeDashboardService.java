package com.example.demo.service;

import com.example.demo.dto.NomineeFolderDTO;
import java.util.List;

public interface NomineeDashboardService {
    List<NomineeFolderDTO> getReleasedFolders(Long nomineeId);

}
