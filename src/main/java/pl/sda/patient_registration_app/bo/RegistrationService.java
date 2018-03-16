package pl.sda.patient_registration_app.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.patient_registration_app.entity.Doctor;
import pl.sda.patient_registration_app.entity.Patient;
import pl.sda.patient_registration_app.entity.Visit;
import pl.sda.patient_registration_app.repository.DoctorsRepository;
import pl.sda.patient_registration_app.repository.PatientsRepository;
import pl.sda.patient_registration_app.repository.VisitsRepository;

import java.time.LocalDate;
import java.time.LocalTime;

@Service
public class RegistrationService {

    private VisitsRepository visitsRepository;
    private PatientsRepository patientsRepository;
    private DoctorsRepository doctorsRepository;

    @Autowired
    public RegistrationService(VisitsRepository visitsRepository, PatientsRepository patientsRepository, DoctorsRepository doctorsRepository) {
        this.visitsRepository = visitsRepository;
        this.patientsRepository = patientsRepository;
        this.doctorsRepository = doctorsRepository;
    }

    public void addVisits(){
        Patient patient = Patient.builder().build();
        patientsRepository.save(patient);
        Doctor doctor = Doctor.builder().build();
        doctorsRepository.save(doctor);
        Visit visit = Visit.builder()
                .doctor(doctor)
                .patient(patient)
                .date(LocalDate.of(2018, 3, 20))
                .time(LocalTime.of(12, 0))
                .build();
        visitsRepository.save(visit);
    }

}
