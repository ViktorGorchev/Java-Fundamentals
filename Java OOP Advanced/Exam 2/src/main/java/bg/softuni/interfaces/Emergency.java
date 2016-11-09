package bg.softuni.interfaces;

import bg.softuni.enums.EmergencyLevel;
import bg.softuni.models.RegistrationTime;

public interface Emergency {
    String getDescription();

    EmergencyLevel getEmergencyLevel();

    RegistrationTime getRegistrationTime();
}
