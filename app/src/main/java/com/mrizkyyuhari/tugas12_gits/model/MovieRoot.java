package com.mrizkyyuhari.tugas12_gits.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieRoot {
    @SerializedName("page")
    private String page;

    @SerializedName("results")
    private List<Result> results;

    @SerializedName("total_pages")
    private String totalPages;

    @SerializedName("total_results")
    private String totalResults;

    public String getPage() {
        return page;
    }


    public List<Result> getResults() {
        return results;
    }


    public String getTotalPages() {
        return totalPages;
    }


    public String getTotalResults() {
        return totalResults;
    }


}
