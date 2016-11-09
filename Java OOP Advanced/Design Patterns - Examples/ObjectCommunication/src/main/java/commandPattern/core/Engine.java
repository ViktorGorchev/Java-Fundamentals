package commandPattern.core;

import commandPattern.interfaces.Command;
import commandPattern.interfaces.CommandDispatcher;
import commandPattern.interfaces.Runnable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Engine implements Runnable {
    private CommandDispatcher commandDispatcher;

    public Engine(CommandDispatcher commandDispatcher) {
        this.commandDispatcher = commandDispatcher;
    }

    public void run() {
        Scanner reader = new Scanner(System.in);

        while (true){
            List<String> input = new ArrayList<>(Arrays.asList(reader.nextLine().split("\\s+")));
            String inputCommand = input.remove(0);
            String[] inputCommandParams = input.toArray(new String[input.size()]);

            if(inputCommand.equalsIgnoreCase("end")){
                break;
            }

            Command command = this.commandDispatcher.dispatchCommand(inputCommand, inputCommandParams);

            String commandResult = command.execute();
            System.out.println(commandResult);
        }
    }
}
