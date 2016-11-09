package commandPattern;

import commandPattern.core.CommandInterpreter;
import commandPattern.core.Engine;
import commandPattern.interfaces.CommandDispatcher;
import commandPattern.interfaces.Runnable;

public class Main {

    public static void main(String[] args) {
        CommandDispatcher commandDispatcher = new CommandInterpreter();

        Runnable engine = new Engine(commandDispatcher);
        engine.run();
    }
}
