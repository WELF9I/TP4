package com.example.tp4_ex2;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    private List<Movie> movieList;
    private Context context;

    public MovieAdapter(List<Movie> movieList, Context context) {
        this.movieList = movieList;
        this.context = context;
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        public ImageView movieImage;
        public TextView movieTitle;

        public MovieViewHolder(View view) {
            super(view);
            movieImage = view.findViewById(R.id.movieImage);
            movieTitle = view.findViewById(R.id.movieTitle);
        }
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_row, parent, false);
        return new MovieViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        Movie movie = movieList.get(position);
        holder.movieImage.setImageResource(movie.getImgURL());
        holder.movieTitle.setText(movie.getTitle());
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }
}