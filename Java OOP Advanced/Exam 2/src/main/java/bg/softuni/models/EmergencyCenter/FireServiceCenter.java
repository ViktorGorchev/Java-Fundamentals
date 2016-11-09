package bg.softuni.models.EmergencyCenter;

public class FireServiceCenter extends BaseEmergencyCenter{

    private static final String MANAGES_EMERGENCY_TYPE_PROPERTY = "PropertyEmergency";

    public FireServiceCenter(String name, Integer amountOfMaximumEmergencies) {
        super(name, amountOfMaximumEmergencies, MANAGES_EMERGENCY_TYPE_PROPERTY);
    }
}