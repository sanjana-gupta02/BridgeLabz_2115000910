import java.io.*;

public class FileReadComparison {
    public static void main(String[] args) throws IOException {
        String filePath = "demo.txt";

        long start = System.nanoTime();
        try (FileReader fr = new FileReader(filePath)) {
            while (fr.read() != -1);
        }
        long fileReaderTime = System.nanoTime() - start;
        System.out.println("FileReader Time: " + fileReaderTime / 1e6 + " ms");

        start = System.nanoTime();
        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath))) {
            while (isr.read() != -1);
        }
        long inputStreamReaderTime = System.nanoTime() - start;
        System.out.println("InputStreamReader Time: " + inputStreamReaderTime / 1e6 + " ms");
    }
}
