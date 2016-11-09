import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AllCapitals {
    public static void main(String[] args) {
        List<String> linesToUpper = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("src/test-2.txt"))){
            String fileLine = reader.readLine();
            while (fileLine != null){
                linesToUpper.add(fileLine.toUpperCase());
                fileLine = reader.readLine();
            }
        }catch (IOException ioe){
            System.out.println(ioe.getMessage());
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/test-2.txt", false))){
            for (String line : linesToUpper) {
                writer.write(line + "\r\n");
            }
        }catch (IOException ioe){
            System.out.println(ioe.getMessage());
        }
    }
}
