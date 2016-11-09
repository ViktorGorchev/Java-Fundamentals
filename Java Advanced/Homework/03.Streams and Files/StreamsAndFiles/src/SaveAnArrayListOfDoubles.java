import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class SaveAnArrayListOfDoubles {
    public static void main(String[] args) {
       //Locale.setDefault(Locale.ROOT);
        List<Double> listOfDoubles = new ArrayList<>(Arrays.asList(1.5, 1.6, 25.63, 99.99));

        File newFile = new File( "src/", "doubles.list" );
        try (ObjectOutputStream outputStream = new ObjectOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(newFile)))){
            for (Double number : listOfDoubles) {
                 outputStream.writeDouble(number);
            }

        }catch( IOException exception ){
            exception.getMessage();
        }

        try (ObjectInputStream inputStream = new ObjectInputStream(
                new BufferedInputStream(
                        new FileInputStream(newFile)))){
            while (true){
                Double number = inputStream.readDouble();
                System.out.println(number);
            }

        }catch (EOFException eof){
            System.out.println("File end!");

        }catch( IOException exception ){
            exception.getMessage();
        }
    }
}