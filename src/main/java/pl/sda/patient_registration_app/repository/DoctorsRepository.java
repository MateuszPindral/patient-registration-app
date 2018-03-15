package pl.sda.patient_registration_app.repository;

import org.springframework.stereotype.Component;
import pl.sda.patient_registration_app.dto.DoctorDto;
import pl.sda.patient_registration_app.type.DocSpecType;

import java.util.ArrayList;
import java.util.List;

@Component
public class DoctorsRepository {

    public static List<DoctorDto> doctors = new ArrayList<>();

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
