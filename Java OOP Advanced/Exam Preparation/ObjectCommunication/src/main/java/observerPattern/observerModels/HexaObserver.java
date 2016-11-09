package observerPattern.observerModels;

import observerPattern.Subject;

public class HexaObserver extends Observer{

    public HexaObserver(Subject subject) {
        super.subject = subject;
        super.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Hex String: " + Integer.toHexString(subject.getState()).toUpperCase());
    }
}
