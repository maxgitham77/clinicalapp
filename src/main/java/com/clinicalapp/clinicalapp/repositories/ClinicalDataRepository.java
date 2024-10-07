package com.clinicalapp.clinicalapp.repositories;

import com.clinicalapp.clinicalapp.entities.ClinicalData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClinicalDataRepository extends JpaRepository<ClinicalData, Long> {
    List<ClinicalData> findByPatientIdAndComponentNameOrderByMeasuredDateTime(Long patientId, String componentName);
}
