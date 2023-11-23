/*
 * Copyright (c) 2023. Bholendra Singh
 */

package org.acharyaprashant.repository;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import org.acharyaprashant.model.Book;
import org.acharyaprashant.model.BookResult;
import org.acharyaprashant.service.BookService;
import org.acharyaprashant.service.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

// Repository class responsible for handling data operations
public class BookRepository {
    private final BookService bookService;

    // Constructor initializing the BookService using RetrofitClient
    public BookRepository() {
        bookService = RetrofitClient.getInstance().create(BookService.class);
    }

    // Method to fetch books data and return as MutableLiveData
    public MutableLiveData<BookResult> getBooks() {
        MutableLiveData<BookResult> bookResultLiveData = new MutableLiveData<>();

        // Enqueue network request to fetch books list
        bookService.getBooks().enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(@NonNull Call<List<Book>> call, @NonNull Response<List<Book>> response) {
                BookResult bookResult;
                if (response.isSuccessful()) {
                    // If successful response, set the result with fetched books
                    bookResult = new BookResult(false, response.body(), null);
                } else {
                    // If unsuccessful response, set error message
                    bookResult = new BookResult(false, null, "Failed to fetch books. Please try again.");
                }
                bookResultLiveData.setValue(bookResult); // Set LiveData value with the result
            }

            @Override
            public void onFailure(@NonNull Call<List<Book>> call, @NonNull Throwable t) {
                // Handle network failures and set appropriate error message
                BookResult bookResult = new BookResult(false, null, "Network error. Please check your connection.");
                bookResultLiveData.setValue(bookResult); // Set LiveData value with the result
            }
        });

        return bookResultLiveData; // Return LiveData for observing changes in UI
    }
}
