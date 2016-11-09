package abstractFactoryPattern.factory;

import abstractFactoryPattern.interfaces.Animal;
import abstractFactoryPattern.interfaces.Plant;
import abstractFactoryPattern.models.animal.Cat;
import abstractFactoryPattern.models.animal.Dog;

public class AnimalFactory extends BaseFactory{

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
        return null;                            ///not good!!!!!!!!!!!!
    }
}
