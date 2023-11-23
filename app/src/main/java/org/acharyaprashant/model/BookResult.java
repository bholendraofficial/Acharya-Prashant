package org.acharyaprashant.model;

import java.util.List;

public class BookResult {
    private final boolean isLoading;
    private final List<Book> books;
    private final String errorMessage;

    public BookResult(boolean isLoading, List<Book> books, String errorMessage) {
        this.isLoading = isLoading;
        this.books = books;
        this.errorMessage = errorMessage;
    }

    public boolean isLoading() {
        return isLoading;
    }

    public List<Book> getBooks() {
        return books;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
