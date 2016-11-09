package commandPatternAndFactoryPattern.core;

import commandPatternAndFactoryPattern.commands.BarkCommand;
import commandPatternAndFactoryPattern.commands.CreateCommand;
import commandPatternAndFactoryPattern.commands.SayCommand;
import commandPatternAndFactoryPattern.interfaces.Command;
import commandPatternAndFactoryPattern.interfaces.CommandDispatcher;
import commandPatternAndFactoryPattern.interfaces.Creatable;
import commandPatternAndFactoryPattern.interfaces.Database;

public class CommandDispatcherImpl implements CommandDispatcher {

    private Creatable factory;

    private Database database;

    public CommandDispatcherImpl(Creatable factory, Database database) {
        this.factory = factory;
        this.database = database;
    }

    public Command dispatchCommand(String command, String[] commandParams) {
        Command createdCommand = null;

        switch (command){
            case "Say":
                createdCommand = new SayCommand(commandParams);
                break;

            case "Bark":
                createdCommand = new BarkCommand();
                break;

            case "Create":
                String animalType = commandParams[0];
                createdCommand = new CreateCommand(this.factory, this.database, animalType);
                break;

            default:
                break;
        }

        return createdCommand;
    }
}
