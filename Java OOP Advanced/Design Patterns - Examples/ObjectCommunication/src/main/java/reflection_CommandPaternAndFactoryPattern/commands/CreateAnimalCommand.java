package reflection_CommandPaternAndFactoryPattern.commands;

import reflection_CommandPaternAndFactoryPattern.anottations.Inject;
import reflection_CommandPaternAndFactoryPattern.interfaces.Animal;
import reflection_CommandPaternAndFactoryPattern.interfaces.Creatable;
import reflection_CommandPaternAndFactoryPattern.interfaces.Database;

public class CreateAnimalCommand extends CommandImpl {

    @Inject
    private Creatable factory;

    @Inject
    private Database database;

    private String type;

    public CreateAnimalCommand(String type) {
        this.type = type;
    }

    @Override
    public String execute() {
        String resultMessage = null;

        Animal animal = this.factory.createAnimal(this.type);
        this.database.addAnimal(animal);
        resultMessage = "Created animal: " + animal.getType();

        return resultMessage;
    }
}
