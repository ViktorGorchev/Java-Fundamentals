import java.util.LinkedHashMap;
        import java.util.Scanner;
        import java.util.regex.Matcher;
        import java.util.regex.Pattern;

public class _13_SrubskoUnleashed {
    public static void main(String[] args) {
        LinkedHashMap<String, LinkedHashMap<String, Long>> data = new LinkedHashMap<>();

        Scanner console = new Scanner(System.in);
        while (true){
            String input = console.nextLine();
            if(input.equals("End")){
                break;
            }

            String regex = "([a-zA-Z ]+) @([a-zA-Z ]+) (\\d+) (\\d+)";
            Matcher matcher = Pattern.compile(regex).matcher(input);
            while (matcher.find()) {
                String singer = matcher.group(1);
                String venue = matcher.group(2);
                long ticketsPrice = Long.parseLong(matcher.group(3));
                long ticketsCount = Long.parseLong(matcher.group(4));

                int venuesWords = matcher.group(2).trim().split(" ").length;
                int singersWords = matcher.group(1).trim().split(" ").length;
                if (venuesWords > 3 || singersWords > 3){
                    break;
                }

                if(!data.containsKey(venue)){
                    data.put(venue, new LinkedHashMap<>());
                }

                if(!data.get(venue).containsKey(singer)){
                    data.get(venue).put(singer, 0L);
                }

                data.get(venue).put(singer, data.get(venue).get(singer) + (ticketsCount * ticketsPrice));
            }
        }

        data.entrySet().stream().forEach(v ->{
            System.out.println(v.getKey());

            v.getValue().entrySet().stream().sorted((s1, s2) -> s2.getValue().compareTo(s1.getValue()))
                    .forEach(s ->{
                        System.out.printf("#  %s -> %d%n", s.getKey(), s.getValue());
                    });
        });
    }
}