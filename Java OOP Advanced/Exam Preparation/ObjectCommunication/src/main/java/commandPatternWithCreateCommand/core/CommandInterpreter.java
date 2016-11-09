package commandPatternWithCreateCommand.core;

import commandPatternWithCreateCommand.commands.BarkCommand;
import commandPatternWithCreateCommand.commands.CreateAnimalCommand;
import commandPatternWithCreateCommand.commands.SayCommand;
import commandPatternWithCreateCommand.interfaces.Command;
import commandPatternWithCreateCommand.interfaces.CommandDispatcher;
import commandPatternWithCreateCommand.interfaces.Database;

public class CommandInterpreter implements CommandDispatcher {

    private Database database;

    public CommandInterpreter(Database database) {
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
                createdCommand = new CreateAnimalCommand(this.database, animalType);
                break;

            default:
                break;
        }

        return createdCommand;
    }
}
