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
import com.trust.pmegpcustomeronboardingapp.activity.utils.SimpleTextWatcher;

import java.util.List;

public class NewWagesAdapter extends RecyclerView.Adapter<NewWagesAdapter.ViewHolder> {

    private final List<DRPMasterData.WagesDetail> wagesDetailList;
    private final OnAmountChangeListener onAmountChangeListener;

    public interface OnAmountChangeListener {
        void onAmountChanged(double total);
    }

    public NewWagesAdapter(List<DRPMasterData.WagesDetail> wagesList, OnAmountChangeListener listener) {
        this.wagesDetailList = wagesList;
        this.onAmountChangeListener = listener;
    }

    // ✅ Return updated data for API
    public List<DRPMasterData.WagesDetail> getUpdatedList() {
        List<DRPMasterData.WagesDetail> updatedList = new java.util.ArrayList<>();
        for (DRPMasterData.WagesDetail item : wagesDetailList) {
            DRPMasterData.WagesDetail detail = new DRPMasterData.WagesDetail();
            detail.setParticulars(item.getParticulars());
            detail.setNoOfWorkers(item.getNoOfWorkers());
            detail.setWagesPerMonth(item.getWagesPerMonth());
            detail.setAmount(item.getAmount());
            updatedList.add(detail);
        }
        return updatedList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_item_wages_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DRPMasterData.WagesDetail item = wagesDetailList.get(position);
        holder.tv_sr_no.setText(String.valueOf(position + 1));

        holder.particulars.setText(item.getParticulars());
        holder.worker_count.setText(item.getNoOfWorkers() == 0 ? "" : String.valueOf(item.getNoOfWorkers()));
        holder.wages_permonth.setText(item.getWagesPerMonth() == 0 ? "" : String.valueOf(item.getWagesPerMonth()));
        holder.amount.setText(String.format("%.2f", item.getAmount()));

        // Remove previous watchers to avoid duplicates
        if (holder.workerWatcher != null)
            holder.worker_count.removeTextChangedListener(holder.workerWatcher);
        if (holder.wageWatcher != null)
            holder.wages_permonth.removeTextChangedListener(holder.wageWatcher);

        // Add watchers
        holder.workerWatcher = new SimpleTextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                updateItem(holder, item);
            }
        };
        holder.wageWatcher = new SimpleTextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                updateItem(holder, item);
            }
        };

        holder.worker_count.addTextChangedListener(holder.workerWatcher);
        holder.wages_permonth.addTextChangedListener(holder.wageWatcher);
    }

    private void updateItem(ViewHolder holder, DRPMasterData.WagesDetail item) {
        double count = 0.0, wages = 0.0;
        try {
            count = Double.parseDouble(holder.worker_count.getText().toString().trim());
        } catch (NumberFormatException ignored) {}
        try {
            wages = Double.parseDouble(holder.wages_permonth.getText().toString().trim());
        } catch (NumberFormatException ignored) {}

        double total = wages * count;
        holder.amount.setText(String.format("%.2f", total));

        item.setNoOfWorkers((int) count);
        item.setWagesPerMonth(wages);
        item.setAmount(total);

        calculateTotal();
    }

    public void calculateTotal() {
        double total = 0.0;
        for (DRPMasterData.WagesDetail b : wagesDetailList) {
            total += b.getAmount();
        }
        if (onAmountChangeListener != null) {
            onAmountChangeListener.onAmountChanged(total);
        }
    }

    @Override
    public int getItemCount() {
        return wagesDetailList.size();
    }

    public void addRow(DRPMasterData.WagesDetail item) {
        wagesDetailList.add(item);
        notifyItemInserted(wagesDetailList.size() - 1);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        EditText particulars, worker_count, wages_permonth, amount;
        TextView tv_sr_no;
        TextWatcher workerWatcher, wageWatcher;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_sr_no = itemView.findViewById(R.id.tv_sr_no);
            particulars = itemView.findViewById(R.id.wages_particulars);
            worker_count = itemView.findViewById(R.id.wages_workersCount);
            wages_permonth = itemView.findViewById(R.id.wages_permonth);
            amount = itemView.findViewById(R.id.wages_amount);
        }
    }
}
