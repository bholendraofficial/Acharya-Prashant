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
    private BookViewModel bookViewModel;
    private RecyclerView recyclerView;
    private BookAdapter bookAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findIDS();
        setupAppBar();
        setupAdapter();
        bookViewModel = new ViewModelProvider(this).get(BookViewModel.class);

        bookViewModel.getBooks().observe(this, bookResult -> {
            if (bookResult != null) {
                if (bookResult.isLoading()) {
                    // Show loading state (e.g., progress bar)
                    progressbar.setVisibility(View.VISIBLE);
                } else {
                    if (bookResult.getBooks() != null) {
                        // Process and use bookResult.getBooks()
                        bookAdapter.setBooks(bookResult.getBooks());
                    } else {
                        // Handle error message (bookResult.getErrorMessage())
                        tv_error_message.setText(bookResult.getErrorMessage());
                    }
                    progressbar.setVisibility(View.GONE);
                }
            }
        });

    }

    private void setupAppBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("Browse Books");
            actionBar.setElevation(0f);
        }
    }


    @Override
    public boolean onSupportNavigateUp() {
        ActivityCompat.finishAffinity(this);
        return true;
    }

    private void setupAdapter() {
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        bookAdapter = new BookAdapter();
        recyclerView.setAdapter(bookAdapter);
    }

    private void findIDS() {
        recyclerView = findViewById(R.id.recyclerView);
        progressbar = findViewById(R.id.progressbar);
        tv_error_message = findViewById(R.id.tv_error_message);
    }
}