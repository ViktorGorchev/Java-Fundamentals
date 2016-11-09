package reflection_CommandPaternAndFactoryPattern.commands;

import reflection_CommandPaternAndFactoryPattern.anottations.Inject;
import reflection_CommandPaternAndFactoryPattern.interfaces.Creatable;
import reflection_CommandPaternAndFactoryPattern.interfaces.Database;
import reflection_CommandPaternAndFactoryPattern.interfaces.Plant;

/**
 * Created by Admin on 25.8.2016 г..
 */
public class CreatePlantCommand extends CommandImpl {

    @Inject
    private Creatable factory;

    @Inject
    private Database database;

    private String type;

    public CreatePlantCommand(String type) {
        this.type = type;
    }

    @Override
    public String execute() {
        String resultMessage = null;

        Plant plant = this.factory.createPlant(this.type);
        this.database.addPlant(plant);
        resultMessage = "Created plant: " + plant.getType();

        return resultMessage;
    }
}
