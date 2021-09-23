package com.mrizkyyuhari.tugas12_gits;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.mrizkyyuhari.tugas12_gits.room.FavoriteMovies;
import com.mrizkyyuhari.tugas12_gits.room.MyMoviesDB;

public class DetailActivity extends AppCompatActivity {
    private static final String TAG = "DetailActivity";
    private ImageView detailImg;
    private TextView detailTitle;
    private TextView detailOverview;

    private Button btnCoba;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        String bcdPath = getIntent().getStringExtra("backdrop");
        String title = getIntent().getStringExtra("title");
        String overview = getIntent().getStringExtra("overview");
        String posterpath = getIntent().getStringExtra("posterpath");
        String vote = getIntent().getStringExtra("voteaverage");
        initView();
        Glide.with(DetailActivity.this).load(bcdPath)
                .into(detailImg);

        detailTitle.setText(title);
        detailOverview.setText(overview);


        btnCoba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveUser(posterpath,bcdPath,title,overview,vote);

            }
        });


    }

    private void initView() {
        detailImg = findViewById(R.id.detail_img);
        detailTitle = findViewById(R.id.detail_title);
        detailOverview = findViewById(R.id.detail_overview);

        btnCoba = findViewById(R.id.btn_coba);
    }

    public void saveUser(String poster_path, String backdrop_path, String title,String overview, String vote ){
        MyMoviesDB myMoviesDB = MyMoviesDB.getInstance(this);

        FavoriteMovies fav = new FavoriteMovies(poster_path,backdrop_path,title,overview,vote);
        myMoviesDB.myDao().insertFavMovies(fav);
        finish();
    }

    class InsertAsyncTask extends AsyncTask<FavoriteMovies, Void, Void> {

        @Override
        protected Void doInBackground(FavoriteMovies... favoriteMovies) {
            MyMoviesDB.getInstance(getApplicationContext())
                    .myDao()
                    .insertFavMovies(favoriteMovies[0]);

            return null;
        }
    }
}