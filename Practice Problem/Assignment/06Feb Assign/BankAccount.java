import java.util.ArrayList;
import java.util.List;

class Bank {
    String name;
    List<Customer> customers = new ArrayList<>();

    Bank(String name) {
        this.name = name;
    }

    void openAccount(Customer customer, double initialDeposit) {
        Account account = new Account(this, initialDeposit);
        customer.addAccount(account);
        if (!customers.contains(customer)) customers.add(customer);
    }
}

class Customer {
    String name;
    List<Account> accounts = new ArrayList<>();

    Customer(String name) {
        this.name = name;
    }

    void addAccount(Account account) {
        accounts.add(account);
    }

    void viewBalance() {
        for (Account account : accounts) {
            System.out.println("Bank: " + account.bank.name + ", Balance: " + account.balance);
        }
    }
}

class Account {
    Bank bank;
    double balance;

    Account(Bank bank, double balance) {
        this.bank = bank;
        this.balance = balance;
    }
}

public class BankAccount {
    public static void main(String[] args) {
        Bank bank = new Bank("State Bank");
        Customer customer1 = new Customer("Sanjana Gupta");
        Customer customer2 = new Customer("Khushi Gupta");

        bank.openAccount(customer1, 5000);
        bank.openAccount(customer2, 10000);
        bank.openAccount(customer1, 2000);

        System.out.println("Customer Balances:");
        customer1.viewBalance();
        customer2.viewBalance();
    }
}
