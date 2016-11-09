import java.util.Scanner;

public class OddOrEvenElements {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String[] inputNumbers = console.nextLine().split(" ");
        int[] numbers = new int[inputNumbers.length];
        for (int i = 0; i < inputNumbers.length; i++) {
            numbers[i] = Integer.parseInt(inputNumbers[i]);
        }

        String[] commandInput = console.nextLine().split(" ");

        System.out.println(findOddOrEvenNumbers(numbers, commandInput[2], Integer.parseInt(commandInput[1])));
    }

    private static String findOddOrEvenNumbers(int[] numbers, String type, Integer count) {
        String stringEmpty = "";
        String result = stringEmpty;
        int counter = 0;
        for (int i = 0; i < numbers.length; i++) {
            boolean numberIsOdd = numbers[i] % 2 != 0;
            boolean typeIsOdd = type.equals("odd");
            boolean isInRange = counter <= count;

            if (numberIsOdd && typeIsOdd && isInRange){
                result += Integer.toString(numbers[i]) + " ";
                counter++;
            }

            if (!numberIsOdd && !typeIsOdd && isInRange){
                result += Integer.toString(numbers[i]) + " ";
                counter++;
            }
        }

        if (result.equals(stringEmpty)){
            return String.format("No %s numbers found!", type);
        }

        return result.trim();
    }
}