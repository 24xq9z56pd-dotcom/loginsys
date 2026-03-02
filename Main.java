import java.util.HashMap;
import java.util.Scanner;

public class Main {

    private static HashMap<String, String> users;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        users = PasswordStorage.load();

        System.out.println("=== Welcome to Simple Login System ===");

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Register new user");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    register(scanner);
                    break;
                case "2":
                    login(scanner);
                    break;
                case "3":
                    System.out.println("Exiting... Goodbye!");
                    PasswordStorage.save(users); // save all users to file
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice, try again!");
            }
        }
    }

    private static void register(Scanner scanner) {
        System.out.print("Enter new username: ");
        String username = scanner.nextLine();

        if (users.containsKey(username)) {
            System.out.println("Username already exists!");
            return;
        }

        System.out.print("Enter new password: ");
        String password = scanner.nextLine();

        // Hash the password
        String hashed = HashUtil.hash(password);
        users.put(username, hashed);
        PasswordStorage.save(users);
        System.out.println("User registered successfully!");
    }

    private static void login(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        if (!users.containsKey(username)) {
            System.out.println("Username not found!");
            return;
        }

        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        String hashedInput = HashUtil.hash(password);

        if (users.get(username).equals(hashedInput)) {
            System.out.println("Login successful! Welcome " + username);
        } else {
            System.out.println("Wrong password!");
        }
    }
}