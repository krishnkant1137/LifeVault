package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "owner_nominees")
public class OwnerNominee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 🔹 Many mappings to User (Owner)
    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;

    // 🔹 Many mappings to Nominee
    @ManyToOne
    @JoinColumn(name = "nominee_id", nullable = false)
    private Nominee nominee;

    @Column(length = 50)
    private String relationship;

    // 🔹 Default constructor
    public OwnerNominee() {}

    // 🔹 Getters & Setters
    public Long getId() {
        return id;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Nominee getNominee() {
        return nominee;
    }

    public void setNominee(Nominee nominee) {
        this.nominee = nominee;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }
}
