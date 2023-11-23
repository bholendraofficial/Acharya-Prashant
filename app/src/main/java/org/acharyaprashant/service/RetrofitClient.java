package org.acharyaprashant.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

// Singleton class to create and manage a Retrofit instance
public class RetrofitClient {
    private static final String BASE_URL = "https://acharyaprashant.org/";
    private static Retrofit retrofit;

    // Method to get or create a Retrofit instance
    public static Retrofit getInstance() {
        if (retrofit == null) {
            // Create a Retrofit instance with specified base URL and Gson converter
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit; // Return the Retrofit instance
    }
}
