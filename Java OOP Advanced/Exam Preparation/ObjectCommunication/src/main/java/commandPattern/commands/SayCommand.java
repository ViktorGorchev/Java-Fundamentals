package commandPattern.commands;

import com.google.common.base.Joiner;

public class SayCommand extends CommandImpl {

    private String[] messagesToSay;

    public SayCommand(String... messageToSay) {
        this.messagesToSay = messageToSay;
    }

    @Override
    public String execute() {
        return Joiner.on(" ").join(this.messagesToSay);
    }
}
