package commandPatternWithCreateCommand.commands;

/**
 * Created by Admin on 18.8.2016 г..
 */
public class BarkCommand extends CommandImpl {

    private static final String BARK_MESSAGE= "Bau bauuuu";

    @Override
    public String execute() {
        return BARK_MESSAGE;
    }
}
