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

public class NewSalaryDetailAdapter extends RecyclerView.Adapter<NewSalaryDetailAdapter.ViewHolder> {

        private final List<DRPMasterData.SalaryDetail> salaryDetailList;
        private final NewSalaryDetailAdapter.OnAmountChangeListener onAmountChangeListener;

        public interface OnAmountChangeListener {
            void onAmountChanged(double total);
        }

    public NewSalaryDetailAdapter(List<DRPMasterData.SalaryDetail> salaryDetails, NewSalaryDetailAdapter.OnAmountChangeListener listener) {
            this.salaryDetailList = salaryDetails;
            this.onAmountChangeListener = listener;
        }


    public List<DRPMasterData.SalaryDetail> getUpdatedList() {
        List<DRPMasterData.SalaryDetail> updatedList = new java.util.ArrayList<>();
        for (DRPMasterData.SalaryDetail item : salaryDetailList) {
            DRPMasterData.SalaryDetail detail = new DRPMasterData.SalaryDetail();
            detail.setParticulars(item.getParticulars());
            try {
                detail.setNoOfStaff(item.getNoOfStaff());
            } catch (NumberFormatException e) {
                detail.setNoOfStaff((int) 0.0);
            }
            try {
                detail.setAmount(item.getAmount());
            } catch (NumberFormatException e) {
                detail.setAmount(0.0);
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
        public NewSalaryDetailAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_item_salary_row, parent, false);
            return new NewSalaryDetailAdapter.ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull NewSalaryDetailAdapter.ViewHolder holder, int position) {
            DRPMasterData.SalaryDetail item = salaryDetailList.get(position);
            holder.tv_sr_no.setText(String.valueOf(position + 1));

            holder.particulars.setText(item.getParticulars());
            holder.staff_count.setText(String.valueOf(item.getNoOfStaff()));
            holder.wages_permonth.setText(String.valueOf(item.getWagesPerMonth()));
            holder.amount.setText(String.format("%.2f", item.getAmount()));

            TextWatcher watcher = new SimpleTextWatcher() {
                @Override
                public void afterTextChanged(Editable s) {
                    double count = 0.0, wages = 0.0;
                    try {
                        count = Double.parseDouble(holder.staff_count.getText().toString().trim());
                    } catch (NumberFormatException ignored) {}
                    try {
                        wages = Double.parseDouble(holder.wages_permonth.getText().toString().trim());
                    } catch (NumberFormatException ignored) {}


                    double total = wages *wages * count;
                    holder.amount.setText(String.format("%.2f", total));

                    item.setNoOfStaff((int) count);
                    item.setAmount(total);

                    calculateTotal();
                }
            };
            holder.wages_permonth.removeTextChangedListener(holder.areaWatcher);
            holder.staff_count.removeTextChangedListener(holder.rateWatcher);

            holder.areaWatcher = watcher;
            holder.rateWatcher = watcher;
            holder.wages_permonth.addTextChangedListener(holder.areaWatcher);
            holder.wages_permonth.addTextChangedListener(holder.rateWatcher);
        }

        public void calculateTotal() {
            double total = 0.0;
            for (DRPMasterData.SalaryDetail b : salaryDetailList) {
                total += b.getAmount();
            }
            if (onAmountChangeListener != null) {
                onAmountChangeListener.onAmountChanged(total);
            }
        }

        @Override
        public int getItemCount() {
            return salaryDetailList.size();
        }

        public void addRow(DRPMasterData.SalaryDetail item) {
            salaryDetailList.add(item);
            notifyItemInserted(salaryDetailList.size() - 1);

        }

        static class ViewHolder extends RecyclerView.ViewHolder {
            EditText particulars, staff_count, wages_permonth, amount;
            TextView tv_sr_no;

            TextWatcher areaWatcher, rateWatcher;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                tv_sr_no = itemView.findViewById(R.id.tv_sr_no);
                particulars = itemView.findViewById(R.id.salary_particulars);
                staff_count = itemView.findViewById(R.id.salary_staff);
                wages_permonth = itemView.findViewById(R.id.salary_wagespermonth);
                amount = itemView.findViewById(R.id.salary_amount);
            }
        }

    }

