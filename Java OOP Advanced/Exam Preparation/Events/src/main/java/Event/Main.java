package Event;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        User gosho = new User();
        User misho = new User();

        Server server = new Server();
        server.addObserver(gosho);
        server.addObserver(misho);

        while (true){
            String input = reader.nextLine();

            if(input.equalsIgnoreCase("end")){
                break;
            }

            if(input.equalsIgnoreCase("change")){

                server.serverStateChange();

                server.notifyObservers("Our servers will be unavailable on friday!");
            }
        }




    }
}