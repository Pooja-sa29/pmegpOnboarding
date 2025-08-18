package com.trust.pmegpcustomeronboardingapp.activity.adapter;



import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import com.trust.pmegpcustomeronboardingapp.R;
import com.trust.pmegpcustomeronboardingapp.activity.model.NICGroupModel;

import java.util.List;

    public class ProjectInfoAdapter extends RecyclerView.Adapter<ProjectInfoAdapter.ViewHolder> {

        private List<NICGroupModel> nicGroupList;

        public ProjectInfoAdapter(List<NICGroupModel> nicGroupList) {
            this.nicGroupList = nicGroupList;
        }

        public List<NICGroupModel> getClassList() {
            return nicGroupList;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.project_nic_row_item, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            NICGroupModel item = nicGroupList.get(position);

            holder.tvSrNo.setText(String.valueOf(position + 1));
            holder.tvNicCode.setText(item.getNic_code());
            holder.tvDescription.setText(item.getNic_desc());
//            holder.cbSelect.setChecked(item.isChecked());
//
//            holder.cbSelect.setOnCheckedChangeListener((buttonView, isChecked) -> {
//                item.setChecked(isChecked);
//            });
            holder.cbSelect.setOnClickListener(v -> {
                nicGroupList.remove(holder.getAdapterPosition());
                notifyItemRemoved(holder.getAdapterPosition());
                notifyItemRangeChanged(holder.getAdapterPosition(), nicGroupList.size());
            });
        }

        @Override
        public int getItemCount() {
            return nicGroupList.size();
        }

        public static class ViewHolder extends RecyclerView.ViewHolder {
            TextView tvSrNo, tvNicCode, tvDescription;
            ImageView cbSelect;

            public ViewHolder(View itemView) {
                super(itemView);
                tvSrNo = itemView.findViewById(R.id.tv_sr_no);
                tvNicCode = itemView.findViewById(R.id.tv_nic_code);
                tvDescription = itemView.findViewById(R.id.tv_description);
                cbSelect = itemView.findViewById(R.id.cb_select);
            }
        }

}
