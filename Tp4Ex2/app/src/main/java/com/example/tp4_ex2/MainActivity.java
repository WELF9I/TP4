package com.example.tp4_ex2;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Movie> movieList;
    private RecyclerView recyclerView;
    private MovieAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        movieList = new ArrayList<>();
        adapter = new MovieAdapter(movieList, this);

        //recyclerView.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL, false));
        StaggeredGridLayoutManager staggeredGridLayoutManager =
                new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);

        recyclerView.setAdapter(adapter);
        prepareMovieData();
    }

    private void prepareMovieData() {
        Movie movie = new Movie("Mad Max: Fury Road Mad Max: Fury Road", R.drawable.madmax);
        movieList.add(movie);

        movie = new Movie("The Martian", R.drawable.themartian);
        movieList.add(movie);

        movie = new Movie("Shaun the Sheep", R.drawable.shaun);
        movieList.add(movie);

        movie = new Movie("Oreo Movie", R.drawable.oreo);
        movieList.add(movie);

        movie = new Movie("Nougat Movie", R.drawable.nougat);
        movieList.add(movie);

        movie = new Movie("Marshmallow Movie", R.drawable.marshmallow);
        movieList.add(movie);

        adapter.notifyDataSetChanged();
    }
}