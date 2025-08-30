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
    private final NewWagesAdapter.OnAmountChangeListener onAmountChangeListener;

    public interface OnAmountChangeListener {
        void onAmountChanged(double total);
    }

    public NewWagesAdapter(List<DRPMasterData.WagesDetail> rawMaterials, NewWagesAdapter.OnAmountChangeListener listener) {
        this.wagesDetailList = rawMaterials;
        this.onAmountChangeListener = listener;
    }

    @NonNull
    @Override
    public NewWagesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_item_wages_row, parent, false);
        return new NewWagesAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewWagesAdapter.ViewHolder holder, int position) {
        DRPMasterData.WagesDetail item = wagesDetailList.get(position);
        holder.tv_sr_no.setText(String.valueOf(position + 1));

        holder.particulars.setText(item.getParticulars());
        holder.worker_count.setText(String.valueOf(item.getNoOfWorkers()));
        holder.wages_permonth.setText(String.valueOf(item.getWagesPerMonth()));
        holder.amount.setText(String.format("%.2f", item.getAmount()));

        TextWatcher watcher = new SimpleTextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                double count = 0.0, wages = 0.0;
                try {
                    count = Double.parseDouble(holder.worker_count.getText().toString().trim());
                } catch (NumberFormatException ignored) {}
                try {
                    wages = Double.parseDouble(holder.wages_permonth.getText().toString().trim());
                } catch (NumberFormatException ignored) {}


                double total = wages *wages * count;
                holder.amount.setText(String.format("%.2f", total));

                item.setNoOfWorkers((int) count);
                item.setAmount(total);

                calculateTotal();
            }
        };
        holder.wages_permonth.removeTextChangedListener(holder.areaWatcher);
        holder.worker_count.removeTextChangedListener(holder.rateWatcher);

        holder.areaWatcher = watcher;
        holder.rateWatcher = watcher;
        holder.wages_permonth.addTextChangedListener(holder.areaWatcher);
        holder.wages_permonth.addTextChangedListener(holder.rateWatcher);
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

        TextWatcher areaWatcher, rateWatcher;

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
