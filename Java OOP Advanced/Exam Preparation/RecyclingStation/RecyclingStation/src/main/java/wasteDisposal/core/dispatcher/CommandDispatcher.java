package wasteDisposal.core.dispatcher;

import wasteDisposal.contracts.DependencyResolver;
import wasteDisposal.contracts.Dispatcher;
import wasteDisposal.contracts.Executable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class CommandDispatcher implements Dispatcher{

    private static final String COMMAND_PACKAGE  = "wasteDisposal.commands.";

    private static final String COMMAND_CONSTANT_WORD  = "Command";

    private DependencyResolver dependencyResolver;

    public CommandDispatcher(DependencyResolver dependencyResolver) {
        this.dependencyResolver = dependencyResolver;
    }

    @Override
    public Executable dispatchCommand(String input) {
        String[] inputData = input.split("[\\s]+");
        String command = inputData[0];

        Executable executable = null;
        try {
            Class executableClass = Class.forName(COMMAND_PACKAGE + command + COMMAND_CONSTANT_WORD);

            if(inputData.length > 1){
                Constructor constructor = executableClass.getConstructor(String.class);
                executable = (Executable) constructor.newInstance(inputData[1]);
            }else {
                executable = (Executable) executableClass.newInstance();
            }

            this.dependencyResolver.resolveDependency(executable);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return executable;
    }
}
