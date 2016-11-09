package wasteDisposal.container;

import wasteDisposal.annotations.Inject;
import wasteDisposal.contracts.*;

import java.lang.reflect.Field;

public class DependencyResolverImpl implements DependencyResolver{

    private Creatable factory;

    private GarbageProcessor garbageProcessor;

    private Database database;

    public DependencyResolverImpl(Creatable factory, GarbageProcessor garbageProcessor, Database database) {
        this.factory = factory;
        this.garbageProcessor = garbageProcessor;
        this.database = database;
    }

    @Override
    public void resolveDependency(Executable executable) {
        Field[] executableClassFields = executable.getClass().getDeclaredFields();
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
                    executableClassField.set(executable, thisClassField.get(this));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}