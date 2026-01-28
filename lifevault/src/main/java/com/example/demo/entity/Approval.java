package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "approvals")
public class Approval {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "request_id", nullable = false, unique = true)
    private DeathVerificationRequest request;

    @ManyToOne
    @JoinColumn(name = "admin_id", nullable = false)
    private User admin;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ApprovalDecision decision;

    @Column(length = 255)
    private String remarks;

    @Column(name = "decided_at")
    private LocalDateTime decidedAt = LocalDateTime.now();

    public Approval() {}

    public Long getId() {
        return id;
    }

    public DeathVerificationRequest getRequest() {
        return request;
    }

    public void setRequest(DeathVerificationRequest request) {
        this.request = request;
    }

    public User getAdmin() {
        return admin;
    }

    public void setAdmin(User admin) {
        this.admin = admin;
    }

    public ApprovalDecision getDecision() {
        return decision;
    }

    public void setDecision(ApprovalDecision decision) {
        this.decision = decision;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public LocalDateTime getDecidedAt() {
        return decidedAt;
    }
}

