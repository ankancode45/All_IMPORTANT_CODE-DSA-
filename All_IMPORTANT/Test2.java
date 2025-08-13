/*
Title: Library Book Management System using Arrays in Core Java

Problem Statement:
Write a Java program to manage books in a library using arrays. The program should allow the user to:

Add new books.

View all books.

Search for a book by ID.

Issue a book (mark as issued).

Return a book (mark as available).

The system should store a maximum of 100 books using arrays (no collections or database).

Requirements:

Create a Book class with:

bookId (int)

title (String)

author (String)

isIssued (boolean)

Use an array of Book objects in the main program.

Implement a menu-driven interface.
*/
import java.util.Scanner;

class Book {
    int bookId;
    String title;
    String author;
    boolean isIssued;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.isIssued = false; // Initially available
    }

    public void issueBook() {
        if (!isIssued) {
            isIssued = true;
            System.out.println("Book issued successfully!");
        } else {
            System.out.println("Book is already issued.");
        }
    }

    public void returnBook() {
        if (isIssued) {
            isIssued = false;
            System.out.println("Book returned successfully!");
        } else {
            System.out.println("Book was not issued.");
        }
    }

    public void displayBook() {
        System.out.println("Book ID: " + bookId + ", Title: " + title +
                ", Author: " + author + ", Status: " + (isIssued ? "Issued" : "Available"));
    }
}

class LibraryManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Book[] books = new Book[100];
        int count = 0;

        while (true) {
            System.out.println("\n--- Library Book Management System ---");
            System.out.println("1. Add New Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Book by ID");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    if (count < books.length) {
                        System.out.print("Enter Book ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Enter Book Title: ");
                        String title = sc.nextLine();
                        System.out.print("Enter Author Name: ");
                        String author = sc.nextLine();
                        books[count] = new Book(id, title, author);
                        count++;
                        System.out.println("Book added successfully!");
                    } else {
                        System.out.println("Library is full!");
                    }
                    break;

                case 2:
                    if (count == 0) {
                        System.out.println("No books in library.");
                    } else {
                        for (int i = 0; i < count; i++) {
                            books[i].displayBook();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Book ID to Search: ");
                    int searchId = sc.nextInt();
                    Book foundBook = findBook(books, count, searchId);
                    if (foundBook != null) {
                        foundBook.displayBook();
                    } else {
                        System.out.println("Book not found!");
                    }
                    break;

                case 4:
                    System.out.print("Enter Book ID to Issue: ");
                    int issueId = sc.nextInt();
                    Book issueBook = findBook(books, count, issueId);
                    if (issueBook != null) {
                        issueBook.issueBook();
                    } else {
                        System.out.println("Book not found!");
                    }
                    break;

                case 5:
                    System.out.print("Enter Book ID to Return: ");
                    int returnId = sc.nextInt();
                    Book returnBook = findBook(books, count, returnId);
                    if (returnBook != null) {
                        returnBook.returnBook();
                    } else {
                        System.out.println("Book not found!");
                    }
                    break;

                case 6:
                    System.out.println("Exiting system. Goodbye!");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    public static Book findBook(Book[] books, int count, int id) {
        for (int i = 0; i < count; i++) {
            if (books[i].bookId == id) {
                return books[i];
            }
        }
        return null;
    }
}
/*
Explanation
Book Class → Stores book ID, title, author, and issue status.

Array of Books → Holds up to 100 books in memory.

Menu System → Allows adding, viewing, searching, issuing, and returning books.

Validation → Prevents issuing already issued books and ensures only existing books can be returned.

findBook Method → Searches the array for a book by ID.

-------------------------------------------------------------------
*/