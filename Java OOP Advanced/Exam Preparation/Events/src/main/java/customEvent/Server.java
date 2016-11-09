package customEvent;

import customEvent.interfaces.Observable;
import customEvent.interfaces.Observer;

import java.util.ArrayList;
import java.util.List;

public class Server implements Observable{

    private String message;

    private List<Observer> observables;

    public Server() {
        this.observables = new ArrayList<Observer>();
    }

    public String getScheduleMessage() {
        return this.message;
    }

    public void addObserver(Observer observer) {
        if(! this.observables.contains(observer)){
            this.observables.add(observer);
        }
    }

    public void removeObserver(Observer observer) {
        if (this.observables.contains(observer)){
            this.observables.remove(observer);
        }
    }

    public void setScheduleDownTime(String message){
        this.message = message;
        this.notifyObservers();
    }

    public void notifyObservers() {
        List<Observer> clonedObservers = new ArrayList<Observer>(this.observables);

        for (Observer clonedObserver : clonedObservers) {
            clonedObserver.update();
        }
    }
}
