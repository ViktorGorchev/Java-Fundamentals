package predicat;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        //returns true or false
        Predicate<Integer> isBiggerThanSix = n -> n > 6;
        System.out.println(isBiggerThanSix.test(7));

        BiPredicate<Integer, Integer> numbersAreEqual = (n1, n2) -> n1 == n2;
        System.out.println(numbersAreEqual.test(2, 3));
    }
}
