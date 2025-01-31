import java.util.Scanner;

public class Book {
    private String title;
    private String author;
    private int price;

    //Making Constructor
    public Book(String title, String author, int price){
        this.title = title;
        this.author = author;
        this.price = price;
    }

    //Making method to display result
    public void displayDetails(){
        System.out.println("Book Title: " +title);
        System.out.println("Book Author: " +author);
        System.out.println("Book Price: " +price);
    }

    //main method to execute
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Book Details:");
        String title = sc.next();
        String author = sc.next();
        int price = sc.nextInt();

        Book obj = new Book(title,author,price);
        obj.displayDetails();

    }

}
