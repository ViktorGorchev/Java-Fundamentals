package wasteDisposal.commands;

import wasteDisposal.contracts.Executable;

public abstract class Command implements Executable{

    public abstract String execute();
}
