package com.example.demo.service;

import com.example.demo.dto.OwnerDashboardResponseDTO;

public interface OwnerDashboardService {
    OwnerDashboardResponseDTO getDashboard(Long ownerId);
}
