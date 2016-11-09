import java.util.LinkedHashMap;
import java.util.Scanner;

public class _09_PopulationCounter {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        LinkedHashMap<String, LinkedHashMap<String, Long>> data = new LinkedHashMap<>();

        while (true){
            String input = console.nextLine();
            if(input.equals("report")){
                break;
            }

            String[] inputData = input.split("\\|");
            String city = inputData[0].trim();
            String country = inputData[1].trim();
            Long population = Long.parseLong(inputData[2].trim());

            if (!data.containsKey(country)) {
                data.put(country, new LinkedHashMap<>());
            }

            if(!data.get(country).containsKey(city)){
                data.get(country).put(city, 0L);
            }

            data.get(country).put(city, population);
        }

        data.entrySet().stream().
                sorted((c1, c2) -> Long.compare(sumPopulation(c2.getValue()), sumPopulation(c1.getValue())))
                .forEach(c ->{
            System.out.printf("%s (total population: %d)%n", c.getKey(), sumPopulation(c.getValue()));

            c.getValue().entrySet().stream()
                    .sorted((city1, city2) -> city2.getValue().compareTo(city1.getValue()))
                    .forEach(city ->{
                        System.out.printf("=>%s: %d%n", city.getKey(), city.getValue());
                    });
        });
    }

    private static Long sumPopulation(LinkedHashMap<String, Long> value) {
        Long sum = 0L;
        for (Long population : value.values()) {
            sum += population;
        }

        return  sum;
    }
}