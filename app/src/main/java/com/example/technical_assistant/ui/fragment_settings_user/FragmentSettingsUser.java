package com.example.technical_assistant.ui.fragment_settings_user;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.ViewModelProvider;
import com.example.technical_assistant.GlobalLinkMainController;
import com.example.technical_assistant.R;
import com.example.technical_assistant.databinding.FragmentSettingsUserBinding;
import com.example.technical_assistant.domain.User;
import com.example.technical_assistant.services.sqlite.DatabaseHelper;
import com.example.technical_assistant.services.user_listener.DataUser;
import com.example.technical_assistant.services.user_listener.HandlerUserListener;

public class FragmentSettingsUser extends Fragment implements View.OnClickListener{

    FragmentSettingsUserBinding binding;
    DatabaseHelper dbHelper;
    FragmentSettingsUserModel model;

    EditText textMail ;
    EditText textPhone;
    EditText textServer;
    EditText textPort ;
    EditText textNameDB;
    EditText textUserDB ;
    EditText textPasswordDB;
    TextView lastName;
    TextView firstName;
    User user1;
    HandlerUserListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        listener = new HandlerUserListener();

        model = new ViewModelProvider(this).get(FragmentSettingsUserModel.class);
        binding = FragmentSettingsUserBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        dbHelper = new DatabaseHelper(getActivity());

        lastName = root.findViewById(R.id.textViewLastName);
        firstName = root.findViewById(R.id.textViewFirstName);
        textMail = root.findViewById(R.id.textInputMail);
        textPhone = root.findViewById(R.id.textInputPhone);
        textServer = root.findViewById(R.id.textInputServer);
        textPort = root.findViewById(R.id.textInputPort);
        textNameDB = root.findViewById(R.id.textInputNameDatabase);
        textUserDB = root.findViewById(R.id.textInputUserDatabase);
        textPasswordDB = root.findViewById(R.id.textInputPasswordDatabase);

        model.getUser().observe(getViewLifecycleOwner(), user -> {
            this.user1 = user;
            lastName.setText(user.getLastName());
            firstName.setText(user.getFirstName());
            textMail.setHint(user.getMailAddress());
            textPhone.setHint(user.getPhone());
            textServer.setHint(user.getServer());
            textPort.setHint(user.getPort());
            textNameDB.setHint(user.getNameDB());
            textUserDB.setHint(user.getUserDB());
            textPasswordDB.setHint(user.getPasswordDB());
        });

        Button buttonSettingsUser = root.findViewById(R.id.buttonSaveSettingsUserData);
        buttonSettingsUser.setOnClickListener(this);

        return root;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onClick(View v) {
        int buttonIndex = translateIdToIndex(v.getId());
        if(buttonIndex == 1){
            listener.registerObserverUser(GlobalLinkMainController.getMainActivity());
            dbHelper.updateUser(user1, getUser());
            listener.onNewDataUser(new DataUser(dbHelper.getUser()));
            Toast.makeText(getActivity(), "Changes are successful", Toast.LENGTH_SHORT).show();
            v.setClickable(false);
        }

    }
    int translateIdToIndex(int id){
        int index = -1;
        switch (id){
            case R.id.buttonSaveSettingsUserData:
                index = 1;
                break;
        }
        return index;
    }
    private User getUser(){
        User user = user1;
        user.setMailAddress(textMail.getText().toString());
        user.setPhone(textPhone.getText().toString());
        user.setServer(textServer.getText().toString());
        user.setPort(textPort.getText().toString());
        user.setNameDB(textNameDB.getText().toString());
        user.setUserDB(textUserDB.getText().toString());
        user.setPasswordDB(textPasswordDB.getText().toString());

        return user;
    }

}