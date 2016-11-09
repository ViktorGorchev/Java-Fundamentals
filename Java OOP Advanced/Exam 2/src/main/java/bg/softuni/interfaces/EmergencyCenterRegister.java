package bg.softuni.interfaces;

/**
 * Created by Admin on 28.8.2016 г..
 */
public interface EmergencyCenterRegister {

    void enqueueEmergency(EmergencyCenter emergencyCenter);

    EmergencyCenter dequeueEmergency();

    EmergencyCenter peekEmergency();

    Boolean isEmpty();
}
