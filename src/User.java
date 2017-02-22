import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class User {
    String name;
    String password;
    boolean loggedIn;
    static Scanner userScanner = new Scanner(System.in);
    static HashMap userDatabase = new HashMap<>();

    public User() {
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    void logIn(){
        loggedIn = false;
        userDatabase.put("Rob", "asdf");
        userDatabase.put("James", "1234");

        System.out.println("Welcome to Inventory Pro");
        System.out.println("Enter username: ");
        String username = userScanner.nextLine();
        System.out.println("Enter password: ");
        String password = userScanner.nextLine();
        if(userDatabase.containsKey(username) && userDatabase.get(username).equals(password)){
            loggedIn = true;
        }
        else{
            System.out.println("Username and password combination does not match any accounts " +
                    "on file. Please try again.");
        }
    }
}
