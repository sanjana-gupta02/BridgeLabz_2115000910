import java.io.*;
import java.util.regex.*;

public class ValidateCSVData {
    public static void main(String[] args) {
        String filePath = "employees.csv";
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        String phoneRegex = "^\\d{10}$";

        Pattern emailPattern = Pattern.compile(emailRegex);
        Pattern phonePattern = Pattern.compile(phoneRegex);

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine();
            System.out.println("Checking CSV Data Validity...\n");
            boolean hasErrors = false;

            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                String email = columns[2].trim();
                String phone = columns[3].trim();

                Matcher emailMatcher = emailPattern.matcher(email);
                Matcher phoneMatcher = phonePattern.matcher(phone);

                if (!emailMatcher.matches() || !phoneMatcher.matches()) {
                    hasErrors = true;
                    System.out.println("Invalid Record: " + line);
                    if (!emailMatcher.matches()) {
                        System.out.println("❌ Invalid Email: " + email);
                    }
                    if (!phoneMatcher.matches()) {
                        System.out.println("❌ Invalid Phone Number: " + phone);
                    }
                    System.out.println();
                }
            }

            if (!hasErrors) {
                System.out.println("✅ All records are valid!");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
