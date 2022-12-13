package com.example.technical_assistant.ui.settings;

import android.view.View;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SettingsViewModel extends ViewModel {

    private final MutableLiveData<View> fragmentMutableLiveData;

    public SettingsViewModel() {
        fragmentMutableLiveData = new MutableLiveData<>();
    }

    public LiveData<View> getFragment() {
        return fragmentMutableLiveData;
    }
}