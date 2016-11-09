package reflection_CommandPaternAndFactoryPattern.commands;

public class BarkCommand extends CommandImpl {

    private static final String BARK_MESSAGE= "Bau bauuuu";

    private String message;

    public BarkCommand(String message) {
        this.message = message;
    }

    @Override
    public String execute() {
        return this.message + " ~~~ " + BARK_MESSAGE;
    }
}
