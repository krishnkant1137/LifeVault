package com.example.demo.controller;

import com.example.demo.dto.OwnerDashboardResponseDTO;
import com.example.demo.service.OwnerDashboardService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/owner-dashboard")
public class OwnerDashboardController {

    private final OwnerDashboardService ownerDashboardService;

    public OwnerDashboardController(OwnerDashboardService ownerDashboardService) {
        this.ownerDashboardService = ownerDashboardService;
    }

    @GetMapping("/{ownerId}")
    public OwnerDashboardResponseDTO dashboard(@PathVariable Long ownerId) {
        return ownerDashboardService.getDashboard(ownerId);
    }
}
