package pl.sda.patient_registration_app.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.sda.patient_registration_app.bo.*;

@Controller
public class PokazywarkaController {


    private final VisitsService visitsService;
    private final VisitsFinder visitsFinder;
    private final DoctorsService doctorsService;
    private final DoctorsFinder doctorsFinder;

    @Autowired
    public PokazywarkaController(VisitsService visitsService, VisitsFinder visitsFinder, DoctorsService doctorsService, DoctorsFinder doctorsFinder) {
        this.visitsService = visitsService;
        this.visitsFinder = visitsFinder;
        this.doctorsService = doctorsService;
        this.doctorsFinder = doctorsFinder;
    }

    @GetMapping("/pokazywarkaWizyt")
    public ModelAndView showPokazywarkaPage() {

        ModelAndView mav = new ModelAndView("pokazywarkaWizyt");

        mav.addObject("wizyty", visitsFinder.showAllVisits());

        return mav;
    }

}
