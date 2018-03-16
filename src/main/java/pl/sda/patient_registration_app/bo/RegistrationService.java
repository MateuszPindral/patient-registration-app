package pl.sda.patient_registration_app.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.patient_registration_app.entity.Doctor;
import pl.sda.patient_registration_app.entity.Patient;
import pl.sda.patient_registration_app.entity.Visit;
import pl.sda.patient_registration_app.repository.DoctorsRepository;
import pl.sda.patient_registration_app.repository.VisitsRepository;

import java.time.LocalDate;
import java.time.LocalTime;

@Service
public class RegistrationService {

    private VisitsRepository visitsRepository;

    @Autowired
    public RegistrationService(VisitsRepository visitsRepository) {
        this.visitsRepository = visitsRepository;
    }

    public void addVisits(){
        Patient patient = Patient.builder().build();
        Doctor doctor = Doctor.builder().build();
        Visit visit = Visit.builder()
                .doctor(doctor)
                .patient(patient)
                .date(LocalDate.of(2018, 3, 20))
                .time(LocalTime.of(12, 0))
                .build();
        visitsRepository.save(visit);
    }

}
