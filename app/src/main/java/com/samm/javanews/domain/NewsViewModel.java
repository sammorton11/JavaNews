package com.samm.javanews.domain;

import android.app.ProgressDialog;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.samm.javanews.data.Repository;
import com.samm.javanews.domain.models.NewsItem;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NewsViewModel extends ViewModel {

    Repository newsRepository = new Repository();

    public MutableLiveData<List<NewsItem>> getData(String search, ProgressDialog progressDialog) {
        return this.newsRepository.getDataList(search, progressDialog);
    }

    // Move this to the view model or something
    public static List<NewsItem> removeDuplicates(List<NewsItem> list){
        Set<NewsItem> newsItemSet = new HashSet<>(list);
        return new ArrayList<>(newsItemSet);
    }

}
