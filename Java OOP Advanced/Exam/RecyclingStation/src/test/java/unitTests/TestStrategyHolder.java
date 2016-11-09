package unitTests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import wasteDisposal.contracts.GarbageDisposalStrategy;
import wasteDisposal.contracts.StrategyHolder;
import wasteDisposal.contracts.Waste;
import wasteDisposal.models.DefaultStrategyHolder;
import wasteDisposal.models.DisposalStrategy;
import wasteDisposal.models.waste.BurnableGarbage;
import wasteDisposal.models.waste.StorableGarbage;

public class TestStrategyHolder {

    private StrategyHolder strategyHolder;

    @Mock
    private Waste burnableGarbage;

    @Mock
    private GarbageDisposalStrategy garbageDisposalStrategy;

    @Before
    public void setUp() {
        this.strategyHolder = new DefaultStrategyHolder();
        this.burnableGarbage = Mockito.mock(BurnableGarbage.class);
        this.garbageDisposalStrategy = Mockito.mock(DisposalStrategy.class);
    }

    @Test
    public void addStrategyMethod_addClassAndStrategy_shouldAddSuccessfullyAndReturnTrue(){
       boolean actual =
                this.strategyHolder.addStrategy(this.burnableGarbage.getClass(), this.garbageDisposalStrategy);

        Assert.assertTrue(actual);
    }

    @Test
    public void addStrategyMethod_addClassAndStrategyThatAlreadyAdded_shouldNotAddAndReturnFalse(){
        this.strategyHolder.addStrategy(this.burnableGarbage.getClass(), this.garbageDisposalStrategy);
        boolean actual =
                this.strategyHolder.addStrategy(this.burnableGarbage.getClass(), this.garbageDisposalStrategy);

        Assert.assertFalse(actual);
    }

    @Test
    public void addStrategyMethod_addClassAndStrategy_shouldAddOneKeySuccessfully(){
        int expected = 1;

        this.strategyHolder.addStrategy(this.burnableGarbage.getClass(), this.garbageDisposalStrategy);
        int actual = this.strategyHolder.getDisposalStrategies().keySet().size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addStrategyMethod_addClassAndStrategy_shouldAddOneValueSuccessfully(){
        int expected = 1;

        this.strategyHolder.addStrategy(this.burnableGarbage.getClass(), this.garbageDisposalStrategy);
        int actual = this.strategyHolder.getDisposalStrategies().values().size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addStrategyMethod_addClassAndStrategyThatAlreadyAdded_shouldNotAddAnd(){
        int expected = 1;

        this.strategyHolder.addStrategy(this.burnableGarbage.getClass(), this.garbageDisposalStrategy);
        this.strategyHolder.addStrategy(this.burnableGarbage.getClass(), this.garbageDisposalStrategy);
        int actual = this.strategyHolder.getDisposalStrategies().keySet().size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeStrategy_removeClassAndStrategyThatAlreadyAdded_shouldRemoveSuccessfullyAndReturnTrue(){
        this.strategyHolder.addStrategy(this.burnableGarbage.getClass(), this.garbageDisposalStrategy);
        boolean actual =
                this.strategyHolder.removeStrategy(this.burnableGarbage.getClass());

        Assert.assertTrue(actual);
    }

    @Test
    public void removeStrategy_removeClassAndStrategyNotAlreadyAdded_shouldReturnFalse(){
        boolean actual =
                this.strategyHolder.removeStrategy(this.burnableGarbage.getClass());

        Assert.assertFalse(actual);
    }

    @Test
    public void removeStrategy_removeClassAndStrategyThatAlreadyAdded_shouldRemoveSuccessfully(){
        int expected = 0;

        this.strategyHolder.addStrategy(this.burnableGarbage.getClass(), this.garbageDisposalStrategy);
        this.strategyHolder.removeStrategy(this.burnableGarbage.getClass());
        int actual = this.strategyHolder.getDisposalStrategies().keySet().size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeStrategy_removeClassAndStrategyThatNotAlreadyAdded_shouldNotChangeTheAmountOfKeys() {
        int expected = 0;

        this.strategyHolder.removeStrategy(this.burnableGarbage.getClass());
        int actual = this.strategyHolder.getDisposalStrategies().keySet().size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getDisposalStrategies_oneClassAndStrategyAdded_shouldReturnSameKeysCollection (){
        Class[] expected = new Class[1];
        expected[0] = this.burnableGarbage.getClass();

        this.strategyHolder.addStrategy(this.burnableGarbage.getClass(), this.garbageDisposalStrategy);
        int setSize = this.strategyHolder.getDisposalStrategies().keySet().size();
        Class[] actual = this.strategyHolder.getDisposalStrategies().keySet().toArray(new Class[setSize]);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void getDisposalStrategies_oneClassAndStrategyAdded_shouldReturnSameValuesCollection() {
        GarbageDisposalStrategy[] expected = new GarbageDisposalStrategy[1];
        expected[0] = this.garbageDisposalStrategy;

        this.strategyHolder.addStrategy(this.burnableGarbage.getClass(), this.garbageDisposalStrategy);
        int setSize = this.strategyHolder.getDisposalStrategies().keySet().size();
        GarbageDisposalStrategy[] actual =
                this.strategyHolder.getDisposalStrategies().values().toArray(new GarbageDisposalStrategy[setSize]);

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void getDisposalStrategies_twoClassAndStrategyAdded_shouldReturnCollectionWithTwoKeys() {
        int expected = 2;
        Waste storableGarbage = Mockito.mock(StorableGarbage.class);
        GarbageDisposalStrategy secondGarbageDisposalStrategy = Mockito.mock(DisposalStrategy.class);

        this.strategyHolder.addStrategy(this.burnableGarbage.getClass(), this.garbageDisposalStrategy);
        this.strategyHolder.addStrategy(storableGarbage.getClass(), secondGarbageDisposalStrategy);
        int actual = this.strategyHolder.getDisposalStrategies().keySet().size();

        Assert.assertEquals(expected, actual);
    }
}