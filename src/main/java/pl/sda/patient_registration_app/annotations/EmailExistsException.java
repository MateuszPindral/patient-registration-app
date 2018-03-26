package pl.sda.patient_registration_app.annotations;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmailExistsException extends Throwable {

    private String errorMsg;

    @Override
    public String toString() {
        return errorMsg;
    }
}
