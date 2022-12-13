package com.example.technical_assistant.ui.settings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import com.example.technical_assistant.GlobalLinkMainController;
import com.example.technical_assistant.R;
import com.example.technical_assistant.databinding.FragmentSettingsBinding;
import com.example.technical_assistant.ui.fragment_registration_user.FragmentRegistrationUser;
import com.example.technical_assistant.ui.fragment_settings_user.FragmentSettingsUser;

public class SettingsFragment extends Fragment implements View.OnClickListener{

    private FragmentSettingsBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SettingsViewModel slideshowViewModel =
                new ViewModelProvider(this).get(SettingsViewModel.class);

        binding = FragmentSettingsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        Button buttonSettingsUser = root.findViewById(R.id.buttonSettingsUser);
        Button buttonRegister = root.findViewById(R.id.buttonRegister);

        if(GlobalLinkMainController.getMainActivity().user != null){
            buttonRegister.setClickable(false);
        } else {
            buttonRegister.setClickable(true);
            buttonRegister.setOnClickListener(this);
        }

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

        if (buttonIndex == 1) {
            FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
            transaction.setReorderingAllowed(true);
            transaction.replace(R.id.fragment_by_settings, FragmentSettingsUser.class, null);
            transaction.commit();
        }
        if(buttonIndex == 2){
            FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
            transaction.setReorderingAllowed(true);
            transaction.replace(R.id.fragment_by_settings, FragmentRegistrationUser.class, null);
            transaction.commit();
        }

        Toast.makeText(getActivity(), String.valueOf(buttonIndex), Toast.LENGTH_SHORT).
               show();
    }


    int translateIdToIndex(int id){
        int index = -1;
        switch (id){
            case R.id.buttonSettingsUser:
                index = 1;
                break;
            case R.id.buttonRegister:
                index = 2;
                break;
        }
        return index;
    }

}