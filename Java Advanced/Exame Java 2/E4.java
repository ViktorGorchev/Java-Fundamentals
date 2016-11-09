import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E4 {
    private static final BigDecimal maxValidPositive = new BigDecimal("18446744073709551616");
    private static final BigDecimal maxValidNegative = new BigDecimal("-18446744073709551616");
    
    public static void main(String[] args) {
        LinkedHashMap<String, TreeMap<String, BigDecimal>> data = new LinkedHashMap<>();
        HashMap<String, Long> workHoursData = new HashMap<>();
        HashMap<String, BigDecimal> dailyIncomeData = new HashMap<>();

        String regex = "^([A-Za-z]+);(-*\\d{1,10});(-*\\d+\\.*\\d*);([A-Za-z]+)$";

        Scanner console = new Scanner(System.in);
        String input = console.nextLine();
        while (!input.equals("Pishi kuf i da si hodim")){
            Matcher matcher = Pattern.compile(regex).matcher(input);
            while (matcher.find()) {
                String name = matcher.group(1);
                Long workHoursPerDay = Long.parseLong(matcher.group(2)); //check!
                BigDecimal dailyPayment = new BigDecimal(matcher.group(3)); //check!
                String team = matcher.group(4);
                
                if(workHoursPerDay >  Integer.MAX_VALUE || workHoursPerDay < Integer.MIN_VALUE){
                    continue;
                }

                if(dailyPayment.compareTo(maxValidPositive) == 1 || dailyPayment.compareTo(maxValidNegative) == -1){
                    continue;
                }

                if(!data.containsKey(team)){
                    data.put(team, new TreeMap<>());
                }

                if(data.get(team).containsKey(name)){
                    continue;
                }

                //((daily payment * work hours) / 24) * 30
                data.get(team).put(name,
                        ((dailyPayment.add(new BigDecimal(workHoursPerDay)))
                                .divide(new BigDecimal(24))).add(new BigDecimal(30)));

                workHoursData.put(name, workHoursPerDay);
                dailyIncomeData.put(name, dailyPayment);
            }

            input = console.nextLine();
        }

        System.out.println(data);
    }
}
