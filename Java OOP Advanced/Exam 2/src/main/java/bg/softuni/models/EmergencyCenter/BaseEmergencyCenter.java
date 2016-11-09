package bg.softuni.models.EmergencyCenter;

import bg.softuni.interfaces.Emergency;
import bg.softuni.interfaces.EmergencyCenter;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseEmergencyCenter implements EmergencyCenter{
    private String name;

    private Integer amountOfMaximumEmergencies;

    private List<Emergency> emergenciesProcessed;

    private String manageEmergenciesType;

    protected BaseEmergencyCenter(
            String name,
            Integer amountOfMaximumEmergencies,
            String manageEmergenciesType) {
        this.setName(name);
        this.setAmountOfMaximumEmergencies(amountOfMaximumEmergencies);
        this.setManageEmergenciesType(manageEmergenciesType);
        this.emergenciesProcessed = new ArrayList<Emergency>();
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public Integer getAmountOfMaximumEmergencies() {
        return this.amountOfMaximumEmergencies;
    }

    private void setAmountOfMaximumEmergencies(Integer amountOfMaximumEmergencies) {
        this.amountOfMaximumEmergencies = amountOfMaximumEmergencies;
    }

    public String getManageEmergenciesType() {
        return this.manageEmergenciesType;
    }

    private void setManageEmergenciesType(String manageEmergenciesType) {
        this.manageEmergenciesType = manageEmergenciesType;
    }

    public void addProcessedEmergency(Emergency emergency){
        this.emergenciesProcessed.add(emergency);
    }

    public Boolean isForRetirement(){
        if(this.emergenciesProcessed.size() >= this.amountOfMaximumEmergencies){
            return true;
        }

        return false;
    }
}