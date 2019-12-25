package com.example.elqaseem.dataReposatory;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

import com.example.elqaseem.dataModel.Item;
import com.example.elqaseem.dataModel.QassimResponse;
import com.example.elqaseem.network.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChaletItemDataSource extends PageKeyedDataSource<Integer, Item> {

    private String fromDate;
    private String toDate;

    public ChaletItemDataSource(String fromDate, String toDate) {
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public static final int PAGE_SIZE = 10;

    private static final int FIRST_PAGE = 1;

    private Long pages;

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull final LoadInitialCallback<Integer, Item> callback) {

        RetrofitClient.getInstance()
                .getApi()
                .getChalets(FIRST_PAGE, PAGE_SIZE, fromDate, toDate, 1)
                .enqueue(new Callback<QassimResponse>() {
                    @Override
                    public void onResponse(Call<QassimResponse> call, Response<QassimResponse> response) {
                        if (response.body() != null) {
                            callback.onResult(response.body().getData(), null, FIRST_PAGE + 1);
                            pages = response.body().getPagination().getPages();
                        }
                    }

                    @Override
                    public void onFailure(Call<QassimResponse> call, Throwable t) {

                    }
                });

    }

    @Override
    public void loadBefore(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, Item> callback) {

        RetrofitClient.getInstance()
                .getApi()
                .getChalets(params.key, PAGE_SIZE, fromDate, toDate, 1)
                .enqueue(new Callback<QassimResponse>() {
                    @Override
                    public void onResponse(Call<QassimResponse> call, Response<QassimResponse> response) {
                        Integer adjacentKey = (params.key > 1) ? params.key - 1 : null;
                        if (response.body() != null) {
                            callback.onResult(response.body().getData(), adjacentKey);
                        }

                    }

                    @Override
                    public void onFailure(Call<QassimResponse> call, Throwable t) {

                    }
                });

    }

    @Override
    public void loadAfter(@NonNull final LoadParams<Integer> params, @NonNull final LoadCallback<Integer, Item> callback) {

        RetrofitClient.getInstance()
                .getApi()
                .getChalets(params.key, PAGE_SIZE, fromDate, toDate, 1)
                .enqueue(new Callback<QassimResponse>() {
                    @Override
                    public void onResponse(Call<QassimResponse> call, Response<QassimResponse> response) {

                        if (response.body() != null) {

                            Integer key = response.body().getPagination().getNext() != null ? params.key + 1 : null;
                            callback.onResult(response.body().getData(), key);


                        }

                    }

                    @Override
                    public void onFailure(Call<QassimResponse> call, Throwable t) {

                    }
                });

    }
}
