import java.util.*;

public class LibrarySystemApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        System.out.println(" Welcome to Rudra's Library Management System");

        while (true) {
            System.out.println("\n------ MENU ------");
            System.out.println("1. Add Book");
            System.out.println("2. Register Member");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. List All Books");
            System.out.println("6. List Issued Books");
            System.out.println("0. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter author: ");
                    String author = sc.nextLine();
                    System.out.print("Enter ISBN: ");
                    String isbn = sc.nextLine();
                    library.addBook(new Book(title, author, isbn));
                    break;
                case 2:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter ID: ");
                    String id = sc.nextLine();
                    System.out.print("Is this a Student or Faculty? ");
                    String type = sc.nextLine();
                    if (type.equalsIgnoreCase("Student")) {
                        library.registerMember(new Student(name, id));
                    } else if (type.equalsIgnoreCase("Faculty")) {
                        library.registerMember(new Faculty(name, id));
                    } else {
                        System.out.println("Invalid member type.");
                    }
                    break;
                case 3:
                    System.out.print("Enter Member ID: ");
                    String memId = sc.nextLine();
                    System.out.print("Enter Book ISBN: ");
                    String bookIsbn = sc.nextLine();
                    library.issueBook(memId, bookIsbn);
                    break;
                case 4:
                    System.out.print("Enter Member ID: ");
                    String memIdR = sc.nextLine();
                    System.out.print("Enter Book ISBN: ");
                    String bookIsbnR = sc.nextLine();
                    library.returnBook(memIdR, bookIsbnR);
                    break;
                case 5:
                    library.listAllBooks();
                    break;
                case 6:
                    library.listIssuedBooks();
                    break;
                case 0:
                    System.out.println(" Goodbye, Happy Reading!");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}


interface Displayable {
    void display();
}

interface Loanable {
    boolean issueBook(Book book);
    void returnBook(Book book);
}

class Book {
    String title;
    String author;
    String isbn;
    boolean isIssued;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isIssued = false;
    }

    public String toString() {
        return String.format("[Book] Title: %s | Author: %s | ISBN: %s | %s",
                title, author, isbn, isIssued ? "Issued" : "Available");
    }
}

abstract class Member implements Loanable, Displayable {
    String name;
    String id;
    List<Book> borrowedBooks = new ArrayList<>();
    int maxLimit;

    public Member(String name, String id, int maxLimit) {
        this.name = name;
        this.id = id;
        this.maxLimit = maxLimit;
    }

    @Override
    public boolean issueBook(Book book) {
        if (borrowedBooks.size() >= maxLimit) {
            System.out.println(" Cannot issue more books. Limit reached!");
            return false;
        }
        if (book.isIssued) {
            System.out.println(" Book already issued.");
            return false;
        }
        book.isIssued = true;
        borrowedBooks.add(book);
        System.out.println("ook issued to " + name);
        return true;
    }

    @Override
    public void returnBook(Book book) {
        if (borrowedBooks.remove(book)) {
            book.isIssued = false;
            System.out.println("Book returned.");
        } else {
            System.out.println(" You don't have this book.");
        }
    }

    @Override
    public void display() {
        System.out.println("Member: " + name + " | ID: " + id + " | Books Borrowed: " + borrowedBooks.size());
    }
}

class Student extends Member {
    public Student(String name, String id) {
        super(name, id, 3); // max 3 books
    }
}

class Faculty extends Member {
    public Faculty(String name, String id) {
        super(name, id, 5); // max 5 books
    }
}

class Library {
    List<Book> books = new ArrayList<>();
    List<Member> members = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println(" Book added: " + book.title);
    }

    public void registerMember(Member member) {
        members.add(member);
        System.out.println(" Member registered: " + member.name);
    }

    public void issueBook(String memberId, String isbn) {
        Member member = findMemberById(memberId);
        Book book = findBookByISBN(isbn);
        if (member != null && book != null) {
            member.issueBook(book);
        }
    }

    public void returnBook(String memberId, String isbn) {
        Member member = findMemberById(memberId);
        Book book = findBookByISBN(isbn);
        if (member != null && book != null) {
            member.returnBook(book);
        }
    }

    public void listAllBooks() {
        System.out.println("\n All Books:");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void listIssuedBooks() {
        System.out.println("\n Issued Books:");
        for (Book book : books) {
            if (book.isIssued)
                System.out.println(book);
        }
    }

    private Book findBookByISBN(String isbn) {
        for (Book book : books) {
            if (book.isbn.equals(isbn))
                return book;
        }
        System.out.println("Book not found.");
        return null;
    }

    private Member findMemberById(String id) {
        for (Member member : members) {
            if (member.id.equals(id))
                return member;
        }
        System.out.println("Member not found.");
        return null;
    }

    public List<Member> getMembers() {
        return members;
    }
}

