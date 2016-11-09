package reflection_CommandPaternAndFactoryPattern.core.DependencyResolver;

import reflection_CommandPaternAndFactoryPattern.anottations.Inject;
import reflection_CommandPaternAndFactoryPattern.interfaces.Creatable;
import reflection_CommandPaternAndFactoryPattern.interfaces.Database;
import reflection_CommandPaternAndFactoryPattern.interfaces.DependencyResolver;
import reflection_CommandPaternAndFactoryPattern.interfaces.Executable;

import java.lang.reflect.Field;

public class DependencyResolverImpl implements DependencyResolver{

    private Creatable factory;

    private Database database;

    public DependencyResolverImpl(Creatable factory, Database database) {
        this.factory = factory;
        this.database = database;
    }

    @Override
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
