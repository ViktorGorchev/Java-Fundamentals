package models;

public class HeavyHardware extends Hardware{
    private static final String TYPE_HEAVY_HARDWARE  = "Heavy";
    private static final int INCREASE_CAPACITY_PERCENT   = 50;
    private static final int DECREASE_MEMORY_PERCENT   = 25;

    private HeavyHardware(
            String name,
            long maxCapacity,
            long maxMemory,
            long currentCapacity,
            long currentMemory) {
        super(name, TYPE_HEAVY_HARDWARE, maxCapacity, maxMemory, currentCapacity, currentMemory);

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
        if((super.getMaxMemory() - (super.getMaxMemory() / 100) * DECREASE_MEMORY_PERCENT) % 2 != 0){
            losOfDivision++;
        }

        long maxMemoryAdjusted =
                super.getMaxMemory() - (super.getMaxMemory() / 100) * DECREASE_MEMORY_PERCENT + losOfDivision;
        super.setMaxMemory(maxMemoryAdjusted);
    }

    @Override
    protected void adjustCapacity() {
        int losOfDivision = 0;
        if(((super.getMaxCapacity() / 100 * INCREASE_CAPACITY_PERCENT) + super.getMaxCapacity() % 2 != 0)){
            losOfDivision++;
        }

        long maxCapacityAdjusted =
                (super.getMaxCapacity() / 100 * INCREASE_CAPACITY_PERCENT) + super.getMaxCapacity() + losOfDivision;
        super.setMaxCapacity(maxCapacityAdjusted);
    }
}