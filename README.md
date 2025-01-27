# OTP Encryption

## Built With

This project was developed using:
* Language: Java 17
* Tools: IntelliJ IDEA (or any Java-compatible IDE)

## Case Study

### Scenario

A program simulating the use of the One-Time Pad (OTP) encryption method. It:
* Encrypts a user-provided message using a key loaded from an external file.
* Allows the user to decrypt the encrypted message by verifying the same key.
* Demonstrates the use of file reading, XOR-based encryption, and simple console interaction.

### Purpose

* To implement a simple example of OTP encryption in Java.
* To illustrate the use of file operations in Java (reading keys from a file).
* To demonstrate XOR encryption and decryption.
* To familiarize students with building, running, and debugging Java projects in IntelliJ IDEA.

---

## Launch Project

### Requirements

* Language: Java 17 or later.
* IDE: IntelliJ IDEA or any Java-compatible environment.
* File `key.txt`: Contains the encryption key (must be present at the specified path in the code).

### Steps

1. Clone the project or copy the provided files into your local environment.
2. Place the `key.txt` file in the specified directory (`src/key.txt` or as indicated in the code).
3. Open the project in IntelliJ IDEA or your preferred Java IDE.
4. Run the `OTPEncryption` class.
5. Follow the prompts in the console:
    * Enter a message to encrypt.
    * View the encrypted message.
    * Choose to decrypt the message by typing `TAK`.

---

## Usage

This program demonstrates the implementation of a simple OTP encryption system using Java. Below are the key components of the project:

### 1. Main Class (java class OTPEncrytpion )

**File Path:** `src/OTPEncryption.java`

This class performs the following operations:
* Reads a key from an external file (`key.txt`).
* Encrypts a user-provided message using the XOR operation.
* Displays the encrypted message.
* Allows the user to decrypt the message by providing confirmation.

#### Example Main (java class OTPEncrytpion )Code

```java
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
```
Sample content of the key file "key.txt"
```text
s;/_,kTezL>{h8(b/GvsQSn(Afz;~d!eaH)NO},lB:8^t28{q|H!CBVzDl4;9IO+3<j~}p8NQ7Ws\'&5tDO1][tyXQ+-)e;IR%iw
```