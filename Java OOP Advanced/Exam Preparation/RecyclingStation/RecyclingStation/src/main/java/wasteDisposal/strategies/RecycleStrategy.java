package wasteDisposal.strategies;

import wasteDisposal.annotations.Recycle;
import wasteDisposal.contracts.ProcessingData;
import wasteDisposal.contracts.Waste;

@Recycle
public class RecycleStrategy extends GarbageDisposalStrategyImpl{

    public RecycleStrategy(ProcessingData processingData) {
        super(processingData);
    }

    @Override
    public ProcessingData processGarbage(Waste garbage) {
        this.setEnergyUsed(garbage.getTotalWasteVolume() / 2.0);
        this.setCapitalEarned(400 * garbage.getWeight());

        this.updateProcessingData();

        return this.getProcessingData();
    }
}
