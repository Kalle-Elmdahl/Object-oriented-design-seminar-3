package seminar3.model;

import seminar3.DTO.ItemDTO;

public class Item {
    String name;
    double VAT;
    String description;
    double price;
    int quantity;
    String identifier;

    public Item(ItemDTO item) {
        this.description = item.getDescription();
        this.VAT = item.getVAT();
        this.price = item.getPrice();
        this.name = item.getName();
        this.identifier = item.getIdentifier();
        quantity = 1;
    }

    
    /** 
     * @return String
     */
    public String getName() {
        return this.name;
    }

    
    /** 
     * @return double
     */
    public double getVAT() {
        return this.VAT;
    }

    
    /** 
     * @return String
     */
    public String getDescription() {
        return this.description;
    }

    
    /** 
     * @return double
     */
    public double getPrice() {
        return this.price;
    }

    
    /** 
     * @return int
     */
    public int getQuantity() {
        return this.quantity;
    }

    public void increaseQuantity() {
        quantity += 1;
    }

    
    /** 
     * @return String
     */
    public String getIdentifier() {
        return this.identifier;
    }
}
