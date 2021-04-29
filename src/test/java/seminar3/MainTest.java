package seminar3;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

import seminar3.startup.Main;

public class MainTest {
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
      
}