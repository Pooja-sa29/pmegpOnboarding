package com.trust.pmegpcustomeronboardingapp.activity.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.trust.pmegpcustomeronboardingapp.R;
import com.trust.pmegpcustomeronboardingapp.activity.model.DPRDetailData;
import com.trust.pmegpcustomeronboardingapp.activity.model.NICGroupModel;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ClassViewHolder> {

    private List<DPRDetailData> classList;

    public ProductAdapter(List<DPRDetailData> classList) {
        this.classList = classList;
    }

    public List<DPRDetailData> getClassList() {
        return classList;
    }

    @NonNull
    @Override
    public ProductAdapter.ClassViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ProductAdapter.ClassViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ClassViewHolder holder, int position) {
        DPRDetailData item = classList.get(position);
        holder.nic_check_item.setVisibility(View.GONE);
        holder.nicCode.setText(item.getUnitActivityName2());
        holder.description.setText(item.getProdDescr2());

    }

    @Override
    public int getItemCount() {
        return classList.size();
    }

    public void updateList(List<DPRDetailData> newList) {
        classList.clear();
        classList.addAll(newList);
        notifyDataSetChanged();
    }

    public static class ClassViewHolder extends RecyclerView.ViewHolder {
        TextView nicCode, description;
        CheckBox nic_check_item;

        public ClassViewHolder(@NonNull View itemView) {
            super(itemView);
            nicCode = itemView.findViewById(R.id.nicCode);
            description = itemView.findViewById(R.id.description);
            nic_check_item = itemView.findViewById(R.id.check_nic_item);
        }
    }
}