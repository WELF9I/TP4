package com.example.tp4_ex1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {
    private List<Movie> moviesList;
    private Context context;

    public Adapter(List<Movie> moviesList, Context context) {
        this.moviesList = moviesList;
        this.context = context;
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title, genre, year;

        public MyViewHolder(View view, Context context, List<Movie> moviesList) {
            super(view);
            title = view.findViewById(R.id.titleText);
            genre = view.findViewById(R.id.genreText);
            year = view.findViewById(R.id.yearText);

            view.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        Toast.makeText(context, moviesList.get(position).getTitle(), Toast.LENGTH_SHORT).show();
                    }
                    return true;
                }
            });
        }
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(itemView, context, moviesList);
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Movie movie = moviesList.get(position);
        holder.title.setText(movie.getTitle());
        holder.genre.setText(movie.getGenre());
        holder.year.setText(movie.getYear());
    }
    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}