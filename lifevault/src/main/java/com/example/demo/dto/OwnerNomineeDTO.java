package com.example.demo.dto;

public class OwnerNomineeDTO {

    private Long nomineeId;
    private String fullName;
    private String email;
    private String relationship;

    public OwnerNomineeDTO(Long nomineeId, String fullName,
                           String email, String relationship) {
        this.nomineeId = nomineeId;
        this.fullName = fullName;
        this.email = email;
        this.relationship = relationship;
    }

    public Long getNomineeId() { return nomineeId; }
    public String getFullName() { return fullName; }
    public String getEmail() { return email; }
    public String getRelationship() { return relationship; }
}
