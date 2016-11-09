package models;

public class PowerHardware extends Hardware{
    private static final String TYPE_POWER_HARDWARE  = "Power";
    private static final int DECREASE_CAPACITY_PERCENT = 75;
    private static final int INCREASE_MEMORY_PERCENT = 75;

    protected PowerHardware(
            String name,
            long maxCapacity,
            long maxMemory,
            long currentCapacity,
            long currentMemory) {
        super(name, TYPE_POWER_HARDWARE, maxCapacity, maxMemory, currentCapacity, currentMemory);

        this.adjustCapacity();
        this.adjustMemory();
    }

    @Override
    public void setCurrentCapacity(long currentCapacity) {
        this.setCurrentCapacity(currentCapacity);
    }

    @Override
    public void setCurrentMemory(long currentMemory) {
        this.setCurrentMemory(currentMemory);
    }

    @Override
    protected void adjustMemory() {
        int losOfDivision = 0;
        if(((super.getMaxMemory() / 100) * INCREASE_MEMORY_PERCENT + super.getMaxMemory() % 2 != 0)){
            losOfDivision++;
        }

        long maxMemoryAdjusted =
                (super.getMaxMemory() / 100) * INCREASE_MEMORY_PERCENT + super.getMaxMemory() +losOfDivision;
        super.setMaxMemory(maxMemoryAdjusted);
    }

    @Override
    protected void adjustCapacity() {
        int losOfDivision = 0;
        if((super.getMaxCapacity() - (super.getMaxCapacity() / 100 * DECREASE_CAPACITY_PERCENT) % 2 != 0)){
            losOfDivision++;
        }

        long maxCapacityAdjusted =
                super.getMaxCapacity() - (super.getMaxCapacity() / 100 * DECREASE_CAPACITY_PERCENT) + losOfDivision;
        super.setMaxCapacity(maxCapacityAdjusted);
    }
}