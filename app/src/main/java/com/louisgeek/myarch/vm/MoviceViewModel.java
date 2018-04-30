package com.louisgeek.myarch.vm;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.louisgeek.myarch.MoiveTop250;
import com.louisgeek.myarch.data.DataRepository;

public class MoviceViewModel extends ViewModel {
    private LiveData<MoiveTop250> moiveTop250LiveData = new MutableLiveData<>();
    private DataRepository mDataRepository;
    public LiveData<MoiveTop250> getMoiveTop250LiveData() {
        moiveTop250LiveData = DataRepository.getInstance().getTop250List();
        return moiveTop250LiveData;
    }
}
