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

public class NewRawMaterialAdapter extends RecyclerView.Adapter<NewRawMaterialAdapter.ViewHolder> {

    private final List<DRPMasterData.RawMaterial> rawMaterialList;
    private final NewRawMaterialAdapter.OnAmountChangeListener onAmountChangeListener;

    public interface OnAmountChangeListener {
        void onAmountChanged(double total);
    }

    public NewRawMaterialAdapter(List<DRPMasterData.RawMaterial> rawMaterials, NewRawMaterialAdapter.OnAmountChangeListener listener) {
        this.rawMaterialList = rawMaterials;
        this.onAmountChangeListener = listener;
    }
    public List<DRPMasterData.RawMaterial> getUpdatedList() {
        List<DRPMasterData.RawMaterial> updatedList = new java.util.ArrayList<>();
        for (DRPMasterData.RawMaterial item : rawMaterialList) {
            DRPMasterData.RawMaterial detail = new DRPMasterData.RawMaterial();
            detail.setParticulars(item.getParticulars());
            try {
                detail.setRatePerUnit(item.getRatePerUnit());
            } catch (NumberFormatException e) {
                detail.setRatePerUnit(0.0);
            }
            try {
                detail.setAmount(item.getAmount());
            } catch (NumberFormatException e) {
                detail.setAmount(0.0);
            }
            updatedList.add(detail);
        }
        return updatedList;
    }
    @NonNull
    @Override
    public NewRawMaterialAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_item_raw_material_row, parent, false);
        return new NewRawMaterialAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewRawMaterialAdapter.ViewHolder holder, int position) {
        DRPMasterData.RawMaterial item = rawMaterialList.get(position);
        holder.tv_sr_no.setText(String.valueOf(position + 1));

        holder.particulars.setText(item.getParticulars());
        holder.rate.setText(String.valueOf(item.getRatePerUnit()));
        holder.unit.setText(String.valueOf(item.getUnit()));
        holder.req_unit.setText(String.valueOf(item.getRequiredUnit()));
        holder.amount.setText(String.format("%.2f", item.getAmount()));

        TextWatcher watcher = new SimpleTextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                double rate = 0, unit = 0, req_unit = 0;
                try {
                    rate = Double.parseDouble(holder.rate.getText().toString().trim());
                } catch (NumberFormatException ignored) {}
                try {
                    unit = Double.parseDouble(holder.unit.getText().toString().trim());
                } catch (NumberFormatException ignored) {}
                try {
                    req_unit = Double.parseDouble(holder.req_unit.getText().toString().trim());
                } catch (NumberFormatException ignored) {}

                double total = req_unit * rate;
                holder.amount.setText(String.format("%.2f", total));

                item.setRatePerUnit((int) rate);
                item.setRatePerUnit((int) unit);
                item.setAmount(total);

                calculateTotal();
            }
        };
        holder.unit.removeTextChangedListener(holder.areaWatcher);
        holder.rate.removeTextChangedListener(holder.rateWatcher);

        holder.areaWatcher = watcher;
        holder.rateWatcher = watcher;
        holder.unit.addTextChangedListener(holder.areaWatcher);
        holder.rate.addTextChangedListener(holder.rateWatcher);
    }

    public void calculateTotal() {
        double total = 0.0;
        for (DRPMasterData.RawMaterial b : rawMaterialList) {
            total += b.getAmount();
        }
        if (onAmountChangeListener != null) {
            onAmountChangeListener.onAmountChanged(total);
        }
    }

    @Override
    public int getItemCount() {
        return rawMaterialList.size();
    }

    public void addRow(DRPMasterData.RawMaterial item) {
        rawMaterialList.add(item);
        notifyItemInserted(rawMaterialList.size() - 1);

    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        EditText particulars, unit, req_unit, rate, amount;
        TextView tv_sr_no;

        TextWatcher areaWatcher, rateWatcher;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_sr_no = itemView.findViewById(R.id.tv_sr_no);
            particulars = itemView.findViewById(R.id.rawMaterial_particulars);
            rate = itemView.findViewById(R.id.raw_rateUnit);
            unit = itemView.findViewById(R.id.rawMaterial_unit);
            req_unit = itemView.findViewById(R.id.rawMaterial_requnit);
            amount = itemView.findViewById(R.id.rawMaterial_amount);
        }
    }

}
