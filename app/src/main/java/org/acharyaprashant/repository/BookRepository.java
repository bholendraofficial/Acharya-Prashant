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

public class BookRepository {
    private final BookService bookService;

    public BookRepository() {
        bookService = RetrofitClient.getInstance().create(BookService.class);
    }

    public MutableLiveData<BookResult> getBooks() {
        MutableLiveData<BookResult> bookResultLiveData = new MutableLiveData<>();

        bookService.getBooks().enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(@NonNull Call<List<Book>> call, Response<List<Book>> response) {
                if (response.isSuccessful()) {
                    BookResult bookResult = new BookResult(false, response.body(), null);
                    bookResultLiveData.setValue(bookResult);
                } else {
                    BookResult bookResult = new BookResult(false, null, "Failed to fetch books. Please try again.");
                    bookResultLiveData.setValue(bookResult);
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Book>> call, @NonNull Throwable t) {
                // Handle network failures
                BookResult bookResult = new BookResult(false, null, "Network error. Please check your connection.");
                bookResultLiveData.setValue(bookResult);
            }
        });

        return bookResultLiveData;
    }
}
