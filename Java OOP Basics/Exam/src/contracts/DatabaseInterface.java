package contracts;

public interface DatabaseInterface {
    void addHardware(HardwareInterface hardware);

    void moveHardwareToDump(String name);

    void addSoftware(SoftwareInterface software);

    void removeSoftware(String name);

    void restoreHardwareFromDump(String name);

    void removeHardwareFromDump(String name);

    String systemAnalysis();

    String finalDataAnalysis();
}
