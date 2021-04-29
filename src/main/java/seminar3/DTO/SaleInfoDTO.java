package seminar3.DTO;

import seminar3.model.Item;

/**
 * This is a DTO class used for transfering information about the lastest scanned item
 */
public class SaleInfoDTO {
    String currentItemDescription;
    double currentItemPrice;
    String currentItemName;
    double runningTotal;
    
    public SaleInfoDTO(Item item, double runningTotal) {
        currentItemDescription = item.getDescription();
        currentItemPrice = item.getPrice();
        currentItemName = item.getName();
        this.runningTotal = runningTotal;
    }

    
    /** 
     * @return String
     */
    public String getCurrentItemDescription() {
        return this.currentItemDescription;
    }

    
    /** 
     * @return double
     */
    public double getCurrentItemPrice() {
        return this.currentItemPrice;
    }

    
    /** 
     * @return String
     */
    public String getCurrentItemName() {
        return this.currentItemName;
    }
}
