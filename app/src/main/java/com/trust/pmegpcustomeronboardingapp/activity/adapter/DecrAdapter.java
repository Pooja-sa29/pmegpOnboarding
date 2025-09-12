package com.trust.pmegpcustomeronboardingapp.activity.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.trust.pmegpcustomeronboardingapp.R;
import com.trust.pmegpcustomeronboardingapp.activity.model.ScoreCard;

import java.util.List;

public class DecrAdapter extends RecyclerView.Adapter<DecrAdapter.ClassViewHolder> {

    private List<ScoreCard.ScoreParameter> classList;
    private int selectedPosition = -1;
    public DecrAdapter(List<ScoreCard.ScoreParameter> classList) {
        this.classList = classList;
    }



    @NonNull
    @Override
    public DecrAdapter.ClassViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_applicant_age_item, parent, false);
        return new DecrAdapter.ClassViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DecrAdapter.ClassViewHolder holder, @SuppressLint("RecyclerView") int position) {
        ScoreCard.ScoreParameter scoreParameter = classList.get(position);
        holder.tvCriteria.setText(scoreParameter.getScrCriteria() != null ? scoreParameter.getScrCriteria() : "max");
        holder.tvMarks.setText( String.valueOf(scoreParameter.getMaxMarks()!= 0 ? scoreParameter.getMaxMarks() : 0));
        holder.rbSelect.setChecked(position == selectedPosition);

        holder.rbSelect.setOnClickListener(v -> {
            selectedPosition = position;
            notifyDataSetChanged();
        });

        holder.btnUploadDoc.setOnClickListener(v -> {
        });

        holder.btnUploadDoc.setVisibility(scoreParameter.isUpload() == false ? View.VISIBLE : View.GONE);
        holder.imgUploadedDoc.setVisibility(scoreParameter.isUpload() ? View.VISIBLE : View.GONE);
        holder.delete_scoreCard.setVisibility(scoreParameter.isUpload() == true ?View.VISIBLE :View.GONE);
    }

    @Override
    public int getItemCount() {
        return classList.size();
    }



    public static class ClassViewHolder extends RecyclerView.ViewHolder {
        TextView tvCriteria, tvMarks,tvMarksSecured;
        RadioButton rbSelect;
        Button btnUploadDoc;
        ImageView imgUploadedDoc;
        ImageButton delete_scoreCard;
        public ClassViewHolder(@NonNull View itemView) {
            super(itemView);
            tvCriteria = itemView.findViewById(R.id.tvCriteria);
            tvMarks = itemView.findViewById(R.id.tvMarks);
            rbSelect = itemView.findViewById(R.id.rbSelect);
            btnUploadDoc = itemView.findViewById(R.id.btnUploadDoc);
            imgUploadedDoc = itemView.findViewById(R.id.imgUploadedDoc);
            delete_scoreCard = itemView.findViewById(R.id.delete_score_data);
        }
    }

}
