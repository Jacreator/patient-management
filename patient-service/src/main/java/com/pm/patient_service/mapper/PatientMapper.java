package com.pm.patient_service.mapper;

import java.time.LocalDate;

import com.pm.patient_service.dto.PatientRequestDto;
import com.pm.patient_service.dto.PatientResponseDto;
import com.pm.patient_service.model.Patient;

public class PatientMapper {
  public static PatientResponseDto toDto(Patient patient) {
    if (patient == null) {
      return null;
    }
    
    PatientResponseDto dto = new PatientResponseDto();
    dto.setId(patient.getId().toString());
    dto.setName(patient.getName());
    dto.setEmail(patient.getEmail());
    dto.setAddress(patient.getAddress());
    dto.setPhoneNumber(patient.getPhoneNumber());
    dto.setDateOfBirth(patient.getDateOfBirth().toString());
    
    return dto;
  }

  public static Patient toEntity(PatientRequestDto dto) {
    if (dto == null) {
      return null;
    }
    
    Patient patient = new Patient();
    patient.setName(dto.getName());
    patient.setEmail(dto.getEmail());
    patient.setAddress(dto.getAddress());
    patient.setPhoneNumber(dto.getPhoneNumber());
    patient.setDateOfBirth(LocalDate.parse(dto.getDateOfBirth()));
    patient.setRegisteredDate(LocalDate.now()); // Assuming registration date is current date
    
    return patient;
  }
}
