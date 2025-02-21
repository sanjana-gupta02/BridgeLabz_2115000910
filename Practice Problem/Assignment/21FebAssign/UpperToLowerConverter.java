import java.io.*;

public class UpperToLowerConverter {
    public static void main(String[] args) {
        File inputFile = new File("input.txt");
        File outputFile = new File("output.txt");

        if (!inputFile.exists()) {
            System.out.println("Input file does not exist.");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {

            int charData;
            while ((charData = br.read()) != -1) {
                bw.write(Character.toLowerCase((char) charData));
            }

            System.out.println("File converted successfully.");
        } catch (IOException e) {
            System.out.println("Error processing file: " + e.getMessage());
        }
    }
}
