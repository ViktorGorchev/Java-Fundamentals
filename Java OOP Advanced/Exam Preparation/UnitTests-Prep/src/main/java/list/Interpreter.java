package list;

/**
 * Created by Admin on 6.8.2016 г..
 */
public class Interpreter {

    private CustomList<Integer> list;

    public Interpreter(CustomList<Integer> list){
        this.list = list;
    }

    public Integer returnLastElementInCustomList(){
        if(this.list.getSize() == 0){
            throw new IllegalArgumentException("No elements present");
        }

        return this.list.getElementAt(this.list.getSize() - 1);
    }


}
