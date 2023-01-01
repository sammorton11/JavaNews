package com.samm.javanews.domain;

import android.app.ProgressDialog;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.samm.javanews.data.Repository;

//public class NewsViewModelFactory implements ViewModelProvider.Factory {
//    Context context;
//    ProgressDialog progressDialog;
//
//    public NewsViewModelFactory(
//            Context context,
//            ProgressDialog progressDialog
//    ) {
//        this.context = context;
//        this.progressDialog = progressDialog;
//    }
//
//    @NonNull
//    @Override
//    public <T extends ViewModel> T create(Class<T> modelClass) {
//        if (modelClass.isAssignableFrom(NewsViewModel.class)) {
//            return (T) new NewsViewModel(
//                    context,
//                    progressDialog
//            );
//        }
//        throw new IllegalArgumentException("Unknown ViewModel class");
//    }
//}


public class NewsViewModelFactory extends ViewModelProvider.NewInstanceFactory {
//    ProgressDialog progressDialog;
//    Context context;

    public NewsViewModelFactory(Context context, ProgressDialog progressDialog) {
//        this.progressDialog = progressDialog;
//        this.context=context;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        //noinspection unchecked
        return (T) new NewsViewModel();
    }
}