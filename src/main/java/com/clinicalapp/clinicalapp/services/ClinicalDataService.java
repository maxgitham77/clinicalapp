package com.clinicalapp.clinicalapp.services;

import com.clinicalapp.clinicalapp.dtos.ClinicalDataRequest;
import com.clinicalapp.clinicalapp.entities.ClinicalData;

import java.util.List;

public interface ClinicalDataService {

    ClinicalData create(ClinicalDataRequest request);

    List<ClinicalData> getClinicalData(Long id, String componentName);

}
