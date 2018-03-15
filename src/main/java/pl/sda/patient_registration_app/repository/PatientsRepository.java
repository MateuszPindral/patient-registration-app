package pl.sda.patient_registration_app.repository;

import pl.sda.patient_registration_app.dto.PatientDto;

import java.util.ArrayList;
import java.util.List;

public class PatientsRepository {

    public static List<PatientDto> patients = new ArrayList<>();

    static {
        patients.add(PatientDto.builder()
                .id(1)
                .name("Tymian")
                .lastName("Polepa")
                .build()
        );
        patients.add(PatientDto.builder()
                .id(2)
                .name("Żegota")
                .lastName("Bąk")
                .build()
        );
        patients.add(PatientDto.builder()
                .id(3)
                .name("Brajan")
                .lastName("Kowalski")
                .build()
        );
    }

}
