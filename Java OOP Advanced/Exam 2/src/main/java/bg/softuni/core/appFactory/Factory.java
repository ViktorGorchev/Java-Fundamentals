package bg.softuni.core.appFactory;

import bg.softuni.interfaces.Creatable;
import bg.softuni.interfaces.Emergency;
import bg.softuni.interfaces.EmergencyCenter;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Factory implements Creatable{

    private static final String EMERGENCY_CENTER_PACKAGE = "bg.softuni.models.EmergencyCenter.";

    private static final String EMERGENCY_PACKAGE = "bg.softuni.models.Emergency.";

    public Emergency createEmergency(String[] emergencyParams) {
        //TODO

        return null;
    }

    public EmergencyCenter createEmergencyCenter(String[] emergencyCenterParams) {
        String className = emergencyCenterParams[0];
        String centerName = emergencyCenterParams[1];
        Integer amountOfMaximumEmergencies = Integer.parseInt(emergencyCenterParams[2]);

        EmergencyCenter emergencyCenter = null;
        try {
            Class emergencyCenterClass = Class.forName(
                    EMERGENCY_CENTER_PACKAGE + className);
            Constructor constructor = emergencyCenterClass.getDeclaredConstructor(String.class, Integer.class);
            emergencyCenter = (EmergencyCenter) constructor.newInstance(centerName, amountOfMaximumEmergencies);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return emergencyCenter;
    }
}
