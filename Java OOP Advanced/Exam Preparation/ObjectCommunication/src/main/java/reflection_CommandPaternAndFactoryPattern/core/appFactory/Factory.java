package reflection_CommandPaternAndFactoryPattern.core.appFactory;

import reflection_CommandPaternAndFactoryPattern.interfaces.Animal;
import reflection_CommandPaternAndFactoryPattern.interfaces.Creatable;
import reflection_CommandPaternAndFactoryPattern.interfaces.Plant;

public class Factory implements Creatable {

    private static final String ANIMAL_PACKAGE = "reflection_CommandPaternAndFactoryPattern.models.animal.";

    private static final String PLANT_PACKAGE = "reflection_CommandPaternAndFactoryPattern.models.plant.";

    @Override
    public Animal createAnimal(String type) {
        Animal animal = null;

        try {
            Class animalClass = Class.forName(ANIMAL_PACKAGE + type);
            animal = (Animal) animalClass.newInstance();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return animal;
    }

    @Override
    public Plant createPlant(String type) {
        Plant plant = null;

        try {
            Class plantClass = Class.forName(PLANT_PACKAGE + type);
            plant = (Plant) plantClass.newInstance();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return plant;
    }
}
