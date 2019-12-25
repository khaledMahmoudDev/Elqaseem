package com.example.elqaseem.dataReposatory;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import androidx.paging.PageKeyedDataSource;

import com.example.elqaseem.dataModel.Item;

public class ChaletItemDataSourceFactory extends DataSource.Factory {
    private String fromDate;
    private String toDate;

    public ChaletItemDataSourceFactory(String fromDate, String toDate) {
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    private MutableLiveData<PageKeyedDataSource<Integer, Item>> mutableLiveData = new MutableLiveData<>();


    @NonNull
    @Override
    public DataSource create() {

        ChaletItemDataSource chaletItemDataSource = new ChaletItemDataSource(fromDate,toDate);

        mutableLiveData.postValue(chaletItemDataSource);

        return chaletItemDataSource;
    }

    public MutableLiveData<PageKeyedDataSource<Integer, Item>> getMutableLiveData() {
        return mutableLiveData;
    }
}
