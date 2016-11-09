package AppFactory;

import contracts.FactoryInterface;
import contracts.HardwareInterface;
import contracts.SoftwareInterface;

public class Factory implements FactoryInterface {
    public SoftwareInterface createSoftware(String command, String arguments){
        SoftwareInterface software = null;
        //TODO

        return software;
    }

    public HardwareInterface createHardware(String command, String arguments){
        HardwareInterface hardware = null;
        //TODO

        return hardware;
    }
}
