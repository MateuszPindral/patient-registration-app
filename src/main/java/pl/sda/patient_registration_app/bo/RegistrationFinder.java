package pl.sda.patient_registration_app.bo;

import org.springframework.stereotype.Service;
import pl.sda.patient_registration_app.dto.VisitDto;

import java.util.List;

import static pl.sda.patient_registration_app.repository.VisitsRepository.visits;

@Service
public class RegistrationFinder {

    public List<VisitDto> showAllVisits(){
        return visits;
    }

}
