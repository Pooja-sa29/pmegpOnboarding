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
import com.trust.pmegpcustomeronboardingapp.activity.model.MachineryItem;
import com.trust.pmegpcustomeronboardingapp.activity.utils.SimpleTextWatcher;

import java.util.List;

public class NewWorkingCapitalAdapter extends RecyclerView.Adapter<com.trust.pmegpcustomeronboardingapp.activity.adapter.NewWorkingCapitalAdapter.ViewHolder> {

    private final List<DRPMasterData.WorkingCapitalDetail> workingCapitalList;
    private final OnAmountChangeListener onAmountChangeListener;

    public interface OnAmountChangeListener {
        void onAmountChanged(double total);
    }

    public NewWorkingCapitalAdapter(List<DRPMasterData.WorkingCapitalDetail> list,
                                 OnAmountChangeListener listener) {
        this.workingCapitalList = list;
        this.onAmountChangeListener = listener;
    }
    public List<DRPMasterData.WorkingCapitalDetail> getUpdatedList() {
        List<DRPMasterData.WorkingCapitalDetail> updatedList = new java.util.ArrayList<>();
        for (DRPMasterData.WorkingCapitalDetail item : workingCapitalList) {
            DRPMasterData.WorkingCapitalDetail detail = new DRPMasterData.WorkingCapitalDetail();
            detail.setParticulars(item.getParticulars());
            try {
                detail.setAmount(item.getAmount());
            } catch (NumberFormatException e) {
                detail.setAmount(0);
            }

            updatedList.add(detail);
        }
        return updatedList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_item_working_capital_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DRPMasterData.WorkingCapitalDetail item = workingCapitalList.get(position);

        holder.tvSrNo.setText(String.valueOf(position + 1));
        holder.etParticulars.setText(item.getParticulars());
        holder.etAmount.setText(String.valueOf(item.getAmount()));

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
                    item.setAmount(Double.parseDouble(s.toString()));
                } catch (NumberFormatException e) {
                    item.setAmount(0);
                }
                calculateTotal();
            }
        });
    }

    private void calculateTotal() {
        double total = 0;
        for (DRPMasterData.WorkingCapitalDetail detail : workingCapitalList) {
            total += detail.getAmount();
        }
        if (onAmountChangeListener != null) {
            onAmountChangeListener.onAmountChanged(total);
        }
    }

    @Override
    public int getItemCount() {
        return workingCapitalList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvSrNo;
        EditText etParticulars, etAmount;

        ViewHolder(View itemView) {
            super(itemView);
            tvSrNo = itemView.findViewById(R.id.tv_sr_no);
            etParticulars = itemView.findViewById(R.id.capWorking_particulars);
            etAmount = itemView.findViewById(R.id.capWorking_amount);
        }
    }

    private abstract static class SimpleWatcher implements TextWatcher {
        @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
        @Override public void onTextChanged(CharSequence s, int start, int before, int count) {}
    }
    }



