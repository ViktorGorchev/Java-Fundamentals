package ui;

import contracts.Readable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reader implements Readable{

    @Override
    public String reade() throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String input = console.readLine();
        console.close();

        return input;
    }
}
