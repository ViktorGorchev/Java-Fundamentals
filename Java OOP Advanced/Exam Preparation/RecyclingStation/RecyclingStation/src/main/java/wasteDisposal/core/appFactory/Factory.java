package wasteDisposal.core.appFactory;

import wasteDisposal.contracts.Creatable;
import wasteDisposal.contracts.Waste;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Factory implements Creatable {

    private static final String PACKAGE_MODELS_WASTE = "wasteDisposal.models.";

    private static final String CONSTANT_WORD_IN_NAME = "Waste";

    @Override
    public Waste createWaste(String name, double weight, double volumePerKg, String wasteType) {
        Waste waste = null;

        try {
            Class wasteClass = Class.forName(PACKAGE_MODELS_WASTE + wasteType + CONSTANT_WORD_IN_NAME);
            Constructor constructor = wasteClass.getConstructor(String.class, double.class, double.class);
            waste = (Waste) constructor.newInstance(name, weight, volumePerKg);

        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException
                | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return waste;
    }
}
