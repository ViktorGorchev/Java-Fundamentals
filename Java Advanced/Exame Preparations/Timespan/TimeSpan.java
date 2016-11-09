import java.util.Scanner;

public class TimeSpan {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

//        LocalTime time1 = LocalTime.parse(console.nextLine());
//        LocalTime time2 = LocalTime.parse(console.nextLine());

        String[] input1 = console.nextLine().split(":");
        int time1Hour = Integer.parseInt(input1[0]);
        int time1Minutes = Integer.parseInt(input1[1]);
        int time1Seconds = Integer.parseInt(input1[2]);

        String[] input2 = console.nextLine().split(":");
        int time2Hour = Integer.parseInt(input2[0]);
        int time2Minutes = Integer.parseInt(input2[1]);
        int time2Seconds = Integer.parseInt(input2[2]);

        int hourResult = time1Hour - time2Hour;
        int minutesResult = 0;
        int secondsResult = 0;

        if(time1Minutes < time2Minutes){
            minutesResult = (time1Minutes - time2Minutes) + 60;
            hourResult = hourResult - 1;
        } else {
            minutesResult = time1Minutes - time2Minutes;
        }

        if(time1Seconds < time2Seconds){
            secondsResult = (time1Seconds - time2Seconds) + 60;
            minutesResult = minutesResult - 1;
        }else {
            secondsResult = time1Seconds - time2Seconds;
        }

        String stringMinutesResult = "" + minutesResult;
        if(minutesResult < 10){
            stringMinutesResult = "0" + stringMinutesResult;
        }

        String stringSecondResult = "" + secondsResult;
        if(secondsResult < 10){
            stringSecondResult = "0" + stringSecondResult;
        }

        System.out.println(hourResult + ":" + stringMinutesResult + ":" + stringSecondResult);
    }
}