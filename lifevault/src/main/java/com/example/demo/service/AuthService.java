package com.example.demo.service;

import com.example.demo.dto.LoginRequestDTO;

public interface AuthService {
    String login(LoginRequestDTO request);
}

