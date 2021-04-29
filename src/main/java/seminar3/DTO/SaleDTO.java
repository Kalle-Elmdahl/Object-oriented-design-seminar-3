package seminar3.DTO;

import java.time.LocalTime;
import java.util.ArrayList;

import seminar3.model.Item;

/**
 * SaleDTO
 */
public class SaleDTO {
    LocalTime time;
    private ArrayList<Item> items;
    double totalPrice;
    double totalVAT;


    public SaleDTO(LocalTime time, ArrayList<Item> items, double totalPrice, double totalVAT) {
        this.time = time;
        this.items = items;
        this.totalPrice = totalPrice;
        this.totalVAT = totalVAT;
    }

    
    /** 
     * @return LocalTime
     */
    public LocalTime getTime() {
        return this.time;
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