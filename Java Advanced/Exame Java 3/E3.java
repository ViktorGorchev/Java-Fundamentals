import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E3 {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            String cod = console.readLine();
            if(cod.equals("Over!")){
                break;
            }

            int codeCount = Integer.parseInt(console.readLine());

            String regex = String.format("^(\\d+)([a-zA-Z]{%d})(?![a-zA-Z]+)(\\d*|.*?)$", codeCount);
            Matcher matcher = Pattern.compile(regex).matcher(cod);
            while (matcher.find()) {
                String firstDigits = matcher.group(1);
                String message = matcher.group(2);
                String lastDigits = matcher.group(3);

                String secondRegex = "([a-zA-Z]+)";
                Matcher secondMatcher = Pattern.compile(secondRegex).matcher(lastDigits);
                if(secondMatcher.find()){
                    continue;
                }

                List<Integer> startNumbers = getNumbers(firstDigits);

                boolean isANumber = true;
                try{
                    int test = Integer.parseInt(lastDigits);
                }catch (NumberFormatException e){
                    isANumber = false;
                }

                List<Integer> endNumbers = new ArrayList<>();
                if(lastDigits != null && isANumber){
                    endNumbers = getNumbers(lastDigits);

                }

                List<Integer> allNumber = new ArrayList<>();
                allNumber.addAll(startNumbers);
                allNumber.addAll(endNumbers);

                StringBuilder result = new StringBuilder();
                result.append(message + " == ");
                for (int i = 0; i < allNumber.size(); i++) {
                    if(allNumber.get(i) > message.length() - 1){
                        result.append(" ");
                        continue;
                    }

                    result.append(message.charAt(allNumber.get(i)));
                }

                System.out.println(result);
            }
        }
        console.close();
    }

    private static List<Integer> getNumbers(String digits) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
             int num = Integer.parseInt(digits.charAt(i) + "");
            numbers.add(num);
        }

        return numbers;
    }
}
