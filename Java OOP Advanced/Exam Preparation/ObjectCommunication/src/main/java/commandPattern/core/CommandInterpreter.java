package commandPattern.core;

import commandPattern.commands.BarkCommand;
import commandPattern.commands.SayCommand;
import commandPattern.interfaces.Command;
import commandPattern.interfaces.CommandDispatcher;

public class CommandInterpreter implements CommandDispatcher {

    public Command dispatchCommand(String command, String[] commandParams) {
        Command createdCommand = null;

        switch (command){
            case "Say":
                createdCommand = new SayCommand(commandParams);
                break;

            case "Bark":
                createdCommand = new BarkCommand();
                break;

            default:
                break;
        }

        return createdCommand;
    }
}
