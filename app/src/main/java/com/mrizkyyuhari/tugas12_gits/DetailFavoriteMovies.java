package com.mrizkyyuhari.tugas12_gits;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class DetailFavoriteMovies extends AppCompatActivity {

    private ImageView bcdRoom;
    private TextView titleRoom;
    private TextView overviewRoom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_favorite_movies);
        String bcd = getIntent().getStringExtra("bcd");
        String over = getIntent().getStringExtra("overview");
        String title = getIntent().getStringExtra("title");
        initView();
        Glide.with(DetailFavoriteMovies.this).load(bcd)
                .into(bcdRoom);

        titleRoom.setText(title);
        overviewRoom.setText(over);
    }

    private void initView() {
        bcdRoom = findViewById(R.id.bcd_room);
        titleRoom = findViewById(R.id.title_room);
        overviewRoom = findViewById(R.id.overview_room);
    }
}