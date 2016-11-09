package wasteDisposal.models.waste;

/**
 * Created by Admin on 7.8.2016 г..
 */
public class StorableGarbage extends Garbage {

    private static final String NAME  = "Storable";

    protected StorableGarbage(double weight, double volumePerKg) {
        super(NAME, weight, volumePerKg);
    }
}
