package wasteDisposal.models;

import wasteDisposal.annotations.Recycle;

@Recycle
public class RecyclableWaste extends WasteImpl {

    public RecyclableWaste(String name, double weight, double volumePerKg) {
        super(name, weight, volumePerKg);
    }
}
