package wasteDisposal.core.garbageProcessor;

import wasteDisposal.annotations.Disposable;
import wasteDisposal.contracts.*;

import java.lang.annotation.Annotation;

public class DefaultGarbageProcessor implements GarbageProcessor {

    private StrategyHolder strategyHolder;

    public DefaultGarbageProcessor(StrategyHolder strategyHolder){
        this.setStrategyHolder(strategyHolder);
    }

    private void setStrategyHolder(StrategyHolder strategyHolder) {
        this.strategyHolder = strategyHolder;
    }

    @Override
    public StrategyHolder getStrategyHolder() {
        return this.strategyHolder;
    }

    @Override
    public ProcessingData processWaste(Waste garbage) {
        Class garbageClass = garbage.getClass();
        Annotation[] garbageAnnotations = garbageClass.getAnnotations();
        Class disposableAnnotationClass = null;
        for (Annotation annotation : garbageAnnotations) {
            if(annotation.annotationType().isAnnotationPresent(Disposable.class)){
                disposableAnnotationClass = annotation.annotationType();
                break;
            }
        }

        if (disposableAnnotationClass == null
                || ! this.getStrategyHolder().getDisposalStrategies().containsKey(disposableAnnotationClass))
        {
            throw new IllegalArgumentException(
                    "The passed in garbage does not implement an annotation " +
                            "implementing the Disposable meta-annotation or is not supported " +
                            "by the StrategyHolder.");
        }

        GarbageDisposalStrategy currentStrategy = this.getStrategyHolder().getDisposalStrategies().get(disposableAnnotationClass);
        ProcessingData processingData = currentStrategy.processGarbage(garbage);

        return processingData;
    }
}
