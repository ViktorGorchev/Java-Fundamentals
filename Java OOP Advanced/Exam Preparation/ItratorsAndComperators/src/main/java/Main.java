import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        //iterator
        System.out.println("---iterator test---");

        MyList<Integer> list = new MyList<Integer>();
        list.addToMyList(8);
        list.addToMyList(5);
        list.addToMyList(7);
        list.addToMyList(9);

        for (Integer number : list) {
            System.out.println(number);
        }

        System.out.println();
        list.forEach(System.out::println);

        HashMap<String , Integer> c = new HashMap<>();

        //comperator
        System.out.println("---comperator test---");

        MyDateClass date1 = new MyDateClass(1995);
        MyDateClass date2 = new MyDateClass(1992);
        MyDateClass date3 = new MyDateClass(1991);
        MyDateClass date4 = new MyDateClass(1992);
        List<MyDateClass> datesList = new ArrayList<>();
        datesList.add(date1);
        datesList.add(date2);
        datesList.add(date3);
        datesList.add(date4);

        for (MyDateClass myDateClass : datesList) {
            System.out.println(myDateClass.getYear());
        }

        System.out.println();

        datesList.sort((d1, d2) -> d1.compareTo(d2));
        for (MyDateClass myDateClass : datesList) {
            System.out.println(myDateClass.getYear());
        }


    }
}
