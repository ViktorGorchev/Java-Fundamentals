package abstractFactoryPattern.core;

import abstractFactoryPattern.factory.AnimalFactory;
import abstractFactoryPattern.factory.PlantFactory;
import abstractFactoryPattern.interfaces.Creatable;
import abstractFactoryPattern.interfaces.FactoryProducer;

public class FactoryProducerImpl implements FactoryProducer{

    @Override
    public Creatable getFactory(String type) {
        Creatable factory = null;

        switch (type){
            case "Cat":
            case "Dog":
                factory = new AnimalFactory();
                break;

            case "Tree":
            case "Grass":
                factory = new PlantFactory();

                default:
                    break;
        }

        return factory;
    }
}
