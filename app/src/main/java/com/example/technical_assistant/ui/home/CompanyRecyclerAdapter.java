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
import com.example.technical_assistant.domain.Company;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CompanyRecyclerAdapter extends RecyclerView.Adapter<CompanyRecyclerAdapter.ViewHolder> {

    private final LayoutInflater inflater;
    private final List<Company> companies;
    private final OnClickListener onClickListener;

    public CompanyRecyclerAdapter(Context context, List<Company> companies, OnClickListener onClick) {
        this.onClickListener = onClick;
        this.inflater = LayoutInflater.from(context);
        this.companies = companies;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.item_companyes, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Company company = companies.get(position);
        holder.nameCompany.setText(company.getNameCompany());
        holder.addressCompany.setText(company.getAddress());
        holder.flagView.setImageResource(R.drawable.ic_dom);

        holder.itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                onClickListener.onClick(company, position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return companies.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView flagView;
        final TextView nameCompany, addressCompany;
        ViewHolder(View view) {
            super(view);
            flagView = (ImageView) view.findViewById(R.id.imageViewLogoCompany);
            nameCompany = (TextView) view.findViewById(R.id.textViewNameCompanyItemCompany);
            addressCompany = (TextView) view.findViewById(R.id.textViewAddressCompanyItemCompany);

        }
    }
    interface OnClickListener{
        void onClick(Company company, int position);
    }
}
