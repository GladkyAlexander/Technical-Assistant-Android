package com.example.technical_assistant.ui.documentation;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DocumentationViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public DocumentationViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}