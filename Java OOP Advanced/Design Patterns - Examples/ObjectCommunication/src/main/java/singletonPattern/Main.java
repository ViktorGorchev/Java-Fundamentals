package singletonPattern;

public class Main {

    public static void main(String[] args) {
        SingleClass singleton  = SingleClass.getInstance();
        singleton.printMessage("Hello");

        SingletonEnum singletonEnum = SingletonEnum.INSTANCE;
        singletonEnum.printMessage("Hi");
        //or
        SingletonEnum.INSTANCE.printMessage("Hei you");

    }
}
