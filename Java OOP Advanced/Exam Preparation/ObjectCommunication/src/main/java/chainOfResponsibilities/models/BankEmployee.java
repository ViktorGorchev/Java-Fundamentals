package chainOfResponsibilities.models;

import chainOfResponsibilities.LoanRequest;

public abstract class BankEmployee implements Employee {
    private Employee successor;

    abstract String getRole();
    abstract int getAllowable();

    public void setSuccessor(Employee successor) {
        this.successor = successor;
    }

    public void processRequest(LoanRequest loanRequest) {
        if(loanRequest.getAmount() <= this.getAllowable()){
            System.out.println(this.getRole() + " approved the request!");

        }else if (this.successor != null){
            this.successor.processRequest(loanRequest);
        }
    }
}
