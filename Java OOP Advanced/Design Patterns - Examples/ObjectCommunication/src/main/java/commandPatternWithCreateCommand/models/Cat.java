package commandPatternWithCreateCommand.models;

public class Cat extends AnimalImpl{

    private static final String TYPE  = "CAT";

    public Cat() {
        super(TYPE);
    }
}
