class BankAccount {
    static String bankName = "State Bank of India";
    static int totalAccounts;
    final int accountNumber;
    String accountHolderName;
    double balance;

    BankAccount(int accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        totalAccounts++;
    }

    void displayAccountDetails() {
        if (this instanceof BankAccount) {
            System.out.println("Bank: " + bankName);
            System.out.println("Account Holder: " + accountHolderName);
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Balance: " + balance);
        }
    }

    static void getTotalAccounts() {
        System.out.println("Total Bank Accounts: " + totalAccounts);
    }

    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount(101, "Sanjana", 5000.0);
        BankAccount acc2 = new BankAccount(102, "Khushi", 7000.0);

        acc1.displayAccountDetails();
        acc2.displayAccountDetails();

        getTotalAccounts();
    }
}
