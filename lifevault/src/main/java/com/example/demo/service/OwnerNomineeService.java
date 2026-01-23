package com.example.demo.service;

import com.example.demo.entity.OwnerNominee;

public interface OwnerNomineeService {

    OwnerNominee assignNominee(Long ownerId, Long nomineeId, String relationship);
}
