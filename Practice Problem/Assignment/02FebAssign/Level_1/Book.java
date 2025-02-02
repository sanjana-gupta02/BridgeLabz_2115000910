import java.util.Scanner;

class Book {
    private String title, author;
    private double price;

    public Book() {
        title = "Unknown";
        author = "Unknown";
        price = 0.0;
    }

    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void displayDetails() {
        System.out.println(title + ", " + author + ", " + price);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Book book1 = new Book();
        book1.displayDetails();

        String title = sc.nextLine();
        String author = sc.nextLine();
        double price = sc.nextDouble();

        Book book2 = new Book(title, author, price);
        book2.displayDetails();

        sc.close();
    }
}
