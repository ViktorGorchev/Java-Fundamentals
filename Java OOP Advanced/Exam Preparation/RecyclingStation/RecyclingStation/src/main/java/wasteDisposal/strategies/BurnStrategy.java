package wasteDisposal.strategies;

import wasteDisposal.annotations.Burn;
import wasteDisposal.contracts.ProcessingData;
import wasteDisposal.contracts.Waste;

@Burn
public class BurnStrategy extends GarbageDisposalStrategyImpl{

    public BurnStrategy(ProcessingData processingData) {
        super(processingData);
    }

    @Override
    public ProcessingData processGarbage(Waste garbage) {
        this.setEnergyProduced(garbage.getTotalWasteVolume());
        this.setEnergyUsed(garbage.getTotalWasteVolume() * 0.2);

        this.updateProcessingData();

        return this.getProcessingData();
    }
}
