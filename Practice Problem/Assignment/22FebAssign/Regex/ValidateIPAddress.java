import java.util.regex.*;

public class ValidateIPAddress {
    public static void main(String[] args) {
        String regex = "^(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)\\."
                + "(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)\\."
                + "(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)\\."
                + "(25[0-5]|2[0-4]\\d|1\\d\\d|[1-9]?\\d)$";

        Pattern pattern = Pattern.compile(regex);

        String[] ipAddresses = {
                "192.168.1.1", "255.255.255.255", "0.0.0.0",
                "256.100.100.100", "123.456.78.90", "192.168.1"
        };

        for (String ip : ipAddresses) {
            System.out.println(ip + " is valid: " + pattern.matcher(ip).matches());
        }
    }
}

