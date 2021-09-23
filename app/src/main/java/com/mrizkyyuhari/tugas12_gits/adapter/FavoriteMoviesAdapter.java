package com.mrizkyyuhari.tugas12_gits.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.mrizkyyuhari.tugas12_gits.BuildConfig;
import com.mrizkyyuhari.tugas12_gits.DetailActivity;
import com.mrizkyyuhari.tugas12_gits.DetailFavoriteMovies;
import com.mrizkyyuhari.tugas12_gits.R;
import com.mrizkyyuhari.tugas12_gits.room.FavoriteMovies;

import java.util.List;

public class FavoriteMoviesAdapter extends RecyclerView.Adapter<FavoriteMoviesAdapter.FMViewHolder> {
    Context context;
    List<FavoriteMovies> fav;

    public FavoriteMoviesAdapter(Context context, List<FavoriteMovies> fav) {
        this.context = context;
        this.fav = fav;
    }

    @NonNull
    @Override
    public FavoriteMoviesAdapter.FMViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.movie_list,parent,false);
        return new FMViewHolder( view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteMoviesAdapter.FMViewHolder holder, int position) {
        holder.tv.setText(fav.get(position).getTitle());
        holder.tv_rating.setText(String.valueOf(fav.get(position).getVote_average()));
        Glide.with(context)
                .load(BuildConfig.IMAGE + fav.get(position).getPoster_path())
                .into(holder.iv_poster);

        holder.cvCard.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetailFavoriteMovies.class);
            intent.putExtra("title",fav.get(position).getTitle());
            intent.putExtra("bcd",fav.get(position).getBackdrop_path());
            intent.putExtra("overview",fav.get(position).getOverview());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return fav.size();
    }

    public class FMViewHolder extends RecyclerView.ViewHolder{
        TextView tv, tv_rating;
        ImageView iv_poster;
        CardView cvCard;
        public FMViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv_title);
            tv_rating = itemView.findViewById(R.id.tv_rating);
            iv_poster = itemView.findViewById(R.id.iv_poster);
            cvCard = itemView.findViewById(R.id.cv_movie);
        }
    }
}
