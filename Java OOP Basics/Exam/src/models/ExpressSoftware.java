package models;

public class ExpressSoftware extends Software {
    private static final String TYPE_EXPRESS_SOFTWARE = "Express";

    protected ExpressSoftware(String name, String type, int capacityConsumtion, int memoryConsumtion, String
            installedOnHardware) {
        super(name, TYPE_EXPRESS_SOFTWARE, capacityConsumtion, memoryConsumtion, installedOnHardware);
    }
}
