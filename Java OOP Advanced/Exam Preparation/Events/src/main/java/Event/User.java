package Event;

import java.util.Observable;
import java.util.Observer;

public class User implements Observer{

    public void update(Observable o, Object arg) {
        System.out.println("Server message: " + arg);
        System.out.println("Observers count: " + o.countObservers());
        System.out.println("-----------------------------------------");
    }
}
