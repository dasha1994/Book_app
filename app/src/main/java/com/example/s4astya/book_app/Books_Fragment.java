package com.example.s4astya.book_app;
import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.s4astya.book_app.model.Book;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by S4ASTYA on 26.02.2016.
 */
public class Books_Fragment extends android.support.v4.app.ListFragment {


    View myView;
    String[] array;
    BookSerializer bookSerializer;
    ArrayList<Book> books;
/*
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        myView = inflater.inflate(R.layout.book_layout,null);

        return myView;
    }
*/
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        bookSerializer = new BookSerializer(this.getContext(),"books.json");
        try {
            books = bookSerializer.loadBooks();
            array = bookSerializer.getTitles();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        setListAdapter(new ArrayAdapter<String>(getActivity(), R.layout.list_item,
                array));
             //   getResources().getStringArray(R.array.sports_array)));

        ListView lv = getListView();

        // Enable filtering when the user types in the virtual keyboard
        lv.setTextFilterEnabled(true);

        // Set an setOnItemClickListener on the ListView
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                String itemTitle = (String) ((TextView)view).getText();
                builder.setTitle(itemTitle);
                DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                };
                builder.setItems(dialogArray(itemTitle),onClickListener);
                builder.setCancelable(false);

                builder.setPositiveButton(R.string.close, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                AlertDialog resetDialog = builder.create();
                resetDialog.show();
            }
        });
    }
    public String[] dialogArray(String title)
    {
        Book book = bookSerializer.getBook(title);
        String[] array = new String[5];
        array[0]="Название: "+book.getTitle();
        array[1]="Автор: "+book.getAuthor();
        array[2]="Жанр: "+book.getGenre();
        array[3]="Страна: "+book.getCountry();
        array[4]="Год: "+book.getYear();
        return array;
    }
}
