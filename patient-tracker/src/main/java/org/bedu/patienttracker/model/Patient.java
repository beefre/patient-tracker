package org.bedu.patienttracker.model;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
public class Patient {

    private int id;
    private String name;
    private String lastName;
    private String mothersSurname;
    private String birthDate;
    private short weight;
}
