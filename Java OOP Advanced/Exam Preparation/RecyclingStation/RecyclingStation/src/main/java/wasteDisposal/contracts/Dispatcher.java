package wasteDisposal.contracts;

public interface Dispatcher {
    Executable dispatchCommand(String input);
}
