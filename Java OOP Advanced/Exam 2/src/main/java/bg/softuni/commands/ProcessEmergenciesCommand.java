package bg.softuni.commands;

import bg.softuni.anotations.Inject;
import bg.softuni.interfaces.EmergencyManagementSystem;

;

public class ProcessEmergenciesCommand extends Command{

    @Inject
    private EmergencyManagementSystem emergencyManagementSystem;

    private String[] tokens;

    public ProcessEmergenciesCommand(String[] tokens) {
        this.tokens = tokens;
    }

    public String execute() {
        String type = tokens[0];
        String operationResult = this.emergencyManagementSystem.processEmergencies(type);

        return operationResult;
    }
}
