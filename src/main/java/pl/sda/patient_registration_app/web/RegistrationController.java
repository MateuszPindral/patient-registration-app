package pl.sda.patient_registration_app.web;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.patient_registration_app.bo.RegistrationFinder;

@Controller
public class RegistrationController {

    private final RegistrationFinder registrationFinder;

    @Autowired
    public RegistrationController(RegistrationFinder registrationFinder) {
        this.registrationFinder = registrationFinder;
    }

    @GetMapping("/rejestracja")
    public ModelAndView showRegistrationPage() {

        ModelAndView mav = new ModelAndView("rejestracja");

        mav.addObject("visits", registrationFinder.showAllVisits());

        return mav;
    }
}
