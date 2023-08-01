package org.bedu.patienttracker.service;

import lombok.AllArgsConstructor;
import org.bedu.patienttracker.mapper.PatientMapper;
import org.bedu.patienttracker.model.Patient;
import org.bedu.patienttracker.repository.PatientRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PatientService {

    private PatientRepository patientRepository;
    private PatientMapper patientMapper;

    public Patient savePatient(Patient patient){
        return patientMapper.patientEntityToPatientModel(patientRepository.save(patientMapper.patientModelToPatientEntity(patient)));
    }

    public Patient getPatient(Integer id){
        return patientMapper.patientEntityToPatientModel(patientRepository.findById(id).get());
    }

    public void deletePatient(Integer id) {
        patientRepository.deleteById(id);
    }

    public void updatePatient(Patient patient) {
        org.bedu.patienttracker.entity.Patient patientEntity = patientMapper.patientModelToPatientEntity(patient);
        patientRepository.save(patientEntity);
    }
}
