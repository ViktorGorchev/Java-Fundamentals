package wasteDisposal.strategies;

import wasteDisposal.annotations.Store;
import wasteDisposal.contracts.ProcessingData;
import wasteDisposal.contracts.Waste;

@Store
public class StoreStrategy extends GarbageDisposalStrategyImpl{

    public StoreStrategy(ProcessingData processingData) {
        super(processingData);
    }

    @Override
    public ProcessingData processGarbage(Waste garbage) {
        this.setEnergyUsed(garbage.getTotalWasteVolume() * 0.13);
        this.setCapitalUsed(garbage.getTotalWasteVolume() * 0.65);

        this.updateProcessingData();

        return this.getProcessingData();
    }
}
