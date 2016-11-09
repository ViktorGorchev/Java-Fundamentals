package commandsWithReflection;

import commandsWithReflection.commands.Executable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        Thread thread = new Thread();
        CommandInterpreter commandInterpreter = new CommandInterpreter(builder, thread);

        while (true){
            String[] data = reader.readLine().split(" ");
            String commandName = data[0];

            Executable command = commandInterpreter.interpretCommand(commandName, data);
            String result = command.execute();

            if(result.equalsIgnoreCase("end")){
                break;
            }

            System.out.println(result);
        }
    }
}
