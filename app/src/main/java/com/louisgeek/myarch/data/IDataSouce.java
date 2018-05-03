package com.louisgeek.myarch.data;

import android.arch.lifecycle.LiveData;

import com.louisgeek.myarch.model.bean.Top250Bean;

public interface IDataSouce {
    LiveData<Top250Bean> getTop250List();
}
