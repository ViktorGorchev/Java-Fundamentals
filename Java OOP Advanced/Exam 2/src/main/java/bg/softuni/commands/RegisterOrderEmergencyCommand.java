package bg.softuni.commands;

import bg.softuni.anotations.Inject;
import bg.softuni.interfaces.EmergencyManagementSystem;
import bg.softuni.interfaces.Creatable;
import bg.softuni.interfaces.Emergency;

;

public class RegisterOrderEmergencyCommand extends Command{

    @Inject
    private Creatable factory;

    @Inject
    private EmergencyManagementSystem emergencyManagementSystem;

    private String[] tokens;

    public RegisterOrderEmergencyCommand(String[] tokens) {
        this.tokens = tokens;
    }

    public String execute() {
        Emergency emergency = this.factory.createEmergency(tokens);
        String operationResult = this.emergencyManagementSystem.registerOrderEmergency(emergency);

        return operationResult;
    }
}
