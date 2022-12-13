package com.example.technical_assistant.ui.fragment_equipment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.example.technical_assistant.R;
import com.example.technical_assistant.domain.Equipment;

public class EquipmentFragment extends Fragment {

    Equipment equipment;
    TextView nameEquipment, model, manufacturer, serial_number, mac, mac1, mac2, mac3, ip_address, masc, gateway,
            ip_dante, masc_dante, gateway_dante, room, location_room, condition;
    Button close;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.item_one_equipment, container, false);

        nameEquipment = (TextView) root.findViewById(R.id.textViewNameEquipment);
        model = (TextView) root.findViewById(R.id.textViewModelEquipment);
        manufacturer = (TextView) root.findViewById(R.id.textViewManufacturer);
        serial_number = (TextView) root.findViewById(R.id.textViewSerialNumber);
        mac = (TextView) root.findViewById(R.id.textViewMacAddress);
        mac1 = (TextView) root.findViewById(R.id.textViewMac1);
        mac2 = (TextView) root.findViewById(R.id.textViewMac2);
        mac3 = (TextView) root.findViewById(R.id.textViewMac3);
        ip_address = (TextView) root.findViewById(R.id.textViewIpAddress);
        masc = (TextView) root.findViewById(R.id.textViewSubnetMasc);
        gateway = (TextView) root.findViewById(R.id.textViewGateway);

        close = root.findViewById(R.id.buttonCloseFragmentIOE);

        ip_dante = (TextView) root.findViewById(R.id.textViewIpAdressDante);
        masc_dante = (TextView) root.findViewById(R.id.textViewMascDante);
        gateway_dante = (TextView) root.findViewById(R.id.textViewGatewayDante);
        room = (TextView) root.findViewById(R.id.textViewRoom);
        location_room = (TextView) root.findViewById(R.id.textViewRoomLocation);
        condition = (TextView) root.findViewById(R.id.textViewCondition);

        close.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                close();
            }
        });

        load();

        return root;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public void load(){
        nameEquipment.setText(equipment.getName());
        model.setText(equipment.getModel());
        manufacturer.setText(equipment.getManufacturer());
        serial_number.setText(equipment.getSerialNumber());
        mac.setText(equipment.getMacAddress());
        mac1.setText(equipment.getMacAddress1());
        mac2.setText(equipment.getMacAddress2());
        mac3.setText(equipment.getMacAddress3());
        ip_address.setText(equipment.getIpAddress());
        masc.setText(equipment.getMasc());
        gateway.setText(equipment.getGateway());
        ip_dante.setText(equipment.getDanteIpAddress());
        masc_dante.setText(equipment.getDanteMasc());
        gateway_dante.setText(equipment.getDanteGateway());
        room.setText(equipment.getRoom());
        location_room.setText(equipment.getLocation());
        condition.setText(equipment.getCondition());
    }
    public void close(){
        getActivity().getSupportFragmentManager().beginTransaction().remove(this).commit();
    }
}
