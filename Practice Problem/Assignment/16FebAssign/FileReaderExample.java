import java.io.*;

public class FileReaderExample {
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("Demo.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
