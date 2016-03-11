package com.example.s4astya.book_app;

import android.content.Context;
import android.util.Log;


import com.example.s4astya.book_app.model.Book;

import java.util.ArrayList;

/**
 * Created by S4ASTYA on 09.03.2016.
 */
public class BookLab {

    private static final String TAG = "BookLab";
    private static final String FILENAME = "books.json";
    private ArrayList<Book> mBooks;
    private BookSerializer mSerializer;
    private static BookLab bookLab;
    private Context mAppContext;

    private BookLab(Context mAppContext) {
        this.mAppContext = mAppContext;
        mSerializer = new BookSerializer(mAppContext, FILENAME);
        try {
            mBooks = mSerializer.loadBooks();
        } catch (Exception e) {
            mBooks = new ArrayList<Book>();
            Log.e(TAG, "Error loading crimes: ", e);
        }
    }

    public static BookLab get(Context c) {
        if (bookLab == null) {
            bookLab = new BookLab(c.getApplicationContext());
        }
        return bookLab;
    }
    public ArrayList<Book> getBooks() {
        return mBooks;
    }


}
