package abstractFactoryPattern.models.plant;

public class Tree extends PlantImpl{

    private static final String TYPE = "TREE";

    public Tree() {
        super(TYPE);
    }
}
