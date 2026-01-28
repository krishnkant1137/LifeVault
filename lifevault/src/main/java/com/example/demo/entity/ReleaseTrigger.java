package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "release_triggers")
public class ReleaseTrigger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "owner_id", nullable = false, unique = true)
    private User owner;

    @Column(name = "inactivity_months")
    private Integer inactivityMonths = 12;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    public ReleaseTrigger() {}

    public Long getId() {
        return id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Integer getInactivityMonths() {
        return inactivityMonths;
    }

    public void setInactivityMonths(Integer inactivityMonths) {
        this.inactivityMonths = inactivityMonths;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}

