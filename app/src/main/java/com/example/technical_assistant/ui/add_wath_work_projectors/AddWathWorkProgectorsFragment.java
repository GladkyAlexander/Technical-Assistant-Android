package com.example.technical_assistant.ui.add_wath_work_projectors;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.example.technical_assistant.GlobalLinkMainController;
import com.example.technical_assistant.R;
import com.example.technical_assistant.domain.Equipment;
import com.example.technical_assistant.domain.equipment.Projector;

import java.util.List;

public class AddWathWorkProgectorsFragment extends Fragment {

    TableLayout mTableLayout;
    List<Projector> projectors;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_add_watch_work_projectors, container, false);

       mTableLayout = (TableLayout) root.findViewById(R.id.vBoxTime);

        return root;
    }

    public void loadProgectors(){
        if(GlobalLinkMainController.getMainActivity().company.getEquipmentList() != null){
            for (Equipment equipment : GlobalLinkMainController.getMainActivity().company.getEquipmentList()){
                if(equipment instanceof Projector){
                    projectors.add((Projector) equipment);
                }
            }
        }

        String[] columns = {"room", "model", "serial number", "operating time"};

    }

}
