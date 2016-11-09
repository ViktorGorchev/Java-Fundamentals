package tests;

import org.junit.Before;
import org.junit.Test;
import wasteDisposal.contracts.StrategyHolder;
import wasteDisposal.models.DefaultStrategyHolder;

;


/**
 * Created by Admin on 7.8.2016 г..
 */
public class TestStrategyHolder {

    private StrategyHolder strategyHolder;

    @Before
    public void setUp(){
        this.strategyHolder = new DefaultStrategyHolder();
    }

//private LinkedHashMap<Class,GarbageDisposalStrategy> strategies;

//    public boolean addStrategy(Class annotationClass, GarbageDisposalStrategy strategy) {
//        this.strategies.put(annotationClass,strategy);
//        return true;
//    }

    @Test
    public void addStrategyMethod_addClassAndStrategy_shouldAddSuccessfully(){

    }

}
