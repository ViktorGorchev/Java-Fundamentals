package models;

import contracts.SoftwareInterface;

public abstract class Software implements SoftwareInterface {
    private String name;
    private String type;
    private int capacityConsumtion;
    private int memoryConsumtion;
    private String installedOnHardware;

    protected Software(String name, String type, int capacityConsumtion, int memoryConsumtion, String installedOnHardware) {
        this.setName(name);
        this.setType(type);
        this.setCapacityConsumtion(capacityConsumtion);
        this.setMemoryConsumtion(memoryConsumtion);
        this.setInstalledOnHardware(installedOnHardware);
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

    public int getCapacityConsumtion() {
        return capacityConsumtion;
    }

    private void setCapacityConsumtion(int capacityConsumtion) {
        this.capacityConsumtion = capacityConsumtion;
    }

    public int getMemoryConsumtion() {
        return memoryConsumtion;
    }

    private void setMemoryConsumtion(int memoryConsumtion) {
        this.memoryConsumtion = memoryConsumtion;
    }

    public String getInstalledOnHardware() {
        return installedOnHardware;
    }

    private void setInstalledOnHardware(String installedOnHardware) {
        this.installedOnHardware = installedOnHardware;
    }
}
