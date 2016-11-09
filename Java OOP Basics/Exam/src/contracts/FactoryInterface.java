package contracts;

public interface FactoryInterface {

    SoftwareInterface createSoftware(String command, String arguments);

    HardwareInterface createHardware(String command, String arguments);
}
