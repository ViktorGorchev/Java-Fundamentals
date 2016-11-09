package wasteDisposal.ui;

import wasteDisposal.contracts.Readable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Admin on 7.8.2016 г..
 */
public class ConsoleReader implements Readable {

    @Override
    public String read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String input = reader.readLine();
        reader.close();

        return input;
    }
}
