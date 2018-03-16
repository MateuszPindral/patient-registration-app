package pl.sda.patient_registration_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import pl.sda.patient_registration_app.dto.DoctorDto;
import pl.sda.patient_registration_app.entity.Doctor;
import pl.sda.patient_registration_app.type.DocSpecType;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface DoctorsRepository extends JpaRepository<Doctor,Long>{




}
