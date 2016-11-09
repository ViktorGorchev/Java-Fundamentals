
public class MyDateClass implements Comparable<MyDateClass> {

    private int year;

    public MyDateClass(int year) {
        this.setYear(year);
    }

    public int getYear() {
        return this.year;
    }

    private void setYear(int year) {
        this.year = year;
    }

    @Override
    public int compareTo(MyDateClass date) {
        //return Integer.compare(this.getYear(), date.getYear());

        if(this.getYear() > date.getYear()){
            return 1;

        } else if(this.getYear() < date.getYear()){
            return -1;

        }else {
            //if equals
            return 0;
        }

    }
}
