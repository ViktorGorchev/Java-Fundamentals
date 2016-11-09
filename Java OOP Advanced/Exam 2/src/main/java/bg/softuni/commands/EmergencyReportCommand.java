package bg.softuni.commands;

import bg.softuni.anotations.Inject;
import bg.softuni.interfaces.EmergencyManagementSystem;

public class EmergencyReportCommand extends Command{

    @Inject
    private EmergencyManagementSystem emergencyManagementSystem;

    public String execute() {
        String operationResult = this.emergencyManagementSystem.emergencyReport();

        return operationResult;
    }
}
