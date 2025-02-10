import java.util.*;

// Interface defining reservable behavior
interface Reservable {
    void reserveItem(String borrower);
    boolean checkAvailability();
}

// Abstract class LibraryItem
abstract class LibraryItem {
    private final String itemId;
    private String title;
    private String author;
    private boolean isAvailable = true;

    LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    public String getItemId() {
        return itemId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailability(boolean availability) {
        this.isAvailable = availability;
    }

    abstract int getLoanDuration();

    public void getItemDetails() {
        System.out.println("Item ID: " + itemId + ", Title: " + title + ", Author: " + author);
    }
}

// Book subclass
class Book extends LibraryItem implements Reservable {
    private static final int LOAN_DURATION = 14;

    Book(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    int getLoanDuration() {
        return LOAN_DURATION;
    }

    @Override
    public void reserveItem(String borrower) {
        if (isAvailable()) {
            setAvailability(false);
            System.out.println("Book reserved by " + borrower);
        } else {
            System.out.println("Book is not available for reservation.");
        }
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable();
    }
}

// Magazine subclass
class Magazine extends LibraryItem {
    private static final int LOAN_DURATION = 7;

    Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    int getLoanDuration() {
        return LOAN_DURATION;
    }
}

// DVD subclass
class DVD extends LibraryItem implements Reservable {
    private static final int LOAN_DURATION = 5;

    DVD(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    int getLoanDuration() {
        return LOAN_DURATION;
    }

    @Override
    public void reserveItem(String borrower) {
        if (isAvailable()) {
            setAvailability(false);
            System.out.println("DVD reserved by " + borrower);
        } else {
            System.out.println("DVD is not available for reservation.");
        }
    }

    @Override
    public boolean checkAvailability() {
        return isAvailable();
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        List<LibraryItem> libraryItems = new ArrayList<>();

        Book book = new Book("B101", "Java Programming", "Sanjana Gupta");
        Magazine magazine = new Magazine("M202", "Tech World", "Khushi Gupta");
        DVD dvd = new DVD("D303", "AnyDVD", "Aman Gupta");

        libraryItems.add(book);
        libraryItems.add(magazine);
        libraryItems.add(dvd);

        for (LibraryItem item : libraryItems) {
            item.getItemDetails();
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");
            if (item instanceof Reservable) {
                ((Reservable) item).reserveItem("Kislay");
                System.out.println("Available: " + ((Reservable) item).checkAvailability());
            }
        }
    }
}
