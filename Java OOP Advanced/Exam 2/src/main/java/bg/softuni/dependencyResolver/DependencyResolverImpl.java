package bg.softuni.DependencyResolver;

import bg.softuni.anotations.Inject;
import bg.softuni.interfaces.*;

import java.lang.reflect.Field;

public class DependencyResolverImpl implements DependencyResolver{

    private Creatable factory;

    private EmergencyManagementSystem emergencyManagementSystem;

    public DependencyResolverImpl(
            Creatable factory,
            EmergencyManagementSystem emergencyManagementSystem) {
        this.factory = factory;
        this.emergencyManagementSystem = emergencyManagementSystem;
    }

    public void resolveDependencies(Executable command) {
        Field[] executableClassFields = command.getClass().getDeclaredFields();
        for (Field executableClassField : executableClassFields) {
            if(! executableClassField.isAnnotationPresent(Inject.class)){
                continue;
            }

            Field[] thisClassFields = this.getClass().getDeclaredFields();
            for (Field thisClassField : thisClassFields) {
                if(! thisClassField.getType().equals(executableClassField.getType())){
                    continue;
                }

                executableClassField.setAccessible(true);
                try {
                    executableClassField.set(command, thisClassField.get(this));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
