package com.louisgeek.myarch.data;

import android.arch.lifecycle.LiveData;

import com.louisgeek.myarch.MoiveTop250;

public interface IDataSouce {
    LiveData<MoiveTop250> getTop250List();
}
