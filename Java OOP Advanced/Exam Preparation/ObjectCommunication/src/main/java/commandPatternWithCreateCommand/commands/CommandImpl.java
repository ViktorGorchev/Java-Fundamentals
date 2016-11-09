package commandPatternWithCreateCommand.commands;

import commandPatternWithCreateCommand.interfaces.Command;

public abstract class CommandImpl implements Command {

    @Override
    public abstract String execute();
}

