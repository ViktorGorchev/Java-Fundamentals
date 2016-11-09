import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JediDreams {
    public static void main(String[] args) throws IOException {
        TreeMap<String, List<String>> data = new TreeMap<>();

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        int linesCount = Integer.parseInt(console.readLine());
        String currentStaticMethod = null;
        for (int i = 0; i < linesCount; i++) {
            String input = console.readLine();

            if(input.contains("static")){
                String staticMethod = getMethodName(input);

                if(input.contains("new")){
                    continue;
                }

                if(! data.containsKey(staticMethod)){
                    data.put(staticMethod, new ArrayList<>());
                }

                currentStaticMethod = staticMethod;
                continue;
            }

            List<String> innerMethods = getInnerMethodName(input);

            if(input.contains("new")){
                continue;
            }

            if(! data.containsKey(currentStaticMethod)){
                continue;
            }

            for (int j = 0; j < innerMethods.size(); j++) {
                if(innerMethods.get(j) == null){
                    continue;
                }

                data.get(currentStaticMethod).add(innerMethods.get(j));
            }


        }


        System.out.println(data);



        console.close();
    }

//    private static boolean newBeforeMethod(String input, String methodName) {
//        String result = null;
//
//        String regex = String.format("(new\\s+%s)", methodName);
//        Matcher matcher = Pattern.compile(regex).matcher(input);
//        while (matcher.find()) {
//            result = matcher.group(1);
//        }
//
//        boolean containsNew = result != null;
//
//        return containsNew;
//    }
//
//    private static boolean newBeforeMethod(String input, List<String> innerMethods) {
//        String result = null;
//
//        String regex = String.format("(new\\s+%s)", methodName);
//        Matcher matcher = Pattern.compile(regex).matcher(input);
//        while (matcher.find()) {
//            result = matcher.group(1);
//        }
//
//        boolean containsNew = result != null;
//
//        return containsNew;
//    }

    private static String getMethodName(String input) {
        String methodName = null;

        String regex = "([A-Z]+\\w+)\\(";
        Matcher matcher = Pattern.compile(regex).matcher(input);
        while (matcher.find()) {
            methodName = matcher.group(1);
        }

        return methodName;
    }

    private static List<String> getInnerMethodName(String input) {
        List<String> methods = new ArrayList<>();

        String regex = "([A-Z]+\\w+)\\(";
        Matcher matcher = Pattern.compile(regex).matcher(input);
        while (matcher.find()) {
            methods.add(matcher.group(1));
        }

        return methods;
    }
}