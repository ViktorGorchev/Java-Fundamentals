import java.util.*;

public class _04_DragonArmy {
    public static void main(String[] args) {
        TreeMap<String, LinkedHashMap<String, List<Integer>>> data = new TreeMap<>();
        LinkedHashMap<String, HashMap<String, List<Integer>>> averageData = new LinkedHashMap<>();

        Scanner console = new Scanner(System.in);
        int numberOfDragons = Integer.parseInt(console.nextLine());
        for (int i = 0; i < numberOfDragons; i++) {
            String[] input = console.nextLine().split("\\s+");
            String type = input[0];
            String name = input[1];
            String stringDamage = input[2];
            String stringHealth = input[3];
            String stringArmor = input[4];

            if(data.containsKey(name) && data.get(name).containsKey(type)){
                averageData.get(type).get("damage").remove(data.get(name).get(type).get(0));
                averageData.get(type).get("health").remove(data.get(name).get(type).get(1));
                averageData.get(type).get("armor").remove(data.get(name).get(type).get(2));

                data.get(name).get(type).clear();
            }

            if(!data.containsKey(name)){
                data.put(name, new LinkedHashMap<>());
            }

            if(!data.get(name).containsKey(type)){
                data.get(name).put(type, new ArrayList<>());
            }

            int damage = 45;
            int health = 250;
            int armor = 10;
            if(!stringDamage.equals("null")){
                damage = Integer.parseInt(stringDamage);
            }

            if(!stringHealth.equals("null")){
                health = Integer.parseInt(stringHealth);
            }

            if(!stringArmor.equals("null")){
                armor = Integer.parseInt(stringArmor);
            }

            data.get(name).get(type).add(damage);
            data.get(name).get(type).add(health);
            data.get(name).get(type).add(armor);

            if(!averageData.containsKey(type)){
                averageData.put(type, new HashMap<>());
                averageData.get(type).put("damage", new ArrayList<>());
                averageData.get(type).put("health", new ArrayList<>());
                averageData.get(type).put("armor", new ArrayList<>());
            }

            averageData.get(type).get("damage").add(damage);
            averageData.get(type).get("health").add(health);
            averageData.get(type).get("armor").add(armor);
        }

        averageData.entrySet().stream().forEach(averData -> {
            System.out.printf("%s::(%.2f/%.2f/%.2f)\n",
                    averData.getKey(),
                    averData.getValue().get("damage").stream().mapToDouble(a -> a).average().getAsDouble(),
                    averData.getValue().get("health").stream().mapToDouble(a -> a).average().getAsDouble(),
                    averData.getValue().get("armor").stream().mapToDouble(a -> a).average().getAsDouble()
            );

            data.entrySet().stream().filter(d -> d.getValue().containsKey(averData.getKey())).forEach(dragon -> {                
                    System.out.printf("-%s -> damage: %d, health: %d, armor: %d\n",
                            dragon.getKey(),
                            dragon.getValue().get(averData.getKey()).get(0),
                            dragon.getValue().get(averData.getKey()).get(1),
                            dragon.getValue().get(averData.getKey()).get(2)
                    );                
            });
        });
    }
}