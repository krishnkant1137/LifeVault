package com.example.demo.controller;

import com.example.demo.dto.AssignNomineeRequestDTO;
import com.example.demo.dto.AssignNomineeResponseDTO;
import com.example.demo.entity.OwnerNominee;
import com.example.demo.service.OwnerNomineeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/owner-nominees")
public class OwnerNomineeController {

    private final OwnerNomineeService ownerNomineeService;

    public OwnerNomineeController(OwnerNomineeService ownerNomineeService) {
        this.ownerNomineeService = ownerNomineeService;
    }

    @PostMapping
    public AssignNomineeResponseDTO assign(@RequestBody AssignNomineeRequestDTO req) {
        OwnerNominee mapping = ownerNomineeService.assignNominee(
                req.getOwnerId(),
                req.getNomineeId(),
                req.getRelationship()
        );

        return new AssignNomineeResponseDTO(
                mapping.getOwner().getId(),
                mapping.getNominee().getId(),
                mapping.getRelationship()
        );
    }
}
