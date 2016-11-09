package commandPatternWithCreateCommand;

import commandPatternWithCreateCommand.core.CommandInterpreter;
import commandPatternWithCreateCommand.core.DatabaseImpl;
import commandPatternWithCreateCommand.core.Engine;
import commandPatternWithCreateCommand.interfaces.CommandDispatcher;
import commandPatternWithCreateCommand.interfaces.Database;
import commandPatternWithCreateCommand.interfaces.Runnable;

public class Main {

    public static void main(String[] args) {
        Database database = new DatabaseImpl();
        CommandDispatcher commandDispatcher = new CommandInterpreter(database);

        Runnable engine = new Engine(commandDispatcher);
        engine.run();
    }
}
