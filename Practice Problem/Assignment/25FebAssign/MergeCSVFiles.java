import java.io.*;
import java.util.*;

public class MergeCSVFiles {
    public static void main(String[] args) {
        String file1 = "students1.csv";
        String file2 = "students2.csv";
        String outputFile = "merged_students.csv";

        Map<String, String[]> studentMap = new HashMap<>();

        try (BufferedReader br1 = new BufferedReader(new FileReader(file1))) {
            String line = br1.readLine();
            while ((line = br1.readLine()) != null) {
                String[] columns = line.split(",");
                studentMap.put(columns[0], new String[]{columns[1], columns[2]});
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br2 = new BufferedReader(new FileReader(file2));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {

            String line = br2.readLine();
            bw.write("ID,Name,Age,Marks,Grade\n");

            while ((line = br2.readLine()) != null) {
                String[] columns = line.split(",");
                String id = columns[0];

                if (studentMap.containsKey(id)) {
                    String[] studentInfo = studentMap.get(id);
                    bw.write(id + "," + studentInfo[0] + "," + studentInfo[1] + "," + columns[1] + "," + columns[2] + "\n");
                }
            }
            System.out.println("Merged CSV file created successfully: " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
