package seminar3.integration;

import seminar3.model.Receipt;

/**
 * Printer. This class sends data to an external printer
 */
public class Printer {

    
    /** 
     * @param receipt
     */
    public void printReceipt(Receipt receipt) {
        System.out.println("Printing receipt");
    }
}