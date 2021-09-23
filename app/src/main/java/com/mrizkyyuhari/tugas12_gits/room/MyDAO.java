package com.mrizkyyuhari.tugas12_gits.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MyDAO {
    @Query("select * from  fav_table order by id desc")
    public List<FavoriteMovies> getAll();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public void insertFavMovies(FavoriteMovies fav);

    @Delete
    public void updateFavMovies(FavoriteMovies fav);

    @Update
    public void deleteFavMovies(FavoriteMovies fav);
}
