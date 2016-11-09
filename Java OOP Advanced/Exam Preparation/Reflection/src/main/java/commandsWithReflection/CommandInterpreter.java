package commandsWithReflection;

import commandsWithReflection.annotations.Alias;
import commandsWithReflection.annotations.Inject;
import commandsWithReflection.commands.Executable;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class CommandInterpreter {

    private static final String COMMAND_PACKAGE = "commandsWithReflection.commands."; // add .

    private StringBuilder builder;

    private Thread thread;

    public CommandInterpreter(StringBuilder builder, Thread thread) {
        this.builder = builder;
        this.thread = thread;
    }

//    public Executable interpretCommand(String name, String[] data){
//
//        Executable command = null;
//
//        try {
//            Class executableClass = Class.forName(COMMAND_PACKAGE + name + "Command");
//            Constructor constructor = executableClass.getDeclaredConstructor(String[].class); //must be getDeclaredConstructor() because abstract class has protected constructor
//            command = (Executable) constructor.newInstance((Object) data); //data must be casted because it might be var args or array
//            this.resolveDependancies(command, executableClass);
//
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
//
//        return command;
//    }

//    // cant work in judge!!!! because this.findCommandClass(name) uses file
    public Executable interpretCommand(String name, String[] data){
        Executable command = null;

        Class executableClass = this.findCommandClass(name);

        try {

            Constructor constructor = executableClass.getDeclaredConstructor(String[].class); //must be getDeclaredConstructor() because abstract class has protected constructor
            command = (Executable) constructor.newInstance((Object) data); //data must be casted because it might be var args or array
            this.resolveDependancies(command, executableClass);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        return command;
    }

    private Class findCommandClass(String name) {
        Class commandClass = null;

        File file = new File("src/main/java/commandsWithReflection/commands");
        for (File currentFile : file.listFiles()) {
            if(currentFile.isFile() && currentFile.getName().endsWith(".java")){
                String className = currentFile.getName().replaceFirst(".java", "");
                try {
                    Class classCommand = Class.forName(COMMAND_PACKAGE + className);
                    Alias alias = (Alias) classCommand.getDeclaredAnnotation(Alias.class);
                    if(alias == null){
                        continue;
                    }

                    if(alias.value().equals(name)){
                        return classCommand;
                    }

                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }



        return commandClass;
    }

    //this method must be a class with method resolveDependancies()
    private void resolveDependancies(Executable command, Class executableClass)
            throws IllegalAccessException {

        Field[] executableClassFields = executableClass.getDeclaredFields();
        for (Field executableClassField : executableClassFields) {
            if(! executableClassField.isAnnotationPresent(Inject.class)){
                continue;
            }

            Field[] thisClassFields = CommandInterpreter.class.getDeclaredFields();
            for (Field thisClassField : thisClassFields) {
                if(! thisClassField.getType().equals(executableClassField.getType())){
                    continue;
                }

                executableClassField.setAccessible(true);
                executableClassField.set(command, thisClassField.get(this));
            }
        }
    }
}
