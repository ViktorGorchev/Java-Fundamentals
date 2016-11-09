package wasteDisposal.models;

import wasteDisposal.annotations.Burn;

@Burn
public class BurnableWaste extends WasteImpl {

    public BurnableWaste(String name, double weight, double volumePerKg) {
        super(name, weight, volumePerKg);
    }
}
