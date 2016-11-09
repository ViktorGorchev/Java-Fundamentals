import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class E4 {

    public static void main(String[] args) throws IOException {
        TreeMap<String, TreeMap<String,BigInteger>> data = new TreeMap<>();
        TreeMap<String, BigInteger> keySortData = new TreeMap<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            String input = reader.readLine();
            if(input.equals("Icarus, Ignite!")){
                break;
            }

            String regex = "^Grow\\s<([A-Z][a-z]+)>\\s<([A-Za-z0-9]+)>\\s([0-9]{1,10})$";
            Matcher matcher = Pattern.compile(regex).matcher(input);
            while (matcher.find()) {
                String regionName = matcher.group(1);
                String colorName = matcher.group(2);
                Integer roseAmount = 0;
                try{
                    roseAmount = Integer.parseInt(matcher.group(3));
                }catch (NumberFormatException e){
                    continue;
                }

                if(! data.containsKey(regionName)){
                    data.put(regionName, new TreeMap<>());
                    keySortData.put(regionName, BigInteger.ZERO);
                }

                if(! data.get(regionName).containsKey(colorName)){
                    data.get(regionName).put(colorName, BigInteger.ZERO);
                }

                data.get(regionName).put(
                        colorName,
                        data.get(regionName).get(colorName).add(BigInteger.valueOf(roseAmount.intValue())));

                keySortData.put(
                        regionName,
                        keySortData.get(regionName).add(BigInteger.valueOf(roseAmount.intValue())));
            }
        }

        keySortData.entrySet().stream()
                .sorted((r1, r2) -> r2.getValue().compareTo(r1.getValue()))
                .forEach(r -> {
                    System.out.println(r.getKey());

                    data.get(r.getKey()).entrySet().stream()
                            .sorted((c1, c2) -> c1.getValue().compareTo(c2.getValue()))
                            .forEach(c -> {
                                System.out.printf("*--%s | %d%n", c.getKey(), c.getValue());
                            });
                });

    }
}
