package commandsWithReflection.commands;

import commandsWithReflection.annotations.Alias;

@Alias("End")
public class EndCommand extends Command{

    public EndCommand(String[] data) {
        super(data);
    }

    public String execute() {
        return "end";
    }
}
