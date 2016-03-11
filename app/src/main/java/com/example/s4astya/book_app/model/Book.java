package com.example.s4astya.book_app.model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by S4ASTYA on 02.03.2016.
 */
public class Book {

    private static final String JSON_TITLE = "title";
    private static final String JSON_AUTHOR = "author";
    private static final String JSON_GENRE = "genre";
    private static final String JSON_COUNTRY = "country";
    private static final String JSON_YEAR = "year";

    private String title;
    private String author;
    private String genre;
    private String country;
    private String year;

    public Book()
    {}

    public Book(String title, String author, String genre, String country, String year) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.country = country;
        this.year = year;
    }
    public Book(JSONObject json) throws JSONException {
        title = json.getString(JSON_TITLE);
        author = json.getString(JSON_AUTHOR);
        genre = json.getString(JSON_GENRE);
        country = json.getString(JSON_COUNTRY);
        year =json.getString(JSON_YEAR);
    }
    public JSONObject toJSON() throws JSONException
    {
       JSONObject jsonObject = new JSONObject();
        jsonObject.put(JSON_TITLE,title);
        jsonObject.put(JSON_AUTHOR,author);
        jsonObject.put(JSON_GENRE,genre);
        jsonObject.put(JSON_COUNTRY,country);
        jsonObject.put(JSON_YEAR,year);
        return  jsonObject;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
