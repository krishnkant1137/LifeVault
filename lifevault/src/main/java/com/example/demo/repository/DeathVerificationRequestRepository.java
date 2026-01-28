package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.DeathVerificationRequest;
import com.example.demo.entity.VerificationStatus;

import java.util.List;

public interface DeathVerificationRequestRepository
        extends JpaRepository<DeathVerificationRequest, Long> {

    List<DeathVerificationRequest> findByOwnerId(Long ownerId);

    List<DeathVerificationRequest> findByNomineeId(Long nomineeId);
    
    List<DeathVerificationRequest> findByStatus(VerificationStatus  status);

}