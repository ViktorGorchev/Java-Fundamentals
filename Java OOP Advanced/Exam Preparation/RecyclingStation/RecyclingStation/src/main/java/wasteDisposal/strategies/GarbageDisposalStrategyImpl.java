package wasteDisposal.strategies;

import wasteDisposal.contracts.GarbageDisposalStrategy;
import wasteDisposal.contracts.ProcessingData;
import wasteDisposal.contracts.Waste;

public abstract class GarbageDisposalStrategyImpl implements GarbageDisposalStrategy{

    private ProcessingData processingData;

    private double energyProduced;

    private double energyUsed;

    private double capitalEarned;

    private double capitalUsed;

    protected GarbageDisposalStrategyImpl(ProcessingData processingData) {
        this.processingData = processingData;
        this.setEnergyProduced(0);
        this.setEnergyUsed(0);
        this.setCapitalEarned(0);
        this.setCapitalUsed(0);
    }

    protected ProcessingData getProcessingData() {
        return this.processingData;
    }

    protected double getEnergyProduced() {
        return this.energyProduced;
    }

    protected void setEnergyProduced(double energyProduced) {
        this.energyProduced = energyProduced;
    }

    protected double getEnergyUsed() {
        return this.energyUsed;
    }

    protected void setEnergyUsed(double energyUsed) {
        this.energyUsed = energyUsed;
    }

    protected double getCapitalEarned() {
        return this.capitalEarned;
    }

    protected void setCapitalEarned(double capitalEarned) {
        this.capitalEarned = capitalEarned;
    }

    protected double getCapitalUsed() {
        return this.capitalUsed;
    }

    protected void setCapitalUsed(double capitalUsed) {
        this.capitalUsed = capitalUsed;
    }

    protected void updateProcessingData(){
        double currentEnergyBalance = this.getProcessingData().getEnergyBalance();
        double currentCapitalBalance = this.getProcessingData().getCapitalBalance();

        double energyTotal = this.getEnergyProduced() - this.getEnergyUsed();
        double capitalTotal = this.getCapitalEarned() - this.getCapitalUsed();

        this.getProcessingData().setEnergyBalance(currentEnergyBalance + energyTotal);
        this.getProcessingData().setCapitalBalance(currentCapitalBalance + capitalTotal);
    }

    @Override
    public abstract ProcessingData processGarbage(Waste garbage);
}
