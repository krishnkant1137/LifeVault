package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.OwnerNominee;

import java.util.List;

public interface OwnerNomineeRepository extends JpaRepository<OwnerNominee, Long> {

    List<OwnerNominee> findByOwnerId(Long ownerId);
}