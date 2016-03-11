package com.example.s4astya.book_app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.s4astya.book_app.R;

/**
 * Created by S4ASTYA on 26.02.2016.
 */
    public class Recs_Fragment extends Fragment {

    View myView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        myView = inflater.inflate(R.layout.rec,container,false);
        return myView;
    }
}
