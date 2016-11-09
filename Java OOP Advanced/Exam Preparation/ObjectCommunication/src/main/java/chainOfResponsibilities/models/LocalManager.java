package chainOfResponsibilities.models;

public class LocalManager extends BankEmployee {

    String getRole() {
        return "Local Manager";
    }

    int getAllowable() {
        return 50000;
    }
}
