package models;

@Mammal(legs = 4)
public abstract class AnimalImpl implements Animal{
    private String type;

    protected AnimalImpl(String type) {
        this.setAnimalType(type);
    }

    public String getAnimalType() {
        return this.type;
    }

    private void setAnimalType(String type) {
        this.type = type;
    }
}
