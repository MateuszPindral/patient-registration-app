package pl.sda.patient_registration_app.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.patient_registration_app.dto.DoctorDayDto;
import pl.sda.patient_registration_app.dto.DoctorDto;
import pl.sda.patient_registration_app.dto.VisitDto;
import pl.sda.patient_registration_app.entity.Visit;
import pl.sda.patient_registration_app.repository.VisitsRepository;
import pl.sda.patient_registration_app.type.VisitStatusType;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorDaysService {

    private VisitsRepository visitsRepository;
    private UtilsService utilsService;
    private DoctorsFinder doctorsFinder;


    @Autowired
    public DoctorDaysService(VisitsRepository visitsRepository, UtilsService utilsService, DoctorsFinder doctorsFinder) {
        this.visitsRepository = visitsRepository;
        this.utilsService = utilsService;
        this.doctorsFinder = doctorsFinder;
    }

    public void addVisitsToDayVisitList(DoctorDayDto doctorDayDto) {
        List<Visit> visitsByDate = visitsRepository.findByDate(doctorDayDto.getDate());
        List<VisitDto> visitsByDoctor = visitsByDate.stream()
                .filter(v -> v.getDoctor().equals(doctorDayDto.getDoctorDto()))
                .map(v -> utilsService.mapVisitToVisitDto(v))
                .collect(Collectors.toList());

        for (VisitDto visit : visitsByDoctor) {
            visit.setStatus(VisitStatusType.AVAILABLE);
        }

        doctorDayDto.getVisits().addAll(visitsByDoctor);

        fillListWithNoExistingVisits(doctorDayDto.getVisits());
    }

    private void fillListWithNoExistingVisits(List<VisitDto> visitsDto) {
        LocalTime temptime = LocalTime.of(0, 0);
        List<VisitDto> tempVisits = new ArrayList<>();
        for (int i = 6; i <= 19; i++) {
            temptime = LocalTime.of(i, 0);
            boolean isContaining = false;
            for (VisitDto visitDto : visitsDto) {
                if (visitDto.getHourOfVisit().equals(temptime)) {
                    isContaining = true;
                    break;
                }
            }
            if (isContaining == false) {
                visitsDto.add(VisitDto.builder()
                        .status(VisitStatusType.NOT_EXIST)
                        .hourOfVisit(LocalTime.of(i, 0))
                        .build());
            }

            /*for (VisitDto visitDto : visitsDto) {
                if (visitDto.getHourOfVisit().equals(temptime)) {
                    continue;
                }
                tempVisits.add(VisitDto.builder()
                        .status(VisitStatusType.NOT_EXIST)
                        .build());
            }
            visitsDto.add(VisitDto.builder().status(VisitStatusType.NOT_EXIST)
                    .build());*/
        }
    }

    private List<VisitDto> sortByHour(List<VisitDto> visitsDto){
        return visitsDto.stream()
                .sorted(VisitDto::compareTo)
                .collect(Collectors.toList());
    }

    public List<DoctorDayDto> createDayDtoFromDoctorDtoAndDate(LocalDate date){

        List<DoctorDayDto> doctorDaysDto = new ArrayList<>();
        List<DoctorDto> doctorsDto = doctorsFinder.showAllDoctors();

        for (DoctorDto doctorDto : doctorsDto){
            DoctorDayDto doctorDayDto = DoctorDayDto.builder()
                    .doctorDto(doctorDto)
                    .date(date)
                    .visits(new ArrayList<>())
                    .build();
            addVisitsToDayVisitList(doctorDayDto);
            //sortByHour(doctorDayDto.getVisits());
            doctorDayDto.setVisits(sortByHour(doctorDayDto.getVisits()));
            doctorDaysDto.add(doctorDayDto);
        }

        return doctorDaysDto;

    }

}
