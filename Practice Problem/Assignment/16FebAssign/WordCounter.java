import java.io.*;

public class WordCounter {
    public static int countWordOccurrences(String fileName, String targetWord) {
        int count = 0;
        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (int i = 0; i < words.length; i++) {
                    if (words[i].equalsIgnoreCase(targetWord)) {
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

    public static void main(String[] args) {
        String fileName = "Demo.txt";
        String targetWord = "the";
        int occurrences = countWordOccurrences(fileName, targetWord);
        System.out.println("The word '" + targetWord + "' appears " + occurrences + " times in the file.");
    }
}
