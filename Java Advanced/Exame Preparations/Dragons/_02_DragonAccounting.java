import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _02_DragonAccounting {
    private static final Integer YEAR_DAYS = 365;
    private static final Integer MONTH_DAYS = 30;
    private static final BigDecimal SALARY_INCREASE_PERCENT = new BigDecimal(0.6);

    private static int day = 0;
    private static boolean notInBankruptcy = true;
    private static BigDecimal capital;
    private static List<BigInteger> employData = new ArrayList<>();
    private static TreeMap<Integer, List<Integer>> employsSalaryRaised = new TreeMap<>();
    private static List<BigDecimal> employsSalary = new ArrayList<>();

    public static void main(String[] args) {
        //String regex = "(\\d+)\\s*;\\s*(\\d+)\\s*;\\s*(\\d+)*\\s*;\\s*(.*)";
        //String regex = "(\\d+)\\s*;\\s*(\\d+)\\s*;\\s*(\\d+.\\d+)\\s*;*\\s*(.*)";
        String regex = "(\\d+)\\s*;\\s*(\\d+)\\s*;\\s*(\\d+.\\d+|\\d+)\\s*;*\\s*(.*)";

        Scanner console = new Scanner(System.in);
        capital = new BigDecimal(console.nextLine());

        int lastMonthDay = 0;
        String input = console.nextLine();
        while (!input.equals("END") && notInBankruptcy) {
            day++;

            Matcher matcher = Pattern.compile(regex).matcher(input);
            while (matcher.find()) {
                BigInteger hired = new BigInteger(matcher.group(1));
                BigInteger fired = new BigInteger(matcher.group(2));
                BigDecimal salary = new BigDecimal(matcher.group(3));
                String capitalData = matcher.group(4);

                hireEmployees(hired, salary);

                checkForRaise();

                if(day - lastMonthDay == MONTH_DAYS){
                    giveSalaries();
                    lastMonthDay = day;
                }

                fireEmployees(fired);

                checkAdditionalIncomeOrExpense(capitalData);

                checkForBankruptcy();
            }

            input = console.nextLine();
        }

        if(notInBankruptcy){
            System.out.printf("%d %.4f\n", sumEmploys(), capital.setScale(4, RoundingMode.FLOOR));
        }

        if(!notInBankruptcy){
            System.out.println("BANKRUPTCY: " + capital.abs().setScale(4, RoundingMode.FLOOR));
        }

    }

    private static void checkForBankruptcy() {
        if(capital.compareTo(BigDecimal.ZERO) <= 0){
            notInBankruptcy = false;
        }
    }

    private static void checkAdditionalIncomeOrExpense(String capitalData) {
//        String regex = "(\\w*\\s*\\w+)\\s*:\\s*(\\d+\\.*\\d*)";
        if(capitalData.equals("")){
            return;
        }

        String[] groups = capitalData.split(";");
        for (int i = 0; i < groups.length; i++) {
            String[] data = groups[i].split(":");
            String type = data[0].trim();
            BigDecimal amount = new BigDecimal(data[1].trim());
            switch (type){
                case "Previous years deficit":
                case "Machines":
                case "Taxes":
                    capital = capital.subtract(amount);
                    break;
                case "Product development":
                case "Unconditional funding":
                    capital = capital.add(amount);
                    break;
            }
        }
    }

    private static void fireEmployees(BigInteger fired) {
        if(fired.compareTo(BigInteger.ZERO) == 0){
            return;
        }

        BigInteger sum = sumEmploys();

        if(fired.compareTo(sum) >= 0){
            for (int i = 0; i < employData.size(); i++) {
                employData.set(i,  BigInteger.ZERO);
            }

            return;
        }

        BigInteger tempFired = fired;
        for (int i = 0; i < employData.size(); i++) {
            if(tempFired.compareTo(BigInteger.ZERO) <= 0){
                break;
            }

            if(tempFired.compareTo(employData.get(i)) >= 0){
                tempFired = tempFired.subtract(employData.get(i));
                employData.set(i, BigInteger.ZERO);
                continue;
            }

            BigInteger tempEmploysLeft = employData.get(i).subtract(tempFired);
            if(tempEmploysLeft.compareTo(BigInteger.ZERO) < 0){
                tempEmploysLeft = BigInteger.ZERO;
            }

            tempFired = tempFired.subtract(employData.get(i).subtract(tempEmploysLeft));
            employData.set(i, tempEmploysLeft);
        }
    }

    private static BigInteger sumEmploys() {
        BigInteger sum = BigInteger.ZERO;
        for (int i = 0; i < employData.size(); i++) {
            sum = sum.add(employData.get(i));
        }

        return sum;
    }

    private static void giveSalaries() {
        for (int i = 1; i < employsSalary.size(); i++) {
            BigDecimal totalWorkDays = new BigDecimal(MONTH_DAYS);
            if(i > day - MONTH_DAYS){
                totalWorkDays = new BigDecimal((MONTH_DAYS -(i - (day - MONTH_DAYS))) + 1);
            }

            if(employsSalary.get(i).signum() == 0){
                continue;
            }

            BigDecimal dailySalary = employsSalary.get(i)
                    .divide(new BigDecimal(MONTH_DAYS), 9, RoundingMode.UP)
                    .setScale(7, RoundingMode.FLOOR);

            //((salary / 30) * totalWorkingDaysThatMonth)
            BigDecimal employSalary = dailySalary.multiply(totalWorkDays);

            BigDecimal amountToSubtract = employSalary.multiply(new BigDecimal(employData.get(i)));
            capital = capital.subtract(amountToSubtract);
        }
    }

    private static void checkForRaise() {
        if(employData.size() - 1 <= YEAR_DAYS){
            return;
        }

        for (int startDay = 1; startDay < employData.size(); startDay++) {
            if(employData.get(startDay).signum() == 0){
                continue;
            }

            boolean hasSalaryRaise = employsSalaryRaised.get(startDay).size() > 0;
//            boolean noAvailableRaise =
//                    day - employsSalaryRaised.get(startDay).get(employsSalaryRaised.get(startDay).size() - 1) <= YEAR_DAYS;
            if(hasSalaryRaise &&
                    day - employsSalaryRaised.get(startDay).get(employsSalaryRaised.get(startDay).size() - 1) <= YEAR_DAYS){
                continue;
            }

            boolean noFirstAvailableRaise = day - startDay < YEAR_DAYS;
            if(!hasSalaryRaise && noFirstAvailableRaise){
                continue;
            }

            //divide by 0 check
            if(employsSalary.get(startDay).signum() == 0){
                continue;
            }

            BigDecimal newSalary = employsSalary.get(startDay)
                    .divide(new BigDecimal(100))
                    .multiply(SALARY_INCREASE_PERCENT)
                    .add(employsSalary.get(startDay));

            employsSalary.set(startDay, newSalary);
            employsSalaryRaised.get(startDay).add(day);
        }
    }

    private static void hireEmployees(BigInteger hired, BigDecimal salary) {
        if(employData.size() == 0){
            employData.add(new BigInteger("0"));
            employsSalary.add(new BigDecimal(0));
        }

        employData.add(hired);
        employsSalaryRaised.put(day, new ArrayList<>());
        employsSalary.add(salary);
    }
}