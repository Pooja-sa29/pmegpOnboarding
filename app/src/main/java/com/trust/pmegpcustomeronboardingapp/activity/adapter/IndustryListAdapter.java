package com.trust.pmegpcustomeronboardingapp.activity.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.trust.pmegpcustomeronboardingapp.R;
import com.trust.pmegpcustomeronboardingapp.activity.model.NICGroupModel;

import java.util.List;

public class IndustryListAdapter extends RecyclerView.Adapter<IndustryListAdapter.ClassViewHolder> {

        private List<NICGroupModel> classList;
        private static final int MAX_SELECTION = 3;
        public IndustryListAdapter(List<NICGroupModel> classList) {
            this.classList = classList;
        }

    public List<NICGroupModel> getClassList() {
        return classList;
    }
        @NonNull
        @Override
        public ClassViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
            return new ClassViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ClassViewHolder holder, int position) {
            NICGroupModel item = classList.get(position);
            holder.nicCode.setText(item.getNic_code());
            holder.description.setText(item.getNic_desc());
            holder.nic_check_item.setOnCheckedChangeListener((buttonView, isChecked) -> {
                item.setChecked(isChecked);
            });
        }
    private int getSelectedCount() {
        int count = 0;
        for (NICGroupModel model : classList) {
            if (model.isChecked()) count++;
        }
        return count;
    }
        @Override
        public int getItemCount() {
            return classList.size();
        }

    public void updateList(List<NICGroupModel> newList) {
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
