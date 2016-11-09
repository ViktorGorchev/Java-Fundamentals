package forEachWithCustomClassAndMethod;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(2);
        numbers.add(4);
        numbers.add(7);

        numbers.stream().forEach(PrintList::printNumber);

    }


}
