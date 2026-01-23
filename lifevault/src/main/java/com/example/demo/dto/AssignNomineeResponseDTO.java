package com.example.demo.dto;

public class AssignNomineeResponseDTO {
    private Long ownerId;
    private Long nomineeId;
    private String relationship;

    public AssignNomineeResponseDTO(Long ownerId, Long nomineeId, String relationship) {
        this.ownerId = ownerId;
        this.nomineeId = nomineeId;
        this.relationship = relationship;
    }

    public Long getOwnerId() { return ownerId; }
    public Long getNomineeId() { return nomineeId; }
    public String getRelationship() { return relationship; }
}
