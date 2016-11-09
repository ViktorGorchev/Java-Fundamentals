package list;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 6.8.2016 г..
 */
public class CustomList <E> {
    List<E> elements;

    public CustomList() {
        this.elements = new ArrayList<E>();
    }

    public boolean addElement(E element){
        boolean elementAdded = this.elements.add(element);

        return elementAdded;
    }

    public E removeElement(int index){
        if(index > this.elements.size() - 1){
            throw new IndexOutOfBoundsException("Index not in range!");
        }

        E elementRemoved = this.elements.remove(index);

        return elementRemoved;
    }

    public Integer getSize(){
        return this.elements.size();
    }

    protected E getElementAt(int ingex){
        return this.elements.get(ingex);
    }

}
