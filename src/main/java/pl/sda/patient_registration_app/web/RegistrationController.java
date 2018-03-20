package pl.sda.patient_registration_app.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.patient_registration_app.bo.*;
import pl.sda.patient_registration_app.type.DocSpecType;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class RegistrationController {

    private final RegistrationFinder registrationFinder;
    private final RegistrationService registrationService;
    private final VisitsService visitsService;
    private final DoctorDaysService doctorDaysService;
    private final UtilsService utilsService;

    @Autowired
    public RegistrationController(RegistrationFinder registrationFinder, RegistrationService registrationService, VisitsService visitsService, DoctorDaysService doctorDaysService, UtilsService utilsService) {
        this.registrationFinder = registrationFinder;
        this.registrationService = registrationService;
        this.visitsService = visitsService;
        this.doctorDaysService = doctorDaysService;
        this.utilsService = utilsService;
    }

    private List<String> convertSpecEnum() { //testy do tego!
        //List<String> afterConvert = new ArrayList<>();
        List<DocSpecType> docSpecTypes = Arrays.asList(DocSpecType.values());
        List<String> docSpecNames = docSpecTypes.stream()
                .map(s -> s.getName())
                .collect(Collectors.toList());
        docSpecNames.sort(String::compareTo);
        return docSpecNames;
    }

    @GetMapping("/rejestracja")
    public ModelAndView showRegistrationPage() {
        ModelAndView mav = new ModelAndView("rejestracja");

        //mav.addObject("visits", registrationFinder.showAllVisits());
        mav.addObject("docSpecEnum", convertSpecEnum());
        return mav;
    }

    @GetMapping("/rejestracja/specjalista")
    public ModelAndView showDoctorsSchedule(@RequestParam("specType") String specName) {
        ModelAndView mav = new ModelAndView("tabelaWizyt");
        // dodać filtrowanie po specjalizacji
        mav.addObject("doctorDayDtoList",
                doctorDaysService.createDayDtoFromDoctorDtoAndDate(LocalDate.of(2018, 6, 10)));
        mav.addObject("hours", utilsService.getHours());
        return mav;
    }

    @PostMapping("/rejestracja/specjalista")/*/rejestracja/specjalista?visitId=3*/
    public ModelAndView registerPatientToVisit(@RequestParam("visitId") Long visitId){
        ModelAndView mav = new ModelAndView("podsumowanieRejestracji");
        visitsService.registerPatient(visitId, Long.valueOf(8)); // 8 to id patienta
        //mav.addObject("id", visitId);
        return mav;
    }
}
