package com.example.demo.dto;

import com.example.demo.entity.Nominee;

public class NomineeMapper {

    public static NomineeResponseDTO toDto(Nominee n) {
        return new NomineeResponseDTO(
                n.getId(),
                n.getFullName(),
                n.getEmail(),
                n.getPhone()
        );
    }
}
