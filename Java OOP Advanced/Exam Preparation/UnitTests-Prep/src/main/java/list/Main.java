package list;

/**
 * Created by Admin on 6.8.2016 г..
 */
public class Main {

    public static void main(String[] args) {
        CustomList<Integer> db = new CustomList<Integer>();
        db.addElement(5);
        Interpreter interpreter = new Interpreter(db);
        InterpreterRenderer renderer = new InterpreterRenderer(interpreter);
        System.out.println(renderer.getElement());


    }

}
