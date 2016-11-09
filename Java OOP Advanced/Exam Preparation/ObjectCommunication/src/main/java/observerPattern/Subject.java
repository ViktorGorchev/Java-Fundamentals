package observerPattern;

import observerPattern.observerModels.Observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    private List<Observer> observers;

    private int state;

    public Subject() {
        this.observers = new ArrayList<>();
    }

    public int getState() {
        return this.state;
    }

    public void setState(int state) {
        this.state = state;
        this.notifyAllObservers();
    }

    public void attach(Observer observer){
        this.observers.add(observer);
    }

    public void notifyAllObservers(){
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
