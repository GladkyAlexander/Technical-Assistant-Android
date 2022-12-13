package com.example.technical_assistant.ui.fragment_settings_user;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.technical_assistant.GlobalLinkMainController;
import com.example.technical_assistant.domain.User;

public class FragmentSettingsUserModel extends ViewModel {
    private MutableLiveData<User> user;
    public LiveData<User> getUser() {
        if(user == null){
            user = new MutableLiveData<User>();
            loadUser();
        }
        return user;
    }

    private void loadUser() {
         user.setValue(GlobalLinkMainController.getMainActivity().user);
    }

}
