package org.bedu.patienttracker.model;

import lombok.*;

@Setter
@Getter
@Builder
@Generated
public class Patient {

    private int id;
    private String name;
    private String lastName;
    private String mothersSurname;
    private String birthDate;
    private short weight;
}
