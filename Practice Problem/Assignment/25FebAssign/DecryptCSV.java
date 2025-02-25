import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.util.Base64;

public class DecryptCSV {
    private static final String ALGORITHM = "AES";
    private static SecretKey secretKey;

    static {
        try {
            byte[] keyBytes = EncryptCSV.secretKey.getEncoded();
            secretKey = new SecretKeySpec(keyBytes, ALGORITHM);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String decrypt(String encryptedValue) {
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedValue));
            return new String(decryptedBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        String filePath = "encrypted_employees.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine(); // Read header
            System.out.println(line);

            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                String decryptedEmail = decrypt(columns[2]);
                String decryptedSalary = decrypt(columns[3]);

                System.out.println(columns[0] + "," + columns[1] + "," + decryptedEmail + "," + decryptedSalary);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
