package seminar3.Model;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import seminar3.model.Sale;
import seminar3.model.Item;
import seminar3.DTO.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SaleTest {
    private Sale instance;

    @Before
    public void setUp() {
        instance = new Sale();
    }

    @After
    public void tearDown() {
        instance = null;
    }

    @Test
    public void testAddItem() {
        String testIdentifier = "Identifier";
        instance.addItem(new ItemDTO("Test item desciption", 1, 10, "Test", testIdentifier));
        ArrayList<Item> items = instance.getItems();
        assertEquals("Item was not added successfully", testIdentifier, items.get(0).getIdentifier());
    }

    @Test
    public void testAddDuplicateItem() {
        String testIdentifier = "Identifier";
        instance.addItem(new ItemDTO("Test item desciption", 1, 10, "Test", testIdentifier));
        instance.addDuplicate(testIdentifier);
        ArrayList<Item> items = instance.getItems();
        assertEquals("Add duplicate is not working", 2, items.get(0).getQuantity());
    }

    @Test
    public void testIsDuplicateTrue() {
        String testIdentifier = "Identifier";
        instance.addItem(new ItemDTO("Test item desciption", 1, 10, "Test", testIdentifier));
        boolean isDuplicate = instance.isDuplicate(testIdentifier);
        assertTrue("is duplicate is not working", isDuplicate);
    }

    @Test
    public void testIsDuplicateFalse() {
        String testIdentifier = "Identifier";
        instance.addItem(new ItemDTO("Test item desciption", 1, 10, "Test", testIdentifier));
        boolean isDuplicate = instance.isDuplicate("Not the same");
        assertTrue("is duplicate is not working", !isDuplicate);
    }

    @Test
    public void testCalculationOfTotalPrice() {
        instance.addItem(new ItemDTO("Test item desciption", 1, 10, "Test", "Identifier1"));
        instance.addItem(new ItemDTO("Test item desciption", 1, 25, "Test", "Identifier2"));
        instance.addDuplicate("Identifier2");
        double totalPrice = instance.getTotalPrice();
        assertEquals("total price was not calculated correcly", 10 + 25 * 2, totalPrice, .01);
    }
}