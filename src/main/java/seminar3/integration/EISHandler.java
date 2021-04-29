package seminar3.integration;

import seminar3.DTO.*;

/**
 * EISHandler, external inventory system handler. This class fetches data and writes to the inventory database
 */
public class EISHandler {
    
    /** 
     * @param identifier
     * @return ItemDTO
     */
    public ItemDTO findItem(String identifier) {
        return new ItemDTO("Ingredienser\nKycklingbröstfilé (100%)\n\nFörvaring\nFörvaras vid högst 4°C\n\nÖvrigt\nEAN kod: 2307111100000", 12, 59.4, "Kycklingfilé Tunnskivad", "2307111100000");
    }

    
    /** 
     * @param sale
     */
    public void updateInventory(SaleDTO sale) {
        System.out.println("updating inventory");
    }
}
