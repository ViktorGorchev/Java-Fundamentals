package methods;

import models.Cow;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class cowClass = Cow.class;
        Constructor constructor = cowClass.getConstructor(String.class, Integer.class);
        Cow cow = (Cow) constructor.newInstance("Pepa", 4);

        //non static method
        Method method = cowClass.getDeclaredMethod("concatCow", String.class, Integer.class); //must be Integer not int in the method and here
        String methodResult = (String) method.invoke(cow, "Gichka", 3);
        System.out.println(methodResult);

        //static method
        Method staticMethod = cowClass.getDeclaredMethod("doubleTheLegs", Integer.class);
        Integer staticMethodResult = (Integer) staticMethod.invoke(null, 4); //works also with invoke(cow, 4)
        System.out.println(staticMethodResult);

    }
}
