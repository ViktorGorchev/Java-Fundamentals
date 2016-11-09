package wasteDisposal.core;

import wasteDisposal.contracts.*;
import wasteDisposal.contracts.Readable;
import wasteDisposal.contracts.Runnable;

public class Engine implements Runnable {

    private Readable reader;
    private Renderable renderer;
    private Dispatcher dispatcher;

    public Engine(Readable reader, Renderable renderer, Dispatcher dispatcher) {
        this.reader = reader;
        this.renderer = renderer;
        this.dispatcher = dispatcher;
    }

    @Override
    public void run() {
        while (true){
            String input = this.reader.reade();

            Executable command = this.dispatcher.dispatchCommand(input);
            String commandResult = command.execute();

            if(commandResult.equalsIgnoreCase("end")){
                break;
            }

            this.renderer.render(commandResult);
        }
    }
}
