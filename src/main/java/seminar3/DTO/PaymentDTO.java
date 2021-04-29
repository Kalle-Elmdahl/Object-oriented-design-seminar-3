package seminar3.DTO;

public class PaymentDTO {
    double amount;
    String currency;

    public PaymentDTO(double amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    
    /** 
     * @return double
     */
    public double getAmount() {
        return this.amount;
    }

    
    /** 
     * @return String
     */
    public String getCurrency() {
        return this.currency;
    }
}
