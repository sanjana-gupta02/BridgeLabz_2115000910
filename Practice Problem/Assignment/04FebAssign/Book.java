import java.util.Scanner;

class Book {
    static String libraryName = "City Library";
    final String isbn;
    String title, author;

    Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    void displayBookDetails() {
        if (this instanceof Book) {
            System.out.println("\nLibrary: " + libraryName);
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
            System.out.println("ISBN: " + isbn);
        }
    }

    static void displayLibraryName() {
        System.out.println("\nLibrary Name: " + libraryName);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        Book[] books = new Book[n];

        for (int i = 0; i < n; i++) {
            String isbn = sc.nextLine();
            String title = sc.nextLine();
            String author = sc.nextLine();

            books[i] = new Book(isbn, title, author);
        }

        displayLibraryName();

        for (int i = 0; i < n; i++) {
            books[i].displayBookDetails();
        }
    }
}
