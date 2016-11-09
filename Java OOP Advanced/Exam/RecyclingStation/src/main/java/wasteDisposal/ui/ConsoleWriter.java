package wasteDisposal.ui;

import wasteDisposal.contracts.Renderable;

/**
 * Created by Admin on 7.8.2016 г..
 */
public class ConsoleWriter implements Renderable {

    @Override
    public void render(String output) {
        System.out.println(output);
    }
}
