import java.io.*;

public class LargeFileReader {
    public static void main(String[] args) {
        File file = new File("largeFile.txt");

        if (!file.exists()) {
            System.out.println("File does not exist.");
            return;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.toLowerCase().contains("error")) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
