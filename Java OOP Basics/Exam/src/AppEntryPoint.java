import AppFactory.Factory;
import contracts.*;
import contracts.Readable;
import database.Database;
import engine.AppEngine;
import ui.Reader;
import ui.Renderer;

public class AppEntryPoint {

    public static void main(String[] args) {
        Readable reader = new Reader();
        Renderable render = new Renderer();
        DatabaseInterface database = new Database();
        FactoryInterface factory = new Factory();

        EngineInterface appEngine = new AppEngine(reader, render, database, factory);
        appEngine.runApp();
    }
}
