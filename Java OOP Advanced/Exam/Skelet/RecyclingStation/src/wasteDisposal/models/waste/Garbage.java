package wasteDisposal.models.waste;

import wasteDisposal.contracts.Waste;

/**
 * Created by Admin on 7.8.2016 г..
 */
public abstract class Garbage implements Waste{

    private String name;
    private double weight;
    private double volumePerKg;

    protected Garbage(String name, double weight, double volumePerKg) {
        this.setName(name);
        this.setWeight(weight);
        this.setVolumePerKg(volumePerKg);
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
}
