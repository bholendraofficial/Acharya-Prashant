package org.acharyaprashant.api.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import org.acharyaprashant.api.model.Book;
import org.acharyaprashant.api.service.BookService;
import org.acharyaprashant.api.service.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BookViewModel extends ViewModel {
    private MutableLiveData<List<Book>> booksLiveData;
    private BookService bookService;

    public BookViewModel() {
        booksLiveData = new MutableLiveData<>();
        bookService = RetrofitClient.getInstance().create(BookService.class);
        fetchBooks();
    }

    public MutableLiveData<List<Book>> getBooksLiveData() {
        return booksLiveData;
    }

    private void fetchBooks() {
        Call<List<Book>> call = bookService.getBooks();
        call.enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(@NonNull Call<List<Book>> call, Response<List<Book>> response) {
                if (response.isSuccessful()) {
                    booksLiveData.setValue(response.body());
                } else {
                    // Handle error
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Book>> call, @NonNull Throwable t) {
                // Handle failure
            }
        });
    }
}
