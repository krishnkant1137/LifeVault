package com.example.demo.service.impl;

import com.example.demo.entity.Nominee;
import com.example.demo.repository.NomineeRepository;
import com.example.demo.service.NomineeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NomineeServiceImpl implements NomineeService {

    private final NomineeRepository nomineeRepository;

    public NomineeServiceImpl(NomineeRepository nomineeRepository) {
        this.nomineeRepository = nomineeRepository;
    }

    @Override
    public Nominee createNominee(String fullName, String email, String phone) {
        Nominee n = new Nominee();
        n.setFullName(fullName.trim());
        n.setEmail(email.trim());
        n.setPhone(phone);
        return nomineeRepository.save(n);
    }

    @Override
    public List<Nominee> getAllNominees() {
        return nomineeRepository.findAll();
    }
}
