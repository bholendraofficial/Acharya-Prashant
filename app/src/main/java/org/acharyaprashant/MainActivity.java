package org.acharyaprashant;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.acharyaprashant.adapter.BookAdapter;
import org.acharyaprashant.api.model.Book;
import org.acharyaprashant.api.viewmodel.BookViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private BookViewModel bookViewModel;
    private RecyclerView recyclerView;
    private BookAdapter bookAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findIDS();
        setupAdapter();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Browse Books");
        getSupportActionBar().setElevation(0f);
        bookViewModel = new ViewModelProvider(this).get(BookViewModel.class);
        bookViewModel.getBooksLiveData().observe(this, new Observer<List<Book>>() {
            @Override
            public void onChanged(List<Book> books) {
                // Update UI with the list of books
                bookAdapter.setBooks(books);
            }
        });
    }
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    private void setupAdapter() {
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        bookAdapter = new BookAdapter();
        recyclerView.setAdapter(bookAdapter);
    }

    private void findIDS() {
        recyclerView = findViewById(R.id.recyclerView);
    }
}