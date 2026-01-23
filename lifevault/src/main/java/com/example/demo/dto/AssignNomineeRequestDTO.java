package com.example.demo.dto;

public class AssignNomineeRequestDTO {
    private Long ownerId;
    private Long nomineeId;
    private String relationship;

    public AssignNomineeRequestDTO() {}

    public Long getOwnerId() { return ownerId; }
    public void setOwnerId(Long ownerId) { this.ownerId = ownerId; }

    public Long getNomineeId() { return nomineeId; }
    public void setNomineeId(Long nomineeId) { this.nomineeId = nomineeId; }

    public String getRelationship() { return relationship; }
    public void setRelationship(String relationship) { this.relationship = relationship; }
}
