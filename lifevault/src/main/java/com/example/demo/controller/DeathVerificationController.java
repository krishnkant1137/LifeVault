package com.example.demo.controller;

import com.example.demo.dto.DeathVerificationRequestDTO;
import com.example.demo.entity.DeathVerificationRequest;
import com.example.demo.service.DeathVerificationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/death-verification")
public class DeathVerificationController {

    private final DeathVerificationService service;

    public DeathVerificationController(DeathVerificationService service) {
        this.service = service;
    }

    @PostMapping("/requests")
    public DeathVerificationRequest create(@RequestBody DeathVerificationRequestDTO dto) {
        return service.createRequest(dto.getNomineeId(), dto.getOwnerId(), dto.getNote());
    }
}
