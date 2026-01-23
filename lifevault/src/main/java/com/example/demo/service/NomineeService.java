package com.example.demo.service;

import com.example.demo.entity.Nominee;

import java.util.List;

public interface NomineeService {
    Nominee createNominee(String fullName, String email, String phone);
    List<Nominee> getAllNominees();
}
