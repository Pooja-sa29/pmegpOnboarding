package com.trust.pmegpcustomeronboardingapp.activity.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.trust.pmegpcustomeronboardingapp.R;

public class ApplicationFragment extends BaseFormFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.layout_application_fragment, container, false);

//        beneficiery_id = view.findViewById(R.id.beneficiary_id);
//        beneficiary_name = view.findViewById(R.id.beneficiary_name);
//        gender = view.findViewById(R.id.gender);
//        social_category = view.findViewById(R.id.social_category);
//        special_category = view.findViewById(R.id.special_category);
//        email = view.findViewById(R.id.email_id);
//        mobile_number = view.findViewById(R.id.mobile_number);
//        btnNext = view.findViewById(R.id.btnNext);
//        btnPrev = view.findViewById(R.id.btnPrevious);

         /*beneficiery_id.setText(applicantDetailsModel.getApplCode());
         beneficiary_name.setText(applicantDetailsModel.getApplName());
         gender.setText(applicantDetailsModel.getGender());
         social_category.setText(applicantDetailsModel.getSocialCatID());
         special_category.setText(applicantDetailsModel.getSpecialCatID());
         email.setText(applicantDetailsModel.getEmail());
         mobile_number.setText(applicantDetailsModel.getMobileNo1());*/


//        btnPrev.setOnClickListener(v -> {
//            if (navigationListener != null) {
//                navigationListener.onPreviousStep();
//            }
//        });
        return view;
    }
}
