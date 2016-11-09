package factoryWithReflection;

import factoryWithReflection.models.Beer;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Brewary {

    private static final String BEER_PACKAGE = "factoryWithReflection.models.";     //a . must be added

    public Beer brew(String beerName, int liters) {
        Beer beer = null;

        try {
            Class beerClass = Class.forName(BEER_PACKAGE + beerName);
            Constructor constructor = beerClass.getDeclaredConstructor(int.class); //if int is in tha constructor of the class int.class must be here
            beer = (Beer) constructor.newInstance(liters);

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

        return beer;
    }
}
