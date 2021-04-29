package seminar3.model;

import java.time.LocalTime;
import java.util.ArrayList;

import seminar3.DTO.*;

/**
 * One single sale made by one single customer and payed with one payment.
 */
public class Sale {
    private LocalTime saleTime;
    private ArrayList<Item> items;
    private double totalPrice;
    private double totalVAT;

    /**
     * Crates a new instance and saves the time of the sale
     */
    public Sale() {
        saleTime = LocalTime.now();
        items = new ArrayList<Item>();
    }

    private void updateRunningTotal() {
        double runningTotal = 0;
        double totalVAT = 0;
        for(Item item : items) {
            runningTotal += item.getPrice() * item.getQuantity();
            totalVAT += item.getVAT() * item.getQuantity();
        }
        this.totalPrice = runningTotal;
        this.totalVAT = totalVAT;
    }

    
    /** 
     * @param idenfier
     * @return SaleInfoDTO
     */
    public SaleInfoDTO addDuplicate(String idenfier) {
        for(Item item : items) {
            if(item.getIdentifier().equals(idenfier)) {
                item.increaseQuantity();
                return new SaleInfoDTO(item, this.totalPrice);
            }
        }
        return null;
    }

    
    /** 
     * @param itemDTO
     * @return SaleInfoDTO
     */
    public SaleInfoDTO addItem(ItemDTO itemDTO) {
        Item item = new Item(itemDTO);
        items.add(item);
        updateRunningTotal();

        return new SaleInfoDTO(item, this.totalPrice);
    }

    
    /** 
     * @param idenfier
     * @return boolean
     */
    public boolean isDuplicate(String idenfier) {
        for(Item item : items)
            if(item.getIdentifier().equals(idenfier))
                return true;
    
        return false;
    }

    
    /** 
     * @return SaleDTO
     */
    public SaleDTO convertToDTO() {
        return new SaleDTO(this.saleTime, this.items, this.totalPrice, this.totalVAT);
    }

    
    /** 
     * @param payment
     * @param sale
     * @return Receipt
     */
    public Receipt complete(PaymentDTO payment, SaleDTO sale) {
        return new Receipt(payment, sale);
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
}
