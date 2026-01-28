package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Nominee;
import com.example.demo.entity.VaultFolder;

public interface NomineeRepository extends JpaRepository<Nominee, Long> {
}