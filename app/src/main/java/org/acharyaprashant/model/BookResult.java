package org.acharyaprashant.model;

import java.util.List;

public class BookResult {
    private boolean isLoading;
    private List<Book> books;
    private String errorMessage;

    public BookResult(boolean isLoading, List<Book> books, String errorMessage) {
        this.isLoading = isLoading;
        this.books = books;
        this.errorMessage = errorMessage;
    }

    public boolean isLoading() {
        return isLoading;
    }

    public void setLoading(boolean loading) {
        isLoading = loading;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
