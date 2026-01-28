package com.example.demo.dto;

public class DecisionDTO {
    private String decision; // APPROVED / REJECTED
    private String remarks;

    public DecisionDTO() {}

    public String getDecision() { return decision; }
    public void setDecision(String decision) { this.decision = decision; }

    public String getRemarks() { return remarks; }
    public void setRemarks(String remarks) { this.remarks = remarks; }
}
