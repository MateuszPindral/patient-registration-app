package pl.sda.patient_registration_app.bo;

import org.springframework.stereotype.Service;

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
