package bg.softuni.models.Emergency;

import bg.softuni.enums.EmergencyLevel;
import bg.softuni.interfaces.PropertyDamage;
import bg.softuni.models.RegistrationTime;

public class PropertyEmergency extends BaseEmergency implements PropertyDamage{

    private Integer propertyDamage;

    public PropertyEmergency(
            String description,
            EmergencyLevel emergencyLevel,
            RegistrationTime registrationTime,
            Integer propertyDamage) {
        super(description, emergencyLevel, registrationTime);

        this.setPropertyDamage(propertyDamage);
    }

    public Integer getPropertyDamage() {
        return this.propertyDamage;
    }

    private void setPropertyDamage(Integer propertyDamage) {
        this.propertyDamage = propertyDamage;
    }
}
