package seminar3.startup;

import seminar3.controller.Controller;
import seminar3.view.View;

/**
 * Starts the entire application. Contains the main method used to start the application.
 */
public class Main {
    /**
     * The main method used to start the application.
     * @param args The applicaiton does not take any command line parameters.
     */
    public static void main(String[] args) {
        Controller contr = new Controller();
        View view = new View(contr);
        
        view.runFakeExecution();
    }
    
}