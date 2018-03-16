package pl.sda.patient_registration_app.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sda.patient_registration_app.dto.DoctorDto;
import pl.sda.patient_registration_app.dto.PatientDto;
import pl.sda.patient_registration_app.dto.VisitDto;
import pl.sda.patient_registration_app.entity.Doctor;
import pl.sda.patient_registration_app.entity.Patient;
import pl.sda.patient_registration_app.entity.Visit;
import pl.sda.patient_registration_app.repository.VisitsRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@Service
public class RegistrationFinder {

    private VisitsRepository visitsRepository;

    @Autowired
    public RegistrationFinder(VisitsRepository visitsRepository) {
        this.visitsRepository = visitsRepository;
    }

    private List<VisitDto> mapVisitsToVisitsDto(Set<Visit> visits) {
        return visits.stream()
                .map(v -> mapVisitToVisitDto(v))
                .collect(Collectors.toList());
    }

    private PatientDto mapPatientToPatientDto(Patient patient) {
        //List<VisitDto> visits = mapVisitsToVisitsDto(patient.getVisits());
        return PatientDto.builder()
                .id(patient.getId())
                .name(patient.getFirstName())
                .lastName(patient.getLastName())
                //.plannedVisits(visits)
                .build();
    }

    private DoctorDto mapDoctorToDoctorDto(Doctor doctor) {
        //List<VisitDto> visit = mapVisitsToVisitsDto(doctor.getVisits());
        return DoctorDto.builder()
                .id(doctor.getId())
                .name(doctor.getFirstName())
                .lastName(doctor.getLastName())
                .specialization(doctor.getSpecialization())
                //.visits(visit)
                .build();
    }

    private VisitDto mapVisitToVisitDto(Visit visit) {
        return VisitDto.builder()
                .patient(mapPatientToPatientDto(visit.getPatient()))
                .doctor(mapDoctorToDoctorDto(visit.getDoctor()))
                .dayOfVisit(visit.getDate())
                .hourOfVisit(visit.getTime())
                .build();
    }

    @Transactional
    public List<VisitDto> showAllVisits() {
        return visitsRepository.findAll().stream()
                .map(v -> mapVisitToVisitDto(v))
                .collect(Collectors.toList());
    }


}
