import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.annotation.Annotation;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //Problem 3.	Cards with Power


//        Rank card = Enum.valueOf(Rank.class, reader.readLine());
//        Suit suit = Enum.valueOf(Suit.class, reader.readLine());
//
//        System.out.printf("Card name: %s of %s; Card power: %d",
//                card.name(),
//                suit.name(),
//                card.getPower() + suit.getPower());


        //Problem 6.	Custom Enum Annotation

        String input = reader.readLine();
        Class<?> enumClass = Class.forName(input);

        Annotation[] annotations = enumClass.getAnnotations();
        for (Annotation annotation : annotations) {
            CardEnumeration cardEnumeration = ((CardEnumeration) annotation);
            if(cardEnumeration == null){
                continue;
            }

            String type = cardEnumeration.type();
            String description = cardEnumeration.description();

            if (!input.equals(cardEnumeration.category())) {
                continue;
            }

            System.out.printf("Type = %s, Description = %s%n",
                    type,
                    description);

        }

    }
}
