import java.util.*;
public class Library6 {
    public static void main(String[] args){
        System.out.println("<---Libary Management System--->");
        Scanner sc=new Scanner(System.in);
        System.out.println("Add a Book: ");
        System.out.println("Add a Member: ");
        System.out.println("Issued Book");
        System.out.println("Return a Book: ");
        System.out.println("List all members: ");
        System.out.println("List all book: ");
        System.out.println("List all issued Books: ");
        System.out.println("");

        int num = sc.nextInt();
        switch(num) {
            case 1 -> {
                System.out.print("Enter Book ID: ");
                int bookId = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter Book Title: ");
                String bookTitle = sc.nextLine();
                System.out.print("Enter Book Author: ");
                String bookAuthor = sc.nextLine();
                Book book = new Book(bookId, bookTitle, bookAuthor);
            }

            case 2 -> {
                System.out.print("Enter Member ID: ");
                int memberId = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter Member Name: ");
                String memberName = sc.nextLine();
                System.out.print("Enter Member Email: ");
                String memberEmail = sc.nextLine();
                Member member = new Member(memberId, memberName, memberEmail);
                // Add member to library
            }

            case 3 -> {
                System.out.print("Enter Member ID to issue book: ");
                int memberId = sc.nextInt();
                System.out.print("Enter Book ID to issue: ");
                int bookId = sc.nextInt();
                // Issue book to member
            }
            case 4 -> {
                System.out.print("Enter Book ID to return: ");
                int bookId = sc.nextInt();
    
            }

            case 5 -> System.out.println("List all members");

            case 6 -> System.out.println("List all books");
            case 7 -> System.out.println("List all issued books");
            default -> System.out.println("Invalid option. Please try again.");
        }



    }
    
}

class Book {
    private int id;
    private String title;
    private String author;
    private boolean isIssued;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    public Book(String author, int id, boolean isIssued, String title) {
        this.author = author;
        this.id = id;
        this.isIssued = isIssued;
        this.title = title;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isIssued() {
        return isIssued;
    }

    public void setIssued(boolean issued) {
        isIssued = issued;
    }
}
class Member {
    private int id;
    private String name;
    private String email;

    public Member(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}