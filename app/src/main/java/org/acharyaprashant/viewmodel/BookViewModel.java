package org.acharyaprashant.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import org.acharyaprashant.model.BookResult;
import org.acharyaprashant.repository.BookRepository;

public class BookViewModel extends ViewModel {
    private final BookRepository bookRepository;
    private MutableLiveData<BookResult> bookResultLiveData;

    public BookViewModel() {
        bookRepository = new BookRepository();
        bookResultLiveData = new MutableLiveData<>();
    }

    public MutableLiveData<BookResult> getBooks() {
        bookResultLiveData = bookRepository.getBooks();
        return bookResultLiveData;
    }
}
