# Acharya Prashant Android Demo App

This Android application allows users to browse and view a collection of books available on the Acharya Prashant website.

## Description

This App fetches book data from the Acharya Prashant website's API and displays it in a user-friendly interface. Users can explore available books, view details, and check for additional information about each book.


![Sample Screenshot](https://github.com/bholendraofficial/Acharya-Prashant/assets/47040352/f10d3c9e-6e2f-40cc-bae6-643d8b44af0d)



https://github.com/bholendraofficial/Acharya-Prashant/assets/47040352/79023b73-fb5c-494c-9eb9-ac7da861d7a1

## Installation

To run this project locally, follow these steps:

1. Clone the repository to your local machine:

   ```bash
   git clone https://github.com/bholendraofficial/Acharya-Prashant.git
2. Open the project in Android Studio.
3. Build and run the project on an Android emulator or a physical device.

# Code Structure

The code structure includes the following major components:

- **BookService**: Responsible for making API calls to fetch books using Retrofit.
- **RetrofitClient**: Manages a Retrofit instance to handle network operations.
- **BookRepository**: Handles data operations and interacts with BookService to fetch book data.
- **BookResult**: Model class representing the result of fetching books.
- **BookViewModel**: ViewModel class to manage and provide data to the UI.
- **MainActivity**: Main activity displaying a list of books fetched from the API.
- **BookAdapter**: RecyclerView adapter to display books in the MainActivity.


# Gradle dependencies used in this project
```gradle
// Retrofit
implementation 'com.squareup.retrofit2:retrofit:2.9.0'
implementation 'com.squareup.retrofit2:converter-gson:2.9.0'

// ViewModel and LiveData (for MVVM)
implementation 'androidx.lifecycle:lifecycle-viewmodel:2.6.2'
implementation 'androidx.lifecycle:lifecycle-livedata:2.6.2'

// Glide
implementation 'com.github.bumptech.glide:glide:4.16.0'



