import java.io.*;

public class WriteUserInputToFile {
    public static void main(String[] args) {
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);

            FileWriter fw = new FileWriter("userInput.txt");
            BufferedWriter bw = new BufferedWriter(fw);

            System.out.println("Enter text (type 'exit' to quit):");
            String line;

            while (!(line = br.readLine()).equalsIgnoreCase("exit")) {
                bw.write(line);
                bw.newLine();
            }

            bw.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
