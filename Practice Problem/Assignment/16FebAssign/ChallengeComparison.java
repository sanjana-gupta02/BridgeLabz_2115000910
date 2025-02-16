import java.io.*;

public class ChallengeComparison {
    public static void main(String[] args) {
        int iterations = 1_000_000;
        String fileName = "Demo.txt";
        String charset = "UTF-8";

        long timeSB = concatenateUsingStringBuilder(iterations);
        long timeSBuffer = concatenateUsingStringBuffer(iterations);
        System.out.println("=== String Concatenation Comparison ===");
        System.out.println("StringBuilder time: " + timeSB / 1_000_000 + " ms");
        System.out.println("StringBuffer time:  " + timeSBuffer / 1_000_000 + " ms");

        long startFR = System.nanoTime();
        int wordCountFR = countWordsUsingFileReader(fileName);
        long durationFR = System.nanoTime() - startFR;

        long startISR = System.nanoTime();
        int wordCountISR = countWordsUsingInputStreamReader(fileName, charset);
        long durationISR = System.nanoTime() - startISR;

        System.out.println("\n=== File Reading & Word Count ===");
        System.out.println("FileReader: " + wordCountFR + " words, time: " + durationFR / 1_000_000 + " ms");
        System.out.println("InputStreamReader: " + wordCountISR + " words, time: " + durationISR / 1_000_000 + " ms");
    }

    public static long concatenateUsingStringBuilder(int iterations) {
        long start = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sb.append("hello");
        }
        long end = System.nanoTime();
        return end - start;
    }

    public static long concatenateUsingStringBuffer(int iterations) {
        long start = System.nanoTime();
        StringBuffer sBuffer = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sBuffer.append("hello");
        }
        long end = System.nanoTime();
        return end - start;
    }

    public static int countWordsUsingFileReader(String fileName) {
        int count = 0;
        BufferedReader br = null;
        try {
            FileReader fr = new FileReader(fileName);
            br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        count++;
                    }
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

    public static int countWordsUsingInputStreamReader(String fileName, String charset) {
        int count = 0;
        BufferedReader br = null;
        try {
            FileInputStream fis = new FileInputStream(fileName);
            InputStreamReader isr = new InputStreamReader(fis, charset);
            br = new BufferedReader(isr);
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        count++;
                    }
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }
}
