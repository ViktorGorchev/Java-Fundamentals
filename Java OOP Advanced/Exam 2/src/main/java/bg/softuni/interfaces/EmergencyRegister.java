package bg.softuni.interfaces;

public interface EmergencyRegister {

    void enqueueEmergency(Emergency emergency);

    Emergency dequeueEmergency();

    Emergency peekEmergency();

    Boolean isEmpty();
}
