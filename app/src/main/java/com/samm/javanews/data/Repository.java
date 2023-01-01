package com.samm.javanews.data;

import static com.samm.javanews.util.Constants.API_KEY;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.samm.javanews.domain.models.NewsItem;
import com.samm.javanews.domain.models.NewsResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {

    public MutableLiveData<List<NewsItem>> getDataList(
            String searchText
    ){
        Api service = RetrofitClientInstance.getRetrofitInstance().create(Api.class);

        // API Call
        Call<NewsResponse> call = service.getAllPhotos(
                searchText, 1, API_KEY);
        final MutableLiveData<List<NewsItem>> newsItems = new MutableLiveData<>();
        // API CallBack
        call.enqueue(new Callback<NewsResponse>() {

            // When SUCCESS
            @Override
            public void onResponse
            (@NonNull Call<NewsResponse> call, @NonNull Response<NewsResponse> response)
            {
                assert response.body() != null;
                newsItems.setValue(response.body().articles);
            }

            // When ERROR
            @Override
            public void onFailure
            (@NonNull Call<NewsResponse> call, @NonNull Throwable t)
            {
                newsItems.setValue(null);
                Log.d("ERROR", t.toString());
            }
        });

        return newsItems;
    }
}
