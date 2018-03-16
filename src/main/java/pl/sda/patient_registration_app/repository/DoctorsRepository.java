package pl.sda.patient_registration_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.patient_registration_app.entity.Doctor;

@Repository
public interface DoctorsRepository extends JpaRepository<Doctor, Long> {


}
