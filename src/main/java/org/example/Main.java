package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        // Adding books to the library
        library.addBook(new Book("Book One", "Author A", 2020, 300, "Fiction"));
        library.addBook(new Book("Book Two", "Author B", 2019, 150, "Non-Fiction"));
        library.addBook(new Book("Book Three", "Author A", 2021, 450, "Science"));

        // Registering users
        User user1 = new User("John Doe", "12345");
        library.registerUser(user1);

        // Loaning a book to a user
        library.loanBook("Book One", user1);

        // Finding books by author
        List<Book> booksByAuthorA = library.findBooksByAuthor("Author A");
        booksByAuthorA.forEach(book -> System.out.println(book.getTitle()));

        // Calculating late fees (simulate delay by changing the system date or using test data)
        double lateFees = user1.calculateLateFees();
        System.out.println("Late Fees: $" + lateFees);
    }
}
