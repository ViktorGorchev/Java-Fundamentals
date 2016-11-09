package bg.softuni.commands;

import bg.softuni.interfaces.Executable;

public abstract class Command implements Executable{

    public abstract String execute();
}