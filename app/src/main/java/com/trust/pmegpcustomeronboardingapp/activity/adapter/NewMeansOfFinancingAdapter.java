package com.trust.pmegpcustomeronboardingapp.activity.adapter;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.trust.pmegpcustomeronboardingapp.R;
import com.trust.pmegpcustomeronboardingapp.activity.model.DRPMasterData;

import java.util.List;

public class NewMeansOfFinancingAdapter extends RecyclerView.Adapter<NewMeansOfFinancingAdapter.ViewHolder> {

    private final List<DRPMasterData.MeansOfFinancing> meansOfFinancingList;

    public interface OnAmountChangeListener {
        void onAmountChanged(double total);
    }

    public NewMeansOfFinancingAdapter(List<DRPMasterData.MeansOfFinancing> list) {
        this.meansOfFinancingList = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_item_new_means_of_financing_row, parent, false);
        return new ViewHolder(view);
    }

    public List<DRPMasterData.MeansOfFinancing> getUpdatedList() {
        List<DRPMasterData.MeansOfFinancing> updatedList = new java.util.ArrayList<>();
        for (DRPMasterData.MeansOfFinancing item : meansOfFinancingList) {
            DRPMasterData.MeansOfFinancing detail = new DRPMasterData.MeansOfFinancing();
            detail.setParticulars(item.getParticulars());
            try {
                detail.setPercentage(item.getPercentage());
            } catch (NumberFormatException e) {
                detail.setPercentage(0);
            }

            updatedList.add(detail);
        }
        return updatedList;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DRPMasterData.MeansOfFinancing item = meansOfFinancingList.get(position);

        holder.tvSrNo.setText(String.valueOf(position + 1));
        holder.etParticulars.setText(item.getParticulars());
        holder.etAmount.setText(String.valueOf(item.getPercentage()));

        holder.etParticulars.addTextChangedListener(new SimpleWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                item.setParticulars(s.toString());
            }
        });

        holder.etAmount.addTextChangedListener(new SimpleWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                try {
                    item.setPercentage(Double.parseDouble(s.toString()));
                } catch (NumberFormatException e) {
                    item.setPercentage(0.0);
                }
            }
        });
    }



    @Override
    public int getItemCount() {
        return meansOfFinancingList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvSrNo;
        EditText etParticulars, etAmount;

        ViewHolder(View itemView) {
            super(itemView);
            tvSrNo = itemView.findViewById(R.id.tv_sr_no);
            etParticulars = itemView.findViewById(R.id.means_particulars);
            etAmount = itemView.findViewById(R.id.means_amount);
        }
    }

    private abstract static class SimpleWatcher implements TextWatcher {
        @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
        @Override public void onTextChanged(CharSequence s, int start, int before, int count) {}
    }
    }



