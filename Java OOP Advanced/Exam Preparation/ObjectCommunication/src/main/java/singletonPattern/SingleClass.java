package singletonPattern;

public class SingleClass {
    //Classic singleton

    private static SingleClass instance = null;

    //make the constructor private so that this class cannot be instantiated
    private SingleClass() {
    }

    //Get the only object available
    public static SingleClass getInstance() {
        if(instance == null) {
            instance = new SingleClass();
        }

        return instance;
    }

    public void printMessage(String message){
        System.out.println(message);
    }
}
