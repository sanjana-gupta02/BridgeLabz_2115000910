import java.util.ArrayList;
import java.util.List;

class Book {
    String title, author;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    void display() {
        System.out.println("Title: " + title + ", Author: " + author);
    }
}

class Library {
    List<Book> books = new ArrayList<>();

    void addBook(Book book) {
        books.add(book);
    }

    void showBooks() {
        for (Book book : books) book.display();
    }
}

public class LibraryBook {
    public static void main(String[] args) {
        Book book1 = new Book("Rich Dad", "Paulo Coelho");
        Book book2 = new Book("Java Programming", "George Orwell");
        Book book3 = new Book("Meditation", "Harper Lee");

        Library library1 = new Library();
        Library library2 = new Library();

        library1.addBook(book1);
        library1.addBook(book2);

        library2.addBook(book2);
        library2.addBook(book3);

        System.out.println("Library 1 Books:");
        library1.showBooks();

        System.out.println("\nLibrary 2 Books:");
        library2.showBooks();
    }
}
