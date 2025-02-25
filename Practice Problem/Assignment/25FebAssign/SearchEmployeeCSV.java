import java.io.*;
import java.util.Scanner;

public class SearchEmployeeCSV {
    public static void main(String[] args) {
        String filePath = "employees.csv";
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter employee name to search: ");
        String searchName = sc.nextLine();

        boolean found = false;
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line = br.readLine(); // Read header (skip processing)
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                if (columns[1].equalsIgnoreCase(searchName)) {
                    System.out.println("Employee Found:");
                    System.out.println("Department: " + columns[2] + ", Salary: " + columns[3]);
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Employee not found!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
