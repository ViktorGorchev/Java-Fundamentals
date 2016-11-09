package observerPattern.observerModels;

import observerPattern.Subject;

public abstract class Observer {
    protected Subject subject;
    public abstract void update();
}
