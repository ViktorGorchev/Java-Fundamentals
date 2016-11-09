package bg.softuni.ui;

import bg.softuni.interfaces.Renderable;

public class ConsoleRenderer implements Renderable {

    public void render(String output) {
        System.out.println(output);
    }
}
