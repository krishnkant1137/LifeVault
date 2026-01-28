package com.example.demo.service.impl;

import com.example.demo.entity.*;
import com.example.demo.repository.*;
import com.example.demo.service.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Transactional
@Service
public class DeathVerificationServiceImpl implements DeathVerificationService {

    private final DeathVerificationRequestRepository requestRepo;
    private final UserRepository userRepo;
    private final NomineeRepository nomineeRepo;
    private final VaultFolderRepository folderRepo;
    private final AuditLogService auditLogService;

    public DeathVerificationServiceImpl(
            DeathVerificationRequestRepository requestRepo,
            UserRepository userRepo,
            NomineeRepository nomineeRepo,
            VaultFolderRepository folderRepo,
            AuditLogService auditLogService
    ) {
        this.requestRepo = requestRepo;
        this.userRepo = userRepo;
        this.nomineeRepo = nomineeRepo;
        this.folderRepo = folderRepo;
        this.auditLogService = auditLogService;
    }

    @Override
    public DeathVerificationRequest createRequest(Long nomineeId, Long ownerId, String note) {

        Nominee nominee = nomineeRepo.findById(nomineeId)
                .orElseThrow(() -> new RuntimeException("Nominee not found"));

        User owner = userRepo.findById(ownerId)
                .orElseThrow(() -> new RuntimeException("Owner not found"));

        DeathVerificationRequest req = new DeathVerificationRequest();
        req.setNominee(nominee);
        req.setOwner(owner);
        req.setStatus(VerificationStatus.PENDING);
        req.setNote(note);

        return requestRepo.save(req);
    }

    @Override
    public List<DeathVerificationRequest> getPending() {
        return requestRepo.findByStatus(VerificationStatus.PENDING);
    }

    @Override
    @Transactional
    public void decide(Long requestId, String decision) {

        DeathVerificationRequest req = requestRepo.findById(requestId)
                .orElseThrow(() -> new RuntimeException("Request not found"));

        if (req.getStatus() != VerificationStatus.PENDING) {
            throw new IllegalStateException("Request already processed");
        }

        VerificationStatus newStatus =
                VerificationStatus.valueOf(decision.trim().toUpperCase());

        req.setStatus(newStatus);
        requestRepo.save(req);

        if (newStatus == VerificationStatus.APPROVED) {

            boolean released = false;
            List<VaultFolder> folders = folderRepo.findByOwnerId(req.getOwner().getId());

            for (VaultFolder f : folders) {
                if (!f.getIsReleased()) {
                    f.setIsReleased(true);
                    folderRepo.save(f);
                    released = true;
                }
            }

            if (released) {
                auditLogService.logSystemAction(
                        req.getOwner().getId(),
                        "Vault released after death verification approval"
                );
            }
        }

    }
}
