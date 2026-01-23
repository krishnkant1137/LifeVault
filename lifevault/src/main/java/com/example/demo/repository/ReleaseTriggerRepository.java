package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.ReleaseTrigger;

import java.util.Optional;

public interface ReleaseTriggerRepository extends JpaRepository<ReleaseTrigger, Long> {

    Optional<ReleaseTrigger> findByOwnerId(Long ownerId);
}