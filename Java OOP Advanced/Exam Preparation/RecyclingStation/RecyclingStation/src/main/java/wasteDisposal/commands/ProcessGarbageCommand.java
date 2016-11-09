package wasteDisposal.commands;

import wasteDisposal.annotations.Inject;
import wasteDisposal.contracts.*;

public class ProcessGarbageCommand extends Command{

    @Inject
    private Creatable factory;

    @Inject
    private GarbageProcessor garbageProcessor;

    @Inject
    private Database database;

    private String tokens;

    public ProcessGarbageCommand(String tokens) {
        this.tokens = tokens;
    }


    @Override
    public String execute() {
        String[] tokensData = this.tokens.split("\\|");
        String name = tokensData[0];
        double weight = Double.parseDouble(tokensData[1]);
        double volumePerKg = Double.parseDouble(tokensData[2]);
        String wasteType = tokensData[3];

        if(this.database.isWasteDenied(wasteType)){
            return "Processing Denied!";
        }

        Waste waste = this.factory.createWaste(name, weight, volumePerKg, wasteType);
        ProcessingData processingData = this.garbageProcessor.processWaste(waste);
        this.database.updateDatabaseData(processingData);

        String operationResult = String.format(
                "%.2f kg of %s successfully processed!",
                weight,
                name);

        return operationResult;
    }
}
