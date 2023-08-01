package org.bedu.patienttracker.controller;

import lombok.AllArgsConstructor;
import org.bedu.patienttracker.model.Patient;
import org.bedu.patienttracker.service.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RequestMapping("/patient")
@RestController
@AllArgsConstructor
public class PatientController {

    private PatientService patientService;

    @PostMapping
    public ResponseEntity<Void> createPatient(@RequestBody Patient patient){
        Patient newPatient = patientService.savePatient(patient);

        return ResponseEntity.created(URI.create(String.valueOf(newPatient.getId()))).build();
    }

    @GetMapping("{id}")
    public ResponseEntity<Patient> getPatient(@PathVariable Integer id){
        return ResponseEntity.ok(patientService.getPatient(id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Integer id){
        patientService.deletePatient(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> updatePatient(@RequestBody Patient patient){
        patientService.updatePatient(patient);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
