package bg.softuni.interfaces;

public interface Creatable {
    Emergency createEmergency(String[] emergencyParams);

    EmergencyCenter createEmergencyCenter(String[] emergencyCenterParams);
}
