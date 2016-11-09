package bg.softuni.commands;

import bg.softuni.anotations.Inject;
import bg.softuni.interfaces.EmergencyManagementSystem;
import bg.softuni.interfaces.Creatable;
import bg.softuni.interfaces.Emergency;

;

public class RegisterHealthEmergencyCommand extends Command{

    @Inject
    private Creatable factory;

    @Inject
    private EmergencyManagementSystem emergencyManagementSystem;


    private String[] tokens;

    public RegisterHealthEmergencyCommand(String[] tokens) {
        this.tokens = tokens;
    }

    public String execute() {
        Emergency emergency = this.factory.createEmergency(tokens);

        String operationResult = this.emergencyManagementSystem.registerHealthEmergency(emergency);

        return operationResult;
    }
}
