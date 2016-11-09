package wasteDisposal.commands;

import wasteDisposal.annotations.Inject;
import wasteDisposal.contracts.Database;

public class StatusCommand extends Command{

    @Inject
    private Database database;

    @Override
    public String execute() {
        String operationResult = this.database.processingDataStatus();

        return operationResult;

    }
}
