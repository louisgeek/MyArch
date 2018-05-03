package com.louisgeek.myarch.vm;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.louisgeek.myarch.data.DataRepository;
import com.louisgeek.myarch.model.bean.Top250Bean;

public class MoviceViewModel extends ViewModel {
    private LiveData<Top250Bean> moiveTop250LiveData = new MutableLiveData<>();
    private DataRepository mDataRepository;
    public LiveData<Top250Bean> getMoiveTop250LiveData() {
        moiveTop250LiveData = DataRepository.getInstance().getTop250List();
        return moiveTop250LiveData;
    }
}
