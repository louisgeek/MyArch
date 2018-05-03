package com.louisgeek.myarch.data;

import android.arch.lifecycle.LiveData;

import com.louisgeek.myarch.model.bean.Top250Bean;

public class RemoteDataSouce implements IDataSouce {
    @Override
    public LiveData<Top250Bean> getTop250List() {
        return null;
    }
}
