package strategyPattern;

import strategyPattern.interfaces.Strategy;
import strategyPattern.interfaces.StrategyExecutable;
import strategyPattern.models.OperationAdd;
import strategyPattern.models.OperationMultiply;
import strategyPattern.models.OperationSubtract;

public class Main {

    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 5;

        Strategy strategyAdd = new OperationAdd();
        StrategyExecutable contextAdd = new Context(strategyAdd);
        int addResult = contextAdd.executeStrategy(num1, num2);
        System.out.printf("%d + %d = %d%n", num1, num2, addResult);

        Strategy strategySubtract = new OperationSubtract();
        StrategyExecutable contextSubtract = new Context(strategySubtract);
        int subtractResult = contextSubtract.executeStrategy(num1, num2);
        System.out.printf("%d - %d = %d%n", num1, num2, subtractResult);

        Strategy strategyMultiply = new OperationMultiply();
        StrategyExecutable contextMultiply = new Context(strategyMultiply);
        int multiplyResult = contextMultiply.executeStrategy(num1, num2);
        System.out.printf("%d * %d = %d%n", num1, num2, multiplyResult);
    }

}
