import com.fasterxml.jackson.databind.*;
import java.io.*;
import java.util.*;

public class CSVToJSON {
    public static void main(String[] args) {
        String csvFile = "students.csv";
        String jsonFile = "students_output.json";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String header = br.readLine();
            String[] columns = header.split(",");

            List<Map<String, Object>> studentList = new ArrayList<>();
            String line;

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                Map<String, Object> student = new HashMap<>();
                for (int i = 0; i < columns.length; i++) {
                    student.put(columns[i], values[i]);
                }
                studentList.add(student);
            }

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(jsonFile), studentList);

            System.out.println("✅ CSV converted to JSON: " + jsonFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
