package com.example.technical_assistant.ui.fragment_registration_user;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.example.technical_assistant.R;
import com.example.technical_assistant.databinding.FragmentRegistrationUserBinding;
import com.example.technical_assistant.domain.User;
import com.example.technical_assistant.services.sqlite.DatabaseHelper;

public class FragmentRegistrationUser extends Fragment implements View.OnClickListener {

    private FragmentRegistrationUserBinding binding;

    EditText lastName ;
    EditText firstName;
    EditText phone;
    EditText email;
    EditText login;
    EditText password;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        FragmentRegistrationUserModel model =
                new ViewModelProvider(this).get(FragmentRegistrationUserModel.class);

        binding = FragmentRegistrationUserBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

         lastName = root.findViewById(R.id.editTextLastNameRegister);
         firstName = root.findViewById(R.id.editTextFirstNameRegister);
         phone = root.findViewById(R.id.editTextPhoneReg);
         email = root.findViewById(R.id.editTextMailRegister);
         login = root.findViewById(R.id.editTextLoginRegister);
         password = root.findViewById(R.id.editTextPasswordRegister);

        Button btnRegister = (Button) root.findViewById(R.id.buttonSaveUser);
        btnRegister.setOnClickListener(this);

        return root;
    }

    @Override
    public void onClick(View v) {

        DatabaseHelper dbHelper = new DatabaseHelper(getActivity());

        if(dbHelper.InsertUser(getUser())){
            Toast.makeText(getActivity(),"Record inserted successfully",Toast.LENGTH_LONG).show();
        } else Toast.makeText(getActivity(),"Record not inserted",Toast.LENGTH_LONG).show();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private User getUser(){
        User user = new User();
        user.setLastName(lastName.getText().toString());
        user.setFirstName(firstName.getText().toString());
        user.setPhone(phone.getText().toString());
        user.setMailAddress(email.getText().toString());
        user.setLogin(login.getText().toString());
        user.setPassword(password.getText().toString());
        return user;
    }
}
