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
     * This function increases the quantity of a matching identifier
     * @param idenfier the identifier to be matched
     * @return SaleInfoDTO Information about the sale to be sent back to the view.
     */
    public SaleInfoDTO addDuplicate(String idenfier) {
        for(Item item : items) {
            if(item.getIdentifier().equals(idenfier)) {
                item.increaseQuantity();
                updateRunningTotal();
                return new SaleInfoDTO(item, this.totalPrice);
            }
        }
        return null;
    }

    
    /** 
     * This function adds a new item to the sale's item list
     * @param itemDTO the item to be added
     * @return SaleInfoDTO information to be shown in th view.
     */
    public SaleInfoDTO addItem(ItemDTO itemDTO) {
        Item item = new Item(itemDTO);
        items.add(item);
        updateRunningTotal();

        System.out.println(items.get(0).getIdentifier());

        return new SaleInfoDTO(item, this.totalPrice);
    }

    
    /** 
     * This function checks if an item with the same identifier already exists in the scanned items list
     * @param idenfier the itentifier to be matched
     * @return boolean true if match was found
     */
    public boolean isDuplicate(String idenfier) {
        for(Item item : items)
            if(item.getIdentifier().equals(idenfier))
                return true;
    
        return false;
    }

    
    /** 
     * This function converts the sale to a SaleDTO to be sent to external systems
     * @return SaleDTO the DTO version of the sale
     */
    public SaleDTO convertToDTO() {
        return new SaleDTO(this.saleTime, this.items, this.totalPrice, this.totalVAT);
    }

    
    /** 
     * This function completes the sale
     * @param payment the payment made by the customer
     * @param sale the sale 
     * @return Receipt the generated receipt
     */
    public Receipt complete(PaymentDTO payment, SaleDTO sale) {
        return new Receipt(payment, sale);
    }

    
    /** 
     * Gets the items scanned in the sale
     * @return ArrayList<Item> the items
     */
    public ArrayList<Item> getItems() {
        ArrayList<Item> items = new ArrayList<Item>();
        for(Item item : this.items)
            items.add(new Item(item));
        return items;
    }

    
    /** 
     * Gets the total price of the sale
     * @return double total price
     */
    public double getTotalPrice() {
        return this.totalPrice;
    }

    
    /** 
     * Gets the total VAT of the sale
     * @return double the total VAT
     */
    public double getTotalVAT() {
        return this.totalVAT;
    }
}
