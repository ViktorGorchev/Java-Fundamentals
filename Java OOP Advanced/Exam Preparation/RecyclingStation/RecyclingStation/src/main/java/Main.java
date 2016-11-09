import wasteDisposal.container.DependencyResolverImpl;
import wasteDisposal.contracts.*;
import wasteDisposal.contracts.Readable;
import wasteDisposal.contracts.Runnable;
import wasteDisposal.core.Engine;
import wasteDisposal.core.appFactory.Factory;
import wasteDisposal.core.dispatcher.CommandDispatcher;
import wasteDisposal.core.garbageProcessor.DefaultGarbageProcessor;
import wasteDisposal.data.DatabaseImpl;
import wasteDisposal.data.DefaultStrategyHolder;
import wasteDisposal.data.ProcessingDataImpl;
import wasteDisposal.ui.ConsoleReader;
import wasteDisposal.ui.ConsoleRenderer;

public class Main {
    public static void main(String[] args) {
        Readable reader = new ConsoleReader();
        Renderable renderer = new ConsoleRenderer();

        Creatable factory = new Factory();
        ProcessingData processingData = new ProcessingDataImpl();
        StrategyHolder strategyHolder = new DefaultStrategyHolder(processingData);
        GarbageProcessor garbageProcessor = new DefaultGarbageProcessor(strategyHolder);
        Database database = new DatabaseImpl();
        DependencyResolver dependencyResolver = new DependencyResolverImpl(factory, garbageProcessor, database);

        Dispatcher dispatcher = new CommandDispatcher(dependencyResolver);

        Runnable engine = new Engine(reader, renderer, dispatcher);
        engine.run();
    }
}
