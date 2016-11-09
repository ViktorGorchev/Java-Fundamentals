package bg.softuni.collections;

import bg.softuni.interfaces.EmergencyCenter;
import bg.softuni.interfaces.EmergencyCenterRegister;

import java.util.LinkedList;
import java.util.Queue;

public class EmergencyCenterRegisterImpl implements EmergencyCenterRegister {

    private Queue<EmergencyCenter> emergencyCenters;

    public EmergencyCenterRegisterImpl() {
        this.emergencyCenters = new LinkedList<>();
    }

    @Override
    public void enqueueEmergency(EmergencyCenter emergencyCenter) {
        this.emergencyCenters.add(emergencyCenter);
    }

    @Override
    public EmergencyCenter dequeueEmergency() {
        return this.emergencyCenters.remove();
    }

    @Override
    public EmergencyCenter peekEmergency() {
        return this.emergencyCenters.peek();
    }

    @Override
    public Boolean isEmpty() {
        if(this.emergencyCenters.size() == 0){
            return true;
        }

        return false;
    }
}
