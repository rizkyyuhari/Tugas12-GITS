package com.mrizkyyuhari.tugas12_gits.adapter;

import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.mrizkyyuhari.tugas12_gits.BuildConfig;
import com.mrizkyyuhari.tugas12_gits.DetailActivity;
import com.mrizkyyuhari.tugas12_gits.R;
import com.mrizkyyuhari.tugas12_gits.model.MovieRoot;
import com.mrizkyyuhari.tugas12_gits.model.Result;

import java.util.ArrayList;
import java.util.List;

public class AdapterRV extends RecyclerView.Adapter<AdapterRV.ViewHolderRV>{

    Context context;
    List<Result> movieList = new ArrayList<>();

    public AdapterRV(Context context, List<Result> movieList) {
        this.context = context;
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public AdapterRV.ViewHolderRV onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.movie_list,parent,false);

        return new ViewHolderRV(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterRV.ViewHolderRV holder, int position) {
        Result movie = movieList.get(position);
        holder.tvTitle.setText(movie.getTitle());
        holder.tvRating.setText(movie.getVoteAverage());
        Glide.with(context)
                .load(BuildConfig.IMAGE + movieList.get(position).getPosterPath())
                .into(holder.ivPoster);

        holder.cvCard.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("title",movieList.get(position).getTitle());
            intent.putExtra("backdrop",BuildConfig.IMAGE +movieList.get(position).getBackdropPath());
            intent.putExtra("overview",movieList.get(position).getOverview());
            intent.putExtra("voteaverage",movieList.get(position).getVoteAverage());
            intent.putExtra("posterpath",movieList.get(position).getPosterPath());
            context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public static class ViewHolderRV extends  RecyclerView.ViewHolder{
        TextView tvTitle, tvRating;
        ImageView ivPoster;
        CardView cvCard;

        public ViewHolderRV(@NonNull View itemView) {
            super(itemView);

            tvRating = itemView.findViewById(R.id.tv_rating);
            tvTitle = itemView.findViewById(R.id.tv_title);
            ivPoster = itemView.findViewById(R.id.iv_poster);
            cvCard = itemView.findViewById(R.id.cv_movie);
        }
    }
}