package chainOfResponsibilities.models;

import chainOfResponsibilities.LoanRequest;

public interface Employee {
    void setSuccessor(Employee successor);
    void processRequest(LoanRequest loanRequest);
}
