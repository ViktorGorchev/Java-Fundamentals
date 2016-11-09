import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Map;
import java.util.TreeMap;

public class E4 {
    public static void main(String[] args) throws IOException {
        TreeMap<String, TreeMap<String, BigInteger>> data = new TreeMap<>();
       BigInteger maxAmount = new BigInteger("1000000");

        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            String rowData = console.readLine();
            if(rowData.equals("Count em all")){
                break;
            }

            String[] input = rowData.split("\\-\\s*>");
            String region = input[0].trim();
            String type = input[1].trim();
            BigInteger amount = new BigInteger(input[2].trim());

            if(! data.containsKey(region)){
                data.put(region, new TreeMap<>());
                data.get(region).put("Green", BigInteger.ZERO);
                data.get(region).put("Red", BigInteger.ZERO);
                data.get(region).put("Black", BigInteger.ZERO);
            }

            BigInteger x = data.get(region).get(type).add(amount);
            data.get(region).put(type, x);
        }

        for (String region : data.keySet()) {
            for (Map.Entry<String,BigInteger> entry : data.get(region).entrySet()) {
                if(entry.getKey().equals("Green") && entry.getValue().compareTo(maxAmount) >= 0){
                    BigInteger tempAmount = entry.getValue();
                    BigInteger count = BigInteger.ZERO;
                    while (tempAmount.compareTo(maxAmount) >= 0){
                        //int a = tempAmount.compareTo(maxAmount);

                        tempAmount = tempAmount.subtract(maxAmount);
                        count = count.add(BigInteger.ONE);
                    }

                    data.get(region).put("Green", tempAmount);
                    data.get(region).put("Red", data.get(region).get("Red").add(count));
                }

                if(entry.getKey().equals("Red") && entry.getValue().compareTo(maxAmount) >= 0){
                    BigInteger tempAmount = entry.getValue();
                    BigInteger count = BigInteger.ZERO;
                    while (tempAmount.compareTo(maxAmount) >= 0){
                        tempAmount = tempAmount.subtract(maxAmount);
                        count = count.add(BigInteger.ONE);
                    }

                    data.get(region).put("Red", tempAmount);
                    data.get(region).put("Black", data.get(region).get("Black").add(count));
                }
            }


        }

        data.entrySet().stream()
                .sorted((r1, r2) -> {
                    int region1 = r1.getKey().length();
                    int region2 = r2.getKey().length();

                    return Integer.compare(region1, region2);
                })
                .sorted((r1, r2) ->{
                    BigInteger blackAmount1 = r1.getValue().get("Black");
                    BigInteger blackAmount2 = r2.getValue().get("Black");

                    return blackAmount2.compareTo(blackAmount1);
                })
                .forEach(r ->{
                    System.out.println(r.getKey());

                    r.getValue().entrySet().stream().sorted((t1, t2) ->{
                        BigInteger units1 = t1.getValue();
                        BigInteger units2 = t2.getValue();

                        return units2.compareTo(units1);
                    })
                            .forEach(t -> {

                                System.out.printf("-> %s : %d%n", t.getKey(), t.getValue());
                            });

                });





        console.close();
    }
}
