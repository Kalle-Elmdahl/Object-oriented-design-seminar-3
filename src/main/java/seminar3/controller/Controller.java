package seminar3.controller;

import seminar3.model.Sale;
import seminar3.model.Register;
import seminar3.integration.*;

/**
 * This is the application's only controller. All calls through the model pass through this class.
 */
public class Controller {
    private Sale sale;
    private EISHandler eis;
    private EASHandler eas;
    private Printer printer;
    private Register register;

    /**
     * This function generates a new instance of the controller
     * @param eis an external inventory handler
     * @param eas an external account system
     * @param printer a printer for printing receipts
     */

    public Controller(EISHandler eis, EASHandler eas, Printer printer) {
        this.eis = eis;
        this.eas = eas;
        this.printer = printer;

        this.register = new Register();

        System.out.println("Controller was started successfully");
    }

    /**
     * Starts a new sale. This method must be called before doing anything else during a sale.
     */
     public void startSale() {
        sale = new Sale();
     }
    
}