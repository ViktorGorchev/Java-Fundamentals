package abstractFactoryPattern;

import abstractFactoryPattern.core.FactoryProducerImpl;
import abstractFactoryPattern.interfaces.Animal;
import abstractFactoryPattern.interfaces.Creatable;
import abstractFactoryPattern.interfaces.FactoryProducer;
import abstractFactoryPattern.interfaces.Plant;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        /*
        Normally, if you use the Factory pattern, you will create objects in a Factory.
        The problem arises when you have multiple implementation of a given class (or classes).
        Now, those multiple implementations are grouped. You will use the Abstract Factory pattern
        when you have a factory, but you would like to group the creating of objects per group.

        Example:
        Let's say you have a class library with data agents.
        Data agents provide you methods to access and store different data.
        Of course, there are multiple ways of storing your data.
        For example: in a database, in XML file, over a service, . For each of these possible ways,
         you would like to have data agents. Now the problem is, you don't want that someone uses
          the DataAgentA for XML files together with DataAgentB for database
          (let's assume that we have entities A and B). The user should use only one storage engine.
         */

        FactoryProducer factoryProducer = new FactoryProducerImpl();
        Scanner reader = new Scanner(System.in);

        while (true){
            String input = reader.nextLine();
            if(input.equalsIgnoreCase("end")){
                break;
            }

            String result = "Created: ";

            Creatable factory = factoryProducer.getFactory(input);
            Animal animal = factory.createAnimal(input);

            ///BAD!!!!!
            if(animal == null){
                Plant plant = factory.createPlant(input);
                result += plant.getType();
            }else {
                result += animal.getType();
            }


            System.out.println(result);
        }
    }
}
