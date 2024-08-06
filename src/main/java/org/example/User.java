package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String libraryCardNumber;
    private List<Book> loanedBooks;

    public User(String name, String libraryCardNumber) {
        this.name = name;
        this.libraryCardNumber = libraryCardNumber;
        this.loanedBooks = new ArrayList<>();
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public String getLibraryCardNumber() {
        return libraryCardNumber;
    }

    public List<Book> getLoanedBooks() {
        return loanedBooks;
    }

    public void loanBook(Book book) {
        loanedBooks.add(book);
    }

    public void returnBook(Book book) {
        loanedBooks.remove(book);
    }

    public double calculateLateFees() {
        double lateFees = 0.0;
        for (Book book : loanedBooks) {
            if (book.isOnLoan() && book.getLoanDate() != null) {
                long daysOnLoan = java.time.temporal.ChronoUnit.DAYS.between(book.getLoanDate(), LocalDate.now());
                if (daysOnLoan > 14) {
                    lateFees += (daysOnLoan - 14) * 0.5; // $0.5 per day late fee
                }
            }
        }
        return lateFees;
    }
}

