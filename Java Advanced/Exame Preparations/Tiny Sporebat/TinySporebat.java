import java.util.Scanner;

public class TinySporebat {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        String input = console.nextLine();

        int glowcaps = 0;
        int health = 5800;
        boolean isDead = false;
        while (!input.equals("Sporeggar")){
            for (int i = 0; i < input.length(); i++) {
                if (i == input.length() - 1){
                    glowcaps += Integer.parseInt(Character.toString(input.charAt(i)));
                    continue;
                }

                char charSymbol = input.charAt(i);
                if(charSymbol == 'L'){
                    health += 200;
                    continue;
                }

                health -= charSymbol;
                if(health <= 0){
                    System.out.printf("Died. Glowcaps: %d\n", glowcaps);
                    isDead = true;
                    break;
                }
            }

            if(isDead){
                break;
            }

            input = console.nextLine();
        }

        if (health > 0){
            System.out.printf("Health left: %d\n", health);
        }

        if(glowcaps >= 30 && health > 0){
            System.out.printf("Bought the sporebat. Glowcaps left: %d\n", glowcaps - 30);
        }

        if(glowcaps < 30 && health > 0){
            System.out.printf("Safe in Sporeggar, but another %d Glowcaps needed.", 30 - glowcaps);
        }
    }
}