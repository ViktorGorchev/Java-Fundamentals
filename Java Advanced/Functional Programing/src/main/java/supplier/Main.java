package supplier;

import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
        //return type
        //takes no arguments and returns
        Supplier<Double> randomNumber = () -> Math.random();
        System.out.println(randomNumber.get());

    }
}
