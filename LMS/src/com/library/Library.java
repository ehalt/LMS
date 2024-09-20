package com.library;

import java.util.ArrayList;
import java.util.HashMap;

public class Library {
    private ArrayList<Book> bookInventory;
    private HashMap<String, Member> members;
    public Library() {
        this.bookInventory = new ArrayList<>();
        this.members = new HashMap<>();
    }

    public void addBook(Book book) {
        bookInventory.add(book);
        System.out.println("Book added: " + book.getTitle());
    }

    public void removeBook(Book book) {
        if (bookInventory.remove(book)) {
            System.out.println("Book removed: " +
                    book.getTitle());
        } else {
            System.out.println("Book not found in inventory.");
        }
    }
    public void addMember(Member member) {
        members.put(member.getMemberID(), member);
        System.out.println("Member added: " + member.getName());
    }

    public void removeMember(Member member) {
        if (members.remove(member.getMemberID()) != null) {
            System.out.println("Member removed: " +
                    member.getName());
        } else {
            System.out.println("Member not found.");
        }
    }

    public Book searchBookByTitle(String title) {
        for (Book book : bookInventory) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public void borrowBook(Member member, String bookTitle) {
        Book book = searchBookByTitle(bookTitle);
        if (book != null && book.isAvailable()) {
            member.borrowBook(book);
        } else {
            System.out.println("Book is not available.");
        }
    }
    public void returnBook(Member member, String bookTitle) {
        Book book = searchBookByTitle(bookTitle);
        if (book != null) {
            member.returnBook(book);
        } else {
            System.out.println("Book not found in inventory.");
        }
    }

}
