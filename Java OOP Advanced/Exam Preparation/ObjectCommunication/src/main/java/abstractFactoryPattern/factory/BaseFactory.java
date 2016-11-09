package abstractFactoryPattern.factory;

import abstractFactoryPattern.interfaces.Animal;
import abstractFactoryPattern.interfaces.Creatable;
import abstractFactoryPattern.interfaces.Plant;

public abstract class BaseFactory implements Creatable{

    public abstract Animal createAnimal(String type);

    public abstract Plant createPlant(String type);
}
