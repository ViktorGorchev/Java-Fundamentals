
public class Main {

    public static void main(String[] args) {
        DayOfWeek dayOfWeek = DayOfWeek.THURSDAY;
        System.out.println(dayOfWeek.name());
        System.out.println(dayOfWeek.ordinal());
        String name = "MONDAY"; //"ONDAY" --> IllegalArgumentException: No enum constant DayOfWeek.ONDAY
        DayOfWeek day = DayOfWeek.valueOf(name);
        System.out.println(day.name());

        Number number = Number.TEN;
        System.out.println(number.name());
        System.out.println(number.getNumber());
        String name2 = "ONE";
        Number one = Number.valueOf(name2);
        System.out.println(one.getNumber());
    }

}
