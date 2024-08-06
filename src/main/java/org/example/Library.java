package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Library {
    private List<Book> books;
    private List<User> users;

    public Library() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    // Methods to manage books
    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(String title) {
        books.removeIf(book -> book.getTitle().equalsIgnoreCase(title));
    }

    public List<Book> findBooksByYear(int year) {
        return books.stream().filter(book -> book.getPublicationYear() == year).collect(Collectors.toList());
    }

    public List<Book> findBooksByAuthor(String author) {
        return books.stream().filter(book -> book.getAuthor().equalsIgnoreCase(author)).collect(Collectors.toList());
    }

    public Book findBookWithMostPages() {
        return books.stream().max(Comparator.comparingInt(Book::getPages)).orElse(null);
    }

    public List<Book> findBooksMoreThanPages(int pages) {
        return books.stream().filter(book -> book.getPages() > pages).collect(Collectors.toList());
    }

    public List<String> getAllBookTitlesSorted() {
        return books.stream().map(Book::getTitle).sorted().collect(Collectors.toList());
    }

    public List<Book> findBooksByCategory(String category) {
        return books.stream().filter(book -> book.getCategory().equalsIgnoreCase(category)).collect(Collectors.toList());
    }

    // Methods to manage book loans
    public void loanBook(String title, User user) {
        books.stream().filter(book -> book.getTitle().equalsIgnoreCase(title) && !book.isOnLoan())
                .findFirst().ifPresent(book -> {
                    book.setOnLoan(true);
                    user.loanBook(book);
                });
    }

    public void returnBook(String title, User user) {
        books.stream().filter(book -> book.getTitle().equalsIgnoreCase(title) && book.isOnLoan())
                .findFirst().ifPresent(book -> {
                    book.setOnLoan(false);
                    user.returnBook(book);
                });
    }

    // Methods to manage users
    public void registerUser(User user) {
        users.add(user);
    }

    public User findUserByCardNumber(String cardNumber) {
        return users.stream().filter(user -> user.getLibraryCardNumber().equals(cardNumber)).findFirst().orElse(null);
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }
}

