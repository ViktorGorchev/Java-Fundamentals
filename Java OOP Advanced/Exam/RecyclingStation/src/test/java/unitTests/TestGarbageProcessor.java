package unitTests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import wasteDisposal.contracts.GarbageProcessor;
import wasteDisposal.contracts.StrategyHolder;
import wasteDisposal.contracts.Waste;
import wasteDisposal.models.DefaultGarbageProcessor;
import wasteDisposal.models.DefaultStrategyHolder;
import wasteDisposal.models.waste.BurnableGarbage;

public class TestGarbageProcessor {

    @Mock
    private StrategyHolder strategyHolder;

    private GarbageProcessor garbageProcessor;

    @Mock
    private Waste waste;

    @Before
    public void setUp() {
        this.strategyHolder = Mockito.mock(DefaultStrategyHolder.class);
        this.garbageProcessor = new DefaultGarbageProcessor(this.strategyHolder);
        this.waste = Mockito.mock(BurnableGarbage.class);
    }


    @Test
    public void getStrategyHolder_shouldReturnObjectHoldingCurrentlyContainedStrategies(){
        StrategyHolder expected = this.strategyHolder;
        StrategyHolder actual = this.garbageProcessor.getStrategyHolder();

        Assert.assertEquals(expected, actual);
    }
}
