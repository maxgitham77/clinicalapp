package com.clinicalapp.clinicalapp.services.Impl;

import com.clinicalapp.clinicalapp.dtos.ClinicalDataRequest;
import com.clinicalapp.clinicalapp.entities.ClinicalData;
import com.clinicalapp.clinicalapp.entities.Patient;
import com.clinicalapp.clinicalapp.repositories.ClinicalDataRepository;
import com.clinicalapp.clinicalapp.repositories.PatientRepository;
import com.clinicalapp.clinicalapp.services.ClinicalDataService;
import com.clinicalapp.clinicalapp.utils.BMICalculate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClinicalDataServiceImpl implements ClinicalDataService {

    @Autowired
    private ClinicalDataRepository clinicalDataRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public ClinicalData create(ClinicalDataRequest request) {
        Patient patient = patientRepository.findById(request.getPatientId()).get();
        ClinicalData newClinicalData = new ClinicalData();
        newClinicalData.setComponentName(request.getComponentName());
        newClinicalData.setComponentValue(request.getComponentValue());
        newClinicalData.setPatient(patient);
        return clinicalDataRepository.save(newClinicalData);
    }

    @Override
    public List<ClinicalData> getClinicalData(Long id, String componentName) {
        if (componentName.equals("bmi")) {
            componentName = "hw";
        }
        List<ClinicalData> clinicalData = clinicalDataRepository.findByPatientIdAndComponentNameOrderByMeasuredDateTime(id, componentName);
        List<ClinicalData> duplicateClinicalData = new ArrayList<>(clinicalData);
        for (ClinicalData eachEntry : duplicateClinicalData) {
            BMICalculate.calculateBmi(eachEntry, clinicalData);
        }
        return clinicalData;
    }
}
