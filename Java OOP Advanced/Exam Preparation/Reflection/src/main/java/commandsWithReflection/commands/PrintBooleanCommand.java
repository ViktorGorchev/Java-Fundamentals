package commandsWithReflection.commands;

import commandsWithReflection.annotations.Alias;
import commandsWithReflection.annotations.Inject;

@Alias("PrintBoolean")
public class PrintBooleanCommand extends Command{

    @Inject
    private StringBuilder builder;

    public PrintBooleanCommand(String[] data) {
        super(data);
    }

    public String execute() {
        boolean bool = Boolean.parseBoolean(getData()[1]);
        this.builder.append(String.valueOf(bool));
        this.builder.append(" printed!");

        return  this.builder.toString() ;
    }
}
