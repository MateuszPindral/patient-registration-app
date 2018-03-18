package pl.sda.patient_registration_app.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.sda.patient_registration_app.dto.VisitDto;
import pl.sda.patient_registration_app.repository.VisitsRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VisitsFinder {

    private VisitsRepository visitsRepository;
    private UtilsService utilsService;

    @Autowired
    public VisitsFinder(VisitsRepository visitsRepository, UtilsService utilsService){
        this.visitsRepository = visitsRepository;
        this.utilsService = utilsService;
    }

    @Transactional
    public List<VisitDto> showAllVisits() {
        return visitsRepository.findAll().stream()
                .map(v -> utilsService.mapVisitToVisitDto(v))
                .collect(Collectors.toList());
    }

}
