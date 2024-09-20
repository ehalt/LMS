package com.library;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private String bookID;
    private String title;
    private String author;
    private String category;
    private boolean isAvailable;

    private static List<Book> bookCollection = new ArrayList<>();

    public Book(String bookID, String title, String author, String category, boolean isAvailable) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.category = category;
        this.isAvailable = true;
    }
    public String getBookID() {
        return bookID;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public void addBook() {
        bookCollection.add(this);
        System.out.println("Book added: " + this.title);
    }

    public void removeBook(String bookID) {
        for (Book book : bookCollection) {
            if (book.getBookID().equals(bookID)) {
                bookCollection.remove(book);
                System.out.println("Book removed: " + this.title);
                return;
            }
        }
        System.out.println("Book with ID " + bookID + " not found");
    }

    public void updateBook(String title, String author, String category) {
        this.title = title;
        this.author = author;
        this.category = category;
        System.out.println("Book updated: " + this.title);
    }

    public static void ListBooks() {
        if (bookCollection.isEmpty()) {
            System.out.println("No books in the collection");
            return;
        }
        for (Book book: bookCollection) {
            System.out.println("ID: " + book.getBookID() +
                    ", Title: " + book.getTitle() +
                    ", Author: " + book.getAuthor() +
                    ", Available: " + book.isAvailable());
        }
    }
}
