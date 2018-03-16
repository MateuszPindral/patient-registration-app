package pl.sda.patient_registration_app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.sda.patient_registration_app.type.DocSpecType;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DoctorDto {
    private String name;
    private String lastName;
    private DocSpecType specialization;
    private Long id;
    private String login;
    private String password;
    private List<VisitDto> visits;
}
