package commandsWithReflection.commands;

import commandsWithReflection.annotations.Alias;
import commandsWithReflection.annotations.Inject;

@Alias("PrintDouble")
public class PrintDoubleCommand extends Command{

    @Inject
    private Thread decimalSpaces;

    public PrintDoubleCommand(String[] data) {
        super(data);
    }

    public String execute() {
        Double value = Double.parseDouble(this.getData()[1]);

        return String.valueOf(value) + " printed!";
    }
}
