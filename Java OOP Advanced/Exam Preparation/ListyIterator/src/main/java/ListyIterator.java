import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class ListyIterator implements Iterable<String>{
    private List<String> elements;
    private int index;

    public ListyIterator(List<String> elements) {
        this.elements = elements;
        this.setIndex(0);
    }

    public int getIndex() {
        return this.index;
    }

    private void setIndex(int index) {
        this.index = index;
    }

    public boolean move(){
        if (this.index < this.elements.size()){
            this.index++;
            return true;
        }

        return false;
    }


    public Iterator<String> iterator() {
        return new ListyCustomIterator();
    }

    private class ListyCustomIterator implements Iterator<String>{

        public boolean hasNext() {
            if (index < elements.size() - 1){
                return true;
            }

            return false;
        }

        public String next() {
            if (this.hasNext()){
                String element = elements.get(index);
                index++;

                return element;
            }

            throw new NoSuchElementException();
        }

        public void remove() {
            if (index < elements.size()){
                elements.remove(index);
            }
        }
    }
}
