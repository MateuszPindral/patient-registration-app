package pl.sda.patient_registration_app.dto;

import lombok.*;
import pl.sda.patient_registration_app.type.DocSpecType;

import java.util.List;

@Setter
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

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public DocSpecType getSpecialization() {
        return specialization;
    }

    public Long getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public List<VisitDto> getVisits() {
        return visits;
    }


}
