package pl.sda.patient_registration_app.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.patient_registration_app.bo.RegistrationFinder;
import pl.sda.patient_registration_app.bo.RegistrationService;
import pl.sda.patient_registration_app.bo.VisitsService;
import pl.sda.patient_registration_app.type.DocSpecType;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class RegistrationController {

    private final RegistrationFinder registrationFinder;
    private final RegistrationService registrationService;
    private final VisitsService visitsService;

    @Autowired
    public RegistrationController(RegistrationFinder registrationFinder, RegistrationService registrationService, VisitsService visitsService) {
        this.registrationFinder = registrationFinder;
        this.registrationService = registrationService;
        this.visitsService = visitsService;
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
        return null;
    }
}
