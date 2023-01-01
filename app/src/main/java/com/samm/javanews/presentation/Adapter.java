package com.samm.javanews.presentation;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.samm.javanews.R;
import com.samm.javanews.domain.models.NewsItem;
import com.samm.javanews.util.Converters;
import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.util.List;
import java.util.Objects;

public class Adapter extends RecyclerView.Adapter<Adapter.CustomViewHolder> {

    private final List<NewsItem> dataList;
    private final Context context;

    public Adapter(Context context, List<NewsItem> dataList ){
        this.context = context;
        this.dataList = dataList;
    }

    static class CustomViewHolder extends RecyclerView.ViewHolder {

        public final View mView;
        public final TextView txtTitle;
        private final ImageView coverImage;
        private final CardView cardView;
        private final TextView publishedAt;

        CustomViewHolder(View itemView) {
            super(itemView);
            mView = itemView;

            txtTitle = mView.findViewById(R.id.title);
            coverImage = mView.findViewById(R.id.imageView);
            cardView = mView.findViewById(R.id.news_card);
            publishedAt = mView.findViewById(R.id.published_at);
        }
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.custom_row, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        NewsItem item = dataList.get(position);
        String formattedDated = null;
        try {
            formattedDated = Converters.formatDate(item.getPublishedAt());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Log.d("DATE", item.getPublishedAt());
        holder.txtTitle.setText(item.getTitle());
        holder.publishedAt.setText(formattedDated);

        Picasso.Builder builder = new Picasso.Builder(context);
        builder.downloader(new OkHttp3Downloader(context));
        builder.build().load(item.getThumbnailUrl())
                .fit()
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_stat_name)
                .into(holder.coverImage);

        /*
            Open the Web View screen
         */
        holder.cardView.setOnClickListener(view -> openWebView(view, item.getUrl()));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    private void openWebView(View view, String url) {
        AppCompatActivity activity = (AppCompatActivity) view.getContext();
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        activity.startActivity(intent);
    }
}
