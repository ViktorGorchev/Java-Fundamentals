package commandPatternWithCreateCommand.commands;

import commandPatternWithCreateCommand.models.Cat;
import commandPatternWithCreateCommand.models.Dog;
import commandPatternWithCreateCommand.interfaces.Animal;
import commandPatternWithCreateCommand.interfaces.Database;

public class CreateAnimalCommand extends CommandImpl{

    private Database database;
    private String type;

    public CreateAnimalCommand(Database database, String type) {
        this.database = database;
        this.type = type;
    }

    @Override
    public String execute() {
        Animal animal = null;

        switch (this.type){
            case "Cat":
                animal = new Cat();
                break;

            case "Dog":
                animal = new Dog();
                break;

            default:
                break;
        }

        this.database.addAnimal(animal);

        String result = "Animal created: " + animal.getType();
        return result;
    }
}
