import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class MyList<E> implements Iterable<E>{

    private List<E> list;

    public MyList() {
        this.list = new ArrayList<E>();
    }

    public void addToMyList(E element){
        this.list.add(element);
    }

    public Iterator iterator() {
        return new CustomIterator();
    }

    private class CustomIterator implements Iterator<E>{

        private int index;

        private CustomIterator() {
            this.index = 0;
        }

        public boolean hasNext() {
            return this.index < list.size() - 1;
        }

        public E next() {
            if(this.hasNext()){
                E element = list.get(this.index);
                this.index++;

                return element;
            }

            throw new NoSuchElementException();
        }
    }
}