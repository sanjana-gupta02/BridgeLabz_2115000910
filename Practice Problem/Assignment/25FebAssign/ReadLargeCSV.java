import java.io.*;

public class ReadLargeCSV {
    public static void main(String[] args) {
        String filePath = "employees.csv";
        int batchSize = 100;
        int totalRecords = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine();
            int batchCount = 0;

            while ((line = br.readLine()) != null) {
                batchCount++;
                totalRecords++;


                if (batchCount == batchSize) {
                    System.out.println("Processed " + totalRecords + " records...");
                    batchCount = 0; // Reset batch count
                }
            }

            System.out.println("Finished processing " + totalRecords + " records.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
