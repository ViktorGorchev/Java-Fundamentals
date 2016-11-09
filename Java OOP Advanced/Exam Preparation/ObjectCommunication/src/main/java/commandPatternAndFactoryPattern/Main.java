package commandPatternAndFactoryPattern;

import commandPatternAndFactoryPattern.core.CommandDispatcherImpl;
import commandPatternAndFactoryPattern.core.DatabaseImpl;
import commandPatternAndFactoryPattern.core.Engine;
import commandPatternAndFactoryPattern.core.appFactory.Factory;
import commandPatternAndFactoryPattern.interfaces.CommandDispatcher;
import commandPatternAndFactoryPattern.interfaces.Creatable;
import commandPatternAndFactoryPattern.interfaces.Database;
import commandPatternAndFactoryPattern.interfaces.Runnable;

public class Main {

    public static void main(String[] args) {
        Creatable factory = new Factory();
        Database database = new DatabaseImpl();
        CommandDispatcher commandDispatcher = new CommandDispatcherImpl(factory, database);

        Runnable engine = new Engine(commandDispatcher);
        engine.run();
    }
}
