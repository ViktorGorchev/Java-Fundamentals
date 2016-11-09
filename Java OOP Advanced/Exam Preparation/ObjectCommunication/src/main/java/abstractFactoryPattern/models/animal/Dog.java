package abstractFactoryPattern.models.animal;

public class Dog extends AnimalImpl {

    private static final String TYPE  = "DOG";

    public Dog() {
        super(TYPE);
    }
}
