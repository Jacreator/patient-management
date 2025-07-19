package com.pm.patient_service.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.pm.patient_service.dto.PatientRequestDto;
import com.pm.patient_service.dto.PatientResponseDto;
import com.pm.patient_service.exception.EmailAlreadyExistsException;
import com.pm.patient_service.exception.PatientNotFoundException;
import com.pm.patient_service.grpc.BillingServiceGrpcClient;
import com.pm.patient_service.mapper.PatientMapper;
import com.pm.patient_service.model.Patient;
import com.pm.patient_service.repository.PatientRepository;


@Service
public class PatientService {
  private PatientRepository patientRepository;
  private final BillingServiceGrpcClient billingServiceGrpcClient;

  public PatientService(PatientRepository patientRepository, BillingServiceGrpcClient billingServiceGrpcClient) {
    this.patientRepository = patientRepository;
    this.billingServiceGrpcClient = billingServiceGrpcClient;
  }

  public List<PatientResponseDto> getAllPatients() {
    List<Patient> patients = patientRepository.findAll();
    return patients.stream().map(PatientMapper::toDto)
        .toList();
  }

  public PatientResponseDto getPatientById(String id) {
    if (id == null || id.isEmpty()) {
      throw new IllegalArgumentException("Patient ID cannot be null or empty");
    }
    Patient patient = patientRepository.findById(UUID.fromString(id))
        .orElseThrow(() -> new PatientNotFoundException("Patient not found"));
    return PatientMapper.toDto(patient);
  }

  public PatientResponseDto createPatient(PatientRequestDto patientDto) {
    if (patientRepository.existsByEmail(patientDto.getEmail())) {
      throw new EmailAlreadyExistsException("Email already exists");
    }
    Patient patient = PatientMapper.toEntity(patientDto);
    patient = patientRepository.save(patient);
    billingServiceGrpcClient.createBillingAccount(patient.getId().toString(), patient.getName(), patient.getEmail());
    return PatientMapper.toDto(patient);
  }

  public void deletePatient(String id) {
    if (id == null || id.isEmpty()) {
      throw new IllegalArgumentException("Patient ID cannot be null or empty");
    }
    UUID patientId = UUID.fromString(id);
    if (!patientRepository.existsById(patientId)) {
      throw new RuntimeException("Patient not found");
    }
    patientRepository.deleteById(patientId);
  }

  public PatientResponseDto updatePatient(String id, PatientRequestDto patientDto) {
    if (id == null || id.isEmpty()) {
      throw new IllegalArgumentException("Patient ID cannot be null or empty");
    }
    UUID patientId = UUID.fromString(id);
    if (!patientRepository.existsById(patientId)) {
      throw new PatientNotFoundException("Patient not found: " + id);
    }
    if (patientRepository.existsByEmailAndIdNot(patientDto.getEmail(), patientId)) {
      throw new EmailAlreadyExistsException("Email already exists");
    }
    Patient patient = PatientMapper.toEntity(patientDto);
    patient.setId(patientId);
    patient = patientRepository.save(patient);
    return PatientMapper.toDto(patient);
  }
}
