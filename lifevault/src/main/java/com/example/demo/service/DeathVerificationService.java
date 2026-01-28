package com.example.demo.service;

import com.example.demo.entity.DeathVerificationRequest;
import java.util.List;

public interface DeathVerificationService {
    DeathVerificationRequest createRequest(Long nomineeId, Long ownerId, String note);
    List<DeathVerificationRequest> getPending();
    void decide(Long requestId, String decision);
}
