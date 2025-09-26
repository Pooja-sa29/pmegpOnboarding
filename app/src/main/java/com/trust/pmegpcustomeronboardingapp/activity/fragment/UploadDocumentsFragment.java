package com.trust.pmegpcustomeronboardingapp.activity.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.trust.pmegpcustomeronboardingapp.R;
import com.trust.pmegpcustomeronboardingapp.activity.model.ApplicantDetailData;
import com.trust.pmegpcustomeronboardingapp.activity.model.ApplicantRequest;
import com.trust.pmegpcustomeronboardingapp.activity.model.ApplicationResponse;
import com.trust.pmegpcustomeronboardingapp.activity.retrofitClient.ApiClient;
import com.trust.pmegpcustomeronboardingapp.activity.services.ApiServices;
import com.trust.pmegpcustomeronboardingapp.activity.utils.AppConstant;

import retrofit2.Call;

public class UploadDocumentsFragment extends BaseFormFragment {
    private ApiServices apiService;
    TextView tv_name,tv_applicant_id,tv_category,tv_sp_category,tv_education,tv_edp_training,tv_unit_loc;
    RecyclerView rv_docupload;

    @SuppressLint("WrongViewCast")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_docupload_fragment, container, false);
        tv_name =view.findViewById(R.id.tv_name);
        tv_applicant_id = view.findViewById(R.id.tv_applicant_id);
        tv_category = view.findViewById(R.id.tv_category);
        tv_sp_category = view.findViewById(R.id.tv_sp_category);
        tv_education = view.findViewById(R.id.tv_education);
        tv_edp_training = view.findViewById(R.id.tv_edp_training);
        tv_unit_loc = view.findViewById(R.id.tv_unit_loc);
        rv_docupload = view.findViewById(R.id.rv_docupload);

        return view;
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        apiService = ApiClient.getClient().create(ApiServices.class);

        String applIdStr = AppConstant.getApplId();


        int applicationId = Integer.parseInt(applIdStr);
        System.out.println("applicationId"+applicationId);
        getApplicantData(applicationId);


    }

    private void getApplicantData(int applId) {
        ApplicantRequest request = new ApplicantRequest(applId);

        apiService.getApplicantData(request).enqueue(new retrofit2.Callback<ApplicationResponse>() {
            @Override
            public void onResponse(Call<ApplicationResponse> call, retrofit2.Response<ApplicationResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    ApplicantDetailData data = response.body().getData();
                    Log.d("API_RESPONSE", new Gson().toJson(data));


//                    setDataToUI(data);
                }
            }

            @Override
            public void onFailure(Call<ApplicationResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

}
