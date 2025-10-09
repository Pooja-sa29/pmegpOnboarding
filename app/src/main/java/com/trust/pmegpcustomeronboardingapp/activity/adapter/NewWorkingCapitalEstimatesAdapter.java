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

public class NewWorkingCapitalEstimatesAdapter extends RecyclerView.Adapter<com.trust.pmegpcustomeronboardingapp.activity.adapter.NewWorkingCapitalEstimatesAdapter.ViewHolder> {

    private final List<DRPMasterData.WorkingCapitalEstimate> workingCapitalList;
    private final NewWorkingCapitalEstimatesAdapter.OnAmountChangeListener onAmountChangeListener;

    public interface OnAmountChangeListener {
        void onAmountChanged(double total);
    }

    public NewWorkingCapitalEstimatesAdapter(List<DRPMasterData.WorkingCapitalEstimate> list,
                                             NewWorkingCapitalEstimatesAdapter.OnAmountChangeListener listener) {
        this.workingCapitalList = list;
        this.onAmountChangeListener = listener;
    }
    public List<DRPMasterData.WorkingCapitalEstimate> getUpdatedList() {
        List<DRPMasterData.WorkingCapitalEstimate> updatedList = new java.util.ArrayList<>();
        for (DRPMasterData.WorkingCapitalEstimate item : workingCapitalList) {
            DRPMasterData.WorkingCapitalEstimate detail = new DRPMasterData.WorkingCapitalEstimate();
            detail.setParticulars(item.getParticulars());
            try {
                detail.setNoOfDays(item.getNoOfDays());
            } catch (NumberFormatException e) {
                detail.setNoOfDays(0);
            }

            updatedList.add(detail);
        }
        return updatedList;
    }
    @NonNull
    @Override
    public NewWorkingCapitalEstimatesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_item_working_capital_estimate_row, parent, false);
        return new NewWorkingCapitalEstimatesAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DRPMasterData.WorkingCapitalEstimate item = workingCapitalList.get(position);

        holder.tvSrNo.setText(String.valueOf(position + 1));
        holder.etParticulars.setText(item.getParticulars());
        holder.etNoOfDays.setText(String.valueOf(item.getNoOfDays()));

        holder.etParticulars.addTextChangedListener(new NewWorkingCapitalEstimatesAdapter.SimpleWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                item.setParticulars(s.toString());
            }
        });


    }


    @Override
    public int getItemCount() {
        return workingCapitalList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvSrNo;
        EditText etParticulars, etNoOfDays;

        ViewHolder(View itemView) {
            super(itemView);
            tvSrNo = itemView.findViewById(R.id.tv_sr_no);
            etParticulars = itemView.findViewById(R.id.capestimate_particulars);
            etNoOfDays = itemView.findViewById(R.id.capEstimate_noOfDays);
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
