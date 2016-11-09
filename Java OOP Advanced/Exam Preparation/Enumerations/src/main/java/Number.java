/**
 * Created by Admin on 17.8.2016 г..
 */
public enum Number {
    ONE(1),
    TEN(10);

    private int number;

    private Number(Integer number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }
}
