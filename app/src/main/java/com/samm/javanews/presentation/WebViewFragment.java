package com.samm.javanews.presentation;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.samm.javanews.R;

public class WebViewFragment extends Fragment {

    private static final String ARG_PARAM1 = "arg_url";
    private String mParam1;

    public WebViewFragment() {
        // Required empty public constructor
    }

    public static WebViewFragment newInstance(String url) {
        WebViewFragment fragment = new WebViewFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, url);
        fragment.setArguments(args);
        fragment.mParam1 = url;
        Log.d("URL", url);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {

        View view = inflater.inflate(R.layout.fragment_web_view, container, false);
        WebView webView = view.findViewById(R.id.web_view);
        String url = mParam1;
        webView.loadUrl(url);

        // Inflate the layout for this fragment
        return view;
    }
}