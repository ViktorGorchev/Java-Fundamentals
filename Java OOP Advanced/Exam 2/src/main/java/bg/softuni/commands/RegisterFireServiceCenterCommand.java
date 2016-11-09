package bg.softuni.commands;

import bg.softuni.anotations.Inject;
import bg.softuni.interfaces.EmergencyManagementSystem;
import bg.softuni.interfaces.Creatable;
import bg.softuni.interfaces.EmergencyCenter;

;

public class RegisterFireServiceCenterCommand extends Command{

    @Inject
    private Creatable factory;

    @Inject
    private EmergencyManagementSystem emergencyManagementSystem;

    private String[] tokens;

    public RegisterFireServiceCenterCommand(String[] tokens) {
        this.tokens = tokens;
    }

    public String execute() {
        EmergencyCenter emergencyCenter = this.factory.createEmergencyCenter(this.tokens);
        String operationResult = this.emergencyManagementSystem.registerFireServiceCenter(emergencyCenter);

        return operationResult;
    }
}
