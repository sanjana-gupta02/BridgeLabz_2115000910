import java.io.*;
import java.nio.file.Files;

public class ImageByteArrayStream {
    public static void main(String[] args) {
        File sourceImage = new File("input.jpg");
        File destinationImage = new File("output.jpg");

        if (!sourceImage.exists()) {
            System.out.println("Source image file does not exist.");
            return;
        }

        try {
            byte[] imageBytes = convertImageToByteArray(sourceImage);
            writeByteArrayToImage(imageBytes, destinationImage);

            System.out.println("Image successfully copied as output.jpg.");

            if (Files.mismatch(sourceImage.toPath(), destinationImage.toPath()) == -1) {
                System.out.println("Verification successful: Files are identical.");
            } else {
                System.out.println("Verification failed: Files are not identical.");
            }
        } catch (IOException e) {
            System.out.println("Error processing image: " + e.getMessage());
        }
    }

    private static byte[] convertImageToByteArray(File imageFile) throws IOException {
        try (FileInputStream fis = new FileInputStream(imageFile);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            return baos.toByteArray();
        }
    }

    private static void writeByteArrayToImage(byte[] imageBytes, File outputFile) throws IOException {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
             FileOutputStream fos = new FileOutputStream(outputFile)) {

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = bais.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }
    }
}
