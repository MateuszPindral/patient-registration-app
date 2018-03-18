package pl.sda.patient_registration_app.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.patient_registration_app.dto.VisitDto;
import pl.sda.patient_registration_app.repository.VisitsRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VisitsFinder {

    private VisitsRepository visitsRepository;
    private UtilsService utilsService;
    private VisitsService visitsService;

    @Autowired
    public VisitsFinder(VisitsRepository visitsRepository, UtilsService utilsService, VisitsService visitsService){
        this.visitsRepository = visitsRepository;
        this.utilsService = utilsService;
        this.visitsService = visitsService;
    }

    @Transactional
    public List<VisitDto> showAllVisits() {

        visitsService.fillDBwithVisits();

        return visitsRepository.findAll().stream()
                .map(v -> utilsService.mapVisitToVisitDto(v))
                .collect(Collectors.toList());
    }

}
