package com.example.technical_assistant.ui.home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.technical_assistant.R;
import com.example.technical_assistant.domain.Equipment;
import com.example.technical_assistant.services.lang.Language;
import com.example.technical_assistant.services.lang.impl.LanguageImpl;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class EquipmentRecyclerAdapter extends RecyclerView.Adapter<EquipmentRecyclerAdapter.ViewHolder> {

    private final LayoutInflater inflater;
    private final List<Equipment> equipments;
    private final OnClickListenerEquipment onClickListener;
    Language language = new LanguageImpl();

    public EquipmentRecyclerAdapter(Context context, List<Equipment> equipments, OnClickListenerEquipment onClickListener) {
        this.inflater = LayoutInflater.from(context);
        this.equipments = equipments;
        this.onClickListener = onClickListener;
    }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.item_equipment, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Equipment equipment = equipments.get(position);
        holder.nameEquipment.setText(equipment.getName());
        holder.serialNumber.setText(equipment.getSerialNumber());
        holder.room.setText(equipment.getRoom());
        if(equipment.getName().equals(language.PROJECTOR("English"))
        || equipment.getName().equals(language.PROJECTOR("Русский"))){
            holder.flagView.setImageResource(R.mipmap.ic_projector_foreground);
        } else holder.flagView.setImageResource(R.drawable.ic_dom);

        holder.itemView.setOnClickListener(v -> onClickListener.onClick(equipment, position));

    }

    @Override
    public int getItemCount() {
        return equipments.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView flagView;
        final TextView nameEquipment, serialNumber, room;

        public ViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            flagView = (ImageView) itemView.findViewById(R.id.imageViewLogoEquipmentItemEq);
            nameEquipment = (TextView) itemView.findViewById(R.id.textViewNameEquipmentItemEq);
            serialNumber = (TextView) itemView.findViewById(R.id.textViewSerialNumberEquipmentItemEq);
            room = itemView.findViewById(R.id.textViewRoom);
        }
    }

    interface OnClickListenerEquipment {
        void onClick(Equipment equipments, int position);
    }

}
