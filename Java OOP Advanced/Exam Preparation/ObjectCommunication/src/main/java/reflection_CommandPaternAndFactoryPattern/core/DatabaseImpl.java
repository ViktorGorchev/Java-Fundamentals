package reflection_CommandPaternAndFactoryPattern.core;

import reflection_CommandPaternAndFactoryPattern.interfaces.Animal;
import reflection_CommandPaternAndFactoryPattern.interfaces.Database;
import reflection_CommandPaternAndFactoryPattern.interfaces.Plant;

import java.util.ArrayList;
import java.util.List;

public class DatabaseImpl implements Database {
    private List<Animal> animals;

    private List<Plant> plants;

    public DatabaseImpl() {
        this.animals = new ArrayList<>();
        this.plants = new ArrayList<>();
    }

    public void addAnimal(Animal animal){
        this.animals.add(animal);
    }

    public void addPlant(Plant plant){
        this.plants.add(plant);
    }
}
