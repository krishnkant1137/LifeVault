package com.example.demo.dto;

public class DeathVerificationRequestDTO {
    private Long nomineeId;
    private Long ownerId;
    private String note;

    public DeathVerificationRequestDTO() {}

    public Long getNomineeId() { return nomineeId; }
    public void setNomineeId(Long nomineeId) { this.nomineeId = nomineeId; }

    public Long getOwnerId() { return ownerId; }
    public void setOwnerId(Long ownerId) { this.ownerId = ownerId; }

    public String getNote() { return note; }
    public void setNote(String note) { this.note = note; }
}
