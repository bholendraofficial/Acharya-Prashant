package org.acharyaprashant.service;

import org.acharyaprashant.model.Book;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BookService {
    @GET("api/v2/legacy/books")
    Call<List<Book>> getBooks();
}
