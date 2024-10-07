package com.clinicalapp.clinicalapp.controllers;

import com.clinicalapp.clinicalapp.dtos.ClinicalDataRequest;
import com.clinicalapp.clinicalapp.entities.ClinicalData;
import com.clinicalapp.clinicalapp.services.ClinicalDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clinical/data")
@CrossOrigin("*")
public class ClinicalDataController {

    @Autowired
    private ClinicalDataService clinicalDataService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<ClinicalData> createClinicalData(@RequestBody ClinicalDataRequest request)
    {
        ClinicalData createdRequest = clinicalDataService.create(request);
        return new ResponseEntity<>(createdRequest, HttpStatus.OK);
    }

    @RequestMapping(value = "/{patientId}/{componentName}", method = RequestMethod.GET)
    public List<ClinicalData> getClinicalData(@PathVariable("patientId") Long id, @PathVariable("componentName") String componentName) {
        return clinicalDataService.getClinicalData(id, componentName);
    }

}
