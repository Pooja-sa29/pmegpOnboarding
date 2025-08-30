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

public class NewDetailsOfSalesAdapter extends RecyclerView.Adapter<NewDetailsOfSalesAdapter.ViewHolder> {

    private final List<DRPMasterData.DetailsOfSale> detailsOfSaleslist;
    private final NewDetailsOfSalesAdapter.OnAmountChangeListener onAmountChangeListener;

    public interface OnAmountChangeListener {
        void onAmountChanged(double total);
    }

    public NewDetailsOfSalesAdapter(List<DRPMasterData.DetailsOfSale> detailsOfSales, NewDetailsOfSalesAdapter.OnAmountChangeListener listener) {
        this.detailsOfSaleslist = detailsOfSales;
        this.onAmountChangeListener = listener;
    }

    @NonNull
    @Override
    public NewDetailsOfSalesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_item_sales_row, parent, false);
        return new NewDetailsOfSalesAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewDetailsOfSalesAdapter.ViewHolder holder, int position) {
        DRPMasterData.DetailsOfSale item = detailsOfSaleslist.get(position);
        holder.tv_sr_no.setText(String.valueOf(position + 1));

        holder.particulars.setText(item.getParticulars());
        holder.quantity.setText(String.valueOf(item.getQuantity()));
        holder.rate.setText(String.valueOf(item.getRatePerUnit()));
        holder.amount.setText(String.format("%.2f", item.getAmount()));

        TextWatcher watcher = new SimpleTextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                double rate = 0.0, quantity = 0.0;
                try {
                    rate = Double.parseDouble(holder.rate.getText().toString().trim());
                } catch (NumberFormatException ignored) {}
                try {
                    quantity = Double.parseDouble(holder.quantity.getText().toString().trim());
                } catch (NumberFormatException ignored) {}

                double total = rate * quantity;
                holder.amount.setText(String.format("%.2f", total));

                item.setRatePerUnit((int) rate);
                item.setQuantity((int) quantity);
                item.setAmount(total);

                calculateTotal();
            }
        };
        holder.quantity.removeTextChangedListener(holder.areaWatcher);
        holder.rate.removeTextChangedListener(holder.rateWatcher);

        holder.areaWatcher = watcher;
        holder.rateWatcher = watcher;
        holder.quantity.addTextChangedListener(holder.areaWatcher);
        holder.rate.addTextChangedListener(holder.rateWatcher);
    }

    public void calculateTotal() {
        double total = 0.0;
        for (DRPMasterData.DetailsOfSale b : detailsOfSaleslist) {
            total += b.getAmount();
        }
        if (onAmountChangeListener != null) {
            onAmountChangeListener.onAmountChanged(total);
        }
    }

    @Override
    public int getItemCount() {
        return detailsOfSaleslist.size();
    }

    public void addRow(DRPMasterData.DetailsOfSale item) {
        detailsOfSaleslist.add(item);
        notifyItemInserted(detailsOfSaleslist.size() - 1);

    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        EditText particulars, quantity, rate, amount;
        TextView tv_sr_no;

        TextWatcher areaWatcher, rateWatcher;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_sr_no = itemView.findViewById(R.id.tv_sr_no);
            particulars = itemView.findViewById(R.id.sales_particulars);
            rate = itemView.findViewById(R.id.sales_rate);
            quantity = itemView.findViewById(R.id.sales_quantity);
            amount = itemView.findViewById(R.id.sales_amount);
        }
    }
}
