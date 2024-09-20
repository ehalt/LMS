import com.library.Book;
import com.library.Member;
import com.library.Library;
import com.library.Transaction;

import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        // Add some books
        Book book1 = new Book("B001", "1984", "George Orwell", "Fiction", true);
        Book book2 = new Book("B002", "To Kill a Mockingbird", "Harper Lee", "Fiction", true);
        library.addBook(book1);
        library.addBook(book2);

        // Add some members
        Member member1 = new Member("M001", "Alice Johnson", "alice@example.com");
        Member member2 = new Member("M002", "Bob Smith", "bob@example.com");
        library.addMember(member1);
        library.addMember(member2);

        String command = "";
        while (!command.equals("exit")) {
            System.out.println("Enter command: addbook, addmember, borrow, return, listbooks, exit");
            command = scanner.nextLine();

            switch (command.toLowerCase()) {
                case "addbook":
                    System.out.println("Enter book ID, title, author, category:");
                    String bookID = scanner.nextLine();
                    String title = scanner.nextLine();
                    String author = scanner.nextLine();
                    String category = scanner.nextLine();
                    Book newBook = new Book(bookID, title, author, category, true);
                    library.addBook(newBook);
                    break;

                case "addmember":
                    System.out.println("Enter member ID, name, contact info:");
                    String memberID = scanner.nextLine();
                    String name = scanner.nextLine();
                    String contact = scanner.nextLine();
                    Member newMember = new Member(memberID, name, contact);
                    library.addMember(newMember);
                    break;

                case "borrow":
                    System.out.println("Enter member ID and book title:");
                    memberID = scanner.nextLine();
                    title = scanner.nextLine();
                    Member member = library.members.get(memberID);
                    if (member != null) {
                        library.borrowBook(member, title);
                    } else {
                        System.out.println("Member not found.");
                    }
                    break;

                case "return":
                    System.out.println("Enter member ID and book title:");
                    memberID = scanner.nextLine();
                    title = scanner.nextLine();
                    member = library.members.get(memberID);
                    if (member != null) {
                        library.returnBook(member, title);
                    } else {
                        System.out.println("Member not found.");
                    }
                    break;

                case "listbooks":
                    Book.ListBooks();
                    break;

                default:
                    if (!command.equals("exit")) {
                        System.out.println("Invalid command.");
                    }
                    break;
            }
            System.out.println();
        }
        scanner.close();
    }
}
