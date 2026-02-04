import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryProject{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("\n---------------- LIBRARY MANAGEMENT SYSTEM --------------------");
            System.out.println("1. Add book to library");
            System.out.println("2. Register new member (Student/Faculty)");
            System.out.println("3. Issue book to member");
            System.out.println("4. Return book");
            System.out.println("5. List all books");
            System.out.println("6. List all issued books");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");

            int num = sc.nextInt();
            sc.nextLine(); 

            switch (num) {
                case 1 -> {
                    System.out.print("Enter Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Book Name: ");
                    String bookname = sc.nextLine();
                    System.out.print("Enter Author: ");
                    String author = sc.nextLine();
                    Book book = new Book(id, bookname, author);
                    library.addBook(book);
                }
                case 2 -> {
                    System.out.print("Enter Member ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Member Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter occupation (Student/Faculty): ");
                    String occupation = sc.nextLine();
                    Member member;
                    if (occupation.equalsIgnoreCase("Student")) {
                        member = new Student(id, name);
                    } else if (occupation.equalsIgnoreCase("Faculty")) {
                        member = new Faculty(id, name);
                    } else {
                        System.out.println("Invalid occupation.");
                        break;
                    }
                    library.registerMember(member);
                }
                case 3 -> {
                    System.out.print("Enter Member ID: ");
                    int memberId = sc.nextInt();
                    System.out.print("Enter Book ID to issue: ");
                    int bookId = sc.nextInt();
                    Member member = library.findMemberById(memberId);
                    Book book = library.findBookById(bookId);
                    if (member == null) {
                        System.out.println("Member not found.");
                    } else if (book == null) {
                        System.out.println("Book not found.");
                    } else {
                        try {
                            member.issueBook(book);
                            System.out.println("Book issued successfully.");
                        } catch (BookIssueException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    }
                }
                case 4 -> {
                    System.out.print("Enter Member ID: ");
                    int memberId = sc.nextInt();
                    System.out.print("Enter Book ID to return: ");
                    int bookId = sc.nextInt();
                    Member member = library.findMemberById(memberId);
                    Book book = library.findBookById(bookId);
                    if (member == null) {
                        System.out.println("Member not found.");
                    } else if (book == null) {
                        System.out.println("Book not found.");
                    } else {
                        member.returnBook(book);
                    }
                }
                case 5 -> {
                    library.listAllBooks();
                }
                case 6 -> {
                    library.listIssuedBooks();
                }
                case 7 -> {
                    System.out.println("Exiting... Goodbye!");
                    sc.close();
                    return;
                }
                default -> {
                    System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }
}


// INTERFACES

interface Loanable {
    void issueBook(Book book) throws BookIssueException;
    void returnBook(Book book);
}

interface Displayable {
    void displayDetails();
}


// EXCEPTION CLASS

class BookIssueException extends Exception {
    public BookIssueException(String message) {
        super(message);
    }
}


// BOOK CLASS

class Book {
     int id;
     String title;
     String author;
     boolean isIssued;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isIssued() { return isIssued; }

    public void setIssued(boolean issued) {
        this.isIssued = issued;
    }

    @Override
    public String toString() {
        return "Book[ID=" + id +
                ", Title=" + title +
                ", Author=" + author +
                ", Issued=" + isIssued + "]";
    }
}


// ABSTRACT MEMBER CLASS

abstract class Member implements Loanable, Displayable {
    protected int memberId;
    protected String name;
    protected List<Book> issuedBooks;
    protected int maxAllowed;

    public Member(int memberId, String name, int maxAllowed) {
        this.memberId = memberId;
        this.name = name;
        this.maxAllowed = maxAllowed;
        this.issuedBooks = new ArrayList<>();
    }

    @Override
    public void issueBook(Book book) throws BookIssueException {
        if (issuedBooks.size() >= maxAllowed) {
            throw new BookIssueException("Member has reached maximum allowed books.");
        }
        if (book.isIssued()) {
            throw new BookIssueException("Book already issued: " + book.getTitle());
        }
        issuedBooks.add(book);
        book.setIssued(true);
    }

    @Override
    public void returnBook(Book book) {
        if (issuedBooks.remove(book)) {
            book.setIssued(false);
            System.out.println("Book returned successfully: " + book.getTitle());
        } else {
            System.out.println("This book was not issued to this member.");
        }
    }

    @Override
    public void displayDetails() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Member[ID=" + memberId +
                ", Name=" + name +
                ", IssuedBooks=" + issuedBooks.size() + "]";
    }
}


// STUDENT CLASS

class Student extends Member {
    public Student(int memberId, String name) {
        super(memberId, name, 3); // max 3 books
    }

    @Override
    public String toString() {
        return "Student[ID=" + memberId +
                ", Name=" + name +
                ", IssuedBooks=" + issuedBooks.size() + "]";
    }
}


// FACULTY CLASS

class Faculty extends Member {
    public Faculty(int memberId, String name) {
        super(memberId, name, 5); // max 5 books
    }

    @Override
    public String toString() {
        return "Faculty[ID=" + memberId +
                ", Name=" + name +
                ", IssuedBooks=" + issuedBooks.size() + "]";
    }
}


// LIBRARY CLASS

class Library {
     List<Book> books;
     List<Member> members;

    public Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book);
    }

    public void registerMember(Member member) {
        members.add(member);
        System.out.println("Member registered: " + member);
    }

    public void listAllBooks() {
        System.out.println("\n--- All Books ---");
        if (books.isEmpty()) {
            System.out.println("No books in library.");
            return;
        }
        for (Book b : books) {
            System.out.println(b);
        }
    }

    public void listIssuedBooks() {
        System.out.println("\n--- Issued Books ---");
        boolean anyIssued = false;
        for (Book b : books) {
            if (b.isIssued()) {
                System.out.println(b);
                anyIssued = true;
            }
        }
        if (!anyIssued) {
            System.out.println("No books are currently issued.");
        }
    }

    public Member findMemberById(int memberId) {
        for (Member m : members) {
            if (m.memberId == memberId) {
                return m;
            }
        }
        return null;
    }

    public Book findBookById(int bookId) {
        for (Book b : books) {
            if (b.getId() == bookId) {
                return b;
            }
        }
        return null;
    }
}