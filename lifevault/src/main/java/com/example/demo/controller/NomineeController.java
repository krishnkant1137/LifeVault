package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.entity.Nominee;
import com.example.demo.service.NomineeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/nominees")
public class NomineeController {

    private final NomineeService nomineeService;

    public NomineeController(NomineeService nomineeService) {
        this.nomineeService = nomineeService;
    }

    @PostMapping
    public NomineeResponseDTO create(@RequestBody NomineeRequestDTO req) {
        Nominee n = nomineeService.createNominee(
                req.getFullName(),
                req.getEmail(),
                req.getPhone()
        );
        return NomineeMapper.toDto(n);
    }

    @GetMapping
    public List<NomineeResponseDTO> list() {
        return nomineeService.getAllNominees()
                .stream()
                .map(NomineeMapper::toDto)
                .collect(Collectors.toList());
    }
}
