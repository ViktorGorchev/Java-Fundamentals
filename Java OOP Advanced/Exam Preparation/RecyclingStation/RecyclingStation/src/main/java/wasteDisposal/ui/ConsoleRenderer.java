package wasteDisposal.ui;

import wasteDisposal.contracts.Renderable;

public class ConsoleRenderer implements Renderable{

    @Override
    public void render(String output) {
        System.out.println(output);
    }
}
