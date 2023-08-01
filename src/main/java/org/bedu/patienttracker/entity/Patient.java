package org.bedu.patienttracker.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "patients")
public class Patient{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "mothers_surname")
    private String mothersSurname;

    @Column(name = "birth_date", nullable = false)
    private String birthDate;

    private short weight;
}
