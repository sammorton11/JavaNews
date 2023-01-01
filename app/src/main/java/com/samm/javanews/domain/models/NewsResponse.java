package com.samm.javanews.domain.models;

import java.util.List;

// Data Class
/*
    Todo:
        - Create properties and Serialize
        - Create a constructor and map the properties to the constructor args
        - Create getters and setters for each property
 */

public class NewsResponse {
    public String status;
    public int totalResults;
    public List<NewsItem> articles;
}

