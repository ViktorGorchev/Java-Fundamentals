package reflection_CommandPaternAndFactoryPattern.core;

import com.google.common.base.Joiner;
import reflection_CommandPaternAndFactoryPattern.interfaces.CommandDispatcher;
import reflection_CommandPaternAndFactoryPattern.interfaces.DependencyResolver;
import reflection_CommandPaternAndFactoryPattern.interfaces.Executable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class CommandDispatcherImpl implements CommandDispatcher {

    private static final String COMMAND_PACKAGE  = "reflection_CommandPaternAndFactoryPattern.commands.";

    private static final String CONSTANT_WORD_IN_COMMAND_NAME= "Command";

    private DependencyResolver dependencyResolver;

    public CommandDispatcherImpl(DependencyResolver dependencyResolver) {
        this.dependencyResolver = dependencyResolver;
    }

    public Executable dispatchCommand(String command, String[] commandParams) {
        Executable createdCommand = null;

        String className = command;
        String message = Joiner.on(" ").join(commandParams);
        if(commandParams.length > 1){
            className += commandParams[0];
            message = commandParams[1];
        }

        try {
            Class executableClass = Class.forName(COMMAND_PACKAGE + className + CONSTANT_WORD_IN_COMMAND_NAME);
            Constructor constructor = executableClass.getDeclaredConstructor(String.class);
            createdCommand = (Executable) constructor.newInstance(message);
            this.dependencyResolver.resolveDependencies(createdCommand);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return createdCommand;
    }
}
