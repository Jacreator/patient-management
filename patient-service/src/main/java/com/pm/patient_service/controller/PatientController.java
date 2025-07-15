package com.pm.patient_service.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pm.patient_service.dto.PatientRequestDto;
import com.pm.patient_service.dto.PatientResponseDto;
import com.pm.patient_service.service.PatientService;

import jakarta.validation.Valid;
import jakarta.validation.groups.Default;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

  private final PatientService patientService;

  public PatientController(PatientService patientService) {
    this.patientService = patientService;
  }

  @GetMapping
  public ResponseEntity<List<PatientResponseDto>> getAllPatients() {
    List<PatientResponseDto> patients = patientService.getAllPatients();
    return ResponseEntity.ok(patients);
  }

  @GetMapping("/{id}")
  public ResponseEntity<PatientResponseDto> getPatientById(@PathVariable String id) {
    PatientResponseDto patient = patientService.getPatientById(id);
    return ResponseEntity.ok(patient);
  }

  @PostMapping
  public ResponseEntity<PatientResponseDto> createPatient(@RequestBody @Valid PatientRequestDto patientDto) {
    PatientResponseDto createdPatient = patientService.createPatient(patientDto);
    return ResponseEntity.status(HttpStatus.CREATED).body(createdPatient);
  }

  @PutMapping("/{id}")
  public ResponseEntity<PatientResponseDto> updatePatient(@PathVariable String id,
      @RequestBody @Validated({ Default.class }) PatientRequestDto patientDto) {
    PatientResponseDto updatedPatient = patientService.updatePatient(id, patientDto);
    return ResponseEntity.ok(updatedPatient);
  }

  @DeleteMapping("/{id}/delete")
  public ResponseEntity<Void> deletePatient(@PathVariable String id) {
    patientService.deletePatient(id);
    return ResponseEntity.noContent().build();
  }
}
