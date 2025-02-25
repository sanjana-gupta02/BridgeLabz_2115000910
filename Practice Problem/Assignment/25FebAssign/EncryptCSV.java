import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.util.Base64;

public class EncryptCSV {
    private static final String ALGORITHM = "AES";
    private static SecretKey secretKey;

    static {
        try {
            KeyGenerator keyGen = KeyGenerator.getInstance(ALGORITHM);
            keyGen.init(128);
            secretKey = keyGen.generateKey();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String encrypt(String value) {
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encryptedBytes = cipher.doFinal(value.getBytes());
            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        String filePath = "encrypted_employees.csv";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("ID,Name,Email,Salary\n");
            writer.write("101,John Doe," + encrypt("john.doe@example.com") + "," + encrypt("60000") + "\n");
            writer.write("102,Jane Smith," + encrypt("jane.smith@example.com") + "," + encrypt("50000") + "\n");
            writer.write("103,Michael Brown," + encrypt("michael.brown@example.com") + "," + encrypt("55000") + "\n");

            System.out.println("✅ Encrypted CSV file created: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
