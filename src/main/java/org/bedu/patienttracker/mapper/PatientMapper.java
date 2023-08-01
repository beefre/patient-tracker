package org.bedu.patienttracker.mapper;

import org.bedu.patienttracker.model.Patient;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PatientMapper {

    Patient patientEntityToPatientModel(org.bedu.patienttracker.entity.Patient patientEntity);

    org.bedu.patienttracker.entity.Patient patientModelToPatientEntity(Patient patientModel);
}
