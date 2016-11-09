package function;

import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        //receives a parameter and returns
        //first type - type of parameter to receive
        //second type - type of parameter to return
        Function<String, Integer> customIntParser = stringNumber -> Integer.parseInt(stringNumber);
        int number = customIntParser.apply("5");
        System.out.println(number);

        //function in method
        int operationResult = operation(5, n -> n * n);
        System.out.println(operationResult);

        int operationResult2 = operation(9 , n -> n / 3);
        System.out.println(operationResult2);
    }

    public static int operation(Integer number, Function<Integer, Integer> function){
        return function.apply(number);
    }
}
