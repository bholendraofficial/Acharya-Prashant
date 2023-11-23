# Acharya Prashant Android Demo App

This Android application allows users to browse and view a collection of books available on the Acharya Prashant website.

## Description

This App fetches book data from the Acharya Prashant website's API and displays it in a user-friendly interface. Users can explore available books, view details, and check for additional information about each book.

# Code Structure

The code structure includes the following major components:

- **BookService**: Responsible for making API calls to fetch books using Retrofit.
- **RetrofitClient**: Manages a Retrofit instance to handle network operations.
- **BookRepository**: Handles data operations and interacts with BookService to fetch book data.
- **BookResult**: Model class representing the result of fetching books.
- **BookViewModel**: ViewModel class to manage and provide data to the UI.
- **MainActivity**: Main activity displaying a list of books fetched from the API.
- **BookAdapter**: RecyclerView adapter to display books in the MainActivity.

