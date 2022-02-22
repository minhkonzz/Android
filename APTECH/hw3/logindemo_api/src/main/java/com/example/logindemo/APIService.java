package com.example.logindemo;

import com.google.gson.GsonBuilder;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface APIService {

    String BASE_URL = "https://62125676f43692c9c6e82f31.mockapi.io/api/m1/";

    APIService apis = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(
                    new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss")
                    .create()
            )).build()
            .create(APIService.class);

    @GET("students")
    Call<Student[]> getAllStudents();
}
