package com.example.demo.service.impl;

import com.example.demo.entity.AuditLog;
import com.example.demo.entity.User;
import com.example.demo.repository.AuditLogRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.AuditLogService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AuditLogServiceImpl implements AuditLogService {

    private final AuditLogRepository auditLogRepository;
    private final UserRepository userRepository;

    public AuditLogServiceImpl(AuditLogRepository auditLogRepository,
                               UserRepository userRepository) {
        this.auditLogRepository = auditLogRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void logSystemAction(Long ownerId, String action) {

        User owner = userRepository.findById(ownerId)
                .orElseThrow(() -> new RuntimeException("User not found for audit log"));

        AuditLog log = new AuditLog();
        log.setUser(owner);            
        log.setAction(action);
        	
        auditLogRepository.save(log);
    }
}
