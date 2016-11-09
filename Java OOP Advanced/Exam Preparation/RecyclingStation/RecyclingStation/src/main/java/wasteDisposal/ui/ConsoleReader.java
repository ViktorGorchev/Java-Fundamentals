package wasteDisposal.ui;

import wasteDisposal.contracts.Readable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader implements Readable{
    private BufferedReader reader;

    public ConsoleReader() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public String reade() {

        String input = null;

        try {
            input = this.reader.readLine();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return input;
    }
}
