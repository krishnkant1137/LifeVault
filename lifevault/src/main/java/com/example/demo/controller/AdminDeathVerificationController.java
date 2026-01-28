package com.example.demo.controller;

import com.example.demo.dto.DecisionDTO;
import com.example.demo.entity.DeathVerificationRequest;
import com.example.demo.service.DeathVerificationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/death-verification")
public class AdminDeathVerificationController {

    private final DeathVerificationService service;

    public AdminDeathVerificationController(DeathVerificationService service) {
        this.service = service;
    }

    @GetMapping("/requests/pending")
    public List<DeathVerificationRequest> pending() {
        return service.getPending();
    }

    @PostMapping("/requests/{id}/decision")
    public void decide(@PathVariable Long id, @RequestBody DecisionDTO dto) {

        System.out.println("🔥 ADMIN DECIDE API HIT 🔥");
        System.out.println("Request ID = " + id);
        System.out.println("Decision = " + dto.getDecision());
        
        service.decide(id, dto.getDecision());
    }
}
