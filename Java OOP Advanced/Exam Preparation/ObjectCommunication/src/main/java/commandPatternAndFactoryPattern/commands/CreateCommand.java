package commandPatternAndFactoryPattern.commands;

import commandPatternAndFactoryPattern.interfaces.Animal;
import commandPatternAndFactoryPattern.interfaces.Creatable;
import commandPatternAndFactoryPattern.interfaces.Database;
import commandPatternAndFactoryPattern.interfaces.Plant;

public class CreateCommand extends CommandImpl {

    private Creatable factory;

    private Database database;

    private String type;

    public CreateCommand(Creatable factory, Database database, String type) {
        this.factory = factory;
        this.database = database;
        this.type = type;
    }

    @Override
    public String execute() {
        String resultMessage = null;

        switch (this.type){
            case "Cat":
            case "Dog":
                Animal animal = this.factory.createAnimal(this.type);
                this.database.addAnimal(animal);
                resultMessage = "Created animal: " + animal.getType();
                break;

            case "Tree":
            case "Grass":
                Plant plant = this.factory.createPlant(this.type);
                this.database.addPlant(plant);
                resultMessage = "Created plant: " + plant.getType();
                break;

            default:
                break;
        }

        return resultMessage;
    }
}
