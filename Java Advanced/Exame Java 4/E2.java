import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class E2 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] matrixData = reader.readLine().split("[\\s]+");

        int n = Integer.parseInt(matrixData[0]);
        int m = Integer.parseInt(matrixData[1]);

        List<String> commands = new ArrayList<>();
        while (true){
            String input = reader.readLine();
            if(input.equals("Bloom Bloom Plow")){
                break;
            }
            
            commands.add(input);
        }

        commands.sort((c1, c2) -> c1.compareTo(c2));

        Integer[][] matrix = new Integer[n][m];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                matrix[row][col] = 0;
            }

        }

        for (int i = 0; i < commands.size(); i++) {
            String[] matrixCommands = commands.get(i).split("[\\s]+");
            int rowCommand = Integer.parseInt(matrixCommands[0]);
            int colCommand = Integer.parseInt(matrixCommands[1]);

            for (int col = 0; col < m; col++) {
                if(col == colCommand){
                    continue;
                }

                matrix[rowCommand][col] +=1;
            }

            for (int row = 0; row < n; row++) {
               matrix[row][colCommand] += 1;
            }
        }

        printMatrix(matrix);
    }
    
    public static void printMatrix(Integer[][] matrix){
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row] [col] + " ");
            }

            System.out.println();
        }
    }
}