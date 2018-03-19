package pl.sda.patient_registration_app.dto;

import org.springframework.beans.factory.annotation.Autowired;
import pl.sda.patient_registration_app.bo.UtilsService;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class DoctorDayDto {


    private UtilsService utilsService;

    private DoctorDto doctorDto;
    private List<VisitDto> visits;
    private final List<LocalTime> HOURS = utilsService.getHours();

    @Autowired
    public DoctorDayDto(UtilsService utilsService) {
        this.utilsService = utilsService;
    }


}
