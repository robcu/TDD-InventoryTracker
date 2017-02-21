import org.junit.Test;
import static org.junit.Assert.assertTrue;


public class InventoryTrackerTest {


    @Test
    public void verifyUser_canLogIn() {
        User existingUser = new User("rob", "asdf");
        InventoryTracker.userDatabase.put(existingUser.name, existingUser);

        assertTrue(InventoryTracker.verifyUser(existingUser));
    }

    @Test
    public void addItem_isNowInInventory(){
        Item item = new Item("itemName", 2);
        InventoryTracker.addItem(item);

        assertTrue(Inventory.inventory.contains(item));
    }

    @Test
    public void removeItem_isNoLongerInInventory(){
        Item item = new Item("testItem", 2);
        InventoryTracker.addItem(item);

        InventoryTracker.removeItem(Inventory.inventory.indexOf(item));

        assertTrue( ! Inventory.inventory.contains(item));
    }

    @Test
    public void changeQuantity_isQuantityChanged(){
        Item item = new Item("testItem", 2);
        InventoryTracker.addItem(item);

        InventoryTracker.changeQuantity(Inventory.inventory.indexOf(item), 3);

        assertTrue( Inventory.inventory.get(Inventory.inventory.indexOf(item)).quantity == 3 );
    }

    @Test
    public void changeName_isNameChanged(){
        Item item = new Item("testItem", 2);
        InventoryTracker.addItem(item);

        InventoryTracker.changeName(Inventory.inventory.indexOf(item), "testName");

        assertTrue(Inventory.inventory.get(Inventory.inventory.indexOf(item)).name.contentEquals("testName"));
    }
}
