package abstractFactoryPattern.interfaces;

public interface Creatable {

    Animal createAnimal(String type);

    Plant createPlant(String type);
}
