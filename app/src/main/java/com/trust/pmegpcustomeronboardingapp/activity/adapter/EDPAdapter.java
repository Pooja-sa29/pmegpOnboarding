package com.trust.pmegpcustomeronboardingapp.activity.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.trust.pmegpcustomeronboardingapp.R;
import com.trust.pmegpcustomeronboardingapp.activity.model.EDPDetails;

import java.util.List;

public class EDPAdapter extends RecyclerView.Adapter<EDPAdapter.EDPViewHolder> {

    private List<EDPDetails> edpList;
    private OnEDPSelectListener listener;

    public interface OnEDPSelectListener {
        void onSelect(EDPDetails edp);
    }

    public EDPAdapter(List<EDPDetails> edpList, OnEDPSelectListener listener) {
        this.edpList = edpList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public EDPViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_edp_row, parent, false);
        return new EDPViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EDPViewHolder holder, int position) {
        EDPDetails edp = edpList.get(position);
        holder.tvOfficeName.setText(edp.getOff_name());
        holder.tvAddress.setText(edp.getAddress());
        holder.tvDistrictState.setText(edp.getDistrict() + ", " + edp.getState());
        holder.tvContact.setText("Tel: " + edp.getContact());

        holder.layout_Select.setOnClickListener(v -> listener.onSelect(edp));
    }

    @Override
    public int getItemCount() {
        return edpList.size();
    }

    static class EDPViewHolder extends RecyclerView.ViewHolder {
        TextView tvOfficeName, tvAddress, tvDistrictState, tvContact;
        LinearLayout layout_Select;

        public EDPViewHolder(@NonNull View itemView) {
            super(itemView);
            tvOfficeName = itemView.findViewById(R.id.tv_office_name);
            tvAddress = itemView.findViewById(R.id.tv_address);
            tvDistrictState = itemView.findViewById(R.id.tv_district_state);
            tvContact = itemView.findViewById(R.id.tv_contact);
            layout_Select = itemView.findViewById(R.id.layout_select);
        }
    }
}
