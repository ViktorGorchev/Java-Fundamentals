package wasteDisposal;

import wasteDisposal.contracts.*;
import wasteDisposal.contracts.Readable;
import wasteDisposal.contracts.Runnable;
import wasteDisposal.core.AppEngine;
import wasteDisposal.factory.GarbageFactory;
import wasteDisposal.models.DefaultGarbageProcessor;
import wasteDisposal.models.DefaultStrategyHolder;
import wasteDisposal.ui.ConsoleReader;
import wasteDisposal.ui.ConsoleWriter;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Readable reader = new ConsoleReader();
        Renderable render = new ConsoleWriter();
        Factory factory = new GarbageFactory();
        StrategyHolder strategyHolder = new DefaultStrategyHolder();
        GarbageProcessor garbageProcessor = new DefaultGarbageProcessor(strategyHolder);

        Runnable appEngine = new AppEngine(reader, render, factory, garbageProcessor);
        appEngine.run();
    }
}
