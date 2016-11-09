package commandPatternWithCreateCommand.core;

import commandPatternWithCreateCommand.interfaces.Animal;
import commandPatternWithCreateCommand.interfaces.Database;

import java.util.ArrayList;
import java.util.List;

public class DatabaseImpl implements Database{
    private List<Animal> animals;

    public DatabaseImpl() {
        this.animals = new ArrayList<>();
    }

    public void addAnimal(Animal animal){
        this.animals.add(animal);
    }
}
