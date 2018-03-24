package pl.sda.patient_registration_app.bo;


import org.springframework.stereotype.Service;
import pl.sda.patient_registration_app.annotations.EmailExistsException;
import pl.sda.patient_registration_app.dto.NewUserRegistrationDto;
import pl.sda.patient_registration_app.entity.Patient;
import pl.sda.patient_registration_app.entity.User;
import pl.sda.patient_registration_app.repository.PatientsRepository;
import pl.sda.patient_registration_app.repository.UserRepository;

@Service
public class NewPatientRegistrationService {

    private final UtilsService utilsService;
    private final PatientsRepository patientsRepository;

    public NewPatientRegistrationService(UtilsService utilsService, PatientsRepository patientsRepository) {
        this.utilsService = utilsService;
        this.patientsRepository = patientsRepository;
    }

    public Patient saveNewPatientToDB(NewUserRegistrationDto newUserRegistrationDto) throws EmailExistsException {

        if (emailExist(newUserRegistrationDto.getEmail())) {
            throw new EmailExistsException(
                    "There is an account with that email adress: "
                            + newUserRegistrationDto.getEmail());
        }


        Patient patient = utilsService.mapNewPatientRegistrationDtoToPatient(newUserRegistrationDto);

      //  user.setRoles(Arrays.asList("ROLE_USER"));
        return patientsRepository.save(patient);

    }







    private boolean emailExist(String email) {
        Patient patient = patientsRepository.findByEmail(email);
        if (patient != null) {
            return true;
        }
        return false;
    }

}
