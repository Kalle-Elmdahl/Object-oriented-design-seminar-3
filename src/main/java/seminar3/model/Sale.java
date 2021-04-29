package seminar3.model;

import java.time.LocalTime;

/**
 * One single sale made by one single customer and payed with one payment.
 */
public class Sale {
    private LocalTime saleTime;

    /**
     * Crates a new instance and saves the time of the sale
     */
    public Sale() {
        saleTime = LocalTime.now();
    }    
}
