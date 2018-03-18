package pl.sda.patient_registration_app.type;

public enum DocSpecType {

    GYNECOLOGIST("ginekolog"),
    UROLOGIST("urolog"),
    DENTIST("dentysta");

    private String name;

    DocSpecType(String name) {
        this.name = name;
    }
}
