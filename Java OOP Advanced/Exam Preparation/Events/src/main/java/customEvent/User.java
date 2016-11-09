package customEvent;

import customEvent.interfaces.Observable;
import customEvent.interfaces.Observer;

public class User implements Observer{

    private String userName;

    private String emailAddress;

    private Observable observable;

    public User(String userName, String emailAddress, Observable observable) {
        this.setUserName(userName);
        this.setEmailAddress(emailAddress);
        this.setObservable(observable);
    }

    public String getUserName() {
        return this.userName;
    }

    private void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    private void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    private void setObservable(Observable observable) {
        this.observable = observable;
    }

    public void update() {
        reade();
        unsubscribe();
    }

    public void unsubscribe() {
        this.observable.removeObserver(this);
    }

    private void reade() {
        System.out.println(this.getUserName() + " received:");
        System.out.println(this.observable.getScheduleMessage());

    }
}
