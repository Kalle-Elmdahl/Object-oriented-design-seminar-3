package seminar3.controller;

import seminar3.model.Sale;
import seminar3.model.Receipt;
import seminar3.model.Register;

import seminar3.DTO.*;
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
    
    /** 
     * @param identifier
     * @return SaleInfoDTO
     */
    public SaleInfoDTO enterItem(String identifier) {
        if(sale.isDuplicate(identifier))
            return sale.addDuplicate(identifier);

        ItemDTO item = eis.findItem(identifier);
        return sale.addItem(item);
    }

    
    /** 
     * @param amount
     * @param currency
     * @return double
     */
    public double pay(double amount, String currency) {
        PaymentDTO payment = new PaymentDTO(amount, currency);
        SaleDTO sale = this.sale.convertToDTO();
        Receipt receipt = this.sale.complete(payment, sale);

        register.updateAmount(amount);

        eas.registerPayment(payment, sale);
        eis.updateInventory(sale);
        printer.printReceipt(receipt);
        return payment.getAmount() - sale.getTotalPrice();
    }
    
}