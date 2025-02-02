public class BankAccount {
    public String accountNumber;
    protected String accountHolder;
    private double balance;

    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: " + balance);
    }
}

class SavingsAccount extends BankAccount {

    public SavingsAccount(String accountNumber, String accountHolder, double balance) {
        super(accountNumber, accountHolder, balance);
    }

    public void displaySavingsAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: " + getBalance());
    }

    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("1234567890", "Sanjana", 5000.0);
        account1.displayAccountDetails();

        SavingsAccount savingsAccount1 = new SavingsAccount("0987654321", "Khushi", 10000.0);
        savingsAccount1.displaySavingsAccountDetails();

        account1.setBalance(5500.0);
        account1.displayAccountDetails();
    }
}
