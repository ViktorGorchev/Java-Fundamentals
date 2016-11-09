package ui;

import contracts.Renderable;

public class Renderer implements Renderable {

    @Override
    public void render(String output) {
        System.out.println(output);
    }
}