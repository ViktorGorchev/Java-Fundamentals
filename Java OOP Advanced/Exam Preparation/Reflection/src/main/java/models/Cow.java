package models;

@Name("Cow milka")
@Mammal(legs = 4)
public class Cow extends AnimalImpl {

    private static final String COW_TYPE = "COW";

    private int legs;

    private String name;

    public Cow(String name, Integer legs) {
        super(COW_TYPE);

        this.setName(name);
        this.setLegs(legs);
    }

    public int getLegs() {
        return legs;
    }

    private void setLegs(int legs) {
        this.legs = legs;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String concatCow(String name, Integer legs){
        return name + " has " + legs + " legs";
    }

    public static int doubleTheLegs(Integer legs){
        return legs * 2;
    }
}
