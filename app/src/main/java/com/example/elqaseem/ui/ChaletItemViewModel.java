package com.example.elqaseem.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PageKeyedDataSource;
import androidx.paging.PagedList;

import com.example.elqaseem.dataModel.Item;
import com.example.elqaseem.dataReposatory.ChaletItemDataSource;
import com.example.elqaseem.dataReposatory.ChaletItemDataSourceFactory;

public class ChaletItemViewModel extends ViewModel {

    LiveData<PagedList<Item>> itemPagedList;
    LiveData<PageKeyedDataSource<Integer, Item>> liveDataSource;

    public LiveData<PagedList<Item>> getItemPagedList(String mStartDate, String mEndDate ) {

        ChaletItemDataSourceFactory chaletItemDataSourceFactory = new ChaletItemDataSourceFactory(mStartDate, mEndDate);

        liveDataSource = chaletItemDataSourceFactory.getMutableLiveData();

        PagedList.Config pagedListConfig = (
                new PagedList.Config.Builder())
                .setEnablePlaceholders(false)
                .setPageSize(ChaletItemDataSource.PAGE_SIZE).build();

        itemPagedList = (new LivePagedListBuilder(chaletItemDataSourceFactory, pagedListConfig)).build();
        return itemPagedList;
    }


}
