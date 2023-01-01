package com.samm.javanews;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.samm.javanews.domain.NewsViewModel;
import com.samm.javanews.domain.models.NewsItem;
import com.samm.javanews.presentation.Adapter;
import com.samm.javanews.util.ViewHider;

import java.util.List;

/*
    Todo:
        - Back to top FAB
        - WebView Fragment when clicked - not chrome
        - Change the Image when error to an image that says error or something
        - Date not displayed when title is too long
        - Sort the list
        - Create Github Repository
 */

public class MainActivity extends AppCompatActivity {

    private ProgressDialog progressDialog;
    private EditText searchField;
    private RecyclerView recyclerView;
    private LinearLayout searchBar;
    private NewsViewModel viewModel;
    private FloatingActionButton backToTop;
    private ImageButton searchButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchField = (EditText) findViewById(R.id.search_field);
        recyclerView = findViewById(R.id.recyclerview);
        searchBar = findViewById(R.id.search_bar);
        viewModel = new ViewModelProvider(this).get(NewsViewModel.class);
        backToTop = findViewById(R.id.back_to_top_button);
        searchButton = findViewById(R.id.search_button);

        searchButton.setOnClickListener( v -> {
            String searchText = searchField.getText().toString();
            createProgressDialog();
            observer(searchText);
            ViewHider.hideKeyboard(this);
        });

        backToTop.setOnClickListener( v-> {
            recyclerView.smoothScrollToPosition(0);
        });
    }

    private void observer(String search){
        viewModel.getData(search, progressDialog).observe(this, list -> {
            if (list.isEmpty()){
                progressDialog.dismiss();
            }
            else {
                progressDialog.dismiss();
                generateDataList(list);
            }
        });
    }
    private void generateDataList(List<NewsItem> photoList) {

        List<NewsItem> newList = NewsViewModel.removeDuplicates(photoList);
        Adapter adapter = new Adapter(this, newList);
        RecyclerView.LayoutManager layoutManager =
                new LinearLayoutManager(MainActivity.this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        ViewHider.hideViewsWhenScrolled(recyclerView, searchBar);
    }

    private void createProgressDialog(){
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Loading....");
        progressDialog.show();
    }
}

