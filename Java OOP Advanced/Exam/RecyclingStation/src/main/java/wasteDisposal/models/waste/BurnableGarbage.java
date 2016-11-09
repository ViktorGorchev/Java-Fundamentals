package wasteDisposal.models.waste;

public class BurnableGarbage extends Garbage {
    private static final String NAME  = "Burnable";

    protected BurnableGarbage(double weight, double volumePerKg) {
        super(NAME, weight, volumePerKg);
    }
}
