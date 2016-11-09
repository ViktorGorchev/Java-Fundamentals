package commandPatternAndFactoryPattern.core.appFactory;

import commandPatternAndFactoryPattern.interfaces.Animal;
import commandPatternAndFactoryPattern.interfaces.Creatable;
import commandPatternAndFactoryPattern.interfaces.Plant;
import commandPatternAndFactoryPattern.models.animal.Cat;
import commandPatternAndFactoryPattern.models.animal.Dog;
import commandPatternAndFactoryPattern.models.plant.Grass;
import commandPatternAndFactoryPattern.models.plant.Tree;

public class Factory implements Creatable{

    @Override
    public Animal createAnimal(String type) {
        Animal animal = null;

        switch (type){
            case "Cat":
                animal = new Cat();
                break;

            case "Dog":
                animal = new Dog();
                break;

            default:
                break;
        }

        return animal;
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
