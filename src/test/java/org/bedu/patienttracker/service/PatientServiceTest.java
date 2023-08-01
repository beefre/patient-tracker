package org.bedu.patienttracker.service;

import org.bedu.patienttracker.mapper.PatientMapper;
import org.bedu.patienttracker.model.Patient;
import org.bedu.patienttracker.repository.PatientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(SpringExtension.class)
class PatientServiceTest {

    private PatientMapper patientMapper;
    private PatientRepository patientRepository;
    private PatientService patientService;

    @BeforeEach
    public void setup(){
        patientMapper = mock(PatientMapper.class);
        patientRepository = mock(PatientRepository.class);
        patientService = new PatientService(patientRepository,patientMapper);
    }

    @Test
    void savePatient() {
        Patient model = Patient.builder().build();
        org.bedu.patienttracker.entity.Patient entity = new org.bedu.patienttracker.entity.Patient();
        when(patientMapper.patientModelToPatientEntity(model)).thenReturn(entity);
        when(patientMapper.patientEntityToPatientModel(entity)).thenReturn(model);
        when(patientRepository.save(entity)).thenReturn(entity);
        assertNotNull(patientService.savePatient(model));
    }

    @Test
    void getPatient() {
        Patient model = Patient.builder().build();
        org.bedu.patienttracker.entity.Patient entity = new org.bedu.patienttracker.entity.Patient();
        when(patientMapper.patientEntityToPatientModel(entity)).thenReturn(model);
        when(patientRepository.findById(1)).thenReturn(Optional.of(entity));
        assertNotNull(patientService.getPatient(1));
    }

    @Test
    void deletePatient() {
        patientService.deletePatient(1);
        verify(patientRepository,times(1)).deleteById(1);
    }

    @Test
    void updatePatient() {
        Patient model = Patient.builder().build();
        org.bedu.patienttracker.entity.Patient entity = new org.bedu.patienttracker.entity.Patient();
        when(patientMapper.patientModelToPatientEntity(model)).thenReturn(entity);
        patientService.updatePatient(model);
        verify(patientRepository,times(1)).save(entity);
    }
}