package wasteDisposal.models;

import wasteDisposal.contracts.GarbageDisposalStrategy;
import wasteDisposal.contracts.StrategyHolder;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class DefaultStrategyHolder implements StrategyHolder {
    private Map<Class,GarbageDisposalStrategy> strategies;

    public DefaultStrategyHolder(){
        this.strategies = new LinkedHashMap<Class,GarbageDisposalStrategy>();
    }

    public Map<Class, GarbageDisposalStrategy> getDisposalStrategies() {
        return Collections.unmodifiableMap(this.strategies);
    }

    public boolean addStrategy(Class annotationClass, GarbageDisposalStrategy strategy) {
        if(!this.strategies.containsKey(annotationClass)){
            this.strategies.put(annotationClass,strategy);
            return true;
        }

        return false;
    }

    public boolean removeStrategy(Class annotationClass) {
        if(this.strategies.containsKey(annotationClass)){
            this.strategies.remove(annotationClass);
            return true;
        }

        return false;
    }
}