import com.opencsv.CSVWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

public class DatabaseToCSVOpenCSV {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/my_database";
        String user = "your_username";
        String password = "your_password";
        String outputFile = "employees.csv";

        String query = "SELECT id, name, department, salary FROM employees";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query);
             CSVWriter writer = new CSVWriter(new FileWriter(outputFile))) {

            // Write header row
            writer.writeNext(new String[]{"Employee ID", "Name", "Department", "Salary"});

            // Fetch and write data rows
            while (rs.next()) {
                writer.writeNext(new String[]{
                        String.valueOf(rs.getInt("id")),
                        rs.getString("name"),
                        rs.getString("department"),
                        String.valueOf(rs.getInt("salary"))
                });
            }

            System.out.println("✅ CSV report generated successfully: " + outputFile);
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
