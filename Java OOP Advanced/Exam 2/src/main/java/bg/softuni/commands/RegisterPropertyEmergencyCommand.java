package bg.softuni.commands;

import bg.softuni.anotations.Inject;
import bg.softuni.interfaces.EmergencyManagementSystem;
import bg.softuni.interfaces.Creatable;
import bg.softuni.interfaces.Emergency;

;

public class RegisterPropertyEmergencyCommand extends Command{

    @Inject
    private Creatable factory;

    @Inject
    private EmergencyManagementSystem emergencyManagementSystem;

    private String[] tokens;

    public RegisterPropertyEmergencyCommand(String[] tokens) {
        this.tokens = tokens;
    }

    public String execute() {
        Emergency emergency = this.factory.createEmergency(tokens);
        String operationResult = this.emergencyManagementSystem.registerPropertyEmergency(emergency);

        return operationResult;
    }
}
