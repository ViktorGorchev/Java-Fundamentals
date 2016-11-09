package bg.softuni.core;

import bg.softuni.interfaces.*;

public class EmergencyManagementSystemImpl implements EmergencyManagementSystem {

    private EmergencyRegister emergencyRegister;

    private EmergencyCenterRegister emergencyCenterRegister;

    public EmergencyManagementSystemImpl(
            EmergencyRegister emergencyRegister,
            EmergencyCenterRegister emergencyCenterRegister) {
        this.emergencyRegister = emergencyRegister;
        this.emergencyCenterRegister = emergencyCenterRegister;
    }

    @Override
    public String registerPropertyEmergency(Emergency emergency) {
        this.emergencyRegister.enqueueEmergency(emergency);
        String result =
                String.format(
                        "Registered Public Property Emergency of level %s at %s.",
                        emergency.getEmergencyLevel(),
                        emergency.getRegistrationTime().toString());

        return result;
    }

    @Override
    public String registerHealthEmergency(Emergency emergency) {
        this.emergencyRegister.enqueueEmergency(emergency);
        String result =
                String.format(
                        "Registered Public Health Emergency Emergency of level %s at %s.",
                        emergency.getEmergencyLevel(),
                        emergency.getRegistrationTime().toString());

        return result;
    }

    @Override
    public String registerOrderEmergency(Emergency emergency) {
        this.emergencyRegister.enqueueEmergency(emergency);
        String result =
                String.format(
                        "Registered Public Order Emergency Emergency of level %s at %s.",
                        emergency.getEmergencyLevel(),
                        emergency.getRegistrationTime().toString());

        return result;
    }

    @Override
    public String registerFireServiceCenter(EmergencyCenter emergencyCenter) {
        this.emergencyCenterRegister.enqueueEmergency(emergencyCenter);
        String result =
                String.format("Registered Fire Service Emergency center – %s.", emergencyCenter.getName());

        return result;
    }

    @Override
    public String registerMedicalServiceCenter(EmergencyCenter emergencyCenter) {
        this.emergencyCenterRegister.enqueueEmergency(emergencyCenter);
        String result =
                String.format("Registered Medical Service Emergency center – %s.", emergencyCenter.getName());

        return result;
    }

    @Override
    public String registerPoliceServiceCenter(EmergencyCenter emergencyCenter) {
        this.emergencyCenterRegister.enqueueEmergency(emergencyCenter);
        String result =
                String.format("Registered Police Service Emergency center – %s.", emergencyCenter.getName());

        return result;
    }

    @Override
    public String processEmergencies(String priority) {
        return null;
    }

    @Override
    public String emergencyReport() {
        return null;
    }
}
