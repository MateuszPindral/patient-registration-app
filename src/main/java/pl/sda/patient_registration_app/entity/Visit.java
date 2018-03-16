package pl.sda.patient_registration_app.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "visits")
public class Visit {

    @Column(name = "patient")
    private Patient patient;

    @Column(name = "doctor")
    private Doctor doctor;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "time")
    private LocalTime time;

}
