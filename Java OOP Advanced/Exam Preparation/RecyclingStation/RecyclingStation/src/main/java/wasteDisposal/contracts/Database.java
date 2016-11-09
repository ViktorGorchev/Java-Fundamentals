package wasteDisposal.contracts;

public interface Database {

    void updateDatabaseData(ProcessingData processingData);

    String processingDataStatus();

    void denyWaste(String wasteType, double minEnergyBalance, double minCapitalBalance);

    boolean isWasteDenied(String wasteType);
}
