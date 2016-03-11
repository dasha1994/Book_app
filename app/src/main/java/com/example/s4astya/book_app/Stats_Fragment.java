package com.example.s4astya.book_app;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


import com.example.s4astya.book_app.model.Book;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by S4ASTYA on 26.02.2016.
 */
public class Stats_Fragment extends Fragment {

    View rootView;
    Button btn;
    EditText editText;
    TextView textView2;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.stats_layout,null);
        btn = (Button)rootView.findViewById(R.id.button);
        editText = (EditText)rootView.findViewById(R.id.editText);
        textView2 = (TextView) rootView.findViewById(R.id.textView2);
        View.OnClickListener ol = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn.setText("Pressed");
            }
        };
        btn.setOnClickListener(ol);
        BookSerializer bookSerializer = new BookSerializer(this.getContext(),"crimes.json");
        try {
           ArrayList<Book> books = bookSerializer.loadBooks();
            textView2.setText(books.get(0).getTitle());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return rootView;
    }
}

