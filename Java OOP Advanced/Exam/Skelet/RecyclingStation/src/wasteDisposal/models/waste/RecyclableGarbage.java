package wasteDisposal.models.waste;

/**
 * Created by Admin on 7.8.2016 г..
 */
public class RecyclableGarbage extends Garbage {

    private static final String NAME  = "Recyclable";

    protected RecyclableGarbage(double weight, double volumePerKg) {
        super(NAME, weight, volumePerKg);
    }
}
