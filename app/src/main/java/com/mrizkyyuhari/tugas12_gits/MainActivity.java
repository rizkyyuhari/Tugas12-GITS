package com.mrizkyyuhari.tugas12_gits;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.mrizkyyuhari.tugas12_gits.fragment.FavoriteFragment;
import com.mrizkyyuhari.tugas12_gits.fragment.MovieFragment;
import com.mrizkyyuhari.tugas12_gits.fragment.TvshowFragment;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.btmNav);

        bottomNavigationView.setOnNavigationItemSelectedListener(bottomNavMethod);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new MovieFragment()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener bottomNavMethod =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                    Fragment fragment = null;

                    switch (menuItem.getItemId()){
                        case R.id.btm_nav_movie:
                            fragment = new MovieFragment();
                            break;

                        case R.id.btm_nav_tvshow:
                            fragment = new TvshowFragment();
                            break;

                        case R.id.btm_nav_favorite:
                            fragment = new FavoriteFragment();
                            break;

                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();

                    return true;
                }
            };

    @Override
    public void onBackPressed() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        builder.setTitle("Exit");
        builder.setMessage("Do you want to exit?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });

        builder.setNegativeButton("No", null);
        final AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}