class LibraryBook {
    private String title;
    private String author;
    private double price;
    private boolean availability;

    public LibraryBook(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.availability = true;
    }

    public void borrowBook() {
        if (availability) {
            availability = false;
            System.out.println("You have successfully borrowed the book: " + title);
        } else {
            System.out.println("Sorry, the book is currently unavailable.");
        }
    }

    public void displayBookDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
        System.out.println("Availability: " + (availability ? "Available" : "Unavailable"));
    }

    public static void main(String[] args) {
        LibraryBook book = new LibraryBook("Java Programming", "Sanjana", 500);
        book.displayBookDetails();
        book.borrowBook();
    }
}
