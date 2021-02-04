package com.example.recyclerviewwithviewbinding;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewwithviewbinding.databinding.RecyclerItemBinding;

import java.util.ArrayList;
import java.util.List;

import static java.security.AccessController.getContext;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    List<String> moviesList = new ArrayList<>();

    public void updateMoviesList(List<String> moviesList){
        this.moviesList = moviesList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        RecyclerItemBinding recyclerItemBinding = RecyclerItemBinding.inflate(layoutInflater, parent, false);
        return new ViewHolder(recyclerItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    holder.bindView(moviesList.get(position));
    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    } //donne le nombre d'éléments à la RV

    class ViewHolder extends RecyclerView.ViewHolder {

        private static final String TAG = "ViewHolder";

        RecyclerItemBinding recyclerItemBinding;

        public ViewHolder(@NonNull RecyclerItemBinding recyclerItemBinding){
            super(recyclerItemBinding.getRoot());
            this.recyclerItemBinding = recyclerItemBinding;
            this.recyclerItemBinding.movieName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //interface
                    Log.d(TAG, "onClick: " + getAdapterPosition());
                }
            });
        }

        public void bindView(String movieName){
            recyclerItemBinding.movieName.setText(movieName);
        }
    }
}
