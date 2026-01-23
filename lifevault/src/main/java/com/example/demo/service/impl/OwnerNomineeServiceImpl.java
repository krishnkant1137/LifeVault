package com.example.demo.service.impl;

import com.example.demo.entity.Nominee;
import com.example.demo.entity.OwnerNominee;
import com.example.demo.entity.User;
import com.example.demo.repository.NomineeRepository;
import com.example.demo.repository.OwnerNomineeRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.OwnerNomineeService;
import org.springframework.stereotype.Service;
import com.example.demo.exception.ResourceNotFoundException;


@Service
public class OwnerNomineeServiceImpl implements OwnerNomineeService {

    private final OwnerNomineeRepository ownerNomineeRepository;
    private final UserRepository userRepository;
    private final NomineeRepository nomineeRepository;

    public OwnerNomineeServiceImpl(OwnerNomineeRepository ownerNomineeRepository,
                                   UserRepository userRepository,
                                   NomineeRepository nomineeRepository) {
        this.ownerNomineeRepository = ownerNomineeRepository;
        this.userRepository = userRepository;
        this.nomineeRepository = nomineeRepository;
    }

    @Override
    public OwnerNominee assignNominee(Long ownerId, Long nomineeId, String relationship) {

        User owner = userRepository.findById(ownerId)
        		 .orElseThrow(() -> new ResourceNotFoundException("Owner not found"));
        Nominee nominee = nomineeRepository.findById(nomineeId)
                .orElseThrow(() -> new ResourceNotFoundException("Nominee not found"));

        OwnerNominee mapping = new OwnerNominee();
        mapping.setOwner(owner);
        mapping.setNominee(nominee);
        mapping.setRelationship(relationship);

        return ownerNomineeRepository.save(mapping);
    }
}
