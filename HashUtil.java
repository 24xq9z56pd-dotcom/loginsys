import java.security.MessageDigest;

    public class HashUtil {

        // Hash a password using SHA-256
        public static String hash(String input) {
            try {
                MessageDigest md = MessageDigest.getInstance("SHA-256");
                byte[] hash = md.digest(input.getBytes());
                StringBuilder hex = new StringBuilder();
                for (byte b : hash) {
                    hex.append(String.format("%02x", b));
                }
                return hex.toString();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }
