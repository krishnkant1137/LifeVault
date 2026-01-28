package com.example.demo.service.impl;

import com.example.demo.entity.ReleaseTrigger;
import com.example.demo.entity.User;
import com.example.demo.entity.VaultFolder;
import com.example.demo.repository.ReleaseTriggerRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.VaultFolderRepository;
import com.example.demo.service.AuditLogService;
import com.example.demo.service.ReleaseTriggerService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReleaseTriggerServiceImpl implements ReleaseTriggerService {

    private final ReleaseTriggerRepository triggerRepository;
    private final UserRepository userRepository;
    private final VaultFolderRepository folderRepository;
    private final AuditLogService auditLogService;


    public ReleaseTriggerServiceImpl(
            ReleaseTriggerRepository triggerRepository,
            UserRepository userRepository,
            VaultFolderRepository folderRepository,
            AuditLogService auditLogService
    ) {
        this.triggerRepository = triggerRepository;
        this.userRepository = userRepository;
        this.folderRepository = folderRepository;
        this.auditLogService = auditLogService;
    }

    @Override
    public void checkAndReleaseVaults() {

        List<ReleaseTrigger> triggers = triggerRepository.findAll();

        for (ReleaseTrigger trigger : triggers) {
            User owner = trigger.getOwner();

            LocalDateTime lastLogin = owner.getLastLoginAt();
            if (lastLogin == null) continue;

            LocalDateTime threshold =
                    lastLogin.plusMonths(trigger.getInactivityMonths());

            if (LocalDateTime.now().isAfter(threshold)) {
                releaseOwnerVault(owner.getId());
            }
        }
    }

    private void releaseOwnerVault(Long ownerId) {

        List<VaultFolder> folders =
                folderRepository.findByOwnerId(ownerId);

        boolean released = false;

        for (VaultFolder folder : folders) {
            if (!folder.getIsReleased()) {
                folder.setIsReleased(true);
                folderRepository.save(folder);
                released = true;
            }
        }

        if (released) {
            auditLogService.logSystemAction(
                    ownerId,
                    "System released vault due to owner inactivity"
            );
        }
    }
}
