package pl.sda.patient_registration_app.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationController {

    @GetMapping("/rejestracja")
    public ModelAndView showRegistrationPage() {

        ModelAndView mav = new ModelAndView("rejestracja");

        return mav;
    }
}
