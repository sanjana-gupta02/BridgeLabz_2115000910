import java.io.*;
import java.util.*;

public class DetectDuplicateCSV {
    public static void main(String[] args) {
        String filePath = "students.csv";
        Set<String> uniqueIds = new HashSet<>();
        List<String> duplicateRecords = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String header = br.readLine();
            String line;

            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                String id = columns[0].trim();

                if (!uniqueIds.add(id)) {
                    duplicateRecords.add(line);
                }
            }

            if (duplicateRecords.isEmpty()) {
                System.out.println("✅ No duplicate records found.");
            } else {
                System.out.println("❌ Duplicate Records Found:");
                duplicateRecords.forEach(System.out::println);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
