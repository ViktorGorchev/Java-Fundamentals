package wasteDisposal.models.waste;

/**
 * Created by Admin on 7.8.2016 г..
 */
public class BurnableGarbage extends Garbage {
    private static final String NAME  = "Burnable";

    protected BurnableGarbage(double weight, double volumePerKg) {
        super(NAME, weight, volumePerKg);
    }
}
