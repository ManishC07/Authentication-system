import java.util.LinkedList;
import java.util.Scanner;

class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password; // Fixed assignment here
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

public class Auth {
    private LinkedList<User> userList;

    public Auth() {
        userList = new LinkedList<>(); // Corrected 'LisnkedList' to 'LinkedList' and changed ':' to ';'
    }

    public void register(String username, String password) {
        User newUser = new User(username, password);
        userList.add(newUser); // Added user to the list
        System.out.println("User Registered Successfully");
    }

    public boolean login(String username, String password) {
        for (User user : userList) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Auth authSystem = new Auth();
        Scanner scanner = new Scanner(System.in);
        boolean loggedIn = false; // Corrected 'loggenIn' to 'loggedIn'

        while (!loggedIn) {
            System.out.println("Choose an option:");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.println("Enter a username: ");
                    String regUsername = scanner.nextLine();
                    System.out.println("Enter a password: "); // Fixed quote and spelling
                    String regPassword = scanner.nextLine();
                    authSystem.register(regUsername, regPassword);
                    break;
                case 2:
                    System.out.println("Enter your username: ");
                    String loginUsername = scanner.nextLine();
                    System.out.println("Enter your password: "); // Fixed quote and spelling
                    String loginPassword = scanner.nextLine();
                    if (authSystem.login(loginUsername, loginPassword)) {
                        System.out.println("Login Successful.");
                        loggedIn = true;
                    } else {
                        System.out.println("Login Failed.");
                    }
                    break;
                case 3:
                    System.out.println("Exiting.");
                    loggedIn = true;
                    break;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
        scanner.close();
    }
}
