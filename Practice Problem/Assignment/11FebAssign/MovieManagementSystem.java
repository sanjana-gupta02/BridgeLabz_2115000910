class MovieNode {
    String title, director;
    int year;
    double rating;
    MovieNode next, prev;

    MovieNode(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}

class MovieLinkedList {
    private MovieNode head, tail;

    void addMovieAtBeginning(String title, String director, int year, double rating) {
        MovieNode newMovie = new MovieNode(title, director, year, rating);
        if (head == null) head = tail = newMovie;
        else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
    }

    void addMovieAtEnd(String title, String director, int year, double rating) {
        MovieNode newMovie = new MovieNode(title, director, year, rating);
        if (head == null) head = tail = newMovie;
        else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
    }

    void addMovieAtPosition(String title, String director, int year, double rating, int position) {
        if (position == 1) {
            addMovieAtBeginning(title, director, year, rating);
            return;
        }
        MovieNode newMovie = new MovieNode(title, director, year, rating);
        MovieNode temp = head;
        for (int i = 1; temp != null && i < position - 1; i++) temp = temp.next;
        if (temp == null || temp.next == null) {
            addMovieAtEnd(title, director, year, rating);
            return;
        }
        newMovie.next = temp.next;
        newMovie.prev = temp;
        temp.next.prev = newMovie;
        temp.next = newMovie;
    }

    void removeMovieByTitle(String title) {
        if (head == null) return;
        if (head.title.equals(title)) {
            head = head.next;
            if (head != null) head.prev = null;
            else tail = null;
            return;
        }
        MovieNode temp = head;
        while (temp != null && !temp.title.equals(title)) temp = temp.next;
        if (temp == null) return;
        if (temp.next != null) temp.next.prev = temp.prev;
        else tail = temp.prev;
        if (temp.prev != null) temp.prev.next = temp.next;
    }

    MovieNode searchMovieByDirector(String director) {
        MovieNode temp = head;
        while (temp != null) {
            if (temp.director.equals(director)) return temp;
            temp = temp.next;
        }
        return null;
    }

    MovieNode searchMovieByRating(double rating) {
        MovieNode temp = head;
        while (temp != null) {
            if (temp.rating == rating) return temp;
            temp = temp.next;
        }
        return null;
    }

    void updateRating(String title, double newRating) {
        MovieNode temp = head;
        while (temp != null) {
            if (temp.title.equals(title)) {
                temp.rating = newRating;
                return;
            }
            temp = temp.next;
        }
    }

    void displayMoviesForward() {
        MovieNode temp = head;
        while (temp != null) {
            System.out.println(temp.title + " " + temp.director + " " + temp.year + " " + temp.rating);
            temp = temp.next;
        }
    }

    void displayMoviesReverse() {
        MovieNode temp = tail;
        while (temp != null) {
            System.out.println(temp.title + " " + temp.director + " " + temp.year + " " + temp.rating);
            temp = temp.prev;
        }
    }
}

public class MovieManagementSystem {
    public static void main(String[] args) {
        MovieLinkedList list = new MovieLinkedList();
        list.addMovieAtEnd("Sholay", "Ramesh Sippy", 1975, 9.0);
        list.addMovieAtEnd("Dilwale Dulhania Le Jayenge", "Aditya Chopra", 1995, 8.5);
        list.addMovieAtBeginning("Mughal-E-Azam", "K. Asif", 1960, 9.2);
        list.addMovieAtPosition("3 Idiots", "Rajkumar Hirani", 2009, 8.4, 2);
        list.displayMoviesForward();
        list.updateRating("Dilwale Dulhania Le Jayenge", 8.8);
        list.removeMovieByTitle("Mughal-E-Azam");
        list.displayMoviesReverse();
    }
}
