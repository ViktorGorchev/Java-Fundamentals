package wasteDisposal.data;

import wasteDisposal.annotations.Burn;
import wasteDisposal.annotations.Recycle;
import wasteDisposal.annotations.Store;
import wasteDisposal.contracts.GarbageDisposalStrategy;
import wasteDisposal.contracts.ProcessingData;
import wasteDisposal.contracts.StrategyHolder;
import wasteDisposal.strategies.BurnStrategy;
import wasteDisposal.strategies.RecycleStrategy;
import wasteDisposal.strategies.StoreStrategy;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class DefaultStrategyHolder implements StrategyHolder {
    private LinkedHashMap<Class,GarbageDisposalStrategy> strategies;

    private ProcessingData processingData;

    public DefaultStrategyHolder(ProcessingData processingData){
        this.processingData = processingData;
        this.strategies = new LinkedHashMap<>();
        this.seedStrategies();
    }

    @Override
    public Map<Class, GarbageDisposalStrategy> getDisposalStrategies() {
        return Collections.unmodifiableMap(this.strategies);
    }

    @Override
    public boolean addStrategy(Class annotationClass, GarbageDisposalStrategy strategy) {
        if(this.strategies.containsKey(annotationClass)){
            return false;
        }

        this.strategies.put(annotationClass,strategy);
        return true;
    }

    @Override
    public boolean removeStrategy(Class annotationClass) {
        if(! this.strategies.containsKey(annotationClass)){
            return false;
        }

        this.strategies.remove(annotationClass);
        return true;
    }

    private void seedStrategies() {
        this.strategies.put(Burn.class, new BurnStrategy(this.processingData));
        this.strategies.put(Recycle.class, new RecycleStrategy(this.processingData));
        this.strategies.put(Store.class, new StoreStrategy(this.processingData));
    }
}
