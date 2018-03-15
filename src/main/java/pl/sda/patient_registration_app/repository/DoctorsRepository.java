package pl.sda.patient_registration_app.repository;

import pl.sda.patient_registration_app.dto.DoctorDto;
import pl.sda.patient_registration_app.type.DocSpecType;

import java.util.List;

public class DoctorsRepository {

    public static List<DoctorDto> doctors;

    static {
        doctors.add(DoctorDto.builder()
                .id(4)
                .name("Bożydar")
                .lastName("Putas")
                .specialization(DocSpecType.GYNECOLOGIST)
                .build()
        );
    }

}
