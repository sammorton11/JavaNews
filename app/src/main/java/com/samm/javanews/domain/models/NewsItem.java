package com.samm.javanews.domain.models;

import com.google.gson.annotations.SerializedName;

public class NewsItem {

    @SerializedName("author")
    private String author ;
    @SerializedName("title")
    private String title;
    @SerializedName("description")
    private String description;
    @SerializedName("publishedAt")
    private String publishedAt;
    @SerializedName("content")
    private String content;
    @SerializedName("url")
    private String url;
    @SerializedName("urlToImage") // changed this
    private String thumbnailUrl;

    public NewsItem(
            String author,
            String title,
            String publishedAt,
            String url,
            String thumbnailUrl
    ){
        this.author = author;
        this.title = title;
        this.publishedAt = publishedAt;
        this.url = url;
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getAuthor() {
        return author;
    }
    public String getTitle() {
        return title;
    }
    public String getUrl() {
        return url;
    }
    public String getThumbnailUrl() {
        return thumbnailUrl;
    }
    public String getPublishedAt() {return publishedAt;}

}
