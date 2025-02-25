import java.io.*;

public class CountCSVRows {
    public static void main(String[] args) {
        String filePath = "employees.csv"; // Change file name if needed
        int rowCount = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            br.readLine(); // Skip header row
            while (br.readLine() != null) {
                rowCount++;
            }
            System.out.println("Total number of records: " + rowCount);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
