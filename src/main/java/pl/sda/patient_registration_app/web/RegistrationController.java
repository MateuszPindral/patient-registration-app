package pl.sda.patient_registration_app.web;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.patient_registration_app.bo.RegistrationFinder;
import pl.sda.patient_registration_app.bo.RegistrationService;

@Controller
public class RegistrationController {

    private final RegistrationFinder registrationFinder;
    private final RegistrationService registrationService;

    @Autowired
    public RegistrationController(RegistrationFinder registrationFinder, RegistrationService registrationService) {
        this.registrationFinder = registrationFinder;
        this.registrationService = registrationService;
    }

    @GetMapping("/rejestracja")
    public ModelAndView showRegistrationPage() {
        registrationService.addVisits();
        ModelAndView mav = new ModelAndView("rejestracja");

        mav.addObject("visits", registrationFinder.showAllVisits());

        return mav;
    }
}
