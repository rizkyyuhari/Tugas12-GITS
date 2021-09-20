package com.mrizkyyuhari.tugas12_gits.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mrizkyyuhari.tugas12_gits.R;
import com.mrizkyyuhari.tugas12_gits.adapter.AdapterRV;
import com.mrizkyyuhari.tugas12_gits.api.ApiService;
import com.mrizkyyuhari.tugas12_gits.api.InitRetrofit;
import com.mrizkyyuhari.tugas12_gits.model.MovieRoot;
import com.mrizkyyuhari.tugas12_gits.model.Result;

import java.util.ArrayList;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MovieFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MovieFragment extends Fragment {
    RecyclerView recyclerView;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MovieFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MovieFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MovieFragment newInstance(String param1, String param2) {
        MovieFragment fragment = new MovieFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_movie, container, false);
        Context context = view.getContext();

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        getMoviePopular();
        return view;
    }

    private void getMoviePopular() {
        ApiService apiService = InitRetrofit.getInstance();
        Call<MovieRoot> responseCall = apiService.popular();

        responseCall.enqueue(new Callback<MovieRoot>() {
            @Override
            public void onResponse(@NonNull Call<MovieRoot> call, @NonNull Response<MovieRoot> response) {
                if (response.isSuccessful()) {
                    Log.i("movie", Objects.requireNonNull(response.body()).getResults().toString());
                    ArrayList<Result> movieModels = (ArrayList<Result>) response.body().getResults();
                    AdapterRV movieAdapter = new AdapterRV(getActivity(), movieModels);

                    recyclerView.setAdapter(movieAdapter);
                }
            }

            @Override
            public void onFailure(@NonNull Call<MovieRoot> call, @NonNull Throwable t) {
                t.printStackTrace();
            }
        });
    }

}