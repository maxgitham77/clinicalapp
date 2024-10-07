package com.clinicalapp.clinicalapp.services.Impl;

import com.clinicalapp.clinicalapp.entities.ClinicalData;
import com.clinicalapp.clinicalapp.entities.Patient;
import com.clinicalapp.clinicalapp.repositories.PatientRepository;
import com.clinicalapp.clinicalapp.services.PatientService;
import com.clinicalapp.clinicalapp.utils.BMICalculate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    Map<String,String> filters = new HashMap<>();

    @Override
    public List<Patient> getAllPatient() {
        return patientRepository.findAll();
    }

    @Override
    public Patient getPatient(Long id) {
        return patientRepository.findById(id).get();
    }

    @Override
    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Patient analyse(Long id) {
        Patient patient = patientRepository.findById(id).get();
        List<ClinicalData> clinicalData = patient.getClinicalData();
        List<ClinicalData> duplicateClinicalData = new ArrayList<>(clinicalData);
        for (ClinicalData eachEntry : duplicateClinicalData) {

            if (filters.containsKey(eachEntry.getComponentName())) {
                clinicalData.remove(eachEntry);
                continue;
            } else {
                filters.put(eachEntry.getComponentName(), null);
            }

            BMICalculate.calculateBmi(eachEntry, clinicalData);
        }
        filters.clear();
        return patient;
    }




}
