package contracts;

public interface HardwareInterface {
    String getName();

    String getType();

    long getMaxCapacity();

    long getMaxMemory();

    long getCurrentCapacity();

    void setCurrentCapacity(long currentCapacity);

    long getCurrentMemory();

    void setCurrentMemory(long currentMemory);
}
