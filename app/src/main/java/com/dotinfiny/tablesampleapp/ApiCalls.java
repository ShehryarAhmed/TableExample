package com.dotinfiny.tablesampleapp;

import com.google.gson.JsonElement;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiCalls {

    @GET("api/EERP/GetData?")
    Call<List<JsonElement>> getData(
            @Query("query") String query,
            @Query("columnNames") String columnNames,
            @Query("viewType") String viewType
    );
}
