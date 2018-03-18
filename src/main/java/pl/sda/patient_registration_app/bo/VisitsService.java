package pl.sda.patient_registration_app.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.patient_registration_app.entity.Doctor;
import pl.sda.patient_registration_app.entity.Patient;
import pl.sda.patient_registration_app.entity.Visit;
import pl.sda.patient_registration_app.repository.DoctorsRepository;
import pl.sda.patient_registration_app.repository.PatientsRepository;
import pl.sda.patient_registration_app.repository.VisitsRepository;
import pl.sda.patient_registration_app.type.DocSpecType;

import java.time.LocalDate;
import java.time.LocalTime;

@Service
public class VisitsService {


    private VisitsRepository visitsRepository;
    private PatientsRepository patientsRepository;
    private DoctorsRepository doctorsRepository;

    @Autowired
    public VisitsService(VisitsRepository visitsRepository, PatientsRepository patientsRepository, DoctorsRepository doctorsRepository) {
        this.visitsRepository = visitsRepository;
        this.patientsRepository = patientsRepository;
        this.doctorsRepository = doctorsRepository;
    }


    public void addVisit(LocalDate day, LocalTime time, Doctor doctor) {

        Visit visit = Visit.builder()
                .date(day)
                .time(time)
                .doctor(doctor)
                .build();
        visitsRepository.save(visit);

    }

    public void fillDBwithVisits() {

        Doctor doctor1 = new Doctor();
        Doctor doctor2 = new Doctor();
        Doctor doctor3 = new Doctor();

        doctor1.setSpecialization(DocSpecType.UROLOGIST);
        doctor1.setFirstName("Mariusz");
        doctor1.setLastName("Putas");
        doctor2.setSpecialization(DocSpecType.UROLOGIST);
        doctor2.setFirstName("Janusz");
        doctor2.setLastName("Fijut");
        doctor3.setSpecialization(DocSpecType.UROLOGIST);
        doctor3.setFirstName("Roman");
        doctor3.setLastName("Wusiacz");

        doctorsRepository.save(doctor1);
        doctorsRepository.save(doctor2);
        doctorsRepository.save(doctor3);

        addVisit(LocalDate.of(2018, 6, 10), LocalTime.of(10, 0), doctor1);
        addVisit(LocalDate.of(2018, 6, 10), LocalTime.of(11, 0), doctor1);
        addVisit(LocalDate.of(2018, 6, 10), LocalTime.of(12, 0), doctor1);
        addVisit(LocalDate.of(2018, 6, 10), LocalTime.of(10, 0), doctor2);
        addVisit(LocalDate.of(2018, 6, 10), LocalTime.of(11, 0), doctor2);
        addVisit(LocalDate.of(2018, 6, 10), LocalTime.of(12, 0), doctor2);
        addVisit(LocalDate.of(2018, 6, 10), LocalTime.of(10, 0), doctor3);
        addVisit(LocalDate.of(2018, 6, 10), LocalTime.of(11, 0), doctor3);
        addVisit(LocalDate.of(2018, 6, 10), LocalTime.of(12, 0), doctor3);


    }


}
