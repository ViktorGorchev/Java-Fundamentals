package wasteDisposal.core;

import wasteDisposal.contracts.Readable;
import wasteDisposal.contracts.Renderable;
import wasteDisposal.contracts.Runnable;

/**
 * Created by Admin on 7.8.2016 г..
 */
public class AppEngine implements Runnable{

    private Readable reader;
    private Renderable render;

    public AppEngine(Readable reader, Renderable render) {
        this.reader = reader;
        this.render = render;
    }

    @Override
    public void run() {

    }
}
