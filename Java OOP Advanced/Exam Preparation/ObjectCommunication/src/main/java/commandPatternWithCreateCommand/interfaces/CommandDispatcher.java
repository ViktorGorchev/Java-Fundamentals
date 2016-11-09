package commandPatternWithCreateCommand.interfaces;

public interface CommandDispatcher {
    Command dispatchCommand(String command, String[] commandParams);
}
