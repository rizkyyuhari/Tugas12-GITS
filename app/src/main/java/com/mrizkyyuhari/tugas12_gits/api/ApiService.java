package com.mrizkyyuhari.tugas12_gits.api;




import com.mrizkyyuhari.tugas12_gits.BuildConfig;
import com.mrizkyyuhari.tugas12_gits.model.MovieRoot;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET(BuildConfig.MOVIE + "popular?api_key="+BuildConfig.TOKEN)
    Call<MovieRoot> popular();
}
