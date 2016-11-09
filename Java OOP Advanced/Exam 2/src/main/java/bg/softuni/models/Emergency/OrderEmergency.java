package bg.softuni.models.Emergency;

import bg.softuni.enums.EmergencyLevel;
import bg.softuni.interfaces.EmergencyStatus;
import bg.softuni.models.RegistrationTime;

public class OrderEmergency extends BaseEmergency implements EmergencyStatus{

    private boolean emergencyStatus;

    public OrderEmergency(
            String description,
            EmergencyLevel emergencyLevel,
            RegistrationTime registrationTime,
            boolean emergencyStatus) {
        super(description, emergencyLevel, registrationTime);

        this.setEmergencyStatus(emergencyStatus);
    }

    public boolean isEmergencyStatus() {
        return this.emergencyStatus;
    }

    private void setEmergencyStatus(boolean emergencyStatus) {
        this.emergencyStatus = emergencyStatus;
    }
}
