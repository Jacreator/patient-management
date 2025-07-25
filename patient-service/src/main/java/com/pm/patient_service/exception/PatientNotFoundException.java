package com.pm.patient_service.exception;

public class PatientNotFoundException extends RuntimeException {
    public PatientNotFoundException(String message) {
        super(message);
    }
    
    public PatientNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
