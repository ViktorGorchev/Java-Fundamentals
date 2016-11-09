import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E1 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String text = console.nextLine();
        String pattern = console.nextLine();

        while (true){
            if(pattern.equals("")){
                break;
            }

            if(text.length() < (pattern.length() * 2)){
                break;
            }

            String regex = "(" + pattern + ")";
            Matcher matcher = Pattern.compile(regex).matcher(text);
            int count = 0;
            while (matcher.find()){
                count++;
            }

            if(count > 1){
                text = text.replaceFirst(Matcher.quoteReplacement(pattern), "");
                int lastIndex = text.lastIndexOf(pattern);

                StringBuffer t = new StringBuffer(text);
                t.replace( lastIndex ,lastIndex + pattern.length() ,"");
                text = t.toString();
                //text = text.replaceFirst(Matcher.quoteReplacement(pattern), "");
                System.out.println("Shaked it.");

                StringBuilder sb = new StringBuilder();
                sb.append(pattern);
                sb.deleteCharAt(pattern.length() / 2);
                pattern = sb.toString();
            } else {
               break;
            }
        }

        System.out.println("No shake.");
        System.out.println(text);
    }
}




//text = text.replaceFirst(pattern, "");
//        text = text.replaceFirst(pattern + "$", "");
//        break;

//    String regex = "(" + pattern + ")";
//    Matcher matcher = Pattern.compile(pattern).matcher(text);
//    int count = 0;
//while (matcher.find()){
//        count++;
//        }
//
//        if(count > 1){
//        matcher.replaceFirst(regex); //first
//        int countLast = 0;
//        while (matcher.find()) {
//        countLast++;
//        if (countLast == count) {
//        matcher.replaceFirst(regex); //last
//
//        }
//        }
//
//
//        } else {
//        canShakeOff = false;
//        }
