package com.example.user.networkingtest.model;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GerritAPI {
    //@GET("volume?")
    @GET("changes/")
    //Call<List<Change>> loadChanges(@Query("q") String status, @Query("maxResults") String results, @Query("printType") String type);
    Call<List<Change>> loadChanges(@Query("q") String status);
}

