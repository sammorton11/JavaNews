package com.samm.javanews.util;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Objects;


// Make this more reusable
public class ViewHider {

    public static void hideViewsWhenScrolled(
            RecyclerView recyclerView,
            View view
    ) {
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                // Get the first visible item position
                int firstVisibleItemPosition = ((LinearLayoutManager)
                        Objects.requireNonNull(recyclerView.getLayoutManager()))
                        .findFirstVisibleItemPosition();

                // Check if the first visible item is the first item in the list
                if (firstVisibleItemPosition == 0) {
                    view.setVisibility(View.VISIBLE);
                } else {
                    view.setVisibility(View.GONE);
                }
            }
        });
    }

    public static void hideKeyboard(Activity activity) {
        View view = activity.getCurrentFocus();
        if (view != null) {
            InputMethodManager inputManager = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            inputManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}

