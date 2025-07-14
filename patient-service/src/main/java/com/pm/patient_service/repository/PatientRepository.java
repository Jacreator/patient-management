package com.pm.patient_service.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pm.patient_service.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, UUID> {
    // Additional query methods can be defined here if needed
  boolean existsByEmail(String email); // Example method to check if an email already exists
}
