package wasteDisposal.models;

import wasteDisposal.contracts.Waste;

public abstract class WasteImpl implements Waste {

    private String name;

    private double weight;

    private double volumePerKg;

    private double totalWasteVolume;

    protected WasteImpl(String name, double weight, double volumePerKg) {
        this.setName(name);
        this.setWeight(weight);
        this.setVolumePerKg(volumePerKg);
        this.setTotalWasteVolume();
    }

    @Override
    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    @Override
    public double getWeight() {
        return this.weight;
    }

    private void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public double getVolumePerKg() {
        return this.volumePerKg;
    }

    private void setVolumePerKg(double volumePerKg) {
        this.volumePerKg = volumePerKg;
    }
    public double getTotalWasteVolume() {
        return this.totalWasteVolume;
    }

    private void setTotalWasteVolume() {
        this.totalWasteVolume = this.getWeight() * this.getVolumePerKg();
    }
}
