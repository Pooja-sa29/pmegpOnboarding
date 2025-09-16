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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.trust.pmegpcustomeronboardingapp.R;
import com.trust.pmegpcustomeronboardingapp.activity.Interface.OnDocUploadClickListener;
import com.trust.pmegpcustomeronboardingapp.activity.model.ScoreCard;
import com.trust.pmegpcustomeronboardingapp.activity.utils.TrustMethods;

import java.util.List;

public class AcadamicAdapter extends RecyclerView.Adapter<AcadamicAdapter.ClassViewHolder> {

private List<ScoreCard.ScoreParameter> classList;
private int selectedPosition = -1;
    private OnDocUploadClickListener uploadClickListener;

public AcadamicAdapter(List<ScoreCard.ScoreParameter> classList, OnDocUploadClickListener listener) {
    this.classList = classList;
    this.uploadClickListener=listener;
}



@NonNull
@Override
public AcadamicAdapter.ClassViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_applicant_age_item, parent, false);
    return new AcadamicAdapter.ClassViewHolder(view);
}

@Override
public void onBindViewHolder(@NonNull AcadamicAdapter.ClassViewHolder holder, @SuppressLint("RecyclerView") int position) {
    ScoreCard.ScoreParameter scoreParameter = classList.get(position);
    holder.tvCriteria.setText(scoreParameter.getScrCriteria() != null ? scoreParameter.getScrCriteria() : "max");
    holder.tvMarks.setText( String.valueOf(scoreParameter.getMaxMarks()!= 0 ? scoreParameter.getMaxMarks() : 0));
    holder.rbSelect.setChecked(position == selectedPosition);

    holder.rbSelect.setOnClickListener(v -> {
        selectedPosition = position;
        notifyDataSetChanged();
    });

    holder.btnUploadDoc.setOnClickListener(v -> {
        if (uploadClickListener != null) {
            uploadClickListener.onDocUploadClick(position);
        }
    });
    holder.delete_scoreCard.setOnClickListener(v -> {
        classList.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, classList.size());
    });
    holder.imgUploadedDoc.setOnClickListener(v -> {
        if (scoreParameter.getUploadedFileUri() != null) {
            TrustMethods.showFileDialog(v.getContext(), scoreParameter.getUploadedFileUri());
        } else {
            Toast.makeText(v.getContext(), "No image uploaded", Toast.LENGTH_SHORT).show();
        }
    });
    if (scoreParameter.isUpload()) {
        holder.btnUploadDoc.setVisibility(View.GONE);
        holder.imgUploadedDoc.setVisibility(View.VISIBLE);
        holder.delete_scoreCard.setVisibility(View.VISIBLE);

        if (scoreParameter.getFileLable() != null) {
            holder.tvFileName.setVisibility(View.VISIBLE);
            holder.tvFileName.setText(scoreParameter.getUploadedFileName());
        } else {
            holder.tvFileName.setVisibility(View.GONE);
        }

    } else {
        holder.imgUploadedDoc.setVisibility(scoreParameter.isUpload() ? View.VISIBLE : View.GONE);
        holder.btnUploadDoc.setVisibility(scoreParameter.isUpload() == false ? View.VISIBLE : View.GONE);
        holder.imgUploadedDoc.setVisibility(scoreParameter.isUpload() ? View.VISIBLE : View.GONE);
        holder.delete_scoreCard.setVisibility(scoreParameter.isUpload() == true ? View.VISIBLE : View.GONE);
    }
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

    TextView tvFileName;

    public ClassViewHolder(@NonNull View itemView) {
        super(itemView);
        tvCriteria = itemView.findViewById(R.id.tvCriteria);
        tvMarks = itemView.findViewById(R.id.tvMarks);
        rbSelect = itemView.findViewById(R.id.rbSelect);
        btnUploadDoc = itemView.findViewById(R.id.btnUploadDoc);
        imgUploadedDoc = itemView.findViewById(R.id.imgUploadedDoc);
        delete_scoreCard = itemView.findViewById(R.id.delete_score_data);
        tvFileName = itemView.findViewById(R.id.tvFileName);

    }
}

}

