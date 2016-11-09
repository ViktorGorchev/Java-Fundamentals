package engine;

import contracts.*;
import contracts.Readable;

import java.io.IOException;

public class AppEngine implements EngineInterface{
    private Readable reader;
    private Renderable render;
    private DatabaseInterface database;
    private FactoryInterface factory;

    public AppEngine(
            Readable reader,
            Renderable render,
            DatabaseInterface database,
            FactoryInterface factory) {
        this.reader = reader;
        this.render = render;
        this.database = database;
        this.factory = factory;
    }

    public void runApp(){
        String input = null;

        while (true){
            try{
                input = this.reader.reade();
            }catch (IOException ioe){

            }

            if(input.equals("System Split")){
                break;
            }

            this.executeCommand(input);
        }

        this.render.render(database.finalDataAnalysis());
    }

    private void executeCommand(String inputCommand){
        String[] commandData = inputCommand.split("\\(");
        String command = commandData[0].trim();
        String commandInfo = commandData[1];

        switch (command){
            case "RegisterPowerHardware":
            case "RegisterHeavyHardware":
                HardwareInterface hardware = factory.createHardware(command, commandInfo);
                this.database.addHardware(hardware);
                break;
            case "RegisterExpressSoftware":
            case "RegisterLightSoftware":
                SoftwareInterface software = factory.createSoftware(command, commandInfo);
                this.database.addSoftware(software);
                break;
            case "ReleaseSoftwareComponent":
                String[] softwareData = commandInfo.split(", |\\)");
                String softwareName = softwareData[1].trim();
                this.database.removeSoftware(softwareName);
                break;
            case "Analyze":
                this.render.render(database.systemAnalysis());
                break;
            default:
                break;
        }
    }
}
