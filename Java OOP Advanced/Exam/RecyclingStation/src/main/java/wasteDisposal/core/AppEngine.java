package wasteDisposal.core;

import wasteDisposal.contracts.*;
import wasteDisposal.contracts.Readable;
import wasteDisposal.contracts.Runnable;

import java.io.IOException;

public class AppEngine implements Runnable{

    private Readable reader;
    private Renderable render;
    private Factory factory;
    private GarbageProcessor garbageProcessor;

    public AppEngine(
            Readable reader,
            Renderable render,
            Factory factory,
            GarbageProcessor garbageProcessor
            ) {

        this.reader = reader;
        this.render = render;
        this.factory = factory;
        this.garbageProcessor = garbageProcessor;
    }

    public void run() throws IOException {
        while (true){
            String input = this.reader.read();
            if(input.equals("TimeToRecycle")){
                break;
            }

            executeCommand(input);
        }


    }

    private void executeCommand(String input) {
        String[] inputData = input.split(" |\\|");
        String command = inputData[0];

        //TODO
    }
}
