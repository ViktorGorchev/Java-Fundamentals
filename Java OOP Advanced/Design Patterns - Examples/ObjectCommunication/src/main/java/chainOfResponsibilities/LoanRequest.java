package chainOfResponsibilities;

public class LoanRequest {
    private int amount;
    private String purpose;

    public LoanRequest(int amount, String purpose) {
        this.setAmount(amount);
        this.setPurpose(purpose);
    }

    public int getAmount() {
        return this.amount;
    }

    private void setAmount(int amount) {
        this.amount = amount;
    }

    public String getPurpose() {
        return this.purpose;
    }

    private void setPurpose(String purpose) {
        this.purpose = purpose;
    }
}
