package com.example.demo.controller;

import com.example.demo.dto.NomineeFolderDTO;
import com.example.demo.service.NomineeDashboardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/nominee-dashboard")
public class NomineeDashboardController {

    private final NomineeDashboardService nomineeDashboardService;

    public NomineeDashboardController(NomineeDashboardService nomineeDashboardService) {
        this.nomineeDashboardService = nomineeDashboardService;
    }

    @GetMapping("/{nomineeId}")
    public List<NomineeFolderDTO> getDashboard(@PathVariable Long nomineeId) {
        return nomineeDashboardService.getReleasedFolders(nomineeId);
    }
}
