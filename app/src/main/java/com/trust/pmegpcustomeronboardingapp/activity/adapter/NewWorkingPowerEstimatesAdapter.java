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

public class NewWorkingPowerEstimatesAdapter extends RecyclerView.Adapter<NewWorkingPowerEstimatesAdapter.ViewHolder> {

    private final List<DRPMasterData.PowerEstimateExpenditure> powerEstimateExpenditureList;
    private final NewWorkingPowerEstimatesAdapter.OnAmountChangeListener onAmountChangeListener;

    public interface OnAmountChangeListener {
        void onAmountChanged(double total);
    }

    public NewWorkingPowerEstimatesAdapter(List<DRPMasterData.PowerEstimateExpenditure> list,
                                           NewWorkingPowerEstimatesAdapter.OnAmountChangeListener listener) {
        this.powerEstimateExpenditureList = list;
        this.onAmountChangeListener = listener;
    }

    @NonNull
    @Override
    public NewWorkingPowerEstimatesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_item_working_power_estimate_row, parent, false);
        return new NewWorkingPowerEstimatesAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DRPMasterData.PowerEstimateExpenditure item = powerEstimateExpenditureList.get(position);

        holder.tvSrNo.setText(String.valueOf(position + 1));
        holder.etCost.setText(String.valueOf(item.getCost()));

        holder.etAmount.setText(String.valueOf(item.getAmountInRs()));


    }


    @Override
    public int getItemCount() {
        return powerEstimateExpenditureList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvSrNo;
        EditText etCost, etAmount;

        ViewHolder(View itemView) {
            super(itemView);
            tvSrNo = itemView.findViewById(R.id.tv_sr_no);
            etCost = itemView.findViewById(R.id.powerestimate_cost);
            etAmount = itemView.findViewById(R.id.powerestimate_amountInRs);
        }
    }

    private abstract static class SimpleWatcher implements TextWatcher {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }
    }
}
