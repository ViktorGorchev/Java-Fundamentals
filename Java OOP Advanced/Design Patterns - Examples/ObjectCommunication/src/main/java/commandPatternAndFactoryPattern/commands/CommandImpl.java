package commandPatternAndFactoryPattern.commands;

import commandPatternAndFactoryPattern.interfaces.Command;

public abstract class CommandImpl implements Command {

    @Override
    public abstract String execute();
}

