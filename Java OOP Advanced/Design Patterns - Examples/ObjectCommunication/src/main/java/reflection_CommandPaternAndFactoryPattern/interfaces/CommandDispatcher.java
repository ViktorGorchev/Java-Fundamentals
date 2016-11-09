package reflection_CommandPaternAndFactoryPattern.interfaces;

public interface CommandDispatcher {
    Executable dispatchCommand(String command, String[] commandParams);
}
