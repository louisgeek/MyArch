package com.louisgeek.myarch.data;

import android.arch.lifecycle.LiveData;

import com.louisgeek.myarch.MoiveTop250;

public class RemoteDataSouce implements IDataSouce {
    @Override
    public LiveData<MoiveTop250> getTop250List() {
        return null;
    }
}
