package com.trust.pmegpcustomeronboardingapp.activity.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.trust.pmegpcustomeronboardingapp.R;
import com.trust.pmegpcustomeronboardingapp.activity.retrofitClient.ApiClient;
import com.trust.pmegpcustomeronboardingapp.activity.services.ApiServices;
import com.trust.pmegpcustomeronboardingapp.activity.utils.AppConstant;

public class ScoreCardFragment  extends BaseFormFragment {
    private ApiServices apiService;
    TextView tv_name,tv_applicant_id,tv_total_marks,tv_marks_secured,tv_percentage;

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


        return view;
    }
}
