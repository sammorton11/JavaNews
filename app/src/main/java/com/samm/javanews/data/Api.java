package com.samm.javanews.data;

import com.samm.javanews.domain.models.NewsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    @GET("/v2/everything")
    Call<NewsResponse> getAllPhotos(
            @Query("q")
            String query,
            @Query("page")
            int pageNumber,
            @Query("apiKey")
            String apiKey
    );
}
