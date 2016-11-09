package bg.softuni.core;

import bg.softuni.interfaces.*;
import bg.softuni.interfaces.Readable;
import bg.softuni.interfaces.Runnable;

public class AppEngine implements Runnable{

    private Readable reader;

    private Renderable renderer;

    private Dispatchable commandDispatcher;

    public AppEngine(Readable reader, Renderable renderer, Dispatchable commandDispatcher) {
        this.reader = reader;
        this.renderer = renderer;
        this.commandDispatcher = commandDispatcher;
    }

    public void run() {

        while (true){
            String inputData = this.reader.reade();

            Executable command = this.commandDispatcher.dispatchCommand(inputData);
            String commandResult = command.execute();

            if (commandResult.equalsIgnoreCase("end")){
                break;
            }

            this.renderer.render(commandResult);
        }
    }
}