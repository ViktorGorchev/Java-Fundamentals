package reflection_CommandPaternAndFactoryPattern.commands;

import reflection_CommandPaternAndFactoryPattern.interfaces.Executable;

public abstract class CommandImpl implements Executable {

    @Override
    public abstract String execute();
}

