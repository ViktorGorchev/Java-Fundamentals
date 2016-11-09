package bg.softuni.collections;

import bg.softuni.interfaces.Emergency;
import bg.softuni.interfaces.EmergencyRegister;
import bg.softuni.models.Emergency.BaseEmergency;

public class EmergencyRegisterImpl implements EmergencyRegister {

    private static final Integer INITIAL_SIZE = 16;

    private Emergency[] emergencyQueue;

    private Integer currentSize;

    private Integer nextIndex;

    public EmergencyRegisterImpl() {
        this.emergencyQueue = new BaseEmergency[INITIAL_SIZE];
        this.currentSize = 0;
        this.nextIndex = 0;
    }

    @Override
    public void enqueueEmergency(Emergency emergency) {
        this.checkIfResizeNeeded();

        this.emergencyQueue[this.nextIndex] = emergency;
        this.incrementNextIndex();

        this.incrementCurrentSize();
    }

    @Override
    public Emergency dequeueEmergency() {
        Emergency removedElement = this.emergencyQueue[0];

        for (int i = 0; i < this.currentSize - 1; i++) {
            this.emergencyQueue[i] = this.emergencyQueue[i + 1];
        }

        this.decrementNextIndex();
        this.decrementCurrentSize();

        return removedElement;
    }

    @Override
    public Emergency peekEmergency() {
        Emergency peekedElement = this.emergencyQueue[0];
        return peekedElement;
    }

    @Override
    public Boolean isEmpty() {
        return this.currentSize == 0;
    }

    private void incrementNextIndex() {
        this.nextIndex++;
    }

    private void decrementNextIndex() {
        this.nextIndex--;
    }

    private void incrementCurrentSize() {
        this.currentSize++;
    }

    private void decrementCurrentSize() {
        this.currentSize--;
    }

    private void checkIfResizeNeeded() {
        if(this.currentSize == this.emergencyQueue.length) {
            this.resize();
        }
    }

    private void resize() {
        Emergency[] newArray = new BaseEmergency[2 * this.currentSize];

        for (int i = 0; i < this.currentSize; i++) {
            newArray[i] = this.emergencyQueue[i];
        }

        this.emergencyQueue = newArray;
    }
}