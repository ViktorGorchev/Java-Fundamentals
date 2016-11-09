package commandPattern.commands;

import commandPattern.interfaces.Command;

public abstract class CommandImpl implements Command{

    @Override
    public abstract String execute();
}

