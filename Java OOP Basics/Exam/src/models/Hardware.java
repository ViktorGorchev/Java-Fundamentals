package models;

import contracts.HardwareInterface;

public abstract class Hardware implements HardwareInterface {
    private String name;
    private String type;
    private long maxCapacity;
    private long maxMemory;
    private long currentCapacity;
    private long currentMemory;

    protected Hardware(String name, String type, long maxCapacity, long maxMemory, long currentCapacity, long currentMemory) {
        this.setName(name);
        this.setType(type);
        this.setMaxCapacity(maxCapacity);
        this.setMaxMemory(maxMemory);
        this.setCurrentMemory(maxCapacity);
        this.setCurrentMemory(maxMemory);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    private void setType(String type) {
        this.type = type;
    }

    public long getMaxCapacity() {
        return maxCapacity;
    }

    protected void setMaxCapacity(long maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public long getMaxMemory() {
        return maxMemory;
    }

    protected void setMaxMemory(long maxMemory) {
        this.maxMemory = maxMemory;
    }

    public long getCurrentCapacity() {
        return currentCapacity;
    }

    public void setCurrentCapacity(int currentCapacity) {
        this.currentCapacity = currentCapacity;
    }

    public long getCurrentMemory() {
        return currentMemory;
    }

    public void setCurrentMemory(int currentMemory) {
        this.currentMemory = currentMemory;
    }

    protected abstract void adjustCapacity();

    protected abstract void adjustMemory();
}
