package pl.sda.patient_registration_app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VisitDto {

    private LocalDate dayOfVisit;
    private LocalTime hourOfVisit;
    private String doctor;





}
