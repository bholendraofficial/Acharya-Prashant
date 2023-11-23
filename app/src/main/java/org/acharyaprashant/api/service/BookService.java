package org.acharyaprashant.api.service;

import org.acharyaprashant.api.model.Book;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BookService {
    @GET("api/v2/legacy/books")
    Call<List<Book>> getBooks();
}
