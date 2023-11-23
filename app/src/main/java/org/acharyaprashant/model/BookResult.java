package org.acharyaprashant.model;

import java.util.List;

// Model class representing the result of fetching books
public class BookResult {
    private final boolean isLoading; // Indicates if the data is in a loading state
    private final List<Book> books; // List of books
    private final String errorMessage; // Error message, if any

    // Constructor to initialize BookResult with loading state, books, and error message
    public BookResult(boolean isLoading, List<Book> books, String errorMessage) {
        this.isLoading = isLoading;
        this.books = books;
        this.errorMessage = errorMessage;
    }

    // Method to check if the data is in a loading state
    public boolean isLoading() {
        return isLoading;
    }

    // Method to retrieve the list of books
    public List<Book> getBooks() {
        return books;
    }

    // Method to retrieve the error message
    public String getErrorMessage() {
        return errorMessage;
    }
}
