import java.util.regex.*;

public class ValidateCreditCard {
    public static void main(String[] args) {
        String visaRegex = "^4\\d{15}$";
        String masterCardRegex = "^5\\d{15}$";

        Pattern visaPattern = Pattern.compile(visaRegex);
        Pattern masterCardPattern = Pattern.compile(masterCardRegex);

        String[] cardNumbers = {
                "4111111111111111",  // Visa - Valid
                "5500000000000004",  // MasterCard - Valid
                "340000000000009",   // Invalid (not Visa/MasterCard)
                "412345678901234",   // Invalid (15 digits, not 16)
                "51234567890123456"  // Invalid (17 digits)
        };

        for (String card : cardNumbers) {
            boolean isVisa = visaPattern.matcher(card).matches();
            boolean isMasterCard = masterCardPattern.matcher(card).matches();
            System.out.println(card + " is Visa: " + isVisa + ", MasterCard: " + isMasterCard);
        }
    }
}
