package bg.softuni.interfaces;

public interface EmergencyCenter {
    public String getName();

    public Integer getAmountOfMaximumEmergencies();

    String getManageEmergenciesType();

    public void addProcessedEmergency(Emergency emergency);

    public Boolean isForRetirement();
}
