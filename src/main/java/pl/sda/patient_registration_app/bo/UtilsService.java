package pl.sda.patient_registration_app.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import pl.sda.patient_registration_app.dto.DoctorDto;
import pl.sda.patient_registration_app.dto.PatientDto;
import pl.sda.patient_registration_app.dto.VisitDto;
import pl.sda.patient_registration_app.entity.Doctor;
import pl.sda.patient_registration_app.entity.Patient;
import pl.sda.patient_registration_app.entity.Visit;
import pl.sda.patient_registration_app.repository.VisitsRepository;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UtilsService {

    public PatientDto mapPatientToPatientDto(Patient patient) {
        //List<VisitDto> visits = mapVisitsToVisitsDto(patient.getVisits());
        if (patient != null) {
            return PatientDto.builder()
                    .id(patient.getId())
                    .name(patient.getFirstName())
                    .lastName(patient.getLastName())
                    //.plannedVisits(visits)
                    .build();
        } else {
            return null;
        }
    }

    public DoctorDto mapDoctorToDoctorDto(Doctor doctor) {
        //List<VisitDto> visit = mapVisitsToVisitsDto(doctor.getVisits());
        return DoctorDto.builder()
                .id(doctor.getId())
                .name(doctor.getFirstName())
                .lastName(doctor.getLastName())
                .specialization(doctor.getSpecialization())
                //.visits(visit)
                .build();
    }

    private List<VisitDto> mapVisitsToVisitsDto(Set<Visit> visits) {
        return visits.stream()
                .map(v -> mapVisitToVisitDto(v))
                .collect(Collectors.toList());
    }

    public VisitDto mapVisitToVisitDto(Visit visit) {
        return VisitDto.builder()
                .id(visit.getId())
                .doctor(mapDoctorToDoctorDto(visit.getDoctor()))
                .patient(mapPatientToPatientDto(visit.getPatient()))
                .dayOfVisit(visit.getDate())
                .hourOfVisit(visit.getTime())
                .build();
    }

    public List<LocalTime> getHours(){
        List<LocalTime> hours = new ArrayList<>();
        for (int i = 6; i <= 19; i++){
            hours.add(LocalTime.of(i, 0));
        }
        return hours;
    }

    public Doctor mapDoctorDtoToDoctor(DoctorDto doctorDto) {
        Doctor doctor = new Doctor();
        doctor.setId(doctorDto.getId());
        return doctor;
    }
}
