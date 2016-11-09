package wasteDisposal.data;

import wasteDisposal.contracts.ProcessingData;

public class ProcessingDataImpl implements ProcessingData {

    private double energyBalance;

    private double capitalBalance;

    public ProcessingDataImpl() {
        this.setEnergyBalance(0);
        this.setCapitalBalance(0);
    }

    @Override
    public double getEnergyBalance() {
        return this.energyBalance;
    }

    public void setEnergyBalance(double energyBalance) {
        this.energyBalance = energyBalance;
    }

    @Override
    public double getCapitalBalance() {
        return this.capitalBalance;
    }

    public void setCapitalBalance(double capitalBalance) {
        this.capitalBalance = capitalBalance;
    }
}
