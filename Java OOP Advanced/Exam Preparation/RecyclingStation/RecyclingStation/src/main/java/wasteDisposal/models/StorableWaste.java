package wasteDisposal.models;

import wasteDisposal.annotations.Store;

@Store
public class StorableWaste extends WasteImpl {

    public StorableWaste(String name, double weight, double volumePerKg) {
        super(name, weight, volumePerKg);
    }
}
