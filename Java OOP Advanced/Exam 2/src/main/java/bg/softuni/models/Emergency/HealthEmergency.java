package bg.softuni.models.Emergency;

import bg.softuni.enums.EmergencyLevel;
import bg.softuni.interfaces.Casualties;
import bg.softuni.models.RegistrationTime;

public class HealthEmergency extends BaseEmergency implements Casualties{

    private Integer casualtiesNumber;

    public HealthEmergency(
            String description,
            EmergencyLevel emergencyLevel,
            RegistrationTime registrationTime,
            Integer casualtiesNumber) {
        super(description, emergencyLevel, registrationTime);

        this.setCasualtiesNumber(casualtiesNumber);
    }

    public Integer getCasualtiesNumber() {
        return this.casualtiesNumber;
    }

    private void setCasualtiesNumber(Integer casualtiesNumber) {
        this.casualtiesNumber = casualtiesNumber;
    }
}
