package com.library;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private String memberID;
    private String name;
    private String contactInfo;
    private List<Book> borrowedBooks;

    public Member(String memberID, String name, String contactInfo) {
        this.memberID = memberID;
        this.name = name;
        this.contactInfo = contactInfo;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getMemberID() {
        return memberID;
    }

    public String getName() {
        return name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(Book book) {
        if (book.isAvailable()) {
            borrowedBooks.add(book);
            book.setAvailable(false);
            System.out.println(name + " borrowed " +
                    book.getTitle());
        } else {
            System.out.println("The book is not available.");
        }
    }

    public void returnBook(Book book) {
        if (borrowedBooks.remove(book)) {
            book.setAvailable(true);
            System.out.println(name + " returned " +
                    book.getTitle());
        } else {
            System.out.println(name + " did not borrow this book.");
        }
    }

    public void updateMemberInfo(String newName, String newContactInfo) {
        this.name = newName;
        this.contactInfo = newContactInfo;
        System.out.println("Member info updated: " + newName + ", " + newContactInfo);
    }

    public void listBorrowedBooks() {
        if (borrowedBooks.isEmpty()) {
            System.out.println(name + " has not borrowed any books.");
            return;
        }
        System.out.println(name + "'s borrowed books:");
        for (Book book : borrowedBooks) {
            System.out.println("- " + book.getTitle());
        }
    }
}

