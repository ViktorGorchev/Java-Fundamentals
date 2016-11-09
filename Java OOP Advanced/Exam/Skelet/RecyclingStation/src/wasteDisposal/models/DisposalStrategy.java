package wasteDisposal.models;

import wasteDisposal.contracts.GarbageDisposalStrategy;
import wasteDisposal.contracts.ProcessingData;
import wasteDisposal.contracts.Waste;

/**
 * Created by Admin on 7.8.2016 г..
 */
public class DisposalStrategy implements GarbageDisposalStrategy{

    public ProcessingData processGarbage(Waste garbage){
        //TODO reflection

        return null;
    }
}
