package pl.sda.patient_registration_app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SortComparator;
import pl.sda.patient_registration_app.type.VisitStatusType;

import java.time.LocalDate;
import java.time.LocalTime;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VisitDto implements Comparable<VisitDto> {

    private LocalDate dayOfVisit;
    private LocalTime hourOfVisit;
    private DoctorDto doctor;
    private PatientDto patient;
    private VisitStatusType status;
    private Long id;


    @Override
    public int compareTo(VisitDto o) {
        return this.hourOfVisit.compareTo(o.hourOfVisit);
    }
}
