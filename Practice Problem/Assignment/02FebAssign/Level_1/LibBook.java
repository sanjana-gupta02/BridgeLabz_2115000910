public class LibBook {
    public String ISBN;
    protected String title;
    private String author;

    public LibBook(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void displayBookDetails() {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }
}

class EBook extends LibBook {

    public EBook(String ISBN, String title, String author) {
        super(ISBN, title, author);
    }

    public void displayEBookDetails() {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
        System.out.println("Author: " + getAuthor());
    }

    public static void main(String[] args) {
        LibBook book1 = new LibBook("978-3-16-148410-0", "The Great Gatsby", "F. Scott Fitzgerald");
        book1.displayBookDetails();

        EBook ebook1 = new EBook("978-1-23-456789-0", "1984", "George Orwell");
        ebook1.displayEBookDetails();

        book1.setAuthor("Fitzgerald");
        book1.displayBookDetails();
    }
}
