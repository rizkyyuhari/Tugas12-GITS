package com.mrizkyyuhari.tugas12_gits.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {FavoriteMovies.class},version = 1,exportSchema = false )
public abstract class MyMoviesDB extends RoomDatabase {
    public abstract MyDAO myDao();
    private static  MyMoviesDB instance;

    public static  MyMoviesDB  getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    MyMoviesDB.class,"favorite_movies").fallbackToDestructiveMigration().allowMainThreadQueries().build();
        }
        return instance;
    }

}
