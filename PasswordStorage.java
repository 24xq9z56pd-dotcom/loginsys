import java.io.BufferedWriter;
import java.io.*;
import java.util.HashMap;

    public class PasswordStorage {

        private static final String FILE_NAME = "users.txt";

        // Save users and hashed passwords to file
        public static void save(HashMap<String, String> users) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
                for (String user : users.keySet()) {
                    writer.write(user + ":" + users.get(user));
                    writer.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Load users and hashed passwords from file
        public static HashMap<String, String> load() {
            HashMap<String, String> users = new HashMap<>();
            try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(":");
                    if (parts.length == 2) {
                        users.put(parts[0], parts[1]);
                    }
                }
            } catch (FileNotFoundException e) {
                // File not found, will create later
            } catch (IOException e) {
                e.printStackTrace();
            }
            return users;
        }
    }
