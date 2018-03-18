package pl.sda.patient_registration_app.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.patient_registration_app.dto.DoctorDto;
import pl.sda.patient_registration_app.dto.VisitDto;
import pl.sda.patient_registration_app.entity.Doctor;
import pl.sda.patient_registration_app.entity.Visit;
import pl.sda.patient_registration_app.entity.Visit;
import pl.sda.patient_registration_app.repository.VisitsRepository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VisitsFinder {

    private VisitsRepository visitsRepository;
    private UtilsService utilsService;

    @Autowired
    public VisitsFinder(VisitsRepository visitsRepository, UtilsService utilsService) {
        this.visitsRepository = visitsRepository;
        this.utilsService = utilsService;
    }

    @Transactional
    public List<VisitDto> showAllVisits() {
        return visitsRepository.findAll().stream()
                .map(v -> utilsService.mapVisitToVisitDto(v))
                .collect(Collectors.toList());
    }

    public List<VisitDto> getVisitsByDate(LocalDate date) {
        List<Visit> foundedByDate = visitsRepository.findByDate(date);
        return foundedByDate.stream()
                .map(v -> utilsService.mapVisitToVisitDto(v))
                .collect(Collectors.toList());
    }

    public List<VisitDto> filterVisitsDtoByHour(List<VisitDto> visitsDto, LocalTime time){
        return visitsDto.stream()
                .filter(v -> v.getHourOfVisit().equals(time))
                .collect(Collectors.toList());
    }

    public List<VisitDto> getVisitsByHour(LocalTime time) {
        List<Visit> foundedByHour = visitsRepository.findByHour(time);
        return foundedByHour.stream()
                .map(v -> utilsService.mapVisitToVisitDto(v))
                .collect(Collectors.toList());
    }

    private List<VisitDto> getVisitsByDoctor(DoctorDto doctorDto){
        List<Visit> foundedDoctors = visitsRepository.findByDoctor(doctorDto);
        return foundedDoctors.stream()
                .map(v -> utilsService.mapVisitToVisitDto(v))
                .collect(Collectors.toList());

    }
    private List<VisitDto> filterVisitsDtoByDoctor(List<VisitDto> visitsDto, DoctorDto doctorDto){
        return visitsDto.stream()
                .filter(v -> v.getDoctor().equals(doctorDto))
                .collect(Collectors.toList());
    }
}
