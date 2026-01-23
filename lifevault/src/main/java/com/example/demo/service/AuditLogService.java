package com.example.demo.service;

public interface AuditLogService {
    void logSystemAction(Long ownerId, String action);
}
