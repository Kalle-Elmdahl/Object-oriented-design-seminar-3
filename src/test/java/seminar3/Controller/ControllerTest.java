package seminar3.Controller;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import seminar3.controller.Controller;
import seminar3.DTO.*;
import seminar3.integration.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ControllerTest {
    private Controller instance;
    private ByteArrayOutputStream printOutBuffer;
    private PrintStream originalSysOut;

    @Before
    public void setUp() {
        printOutBuffer = new ByteArrayOutputStream();
        PrintStream inMemSysOut = new PrintStream(printOutBuffer);
        originalSysOut = System.out;
        System.setOut(inMemSysOut);
        
        EASHandler eas = new EASHandler();
        EISHandler eis = new EISHandler();
        Printer printer = new Printer();

        instance = new Controller(eis, eas, printer);

    }

    @After
    public void tearDown() {
        printOutBuffer = null;
        System.setOut(originalSysOut);

        instance = null;
    }

    @Test
    public void testControllerHasStarted() {
        String printOut = this.printOutBuffer.toString();
        String expectedOutput = "success";
        assertTrue("Controller did not start correctly", printOut.contains(expectedOutput));
    }

    @Test
    public void addItem() {
        instance.startSale();
        SaleInfoDTO test = instance.enterItem("identifier1");
        double runningTotal = test.getRunningTotal();
        assertEquals("Add duplicate is not working", 59.4, runningTotal, .1);
    }

    @Test
    public void addMultipleOfSame() {
        instance.startSale();
        String identifier = "identifier1";
        instance.enterItem(identifier);
        SaleInfoDTO secondOfSame = instance.enterItem(identifier);
        int quantity = secondOfSame.getCurrentItemQuantity();
        assertEquals("Add Multiple of same item is not working", 2, quantity);
    }

    @Test
    public void checkIfChangeIsCalculatedCorrectly() {
        instance.startSale();
        instance.enterItem("identifier1");
        double change = instance.pay(90, "SEK");
        assertEquals("Calculation of change is not working", 90 - 59.4, change, .01);
    }
}