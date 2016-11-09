package bg.softuni;

import bg.softuni.DependencyResolver.DependencyResolverImpl;
import bg.softuni.collections.EmergencyCenterRegisterImpl;
import bg.softuni.collections.EmergencyRegisterImpl;
import bg.softuni.core.AppEngine;
import bg.softuni.core.CommandDispatcher;
import bg.softuni.core.EmergencyManagementSystemImpl;
import bg.softuni.core.appFactory.Factory;
import bg.softuni.interfaces.*;
import bg.softuni.interfaces.Readable;
import bg.softuni.interfaces.Runnable;
import bg.softuni.ui.ConsoleReader;
import bg.softuni.ui.ConsoleRenderer;

public class Main {

    public static void main(String[] args) {
        Readable reader = new ConsoleReader();
        Renderable renderer = new ConsoleRenderer();

        Creatable factory = new Factory();
        EmergencyRegister emergencyRegister = new EmergencyRegisterImpl();
        EmergencyCenterRegister emergencyCenterRegister = new EmergencyCenterRegisterImpl();
        EmergencyManagementSystem emergencyManagementSystem = new EmergencyManagementSystemImpl(
                emergencyRegister,
                emergencyCenterRegister);
        DependencyResolver dependencyResolver = new DependencyResolverImpl(
                factory,
                emergencyManagementSystem);

        Dispatchable dispatcher = new CommandDispatcher(dependencyResolver);

        Runnable engine = new AppEngine(reader, renderer, dispatcher);
        engine.run();
    }

}
