package factoryWithReflection;

import factoryWithReflection.models.Beer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            String input = reader.readLine();
            if(input.equalsIgnoreCase("end")){
                break;
            }

            String[] inputParams = input.split(" ");
            String beerName = inputParams[0];
            int liters = Integer.parseInt(inputParams[1]);

            Brewary brewary = new Brewary();
            Beer beer = brewary.brew(beerName, liters);

            System.out.println("Bear brewed: " + beer.getClass().getSimpleName());

        }
    }
}
