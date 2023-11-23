package org.acharyaprashant.adapter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;

import org.acharyaprashant.R;
import org.acharyaprashant.model.Book;

import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {
    private List<Book> books;

    // Getter method for books list
    public List<Book> getBooks() {
        return books;
    }

    // Setter method for books list with notifyDataSetChanged call
    @SuppressLint("NotifyDataSetChanged")
    public void setBooks(List<Book> books) {
        this.books = books;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate the item_book layout for each item in the RecyclerView
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_book, parent, false);
        return new BookViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        if (books != null) {
            // Get the Book object at the current position
            Book currentBook = books.get(position);

            // Set title, subtitle, and price information in respective TextViews
            holder.tv_title.setText(currentBook.getTitle());
            holder.tv_subtitle.setText(currentBook.getSubtitle());

            // Display price information using HTML formatting in TextView
            if (currentBook.getOriginalAmount() > 0) {
                String htmlText = "Suggested donation: ₹" + currentBook.getAmount() + " ₹<strike>" + currentBook.getOriginalAmount() + "</strike>";
                holder.tv_price_tag.setText(Html.fromHtml(htmlText));
            } else if (currentBook.getAmount() > 0) {
                String text = "Suggested donation: ₹" + currentBook.getAmount();
                holder.tv_price_tag.setText(text);
            } else {
                holder.tv_price_tag.setText("Available for free");
            }

            // Load cover image using Glide into ImageView with rounded corners
            Glide.with(holder.itemView.getContext())
                    .load(currentBook.getCoverImage())
                    .transform(new RoundedCorners(20))
                    .placeholder(R.drawable.placeholder)
                    .error(R.drawable.placeholder)
                    .into(holder.iv_coverImage);
        }
    }

    @Override
    public int getItemCount() {
        return books != null ? books.size() : 0;
    }

    // ViewHolder class to hold the views of each item in the RecyclerView
    class BookViewHolder extends RecyclerView.ViewHolder {
        private final AppCompatTextView tv_title;
        private final AppCompatTextView tv_subtitle;
        private final AppCompatTextView tv_price_tag;
        private final AppCompatImageView iv_coverImage;

        public BookViewHolder(View itemView) {
            super(itemView);
            // Initialize TextViews and ImageView
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_subtitle = itemView.findViewById(R.id.tv_subtitle);
            tv_price_tag = itemView.findViewById(R.id.tv_price_tag);
            iv_coverImage = itemView.findViewById(R.id.iv_coverImage);

            // Set click listener to open the book's URL in a browser
            itemView.setOnClickListener(v -> {
                String url = getBooks().get(getAdapterPosition()).getPaperBookURL();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));

                // Verify if there's an app to handle this intent before starting the activity
                if (intent.resolveActivity(itemView.getContext().getPackageManager()) != null) {
                    itemView.getContext().startActivity(intent);
                } else {
                    // Handle case where there is no app available to handle the intent
                    // For example, show a message to the user
                    Toast.makeText(itemView.getContext(), "No application available to handle this action", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
