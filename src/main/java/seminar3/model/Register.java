package seminar3.model;

/**
 * This is a virtual register. Used for keeping track of the money in the register
 */
public class Register {
    double amount;

    /**
     * This function generates a new instance of a register
     */
    public Register() {
        this.amount = 1000;
    }

    
    /** 
     * @return double: the amount of money in the register
     */
    public double getAmount() {
        return amount;
    }
}
