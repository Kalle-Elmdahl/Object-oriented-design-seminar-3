package seminar3.DTO;

public class ItemDTO {
    String description;
    double VAT;
    double price;
    String name;
    String identifier;


    public ItemDTO(String description, double VAT, double price, String name, String identifier) {
        this.description = description;
        this.VAT = VAT;
        this.price = price;
        this.name = name;
        this.identifier = identifier;
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
    public double getVAT() {
        return this.VAT;
    }

    
    /** 
     * @return double
     */
    public double getPrice() {
        return this.price;
    }

    
    /** 
     * @return String
     */
    public String getName() {
        return this.name;
    }

    
    /** 
     * @return String
     */
    public String getIdentifier() {
        return this.identifier;
    }
}
