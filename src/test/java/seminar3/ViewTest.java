package seminar3;



import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

import seminar3.controller.Controller;
import seminar3.view.View;

public class ViewTest {
    private View instanceToTest;
    private ByteArrayOutputStream printOutBuffer;
    private PrintStream originalSysOut;

    @Before
    public void setUp() {
        Controller contr = new Controller();
        instanceToTest = new View(contr);

        printOutBuffer = new ByteArrayOutputStream();
        PrintStream inMemSysOut = new PrintStream(printOutBuffer);
        originalSysOut = System.out;
        System.setOut(inMemSysOut);
    }

    @After
    public void tearDown() {
        instanceToTest = null;

        printOutBuffer = null;
        System.setOut(originalSysOut);
    }
    
    @Test
    public void viewTest() {
        instanceToTest.runFakeExecution();
        String printOut = this.printOutBuffer.toString();
        String expectedOutput = "started";
        assertTrue("UI did not start correctly", printOut.contains(expectedOutput));
    }
}