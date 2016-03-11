package com.example.s4astya.book_app;

import android.content.Context;

import com.example.s4astya.book_app.model.Book;

import org.json.*;

import java.io.*;
import java.util.ArrayList;


/**
 * Created by S4ASTYA on 09.03.2016.
 */
public class BookSerializer {

    private Context mContext;
    private String mFilename;
    ArrayList<Book> books = null;
    JSONArray array = new JSONArray();
    public int size;

    public BookSerializer(Context c, String f) {
        mContext = c;
        mFilename = f;
    }
    public void saveBook(Book book) throws JSONException, IOException
    {
        array.put(book.toJSON());
        Writer writer = null;
        try {
            OutputStream out = mContext
                    .openFileOutput(mFilename, Context.MODE_PRIVATE);
            writer = new OutputStreamWriter(out);
            writer.write(array.toString());
        } finally {
            size =array.length();
            if (writer != null)
                writer.close();
        }
    }
    public String sizeE()
    {
        return String.valueOf(size);
    }
    public ArrayList<Book> loadBooks() throws IOException, JSONException {

        BufferedReader reader = null;
        books = new ArrayList();
        try {
            FileInputStream in = mContext.openFileInput(mFilename);
            reader = new BufferedReader(new InputStreamReader(in));
            StringBuilder jsonString = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                jsonString.append(line);
            }

            JSONArray array = (JSONArray) new JSONTokener(jsonString.toString()).nextValue();
            for (int i = 0; i < array.length(); i++) {
                books.add(new Book(array.getJSONObject(i)));
            }
        } catch (FileNotFoundException e) {

        } finally {
            if (reader != null) {
                reader.close();
            }
        }
        return books;
    }
    public String[] getTitles() throws IOException, JSONException {

        String[] titles = new String[books.size()];
        for(int i = 0;i<titles.length;i++)
        {
            titles[i]=books.get(i).getTitle();
        }
        return titles;
    }
    public Book getBook(String title)
    {
        for(Book b : books)
        {
            if(b.getTitle().equals(title))
                return b;
        }
        return null;
    }
}
