package com.louisgeek.myarch.data;

import android.arch.lifecycle.LiveData;

import com.louisgeek.myarch.model.bean.Top250Bean;

public class DataRepository {
    private DataRepository(){
    }
    public static DataRepository getInstance() {
        return Inner.sInstance;
    }
    private static class Inner {
        private static DataRepository sInstance = new DataRepository();
    }

    private LocalDataSouce localDataSouce;
    private RemoteDataSouce remoteDataSouce;
    public LiveData<Top250Bean> getTop250List() {
        if (false) {
            return remoteDataSouce.getTop250List();
        }
        return localDataSouce.getTop250List();
    }
}
