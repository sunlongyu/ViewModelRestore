package com.example.viewmodelrestore;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
    private SavedStateHandle handle;

    public MyViewModel(SavedStateHandle handle) {
        this.handle = handle;
    }

    public MutableLiveData<Integer> getNumber() {
        if (!handle.contains(MainActivity.KEY)) {
            handle.set(MainActivity.KEY, 0);
        }
        return handle.getLiveData(MainActivity.KEY);
    }

    public void add() {
        getNumber().setValue(getNumber().getValue() + 1);
    }
}
