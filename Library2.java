import java.util.*;


// Main class (Polymorphism, Program Execution)
public class Library2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("\n===== 📘 Library Menu =====");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Search Book");
            System.out.println("6. List All Books");
            System.out.println("7. Exit");
            System.out.print("➡️ Enter your choice: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid input. Try again.");
                continue;
            }

            try {
                switch (choice) {
                    case 1 -> {
                        System.out.print("🔤 Enter Book ID: ");
                        String id = sc.nextLine();
                        System.out.print("📚 Enter Title: ");
                        String title = sc.nextLine();
                        System.out.print("✍️ Enter Author: ");
                        String author = sc.nextLine();
                        Book book = new Book(id, title, author);
                        library.addBook(book);
                    }

                    case 2 -> {
                        System.out.print("🗑️ Enter Book ID to remove: ");
                        library.removeBook(sc.nextLine());
                    }

                    case 3 -> {
                        System.out.print("📥 Enter Book ID to borrow: ");
                        library.borrowBook(sc.nextLine());
                    }

                    case 4 -> {
                        System.out.print("📤 Enter Book ID to return: ");
                        library.returnBook(sc.nextLine());
                    }

                    case 5 -> {
                        System.out.print("🔍 Enter keyword to search (title/author): ");
                        library.searchBook(sc.nextLine());
                    }

                    case 6 -> library.listBooks();

                    case 7 -> {
                        System.out.println("👋 Thank you for using Library System!");
                        return;
                    }

                    default -> System.out.println("❌ Invalid choice. Try 1–7.");
                }
            } catch (BookNotFoundException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("⚠️ Unexpected error: " + e.getMessage());
            }
        }
    }
}


// Book class (Encapsulation)
class Book {

      String id;
      String title;
      String author;
     boolean isBorrowed;

    public Book(String id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isBorrowed = false;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isBorrowed() { return isBorrowed; }

    public void borrow() { isBorrowed = true; }
    public void returned() { isBorrowed = false; }

      @Override
    public String toString() {
        return id + " | " + title + " by " + author + (isBorrowed ? " [Borrowed]" : " [Available]");
    }
}

// Custom Exception
class BookNotFoundException extends Exception {
    public BookNotFoundException(String msg) {
        super(msg);
    }
}

// Library class (Abstraction)
class Library {
     Map<String, Book> books = new HashMapP1<>();

    public void addBook(Book book) {
        books.put(book.getId(), book);
        System.out.println("✅ Book added successfully.");
    }

    public void removeBook(String id) throws BookNotFoundException {
        if (!books.containsKey(id)) {
            throw new BookNotFoundException("❌ Book ID not found.");
        }
        books.remove(id);
        System.out.println("✅ Book removed successfully.");
    }

    public void borrowBook(String id) throws BookNotFoundException {
        Book book = books.get(id);
        if (book == null) throw new BookNotFoundException("❌ Book not found.");
        if (book.isBorrowed()) {
            System.out.println("⚠️ Book is already borrowed.");
        } else {
            book.borrow();
            System.out.println("✅ Book borrowed successfully.");
        }
    }

    public void returnBook(String id) throws BookNotFoundException {
        Book book = books.get(id);
        if (book == null) throw new BookNotFoundException("❌ Book not found.");
        if (!book.isBorrowed()) {
            System.out.println("⚠️ Book wasn't borrowed.");
        } else {
            book.returned();
            System.out.println("✅ Book returned successfully.");
        }
    }

    public void searchBook(String keyword) {
        boolean found = false;
        for (Book book : books.values()) {
            if (book.getTitle().toLowerCase().contains(keyword.toLowerCase()) || 
                book.getAuthor().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("🔍 No matching books found.");
        }
    }

    public void listBooks() {
        if (books.isEmpty()) {
            System.out.println("📚 Library is empty.");
        } else {
            System.out.println("📖 All books:");
            for (Book book : books.values()) {
                System.out.println(book);
            }
        }
    }
}

