package reflection_CommandPaternAndFactoryPattern;

import reflection_CommandPaternAndFactoryPattern.core.CommandDispatcherImpl;
import reflection_CommandPaternAndFactoryPattern.core.DatabaseImpl;
import reflection_CommandPaternAndFactoryPattern.core.DependencyResolver.DependencyResolverImpl;
import reflection_CommandPaternAndFactoryPattern.core.Engine;
import reflection_CommandPaternAndFactoryPattern.core.appFactory.Factory;
import reflection_CommandPaternAndFactoryPattern.interfaces.*;
import reflection_CommandPaternAndFactoryPattern.interfaces.Runnable;

public class Main {

    public static void main(String[] args) {
        Creatable factory = new Factory();
        Database database = new DatabaseImpl();
        DependencyResolver dependencyResolver = new DependencyResolverImpl(factory, database);
        CommandDispatcher commandDispatcher = new CommandDispatcherImpl(dependencyResolver);

        Runnable engine = new Engine(commandDispatcher);
        engine.run();
    }
}
