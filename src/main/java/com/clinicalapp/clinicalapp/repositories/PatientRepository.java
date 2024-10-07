package com.clinicalapp.clinicalapp.repositories;

import com.clinicalapp.clinicalapp.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
