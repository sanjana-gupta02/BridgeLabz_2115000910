import com.fasterxml.jackson.databind.*;
import java.io.*;
import java.util.*;

public class JSONToCSV {
    public static void main(String[] args) {
        String jsonFile = "students.json";
        String csvFile = "students.csv";

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            List<Map<String, Object>> students = objectMapper.readValue(new File(jsonFile), List.class);

            BufferedWriter writer = new BufferedWriter(new FileWriter(csvFile));
            writer.write("ID,Name,Age,Marks\n");

            for (Map<String, Object> student : students) {
                writer.write(student.get("ID") + "," + student.get("Name") + "," +
                        student.get("Age") + "," + student.get("Marks") + "\n");
            }

            writer.close();
            System.out.println("✅ JSON converted to CSV: " + csvFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
