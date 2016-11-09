import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        ListyIterator listyIterator = null;

        while (true){
            String commandData = consoleReader.readLine();
            if(commandData.equals("END")){
                break;
            }

            String[] tokens = commandData.split("[\\s]+");
            String command = tokens[0];

            switch (command){
                case "Create":
                    List<String> data = new ArrayList<>(Arrays.asList(tokens));
                    data.remove(0);
                    listyIterator = new ListyIterator(data);
                    break;

                case "Move":
                    boolean operationResult = listyIterator.move();
                    System.out.println(operationResult);
                    break;

                case "HasNext":
                    System.out.println(listyIterator.iterator().hasNext());
                    break;

                case "Print":
                    if(listyIterator.iterator().hasNext() == false){
                        System.out.println("Invalid Operation!");
                        break;
                    }

                    int currentIndex = 0;
                    for (String element : listyIterator) {
                        if(currentIndex != listyIterator.getIndex()){
                            currentIndex++;
                            continue;
                        }

                        System.out.println(element);
                        break;
                    }

                    break;
                default:
                    break;
            }

        }
    }

}
