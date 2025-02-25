import java.io.*;

public class UpdateITSalaryCSV {
    public static void main(String[] args) {
        String inputFile = "employees.csv";
        String outputFile = "updated_employees.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {

            String line = br.readLine();
            bw.write(line + "\n");

            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");
                if (columns[2].equalsIgnoreCase("IT")) {
                    double salary = Double.parseDouble(columns[3]) * 1.1;
                    columns[3] = String.valueOf((int) salary);
                }
                bw.write(String.join(",", columns) + "\n");
            }

            System.out.println("Updated salaries saved to " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
