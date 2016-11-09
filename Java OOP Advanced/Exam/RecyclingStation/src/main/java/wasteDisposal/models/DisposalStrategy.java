package wasteDisposal.models;

import wasteDisposal.contracts.GarbageDisposalStrategy;
import wasteDisposal.contracts.ProcessingData;
import wasteDisposal.contracts.Waste;

public class DisposalStrategy implements GarbageDisposalStrategy{

    public ProcessingData processGarbage(Waste garbage){
        //TODO reflection

        return null;
    }
}
