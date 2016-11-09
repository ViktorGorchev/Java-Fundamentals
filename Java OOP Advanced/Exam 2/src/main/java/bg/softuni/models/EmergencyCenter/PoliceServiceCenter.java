package bg.softuni.models.EmergencyCenter;

public class PoliceServiceCenter extends BaseEmergencyCenter{

    private static final String MANAGES_EMERGENCY_TYPE_ORDER = "OrderEmergency";

    public PoliceServiceCenter(String name, Integer amountOfMaximumEmergencies) {
        super(name, amountOfMaximumEmergencies, MANAGES_EMERGENCY_TYPE_ORDER);
    }
}