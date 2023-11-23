package org.acharyaprashant.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.acharyaprashant.R;
import org.acharyaprashant.adapter.BookAdapter;
import org.acharyaprashant.viewmodel.BookViewModel;

public class MainActivity extends AppCompatActivity {
    ProgressBar progressbar;
    AppCompatTextView tv_error_message;
    private RecyclerView recyclerView;
    private BookAdapter bookAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findIDS(); // Finding view IDs
        setupAppBar(); // Setting up the app bar
        setupAdapter(); // Setting up the RecyclerView adapter
        getBooksData(); // Fetching book data
    }

    // Method to find view IDs
    private void findIDS() {
        recyclerView = findViewById(R.id.recyclerView);
        progressbar = findViewById(R.id.progressbar);
        tv_error_message = findViewById(R.id.tv_error_message);
    }

    // Method to set up the app bar
    private void setupAppBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("Browse Books");
            actionBar.setElevation(0f);
        }
    }

    // Method to set up the RecyclerView adapter
    private void setupAdapter() {
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        bookAdapter = new BookAdapter();
        recyclerView.setAdapter(bookAdapter);
    }

    // Method to fetch book data using ViewModel
    private void getBooksData() {
        BookViewModel bookViewModel = new ViewModelProvider(this).get(BookViewModel.class);
        bookViewModel.getBooks().observe(this, bookResult -> {
            if (bookResult != null) {
                if (bookResult.isLoading()) {
                    // Show loading state (e.g., progress bar)
                    progressbar.setVisibility(View.VISIBLE);
                } else {
                    if (bookResult.getBooks() != null) {
                        // Process and set books in the adapter
                        bookAdapter.setBooks(bookResult.getBooks());
                    } else {
                        // Show error message if no books or an error occurred
                        tv_error_message.setText(bookResult.getErrorMessage());
                    }
                    progressbar.setVisibility(View.GONE);
                }
            }
        });
    }

    // Override to handle the Up button action in the app bar
    @Override
    public boolean onSupportNavigateUp() {
        ActivityCompat.finishAffinity(this);
        return true;
    }
}
