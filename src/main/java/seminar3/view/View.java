package seminar3.view;

import seminar3.controller.Controller;

/**
 * This is a pleaceholder for the real view. It contains a hardcoded execution with calls to all 
 * system operations in the controller
 */
public class View {
    private Controller contr;

    /**
     * Creates a new instance, that uses the specifier controller for all calls to other layers
     * 
     * @param contr The controller to use for all calls to other layers.
     */
    public View(Controller contr) {
        this.contr = contr;
    }

    /**
     * Performs a fake sale, by calling all system operations in the controller.
     */
    public void runFakeExecution() {
        contr.startSale();
        System.out.println("A new sale has been started.");
        contr.enterItem("identifier1");
        System.out.println("Added an item with identifier: identifier1");
        contr.pay(500, "SEK");
        System.out.println("A payment of 500 SEK was made");
    }
}
