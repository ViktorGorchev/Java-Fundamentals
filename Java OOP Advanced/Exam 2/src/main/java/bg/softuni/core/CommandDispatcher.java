package bg.softuni.core;

import bg.softuni.interfaces.DependencyResolver;
import bg.softuni.interfaces.Dispatchable;
import bg.softuni.interfaces.Executable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandDispatcher implements Dispatchable{

    private static final String COMMAND_PACKAGE = "bg.softuni.commands.";

    private static final String COMMAND_NAME_CONSTANT = "Command";

    private DependencyResolver dependencyResolver;

    public CommandDispatcher(DependencyResolver dependencyResolver) {
        this.dependencyResolver = dependencyResolver;
    }

    public Executable dispatchCommand(String inputData) {
        List<String> input = new ArrayList<>(Arrays.asList(inputData.split("\\|")));

        String commandName = input.remove(0);
        String className = commandName.replaceFirst("Register", "");
        if(className != null){
            input.add(0, className);
        }

        String[] tokens = input.toArray(new String[input.size()]);

        Executable command = null;
        Class executableClass;
        try {
            executableClass = Class.forName(COMMAND_PACKAGE + commandName + COMMAND_NAME_CONSTANT);

            if(tokens.length > 1){
                Constructor constructor = executableClass.getDeclaredConstructor(String[].class);
                command = (Executable) constructor.newInstance((Object) tokens);
            }else {
                command = (Executable) executableClass.newInstance();
            }

        } catch (ClassNotFoundException | NoSuchMethodException
                | InstantiationException | IllegalAccessException
                | InvocationTargetException e) {
            e.printStackTrace();
        }

        this.dependencyResolver.resolveDependencies(command);

        return command;
    }
}
