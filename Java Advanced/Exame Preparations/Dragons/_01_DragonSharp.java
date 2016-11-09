import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _01_DragonSharp {
    public static void main(String[] args) {
        StringBuilder text = new StringBuilder();
        String lineSplitter = "####";

        Scanner console = new Scanner(System.in);
        int numberLines = Integer.parseInt(console.nextLine());


        boolean noCompileError = true;
        for (int i = 0; i < numberLines; i++) {
            String fullInput = console.nextLine();
            text.append(fullInput);
            if(i < numberLines - 1) {
                text.append(lineSplitter);
            }

            String valueForPrinting = stringIsCorrect(fullInput);

            if (valueForPrinting == null) {
                System.out.println("Compile time error @ line " + (i + 1));
                noCompileError = false;
                break;
            }
        }

        if(noCompileError){
            execute(text, lineSplitter);
        }

    }

    private static void execute(StringBuilder text, String lineSplitter) {
        String[] textArray = text.toString().split(lineSplitter);

        boolean elseIsTrue = false;
        for (int i = 0; i < textArray.length; i++) {
            String fullInput = textArray[i];
            String[] input = convertToSpacesRegex(fullInput).split("\\s+");
            String valueForPrinting = stringIsCorrect(fullInput);

            if(input[0].equals("if")){
                String regex = "\\((\\d+)(>|<|={2})(\\d+)\\)";
                Matcher matcher = Pattern.compile(regex).matcher(input[1]);
                int firstNumber = 0;
                String condition = null;
                int secondNumber = 0;
                while (matcher.find()) {
                    firstNumber = Integer.parseInt(matcher.group(1));
                    condition = matcher.group(2);
                    secondNumber = Integer.parseInt(matcher.group(3));
                }

                if(conditionIsTrue(firstNumber, condition, secondNumber)){
                    if(input[2].equals("loop")){
                        int iterations = Integer.parseInt(input[3]);
                        for (int j = 0; j < iterations; j++) {
                            System.out.println(valueForPrinting);
                        }
                    }

                    if (input[2].equals("out")) {
                        System.out.println(valueForPrinting);
                    }

                    elseIsTrue = false;

                }else {
                    elseIsTrue = true;
                }

            }

            if(elseIsTrue) {
                if(input[1].equals("loop")){
                    int iterations = Integer.parseInt(input[2]);
                    for (int j = 0; j < iterations; j++) {
                        System.out.println(valueForPrinting);
                    }

                    elseIsTrue = false;
                }

                if (input[1].equals("out")) {
                    System.out.println(valueForPrinting);
                    elseIsTrue = false;
                }
            }
        }
    }

    private static boolean conditionIsTrue(int firstNumber, String condition, int secondNumber) {
        switch (condition){
            case "<": return firstNumber < secondNumber;
            case ">": return firstNumber > secondNumber;
            case "==": return firstNumber == secondNumber;
            default:
                break;
        }

        return false;
    }

    private static String stringIsCorrect(String value) {
        String regex = "out\\s+\"(.*?)\"\\s*;";
        Matcher matcher = Pattern.compile(regex).matcher(value);
        while (matcher.find()) {
            return matcher.group(1);
        }

        return null;
    }

    private static String convertToSpacesRegex(String value)
    {
        value = value.replaceAll("\\s+", " ");
        return value;
    }
}