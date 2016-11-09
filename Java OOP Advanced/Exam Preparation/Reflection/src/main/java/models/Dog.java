package models;

public class Dog extends AnimalImpl{

    private static final String DOG_TYPE  = "DOG";

    private String color = "black";

    public Dog() {
        super(DOG_TYPE);
    }

    public String getColor() {
        return this.color;
    }
}
