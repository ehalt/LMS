package com.library;

import java.util.Date;

public class Transaction {
    private String transactionID;
    private Book book;
    private Member member;
    private Date borrowDate;
    private Date returnDate;
    public Transaction(String transactionID, Book book, Member
            member, Date borrowDate) {
        this.transactionID = transactionID;
        this.book = book;
        this.member = member;
        this.borrowDate = borrowDate;
        this.returnDate = null;
    }
    public void logTransaction() {
        System.out.println("Transaction ID: " + transactionID);
        System.out.println("Book: " + book.getTitle());
        System.out.println("Member: " + member.getName());
        System.out.println("Borrow Date: " + borrowDate);
        if (returnDate != null) {
            System.out.println("Return Date: " + returnDate);
        } else {
            System.out.println("Book not yet returned.");
        }
    }
    public void returnBook(Date returnDate) {
        this.returnDate = returnDate;
    }
}