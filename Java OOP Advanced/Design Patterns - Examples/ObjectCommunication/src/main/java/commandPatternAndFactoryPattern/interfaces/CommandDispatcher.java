package commandPatternAndFactoryPattern.interfaces;

public interface CommandDispatcher {
    Command dispatchCommand(String command, String[] commandParams);
}
