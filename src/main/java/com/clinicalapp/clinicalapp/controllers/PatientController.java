package com.clinicalapp.clinicalapp.controllers;

import com.clinicalapp.clinicalapp.entities.Patient;
import com.clinicalapp.clinicalapp.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patients")
@CrossOrigin("*")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<Patient>> getPatients()
    {
        List<Patient> patient = patientService.getAllPatient();
        return ResponseEntity.ok(patient);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Patient> getOnePatient(@PathVariable("id") Long id)
    {
        Patient patient = patientService.getPatient(id);
        return new ResponseEntity<>(patient, HttpStatus.OK);
    }

    public ResponseEntity<Patient> registerPatient(Patient patient)
    {
        Patient savedPatient = patientService.createPatient(patient);
        return new ResponseEntity<>(savedPatient, HttpStatus.OK);
    }

    @RequestMapping(value = "/analyse/{id}", method = RequestMethod.GET)
    public Patient analyse(@PathVariable("id") Long id) {
        return patientService.analyse(id);
    }

}
