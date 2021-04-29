package seminar3.model;

import java.time.LocalTime;
import java.util.ArrayList;

import seminar3.DTO.*;

/**
 * Represents one receipt, which proves the payment of one sale
 */
public class Receipt {
    LocalTime timeOfSale;
    private ArrayList<Item> items = new ArrayList<Item>();
    private double totalPrice;
    private double totalVAT;
    private double amountPaid;
    private String currency;
    private String storeInformation = "This is some information about the store";

    public Receipt(PaymentDTO payment, SaleDTO sale) {
        this.timeOfSale = sale.getTime();
        this.items = sale.getItems();
        this.totalPrice = sale.getTotalPrice();
        this.totalVAT = sale.getTotalVAT();

        this.amountPaid = payment.getAmount();
        this.currency = payment.getCurrency();
    }


    
    /** 
     * @return LocalTime
     */
    public LocalTime getTimeOfSale() {
        return this.timeOfSale;
    }

    
    /** 
     * @return ArrayList<Item>
     */
    public ArrayList<Item> getItems() {
        return this.items;
    }

    
    /** 
     * @return double
     */
    public double getTotalPrice() {
        return this.totalPrice;
    }

    
    /** 
     * @return double
     */
    public double getTotalVAT() {
        return this.totalVAT;
    }

    
    /** 
     * @return double
     */
    public double getAmountPaid() {
        return this.amountPaid;
    }

    
    /** 
     * @return String
     */
    public String getCurrency() {
        return this.currency;
    }

    
    /** 
     * @return String
     */
    public String getStoreInformation() {
        return this.storeInformation;
    }    
}
