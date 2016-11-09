package customEvent.interfaces;

public interface Observable {

    String getScheduleMessage();

    void setScheduleDownTime(String message);

    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers();
}
