package getFromClass;

import models.Animal;
import models.Dog;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchFieldException {

        Class dogClass = Dog.class;

        //super class
        Class dogSuperClass = dogClass.getSuperclass();
        System.out.println(dogSuperClass.getSimpleName());

        //interfaces of a class
        Class[] animalInterfaces = dogSuperClass.getInterfaces();
        for (Class animalInterface : animalInterfaces) {
            System.out.println(animalInterface.getSimpleName());
        }

        //class fields
        Field[] dogFields = dogClass.getDeclaredFields(); //getDeclaredFields -> for private too
        for (Field dogField : dogFields) {
            System.out.println(System.lineSeparator() +
                    "Type: " + dogField.getType().getSimpleName()
                    + " Name: " + dogField.getName()
            );
        }

        //change private field
        Field dogField = dogClass.getDeclaredField("color");
        Class dogClass2 = Dog.class;
        Dog dog2 = (Dog) dogClass2.newInstance();

        dogField.setAccessible(true);   //needed for private fields
        String beforeChange = (String) dogField.get(dog2);
        dogField.set(dog2, "green");

        String afterChange =  (String) dogField.get(dog2);
        System.out.println(System.lineSeparator() + "Access modifier int: " + dogField.getModifiers());
        System.out.printf("Before change: %s --> After change: %s%n", beforeChange, afterChange);

        //get methods of interface
        Class animalInterfaceClass = Animal.class;
        Method[] interfaceMethods = animalInterfaceClass.getMethods();
        for (Method interfaceMethod : interfaceMethods) {
            System.out.println(interfaceMethod.getName());
        }


    }
}
