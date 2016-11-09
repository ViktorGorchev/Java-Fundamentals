package customEvent;

import customEvent.interfaces.Observable;
import customEvent.interfaces.Observer;

public class Main {

    public static void main(String[] args) {
        Observable server = new Server();

        Observer gosho = new User("gosho", "gosho@abv.bg", server);
        server.addObserver(gosho);
        Observer ivan = new User("ivan", "ivan@gmail.com", server);
        server.addObserver(ivan);

        server.setScheduleDownTime("Our servers will be unavailable on friday!");

        Observer misho = new User("misho", "misho@yahoo.com", server);
        server.addObserver(misho);

        server.setScheduleDownTime("We are going to have a party.");
    }
}
