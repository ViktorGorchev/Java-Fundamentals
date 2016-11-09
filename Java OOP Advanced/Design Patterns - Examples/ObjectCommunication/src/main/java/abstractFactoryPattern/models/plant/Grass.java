package abstractFactoryPattern.models.plant;

public class Grass extends PlantImpl {

    private static final String TYPE = "GRASS";

    public Grass() {
        super(TYPE);
    }
}
