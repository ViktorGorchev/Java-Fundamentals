package abstractFactoryPattern.factory;

import abstractFactoryPattern.interfaces.Animal;
import abstractFactoryPattern.interfaces.Plant;
import abstractFactoryPattern.models.plant.Grass;
import abstractFactoryPattern.models.plant.Tree;

public class PlantFactory extends BaseFactory{

    @Override
    public Animal createAnimal(String type) {
        return null;                            ////not good!!!!!!!!
    }

    @Override
    public Plant createPlant(String type) {
        Plant plant = null;

        switch (type){
            case "Tree":
                plant = new Tree();
                break;

            case "Grass":
                plant = new Grass();
                break;

            default:
                break;
        }

        return plant;
    }
}
