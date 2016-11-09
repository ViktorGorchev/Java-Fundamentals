package wasteDisposal.data;

import wasteDisposal.contracts.Database;
import wasteDisposal.contracts.ProcessingData;

public class DatabaseImpl implements Database{

    private ProcessingData processingData;

    private String denyWasteType;

    private double minEnergyBalance;

    private double minCapitalBalance;

    public DatabaseImpl() {
        this.denyWasteType = null;
        this.minEnergyBalance = 0;
        this.minCapitalBalance = 0;
    }

    @Override
    public void updateDatabaseData(ProcessingData processingData) {
        this.processingData = processingData;
    }

    @Override
    public String processingDataStatus() {
        if(this.processingData == null){
            return "Energy: 0.00 Capital: 0.00";
        }

        String status = String.format(
                "Energy: %.2f Capital: %.2f",
                this.processingData.getEnergyBalance(),
                this.processingData.getCapitalBalance());

        return status;
    }

    @Override
    public void denyWaste(String wasteType, double minEnergyBalance, double minCapitalBalance) {
        this.denyWasteType = wasteType;
        this.minEnergyBalance = minEnergyBalance;
        this.minCapitalBalance = minCapitalBalance;
    }

    @Override
    public boolean isWasteDenied(String wasteType) {
        if(this.denyWasteType == null || ! this.denyWasteType.equals(wasteType)){
            return false;
        }

        if(this.processingData == null
                && (0 < this.minEnergyBalance ||  0 < this.minCapitalBalance)){
            return true;
        }

        boolean energyIsUnderMinimum = this.processingData.getEnergyBalance() < this.minEnergyBalance;
        boolean capitalIsUnderMinimum = this.processingData.getCapitalBalance() < this.minCapitalBalance;
        if(energyIsUnderMinimum || capitalIsUnderMinimum){
            return true;
        }

        return false;
    }
}
