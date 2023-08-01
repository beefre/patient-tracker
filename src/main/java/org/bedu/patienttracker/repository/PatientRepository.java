package org.bedu.patienttracker.repository;

import org.bedu.patienttracker.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Integer> {
}
