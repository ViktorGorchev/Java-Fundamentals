package bg.softuni.models.EmergencyCenter;

public class MedicalServiceCenter extends BaseEmergencyCenter{

    private static final String MANAGES_EMERGENCY_TYPE_HEALTH = "HealthEmergency";

    public MedicalServiceCenter(String name, Integer amountOfMaximumEmergencies) {
        super(name, amountOfMaximumEmergencies, MANAGES_EMERGENCY_TYPE_HEALTH);
    }
}
