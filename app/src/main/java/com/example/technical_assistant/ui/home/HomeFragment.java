package com.example.technical_assistant.ui.home;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.technical_assistant.R;
import com.example.technical_assistant.databinding.FragmentHomeBinding;
import com.example.technical_assistant.domain.Company;
import com.example.technical_assistant.domain.Equipment;
import com.example.technical_assistant.ui.fragment_equipment.EquipmentFragment;

public class HomeFragment extends Fragment{

    private FragmentHomeBinding binding;
    RecyclerView recyclerViewCompany, recyclerViewEquipment;
    HomeFragment fragment = this;

    @SuppressLint("NotifyDataSetChanged")
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        recyclerViewEquipment = root.findViewById(R.id.recyclerViewEquipmentHomeFr);
        recyclerViewCompany = root.findViewById(R.id.recyclerViewCompanyesHomeFr);

            homeViewModel.getListCompanyes().observe(getViewLifecycleOwner(), listCompanyes ->{
                recyclerViewCompany.setLayoutManager(new LinearLayoutManager(getActivity()));

                CompanyRecyclerAdapter.OnClickListener onClickListener = (company, position) -> {

                    homeViewModel.getEquipmentList(company).observe(getViewLifecycleOwner(), equipmentList -> {

                        recyclerViewEquipment.setLayoutManager(new LinearLayoutManager(getActivity()));

                        EquipmentRecyclerAdapter.OnClickListenerEquipment onClickListener1 = (equipments, position1) -> {
                            FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();

                            EquipmentFragment fragment = new EquipmentFragment();
                            fragment.setEquipment(equipments);
                            transaction.replace(getId(), fragment, null);

                            transaction.commit();
                        };
                        EquipmentRecyclerAdapter adapter = new EquipmentRecyclerAdapter(getActivity(), equipmentList, onClickListener1);
                        recyclerViewEquipment.setAdapter(adapter);

                    });

                    Toast.makeText(getContext(), "Был выбран пункт " + company.getNameCompany(),
                            Toast.LENGTH_SHORT).show();
                };
                CompanyRecyclerAdapter adapter = new CompanyRecyclerAdapter(getActivity(), listCompanyes, onClickListener);
                recyclerViewCompany.setAdapter(adapter);
            });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}