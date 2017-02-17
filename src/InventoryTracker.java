import java.util.HashMap;
import java.util.Scanner;


public class InventoryTracker {

    static HashMap<String, User> userDatabase = new HashMap();
    static Scanner scanner = new Scanner(System.in);


    static boolean verifyUser(User user){
        return (userDatabase.get(user.name).equals(user));
    }

    static void addItem(Item item){
        Inventory.inventory.add(item);
    }

    static void removeItem(int key){
        Inventory.inventory.remove(key);
    }

    static void changeQuantity(int key, int quantity){
        Item item = Inventory.inventory.get(key);
        item.quantity = quantity;
    }

    static void changeName(int key, String name){
        Item item = Inventory.inventory.get(key);
        item.name = name;
    }



    public static void main(String[] args) {


    }
}
