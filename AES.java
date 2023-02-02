/*
01/26/2023
AES (Advanced Encryption Standard) Encryption And Decryption In Java using the Java Cryptography Architecture (JCA) library.
Author: Elijah Williams
Resources:
https://www.section.io/engineering-education/implementing-aes-encryption-and-decryption-in-java/
https://csrc.nist.gov/csrc/media/publications/fips/197/final/documents/fips-197.pdf
https://www.devglan.com/online-tools/aes-encryption-decryption
https://www.youtube.com/watch?v=I68uBhHdnM4
*/

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Scanner;

public class AES {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter plaintext: ");
        // Read plaintext from user input, Ex: Hello World
        String plainText = sc.nextLine();

        System.out.println("Enter key: ");
        // Read key from user input, Ex: 1234567812345670
        String key = sc.nextLine();

        // Encrypt plaintext using AES algorithm
        String encodedEncryptedData = Base64.getEncoder().encodeToString(encryptAES(plainText, key));
        System.out.println("Encrypted Text: " + encodedEncryptedData);

        // Decrypt the encoded encrypted text using the same key
        String decryptedText = decryptAES(encodedEncryptedData, key);
        System.out.println("Decrypted Text: " + decryptedText);
    }

    public static byte[] encryptAES(String plainText, String key) throws Exception {
        // Create a SecretKeySpec object using the key
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "AES");
        // Create a Cipher object using AES algorithm and ECB mode
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        // Initialize the Cipher object for encryption
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        // Encrypt the plaintext
        return cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));
    }

    public static String decryptAES(String encodedEncryptedText, String key) throws Exception {
        // Decode the encoded encrypted text
        byte[] encryptedData = Base64.getDecoder().decode(encodedEncryptedText);

        // Create a SecretKeySpec object using the key
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "AES");
        // Create a Cipher object using AES algorithm and ECB mode
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        // Initialize the Cipher object for decryption
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        // Decrypt the encrypted data
        byte[] decryptedData = cipher.doFinal(encryptedData);
        // Return the decrypted data as a string
        return new String(decryptedData, StandardCharsets.UTF_8);
    }
}
