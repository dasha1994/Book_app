package com.example.s4astya.book_app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.*;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.s4astya.book_app.model.Book;


/**
 * Created by S4ASTYA on 09.03.2016.
 */
public class Add_book_Fragment extends android.support.v4.app.Fragment {

    View myView;
    EditText editTitle;
    EditText editAuthor;
    EditText editGenre;
    EditText editCountry;
    EditText editYear;

    Button save;
    Button cancel;

    BookSerializer bookSerializer;
    private static final String FILENAME = "books.json";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        myView = inflater.inflate(R.layout.add_book, null);
        bookSerializer = new BookSerializer(this.getContext(),FILENAME);
        editTitle = (EditText)myView.findViewById(R.id.editTitle);
        editAuthor =(EditText)myView.findViewById(R.id.editAuthor);
        editGenre = (EditText)myView.findViewById(R.id.editGenre);
        editCountry = (EditText)myView.findViewById(R.id.editCountry);
        editYear = (EditText)myView.findViewById(R.id.editYear);

        save = (Button) myView.findViewById(R.id.btnSave);
        cancel = (Button) myView.findViewById(R.id.btnCancel);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btnSave :
                           if(saveBook(objBook()))
                           Toast.makeText(getContext(), "Saved",
                                   Toast.LENGTH_LONG).show();
                           else
                               Toast.makeText(getContext(), "Failed",
                                       Toast.LENGTH_LONG).show();
                    case R.id.btnCancel :
                            clearFields();
                }
            }
        };
        save.setOnClickListener(listener);
        return myView;
    }

    public void clearFields()
    {
        editTitle.setText("");
        editAuthor.setText("");
        editGenre.setText("");
        editCountry.setText("");
        editYear.setText("");
    }
    public Book objBook()
    {
            Book newBook = new Book();
            newBook.setTitle(String.valueOf(editTitle.getText()));
            newBook.setAuthor(String.valueOf(editAuthor.getText()));
            newBook.setGenre(String.valueOf(editGenre.getText()));
            newBook.setCountry(String.valueOf(editCountry.getText()));
            newBook.setYear(String.valueOf(editYear.getText()));
            return newBook;
    }
    public boolean saveBook(Book b)
    {
        try {
            bookSerializer.saveBook(b);
            return true;
        } catch (Exception e) {
            return false;
        }

    }
}

