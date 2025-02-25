import java.io.*;
import java.util.*;

public class SortCSVBySalary {
    public static void main(String[] args) {
        String inputFile = "employees.csv";
        List<String[]> records = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String header = br.readLine(); // Read the header
            String line;

            while ((line = br.readLine()) != null) {
                records.add(line.split(","));
            }

            records.sort((a, b) -> Integer.compare(Integer.parseInt(b[3]), Integer.parseInt(a[3])));

            System.out.println(header);
            for (int i = 0; i < Math.min(5, records.size()); i++) {
                System.out.println(String.join(",", records.get(i)));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
