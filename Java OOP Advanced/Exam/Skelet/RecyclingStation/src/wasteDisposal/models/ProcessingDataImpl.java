package wasteDisposal.models;

import wasteDisposal.contracts.ProcessingData;

/**
 * Created by Admin on 7.8.2016 г..
 */
public class ProcessingDataImpl implements ProcessingData {

    private double energyBalance;
    private double capitalBalance;

    private ProcessingDataImpl(double energyBalance, double capitalBalance) {
        this.setEnergyBalance(energyBalance);
        this.setCapitalBalance(capitalBalance);
    }

    @Override
    public double getEnergyBalance() {
        return this.energyBalance;
    }

    private void setEnergyBalance(double energyBalance) {
        this.energyBalance = energyBalance;
    }

    @Override
    public double getCapitalBalance() {
        return this.capitalBalance;
    }

    private void setCapitalBalance(double capitalBalance) {
        this.capitalBalance = capitalBalance;
    }

}
