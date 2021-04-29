package seminar3;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import seminar3.controller.Controller;
import seminar3.integration.*;

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

    }

    @After
    public void tearDown() {
        printOutBuffer = null;
        System.setOut(originalSysOut);

        instance = null;
    }

    @Test
    public void testControllerHasStarted() {
        EASHandler eas = new EASHandler();
        EISHandler eis = new EISHandler();
        Printer printer = new Printer();

        instance = new Controller(eis, eas, printer);
        String printOut = this.printOutBuffer.toString();
        String expectedOutput = "success";
        assertTrue("Controller did not start correctly", printOut.contains(expectedOutput));
    }
}