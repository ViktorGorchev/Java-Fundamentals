package factoryWithReflection.models;

public abstract class Beer {

    private int liters;

    protected Beer(int liters) {
        this.liters = liters;
    }
}
