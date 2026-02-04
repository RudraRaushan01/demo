import java.util.*;
public class Library3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("\n===== LIBRARY MENU =====");
            System.out.println("1. Add Book");
            System.out.println("2. Register Member");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. List All Books");
            System.out.println("6. List Issued Books");
            System.out.println("7. List Members");
            System.out.println("0. Exit");
            System.out.println("Choose an option: ");
            int choice = sc.nextInt();

            switch (choice) {
              case 1 -> {
    System.out.print("Enter book title: ");
    String title = sc.nextLine();  // ✅ no extra nextLine here
    System.out.print("Enter author name: ");
    String author = sc.nextLine();
    library.addBook(title, author);
}
case 2 -> {
    System.out.print("Enter member name: ");
    String name = sc.nextLine();
    System.out.print("Enter type (Student/Faculty): ");
    String type = sc.nextLine();
    library.registerMember(name, type);
}

                case 3 -> {
                    System.out.print("Enter Member ID: ");
                    int memId = sc.nextInt();
                    System.out.print("Enter Book ID: ");
                    int bookId = sc.nextInt();
                    library.issueBook(memId, bookId);
                }
                case 4 -> {
                    System.out.print("Enter Member ID: ");
                    int mId = sc.nextInt();
                    System.out.print("Enter Book ID: ");
                    int bId = sc.nextInt();
                    library.returnBook(mId, bId);
                }
                case 5 -> library.listAllBooks();
                case 6 -> library.listIssuedBooks();
                case 7 -> library.listMembers();
                case 0 -> {
                    System.out.println("Exiting... 📚👋");
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }
}
interface Loanable {
    boolean issueBook(Book book);
    boolean returnBook(Book book);
}

interface Displayable {
    void displayInfo();
}


class Book {
    private static int count = 1;
     int id;
     String title;
     String author;
     boolean isIssued;

    public Book(String title, String author) {
        this.id = count++;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public boolean isIssued() { return isIssued; }
    public void setIssued(boolean issued) { isIssued = issued; }

    @Override
    public String toString() {
        return "Book[ID=" + id + ", Title='" + title + "', Author='" + author + "', Issued=" + isIssued + "]";
    }
}

// Custom Exception
class BookLimitExceededException extends Exception {
    public BookLimitExceededException(String message) {
        super(message);
    }
}

abstract class Member implements Loanable, Displayable {
    private static int count = 100;
    protected int memberId;
    protected String name;
    protected List<Book> issuedBooks;

    public Member(String name) {
        this.name = name;
        this.memberId = count++;
        this.issuedBooks = new ArrayList<>();
    }

    public int getId() { return memberId; }
    public List<Book> getIssuedBooks() { return issuedBooks; }

    @Override
    public void displayInfo() {
        System.out.println(this);
    }

    public boolean hasBook(Book book) {
        return issuedBooks.contains(book);
    }

    @Override
    public String toString() {
        return "Member[ID=" + memberId + ", Name='" + name + "', Type=" + this.getClass().getSimpleName() + ", IssuedBooks=" + issuedBooks.size() + "]";
    }

    public abstract int getMaxBooksAllowed();

    @Override
    public boolean issueBook(Book book) {
        if (issuedBooks.size() >= getMaxBooksAllowed()) {
            return false;
        }
        issuedBooks.add(book);
        book.setIssued(true);
        return true;
    }

    @Override
    public boolean returnBook(Book book) {
        if (issuedBooks.remove(book)) {
            book.setIssued(false);
            return true;
        }
        return false;
    }
}


class Student extends Member {
    public Student(String name) { super(name); }
    @Override
    public int getMaxBooksAllowed() { return 3; }
}


class Faculty extends Member {
    public Faculty(String name) { super(name); }
    @Override
    public int getMaxBooksAllowed() { return 5; }
}


class Library {
     List<Book> books = new ArrayList<>();
     List<Member> members = new ArrayList<>();

    public void addBook(String title, String author) {
        books.add(new Book(title, author));
        System.out.println("Book added successfully!");
    }

    public void registerMember(String name, String type) {
        if (type.equalsIgnoreCase("student")) {
            members.add(new Student(name));
        } else if (type.equalsIgnoreCase("faculty")) {
            members.add(new Faculty(name));
        } else {
            System.out.println("Invalid member type.");
            return;
        }
        System.out.println("Member registered successfully!");
    }

    public Member getMemberById(int id) {
        for (Member m : members) {
            if (m.getId() == id) return m;
        }
        return null;
    }

    public Book getBookById(int id) {
        for (Book b : books) {
            if (b.getId() == id) return b;
        }
        return null;
    }

    public void issueBook(int memberId, int bookId) {
        Member member = getMemberById(memberId);
        Book book = getBookById(bookId);

        if (member == null || book == null) {
            System.out.println("Invalid member or book ID.");
            return;
        }

        if (book.isIssued()) {
            System.out.println("Book is already issued.");
            return;
        }

        try {
            if (!member.issueBook(book)) {
                throw new BookLimitExceededException("Cannot issue more books to this member.");
            }
            System.out.println("Book issued successfully!");
        } catch (BookLimitExceededException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void returnBook(int memberId, int bookId) {
        Member member = getMemberById(memberId);
        Book book = getBookById(bookId);

        if (member == null || book == null) {
            System.out.println("Invalid member or book ID.");
            return;
        }

        if (!member.returnBook(book)) {
            System.out.println("This book was not issued to the member.");
        } else {
            System.out.println("Book returned successfully!");
        }
    }

    public void listAllBooks() {
        System.out.println("All Books in Library:");
        for (Book b : books) {
            System.out.println(b);
        }
    }

    public void listIssuedBooks() {
        System.out.println("Issued Books:");
        for (Book b : books) {
            if (b.isIssued()) {
                System.out.println(b);
            }
        }
    }

    public void listMembers() {
        System.out.println("All Members:");
        for (Member m : members) {
            m.displayInfo();
        }
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }
}



