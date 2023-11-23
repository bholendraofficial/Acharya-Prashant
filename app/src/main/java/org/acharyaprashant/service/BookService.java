package org.acharyaprashant.service;

import org.acharyaprashant.model.Book;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

// Interface defining the BookService for API calls using Retrofit
public interface BookService {

    // GET request to fetch a list of books from the specified endpoint
    @GET("api/v2/legacy/books")
    Call<List<Book>> getBooks();
}
