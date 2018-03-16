package pl.sda.patient_registration_app.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.sda.patient_registration_app.type.DocSpecType;

import javax.persistence.*;
import java.util.Set;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "doctors")
public class Doctor extends User{



    @OneToMany(mappedBy = "doctor")
    private Set<Visit> visits;

    @Column(name = "specialization")
    @Enumerated(value = EnumType.STRING)
    private DocSpecType specialization;

}
