package com.trust.pmegpcustomeronboardingapp.activity.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.trust.pmegpcustomeronboardingapp.R;
import com.trust.pmegpcustomeronboardingapp.activity.adapter.ApplicantAgeAdapter;
import com.trust.pmegpcustomeronboardingapp.activity.model.ApplicantRequest;
import com.trust.pmegpcustomeronboardingapp.activity.model.DRPMasterData;
import com.trust.pmegpcustomeronboardingapp.activity.model.ScoreCard;
import com.trust.pmegpcustomeronboardingapp.activity.retrofitClient.ApiClient;
import com.trust.pmegpcustomeronboardingapp.activity.services.ApiServices;
import com.trust.pmegpcustomeronboardingapp.activity.utils.AppConstant;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;

public class ScoreCardFragment  extends BaseFormFragment {
    private ApiServices apiService;
    TextView tv_name,tv_applicant_id,tv_total_marks,tv_marks_secured,tv_percentage;
    ApplicantAgeAdapter applicantAgeAdapter;

    List<ScoreCard.ScoreParameter> scoreParameterList = new ArrayList<>();

    RecyclerView rv_applicant;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        apiService = ApiClient.getClient().create(ApiServices.class);
        String applIdStr = AppConstant.getApplId();


        int applicationId = Integer.parseInt(applIdStr);
        System.out.println("applicationId"+applicationId);
        getScoreCard(applicationId);
    }

    private void getScoreCard(int appId) {
        ApplicantRequest request = new ApplicantRequest(appId);


        apiService.getScoreCardData(request).enqueue(new Callback<ScoreCard>() {
            @Override
            public void onResponse(Call<ScoreCard> call, retrofit2.Response<ScoreCard> response) {
                if (response.isSuccessful() && response.body() != null) {
                    ScoreCard data = response.body();
                    Log.d("SCORE_master_API_RESPONSE", new Gson().toJson(data));
                    setScoreCardDatatoUI(data);
                }
            }

            @Override
            public void onFailure(Call<ScoreCard> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    private void setScoreCardDatatoUI(ScoreCard data) {

        //Applicant data
           tv_name.setText(data.getApplicant().getApplName());
           tv_applicant_id.setText(data.getApplicant().getApplCode());
           tv_total_marks.setText(data.getMaximumMarks());
           tv_marks_secured.setText(data.getMarksSecured());
           int m1 = Integer.parseInt(data.getMarksSecured());
           int m2 = Integer.parseInt(data.getMaximumMarks());
        if (m2 != 0) {
            float percent = (m1 * 100f) / m2;
            tv_percentage.setText(String.format(Locale.getDefault(), "%.2f%%", percent));
        } else {
            tv_percentage.setText("N/A");
        }
        //age
        scoreParameterList = data.getScoreParameters();

        applicantAgeAdapter = new ApplicantAgeAdapter(scoreParameterList);
        rv_applicant.setAdapter(applicantAgeAdapter);



    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.layout_score_fragment, container, false);
        tv_name = view.findViewById(R.id.tv_name);
        tv_applicant_id = view.findViewById(R.id.tv_applicant_id);
        tv_total_marks = view.findViewById(R.id.tv_total_marks);
        tv_marks_secured = view.findViewById(R.id.tv_marks_secured);
        tv_percentage = view.findViewById(R.id.tv_percentage);

        rv_applicant = view.findViewById(R.id.rv_applicant);

        rv_applicant.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }
}
