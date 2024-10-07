package com.clinicalapp.clinicalapp.services;

import com.clinicalapp.clinicalapp.entities.Patient;

import java.util.List;

public interface PatientService {
    List<Patient> getAllPatient();
    Patient getPatient(Long id);
    Patient createPatient(Patient patient);
    Patient analyse(Long id);

}
