package wasteDisposal.commands;

import wasteDisposal.annotations.Inject;
import wasteDisposal.contracts.Database;

public class ChangeManagementRequirementCommand extends Command{

    @Inject
    private Database database;

    private String tokens;

    public ChangeManagementRequirementCommand(String tokens) {
        this.tokens = tokens;
    }

    @Override
    public String execute() {
        String[] tokensData = this.tokens.split("\\|");
        double minEnergyBalance = Double.parseDouble(tokensData[0]);
        double minCapitalBalance = Double.parseDouble(tokensData[1]);
        String denyGarbageType = tokensData[2];

        this.database.denyWaste(denyGarbageType, minEnergyBalance, minCapitalBalance);

        String operationResult = "Management requirement changed!";

        return operationResult;
    }
}
