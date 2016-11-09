package createClass;

import models.Cat;
import models.Cow;
import models.Dog;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException,
            ClassNotFoundException, NoSuchMethodException, InvocationTargetException {

        Class dogClass = Dog.class;
        Dog dog = (Dog) dogClass.newInstance();

        System.out.println(dog.getAnimalType()); //DOG

        //class name from input
        Scanner reader = new Scanner(System.in);

        Class catClass = Class.forName("models." + reader.nextLine());  //in -> Cat
        Cat cat = (Cat) catClass.newInstance();

        System.out.println(cat.getAnimalType());  //CAT

        //create class with parameters in the constructor
        Class cowClass = Cow.class;
        Constructor constructor = cowClass.getConstructor(String.class, Integer.class); //must be Integer not int in the class and here
        Cow cow = (Cow) constructor.newInstance("Mara", 4);

        System.out.println(cow.getName() + ", legs number: " + cow.getLegs());
    }
}
