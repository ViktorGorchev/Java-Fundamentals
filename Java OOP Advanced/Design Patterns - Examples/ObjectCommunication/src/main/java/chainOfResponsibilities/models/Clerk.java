package chainOfResponsibilities.models;


public class Clerk extends BankEmployee {

    @Override
    String getRole() {
        return "Clerk";
    }

    @Override
    int getAllowable() {
        return 10000;
    }
}
