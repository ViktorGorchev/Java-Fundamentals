package commandsWithReflection.commands;

import commandsWithReflection.annotations.Alias;

@Alias("PrintInt")
public class PrintIntCommand extends Command{

    public PrintIntCommand(String[] data) {
        super(data);
    }

    public String execute() {
        int value = Integer.parseInt(this.getData()[1]);

        return String.valueOf(value) + " printed!";
    }
}
