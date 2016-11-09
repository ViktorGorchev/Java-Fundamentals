package bg.softuni.ui;

import bg.softuni.interfaces.Readable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader implements Readable {

    private BufferedReader reader;

    public ConsoleReader() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

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
