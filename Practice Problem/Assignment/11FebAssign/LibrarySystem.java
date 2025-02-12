class BookNode {
    String title, author, genre;
    int bookId;
    boolean isAvailable;
    BookNode next, prev;

    BookNode(int bookId, String title, String author, String genre, boolean isAvailable) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isAvailable = isAvailable;
        this.next = this.prev = null;
    }
}

class LibraryManager {
    private BookNode head, tail;
    private int bookCount;

    void addBookAtBeginning(int bookId, String title, String author, String genre, boolean isAvailable) {
        BookNode newBook = new BookNode(bookId, title, author, genre, isAvailable);
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
        bookCount++;
    }

    void addBookAtEnd(int bookId, String title, String author, String genre, boolean isAvailable) {
        BookNode newBook = new BookNode(bookId, title, author, genre, isAvailable);
        if (tail == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
        bookCount++;
    }

    void removeBookById(int bookId) {
        if (head == null) return;
        BookNode temp = head;
        while (temp != null && temp.bookId != bookId) temp = temp.next;
        if (temp == null) return;
        if (temp == head) head = head.next;
        if (temp == tail) tail = tail.prev;
        if (temp.prev != null) temp.prev.next = temp.next;
        if (temp.next != null) temp.next.prev = temp.prev;
        bookCount--;
    }

    BookNode searchBookByTitleOrAuthor(String query) {
        BookNode temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(query) || temp.author.equalsIgnoreCase(query)) return temp;
            temp = temp.next;
        }
        return null;
    }

    void updateAvailability(int bookId, boolean isAvailable) {
        BookNode temp = head;
        while (temp != null) {
            if (temp.bookId == bookId) {
                temp.isAvailable = isAvailable;
                return;
            }
            temp = temp.next;
        }
    }

    void displayBooksForward() {
        BookNode temp = head;
        while (temp != null) {
            System.out.println(temp.bookId + " " + temp.title + " " + temp.author + " " + temp.genre + " " + temp.isAvailable);
            temp = temp.next;
        }
    }

    void displayBooksReverse() {
        BookNode temp = tail;
        while (temp != null) {
            System.out.println(temp.bookId + " " + temp.title + " " + temp.author + " " + temp.genre + " " + temp.isAvailable);
            temp = temp.prev;
        }
    }

    int getTotalBookCount() {
        return bookCount;
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        LibraryManager library = new LibraryManager();
        library.addBookAtEnd(1, "Sholay", "Ramesh Sippy", "Drama", true);
        library.addBookAtEnd(2, "Mughal-e-Azam", "K. Asif", "Historical", false);
        library.addBookAtBeginning(3, "Mother India", "Mehboob Khan", "Drama", true);
        library.displayBooksForward();
        System.out.println("Total Books: " + library.getTotalBookCount());
        library.updateAvailability(2, true);
        library.displayBooksReverse();
        library.removeBookById(1);
        library.displayBooksForward();
    }
}
