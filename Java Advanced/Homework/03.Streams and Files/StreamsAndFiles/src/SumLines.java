import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SumLines {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("src/test.txt"))){
            String fileLine = reader.readLine();
            while (fileLine != null){
                int charCount = 0;
                for (int i = 0; i < fileLine.length(); i++) {
                    charCount += fileLine.charAt(i);
                }

                System.out.println(charCount);
                fileLine = reader.readLine();
            }
        }catch (IOException ioe){
            System.out.println(ioe.getMessage());
        }
    }
}