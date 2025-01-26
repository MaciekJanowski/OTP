import java.io.*;
import java.nio.file.*;
import java.util.Scanner;

public class OTPEncryption {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read key file
        String key = loadKey("C:\\Users\\Maciek Vistula\\IdeaProjects\\OTP\\src\\key.txt");
        if (key == null) {
            System.out.println("Nie można wczytać klucza z pliku. Sprawdź plik key.txt.");
            return;
        }

        // Enter the message to encrypt
        System.out.println("Wpisz wiadomość do zaszyfrowania:");
        String message = scanner.nextLine();

        // encrypt
        String encryptedMessage = encrypt(message, key);
        System.out.println("Zaszyfrowana wiadomość:");
        System.out.println(encryptedMessage);

        // Decryption question
        System.out.println("Czy chcesz rozszyfrować wiadomość? (TAK/NIE):");
        String response = scanner.nextLine();

        if (response.equalsIgnoreCase("TAK")) {
            // Decryption
            String decryptedMessage = decrypt(encryptedMessage, key);
            System.out.println("Odszyfrowana wiadomość:");
            System.out.println(decryptedMessage);
        } else {
            System.out.println("Program zakończony.");
        }
    }

    // Function that reads key from file
    private static String loadKey(String filePath) {
        try {
            return new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Encryption function (XOR operation)
    private static String encrypt(String message, String key) {
        StringBuilder encrypted = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char messageChar = message.charAt(i);
            char keyChar = key.charAt(i % key.length()); // Repeat key if it is shorter than the message
            encrypted.append((char) (messageChar ^ keyChar));
        }
        return encrypted.toString();
    }

    // Decryption function (XOR operation)
    private static String decrypt(String encryptedMessage, String key) {
        // The decryption process is identical to the encryption in the case of XOR
        return encrypt(encryptedMessage, key);
    }
}
