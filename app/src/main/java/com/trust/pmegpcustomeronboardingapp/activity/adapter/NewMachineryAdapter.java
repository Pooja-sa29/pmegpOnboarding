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
import com.trust.pmegpcustomeronboardingapp.activity.model.BuildingItem;
import com.trust.pmegpcustomeronboardingapp.activity.model.MachineryItem;
import com.trust.pmegpcustomeronboardingapp.activity.utils.SimpleTextWatcher;

import java.util.List;

public class NewMachineryAdapter extends RecyclerView.Adapter<NewMachineryAdapter.ViewHolder> {

    private final List<MachineryItem> machineryItemList;
    private final NewMachineryAdapter.OnAmountChangeListener onAmountChangeListener;

    public interface OnAmountChangeListener {
        void onAmountChanged(double total);
    }

    public NewMachineryAdapter(List<MachineryItem> buildingList, NewMachineryAdapter.OnAmountChangeListener listener) {
        this.machineryItemList = buildingList;
        this.onAmountChangeListener = listener;
    }

    @NonNull
    @Override
    public NewMachineryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_item_machinery_row, parent, false);
        return new NewMachineryAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewMachineryAdapter.ViewHolder holder, int position) {
        MachineryItem item = machineryItemList.get(position);
        holder.tv_sr_no.setText(String.valueOf(position + 1));

        holder.particulars.setText(item.getParticulars());
        holder.area.setText(item.getArea());
        holder.rate.setText(item.getRate());
        holder.amount.setText(item.getAmount());

        TextWatcher watcher = new SimpleTextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                double rate = 0.0, area = 0.0;
                try {
                    rate = Double.parseDouble(holder.rate.getText().toString().trim());
                } catch (NumberFormatException ignored) {}
                try {
                    area = Double.parseDouble(holder.area.getText().toString().trim());
                } catch (NumberFormatException ignored) {}

                double total = rate * area;
                holder.amount.setText(String.valueOf(total));

                item.setRate(holder.rate.getText().toString().trim());
                item.setArea(holder.area.getText().toString().trim());
                item.setAmount(String.valueOf(total));

                calculateTotal();
            }
        };
        holder.area.removeTextChangedListener(holder.areaWatcher);
        holder.rate.removeTextChangedListener(holder.rateWatcher);

        holder.areaWatcher = watcher;
        holder.rateWatcher = watcher;
        holder.area.addTextChangedListener(holder.areaWatcher);
        holder.rate.addTextChangedListener(holder.rateWatcher);
    }

    private void calculateTotal() {

        double total = 0.0;
        for (MachineryItem b : machineryItemList) {
            try {
                total += Double.parseDouble(b.getAmount());
            } catch (NumberFormatException ignored) {}
        }
        if (onAmountChangeListener != null) {
            onAmountChangeListener.onAmountChanged(total);
        }
    }

    @Override
    public int getItemCount() {
        return machineryItemList.size();
    }

    public void addRow(MachineryItem item) {
        machineryItemList.add(item);
        notifyItemInserted(machineryItemList.size() - 1);

    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        EditText particulars, area, rate, amount;
        TextView tv_sr_no;

        TextWatcher areaWatcher, rateWatcher;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_sr_no = itemView.findViewById(R.id.tv_sr_no);
            particulars = itemView.findViewById(R.id.machinery_particulars);
            area = itemView.findViewById(R.id.machinery_area);
            rate = itemView.findViewById(R.id.machinery_rate);
            amount = itemView.findViewById(R.id.machine_amount);
        }
    }
}

