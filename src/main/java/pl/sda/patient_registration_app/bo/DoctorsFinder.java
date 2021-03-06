package pl.sda.patient_registration_app.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sda.patient_registration_app.dto.DoctorDto;
import pl.sda.patient_registration_app.repository.DoctorsRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DoctorsFinder {

    private DoctorsService doctorsService;
    private DoctorsRepository doctorsRepository;
    private UtilsService utilsService;

    @Autowired
    public DoctorsFinder(DoctorsRepository doctorsRepository, UtilsService utilsService, DoctorsService doctorsService) {
        this.doctorsRepository = doctorsRepository;
        this.doctorsService = doctorsService;
        this.utilsService = utilsService;
    }

    @Transactional
    public List<DoctorDto> showAllDoctors() {
        //doctorsService.fillDBwithDoctors();
        return doctorsRepository.findAll().stream()
                .map(v -> utilsService.mapDoctorToDoctorDto(v))
                .collect(Collectors.toList());
    }


}
