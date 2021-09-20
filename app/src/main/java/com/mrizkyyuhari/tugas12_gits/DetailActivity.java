package com.mrizkyyuhari.tugas12_gits;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    private ImageView detailImg;
    private TextView detailTitle;
    private TextView detailOverview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        String bcdPath = getIntent().getStringExtra("backdrop");
        String title = getIntent().getStringExtra("title");
        String overview = getIntent().getStringExtra("overview");

        initView();
        Glide.with(DetailActivity.this).load(bcdPath)
                .into(detailImg);

        detailTitle.setText(title);
        detailOverview.setText(overview);
    }

    private void initView() {
        detailImg = findViewById(R.id.detail_img);
        detailTitle = findViewById(R.id.detail_title);
        detailOverview = findViewById(R.id.detail_overview);
    }
}