package com.trust.pmegpcustomeronboardingapp.activity.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.trust.pmegpcustomeronboardingapp.R;
import com.trust.pmegpcustomeronboardingapp.activity.model.Document;

import java.util.List;

public class DocumentAdapter extends RecyclerView.Adapter<DocumentAdapter.DocViewHolder> {

    private List<Document> docList;

    public DocumentAdapter(List<Document> docList) {
        this.docList = docList;
    }

    @NonNull
    @Override
    public DocViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_document, parent, false);
        return new DocViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DocViewHolder holder, int position) {
        Document doc = docList.get(position);
        holder.tvSrNo.setText(String.valueOf(doc.getSrNo()));
        holder.tvFileName.setText(doc.getFileName());

        holder.btnView.setOnClickListener(v -> {
            Toast.makeText(v.getContext(), "Viewing: " + doc.getFileName(), Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return docList.size();
    }

    public static class DocViewHolder extends RecyclerView.ViewHolder {
        TextView tvSrNo, tvFileName;
        Button btnView;

        public DocViewHolder(@NonNull View itemView) {
            super(itemView);
            tvSrNo = itemView.findViewById(R.id.tv_sr_no);
            tvFileName = itemView.findViewById(R.id.tv_file_name);
            btnView = itemView.findViewById(R.id.btn_view);
        }
    }
}
