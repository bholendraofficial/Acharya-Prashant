package org.acharyaprashant.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import org.acharyaprashant.model.BookResult;
import org.acharyaprashant.repository.BookRepository;

public class BookViewModel extends ViewModel {
    private final BookRepository bookRepository;
    private MutableLiveData<BookResult> bookResultLiveData;

    // Constructor initializing BookRepository and MutableLiveData
    public BookViewModel() {
        bookRepository = new BookRepository();
        bookResultLiveData = new MutableLiveData<>();
    }

    // Method to get books LiveData from the repository
    public MutableLiveData<BookResult> getBooks() {
        // Fetch books data from the repository
        bookResultLiveData = bookRepository.getBooks();
        return bookResultLiveData; // Return LiveData to observe changes
    }
}
