import java.io.*;

public class BufferedFileCopy {
    public static void main(String[] args) {
        File sourceFile = new File("input.txt");
        File destBuffered = new File("bufferedCopy.txt");
        File destUnbuffered = new File("unbufferedCopy.txt");

        if (!sourceFile.exists()) {
            System.out.println("Source file does not exist.");
            return;
        }

        long startBuffered = System.nanoTime();
        copyFileWithBuffer(sourceFile, destBuffered);
        long endBuffered = System.nanoTime();
        System.out.println("Buffered Stream Time: " + (endBuffered - startBuffered) / 1_000_000 + " ms");

        long startUnbuffered = System.nanoTime();
        copyFileWithoutBuffer(sourceFile, destUnbuffered);
        long endUnbuffered = System.nanoTime();
        System.out.println("Unbuffered Stream Time: " + (endUnbuffered - startUnbuffered) / 1_000_000 + " ms");
    }

    private static void copyFileWithBuffer(File source, File destination) {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destination))) {

            byte[] buffer = new byte[4096]; // 4 KB buffer
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
            System.out.println("File copied successfully with buffering.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copyFileWithoutBuffer(File source, File destination) {
        try (FileInputStream fis = new FileInputStream(source);
             FileOutputStream fos = new FileOutputStream(destination)) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
            System.out.println("File copied successfully without buffering.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
