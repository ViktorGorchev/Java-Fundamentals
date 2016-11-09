package wasteDisposal.contracts;

public interface Creatable {
    Waste createWaste(String name, double weight, double volumePerKg, String wasteType);
}
