package models;

public class LightSoftware extends Software {
    private static final String TYPE_LIGHT_SOFTWARE = "Light";

    public LightSoftware(String name,
                          int capacityConsumtion,
                          int memoryConsumtion,
                          String installedOnHardware) {
        super(name, TYPE_LIGHT_SOFTWARE, capacityConsumtion, memoryConsumtion, installedOnHardware);
    }
}
