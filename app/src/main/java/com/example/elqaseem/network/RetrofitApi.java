package com.example.elqaseem.network;

import com.example.elqaseem.dataModel.QassimResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitApi {

    @GET("api/chalets/")
    Call<QassimResponse> getChalets(
            @Query("page") int page,
            @Query("page_size") int pageSize,
            @Query("from_date") String fromDate,
            @Query("to_date") String toDate,
            @Query("availability") int availability
    );

}
