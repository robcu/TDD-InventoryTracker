import java.util.Scanner;


public class InventoryTracker {

    public static void main(String[] args) {

        User user = new User();

        while (!user.loggedIn) {
            user.logIn();
        }
        runMenu();
    }

    static Scanner scanner = new Scanner(System.in);

    static void runMenu() {

        while(true) {
            switch(getMenuOption()) {
                case 1:
                    addItem(promptName(), promptQuantity());
                    break;
                case 2:
                    printInventory();
                    removeItem(promptKey());
                    break;
                case 3:
                    printInventory();
                    changeQuantity(promptKey(), promptQuantity());
                    break;
                case 4:
                    printInventory();
                    changeName(promptKey(), promptName());
                    break;
                case 5:
                    printInventory();
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static Integer getMenuOption() {
        System.out.println("Inventory Options:");
        System.out.println("[1] - Add a new item");
        System.out.println("[2] - Remove an item");
        System.out.println("[3] - Change an item's quantity");
        System.out.println("[4] - Change an item's name");
        System.out.println("[5] - Print inventory");

        return Integer.parseInt(scanner.nextLine());
    }

    static String promptName(){
        System.out.println("Enter the name of the item:");
        return scanner.nextLine();
    }

    static Integer promptKey(){
        System.out.println("Enter the number of the item: ");
        return Integer.parseInt(scanner.nextLine());
    }

    static Integer promptQuantity(){
        System.out.println("Enter the quantity: ");
        return Integer.parseInt(scanner.nextLine());
    }

    static void addItem(String itemName, Integer quantity){
        Inventory.inventory.add(new Item(itemName, quantity));
    }

    static void removeItem(Integer key){
        Inventory.inventory.remove(key);
    }

    static void changeQuantity(Integer key, Integer quantity){
        Item tobeModified = new Item(Inventory.inventory.get(key).name, quantity);
        Inventory.inventory.set(key, tobeModified);
    }

    static void changeName(Integer key, String name){
        Item tobeModified = new Item(name, Inventory.inventory.get(key).quantity);
        Inventory.inventory.set(key, tobeModified);
    }

    static void printInventory(){
        System.out.println("Inventory contents:");
        for(int i = 0; i < Inventory.inventory.size(); i++){
            System.out.println("[" + (i) + "] - " + Inventory.inventory.get(i).name + ", "
                    + Inventory.inventory.get(i).quantity);
        }
        System.out.println("\n");
    }
}
