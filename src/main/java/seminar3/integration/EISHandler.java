package seminar3.integration;

import seminar3.DTO.*;

/**
 * EISHandler, external inventory system handler. This class fetches data and writes to the inventory database
 */
public class EISHandler {
    
    /** 
     * This function gets the correct item from the external inventory system based on an idenfier
     * @param identifier the item's identifier
     * @return ItemDTO the found item
     */
    public ItemDTO findItem(String identifier) {
        return new ItemDTO("Ingredienser\nKycklingbröstfilé (100%)\n\nFörvaring\nFörvaras vid högst 4°C\n\nÖvrigt\nEAN kod: 2307111100000", 12, 59.4, "Kycklingfilé Tunnskivad", "2307111100000");
    }

    
    /** 
     * The function updates the inventory based on the items sold in a sale
     * @param sale the completed sale in a data transfer object
     */
    public void updateInventory(SaleDTO sale) {
        System.out.println("updating inventory");
    }
}
