package pl.sda.patient_registration_app.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NewUserController {

    @GetMapping(value = "/nowyUzytkownik")
    public ModelAndView showNewUserPage() {

        ModelAndView mav = new ModelAndView("nowyUzytkownik");



        return mav;
    }


}
