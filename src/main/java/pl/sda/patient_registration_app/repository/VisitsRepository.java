package pl.sda.patient_registration_app.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.sda.patient_registration_app.dto.DoctorDto;
import pl.sda.patient_registration_app.dto.VisitDto;
import pl.sda.patient_registration_app.type.DocSpecType;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Component
public class VisitsRepository {


    public static List<VisitDto> visits;

    static {
        visits.add(VisitDto.builder()
                .doctor(DoctorDto.builder().id(4).name("Bożydar").lastName("Putas").specialization(DocSpecType.GYNECOLOGIST).build())
                .dayOfVisit(LocalDate.of(2018, 9, 15))
                .hourOfVisit(LocalTime.of(12,00))
                .build()
        );
        visits.add(VisitDto.builder()
                .doctor(DoctorDto.builder().id(4).name("Bożydar").lastName("Putas").specialization(DocSpecType.GYNECOLOGIST).build())
                .dayOfVisit(LocalDate.of(2018, 9, 15))
                .hourOfVisit(LocalTime.of(13,00))
                .build()
        );
    }
}
