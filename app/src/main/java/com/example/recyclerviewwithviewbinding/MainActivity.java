package com.example.recyclerviewwithviewbinding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.recyclerviewwithviewbinding.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;
    RecyclerAdapter recyclerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(activityMainBinding.getRoot());

        recyclerAdapter = new RecyclerAdapter();

        activityMainBinding.recyclerView.setAdapter(recyclerAdapter);

        initMovieList();
    }

    private void initMovieList(){
        List<String> moviesList = new ArrayList<>();
        moviesList.add("The Lord of the Rings");
        moviesList.add("The Hobbit");
        moviesList.add("Star Wars");
        moviesList.add("Harry Potter");
        recyclerAdapter.updateMoviesList(moviesList);
        //recyclerAdapter.notifyDataSetChanged();//rafraichissement adapter

    }
}