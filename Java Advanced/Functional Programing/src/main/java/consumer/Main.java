package consumer;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {
        //is a void
        Consumer<String> printMessage = m -> System.out.println(m);
        //or
        Consumer<String> printMessage2 = System.out::println;

        printMessage.accept("Hello");
        printMessage2.accept("Hi");

        printMessage.accept(String.valueOf(5));

        BiConsumer<String, Integer> printSum = (n1, n2) -> System.out.println(Integer.parseInt(n1) + n2);
        printSum.accept("6", 10);
    }


}
