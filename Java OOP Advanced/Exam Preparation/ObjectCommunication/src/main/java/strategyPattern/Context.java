package strategyPattern;

import strategyPattern.interfaces.Strategy;
import strategyPattern.interfaces.StrategyExecutable;

public class Context implements StrategyExecutable{

    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2){
        int result = this.strategy.doOperation(num1, num2);

        return result;
    }
}
