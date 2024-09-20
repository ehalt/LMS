import com.library.Book;
import com.library.Member;
import com.library.Library;
import com.library.Transaction;

import java.util.Date;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Library library = new Library();
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
// Borrow and return books
        library.borrowBook(member1, "1984");
        library.returnBook(member1, "1984");
// Create and log a transaction
        Transaction transaction = new Transaction("T001",
                book1, member1, new Date());
        transaction.logTransaction();
        transaction.returnBook(new Date());
        transaction.logTransaction();
    }
}
