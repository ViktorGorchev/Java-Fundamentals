package chainOfResponsibilities;

import chainOfResponsibilities.models.BankEmployee;
import chainOfResponsibilities.models.Clerk;
import chainOfResponsibilities.models.LocalManager;

public class Main {

    public static void main(String[] args) {
        BankEmployee clerk = new Clerk();
        BankEmployee manager = new LocalManager();
        clerk.setSuccessor(manager);

        LoanRequest loanRequest = new LoanRequest(8000, "studies");
        clerk.processRequest(loanRequest);

        LoanRequest loanRequest2 = new LoanRequest(40000, "car");
        clerk.processRequest(loanRequest2);
    }
}
