package com.example.demo.controller;

import com.example.demo.dto.NomineeFolderDTO;
import com.example.demo.service.NomineeDashboardService;
import com.example.demo.service.VaultFolderService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/nominee-dashboard")
public class NomineeDashboardController {

    private final NomineeDashboardService nomineeDashboardService;
    private final VaultFolderService  folderService;
    

    public NomineeDashboardController(NomineeDashboardService nomineeDashboardService, VaultFolderService  folderService) {
        this.nomineeDashboardService = nomineeDashboardService;
        this.folderService = folderService;
    }

    @GetMapping("/{nomineeId}")
    public List<NomineeFolderDTO> getDashboard(@PathVariable Long nomineeId) {
        return nomineeDashboardService.getReleasedFolders(nomineeId);
    }
    
    @GetMapping("/{nomineeId}/folders")
    public List<NomineeFolderDTO> getFolders(@PathVariable Long nomineeId) {
        return nomineeDashboardService.getReleasedFolders(nomineeId);
    }
}
