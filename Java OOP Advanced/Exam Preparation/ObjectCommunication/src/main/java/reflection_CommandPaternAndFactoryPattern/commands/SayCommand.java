package reflection_CommandPaternAndFactoryPattern.commands;

public class SayCommand extends CommandImpl {

    private String messagesToSay;

    public SayCommand(String messageToSay) {
        this.messagesToSay = messageToSay;
    }

    @Override
    public String execute() {
        return this.messagesToSay;
    }
}
