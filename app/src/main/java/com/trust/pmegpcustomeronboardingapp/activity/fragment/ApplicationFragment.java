package com.trust.pmegpcustomeronboardingapp.activity.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.trust.pmegpcustomeronboardingapp.R;
import com.trust.pmegpcustomeronboardingapp.activity.model.ApplicantDataModel;
import com.trust.pmegpcustomeronboardingapp.activity.model.ApplicantDetailData;
import com.trust.pmegpcustomeronboardingapp.activity.model.ApplicantInfoModel;
import com.trust.pmegpcustomeronboardingapp.activity.model.ApplicantRequest;
import com.trust.pmegpcustomeronboardingapp.activity.model.ApplicationResponse;
import com.trust.pmegpcustomeronboardingapp.activity.model.GenderModel;
import com.trust.pmegpcustomeronboardingapp.activity.retrofitClient.ApiClient;
import com.trust.pmegpcustomeronboardingapp.activity.screens.NewApplicantUnitActivity;
import com.trust.pmegpcustomeronboardingapp.activity.services.ApiServices;
import com.trust.pmegpcustomeronboardingapp.activity.utils.AppConstant;
import com.trust.pmegpcustomeronboardingapp.activity.utils.TrustMethods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApplicationFragment extends BaseFormFragment {
    private ApiServices apiService;
    private List<CardView> allCards;
    private List<TextView> allTextViews;
    TextView txt_application_layout,app_txt_communicationLayout,txtimplementing_agency_layout,app_txt_unitlayout,app_txt_projectinfo_Layout,app_txt_primary_finance_bank_layout,app_txt_altfbank_Layout,app_txt_other_info_Layout;
    CardView cv_application,app_cv_communication_address,app_cv_implementing_agency,app_cv_unitAddress,app_cv_projectinfo,app_cv_primary_Financing_bank,app_cv_alternate_Financing_bank,app_cv_otherInfo;
    Button app_btn_district_change,app_alt_btn_ifsc_code,app_btn_ifsc_code,app_btn_updateform,app_btn_show_nic_code_list,app_btn_industry_activity,app_btn_edpSelection;
    EditText  app_email,app_mobile_number,app_alternate_mobile_number,app_pin_number,app_adharcardno,app_district,app_taluka_block_name,app_pannumber,app_nameofapplicant,app_dob,app_age,app_communication_address,app_unitaddress,app_unitLoc,app_unitpincode,app_lgd_code,app_edp_training_insti_name,app_capital_exp,app_workingcapital,app_totalexp,app_employee_count,app_ifscbank_code,app_branch_name,app_primary_address,app_pf_districtEd,app_alt_ifscbank_code,app_alt_primary_address,app_alt_pf_districtEd;
    Spinner app_implementing_agency_txt,app_titleSpinner,app_spinner_about_us_spinner,app_iastateSpinner,app_activityspinner,app_agencydistrictSpinner,app_unitvillagenamespinner,app_unitsubdistrictnameSpinner,app_unitdistrictnameList,app_spinner_gender,app_social_category_spinner,app_special_category_spinner,app_qualificationspinner,app_state_spinner,app_bank_spinner_list,app_alt_bank_spinner_list;
    CheckBox app_agencyTypecheck,app_checkbox_availt_note,app_form_check;
    TextView app_agencyTypeName;
    RecyclerView app_rv_product;
    RadioGroup app_edp_radioGrp,app_edp_subgrp_radioGrp,app_cgtmse_radioGrp;

    List<String> titleList = new ArrayList<String>();
    List<String> genderInfoList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.layout_application_fragment, container, false);

        app_adharcardno = view.findViewById(R.id.app_adharcardno);
        app_pannumber = view.findViewById(R.id.app_pannumber);
        app_titleSpinner = view.findViewById(R.id.app_titleSpinner);
        app_nameofapplicant = view.findViewById(R.id.app_nameofapplicant);
        app_dob = view.findViewById(R.id.app_dob);
        app_age = view.findViewById(R.id.app_age);
        app_spinner_gender = view.findViewById(R.id.app_spinner_gender);
        app_social_category_spinner = view.findViewById(R.id.app_social_category_spinner);
        app_special_category_spinner = view.findViewById(R.id.app_special_category_spinner);
        app_qualificationspinner = view.findViewById(R.id.app_qualificationspinner);
        app_communication_address = view.findViewById(R.id.app_communication_address);
        app_state_spinner = view.findViewById(R.id.app_state_spinner);
        app_district = view.findViewById(R.id.app_district);
        app_btn_district_change = view.findViewById(R.id.app_btn_district_change);
        app_taluka_block_name = view.findViewById(R.id.app_taluka_block_name);
        app_pin_number = view.findViewById(R.id.app_pin_number);
        app_mobile_number = view.findViewById(R.id.app_mobile_number);
        app_alternate_mobile_number = view.findViewById(R.id.app_alternate_mobile_number);
        app_email = view.findViewById(R.id.app_email);
        app_implementing_agency_txt = view.findViewById(R.id.app_implementing_agency_txt);
        app_iastateSpinner = view.findViewById(R.id.app_iastateSpinner);
        app_agencydistrictSpinner = view.findViewById(R.id.app_agencydistrictSpinner);
        app_agencyTypecheck = view.findViewById(R.id.app_agencyTypecheck);
        app_agencyTypeName = view.findViewById(R.id.app_agencyTypeName);
        app_unitdistrictnameList = view.findViewById(R.id.app_unitdistrictnameList);
        app_unitsubdistrictnameSpinner = view.findViewById(R.id.app_unitsubdistrictnameSpinner);
        app_unitvillagenamespinner = view.findViewById(R.id.app_unitvillagenamespinner);
        app_lgd_code = view.findViewById(R.id.app_lgd_code);
        app_unitpincode = view.findViewById(R.id.app_unitpincode);
        app_unitLoc = view.findViewById(R.id.app_unitLoc);
        app_unitaddress = view.findViewById(R.id.app_unitaddress);
        app_activityspinner = view.findViewById(R.id.app_activityspinner);
        app_btn_industry_activity = view.findViewById(R.id.app_btn_industry_activity);
        app_btn_show_nic_code_list = view.findViewById(R.id.app_btn_show_nic_code_list);
        app_rv_product = view.findViewById(R.id.app_rv_product);
        app_edp_radioGrp = view.findViewById(R.id.app_edp_radioGrp);
        app_edp_subgrp_radioGrp = view.findViewById(R.id.app_edp_subgrp_radioGrp);
        app_edp_training_insti_name = view.findViewById(R.id.app_edp_training_insti_name);
        app_btn_edpSelection = view.findViewById(R.id.app_btn_edpSelection);
        app_capital_exp = view.findViewById(R.id.app_capital_exp);
        app_workingcapital = view.findViewById(R.id.app_workingcapital);
        app_totalexp = view.findViewById(R.id.app_totalexp);
        app_employee_count = view.findViewById(R.id.app_employee_count);
        app_bank_spinner_list = view.findViewById(R.id.app_bank_spinner_list);
        app_ifscbank_code = view.findViewById(R.id.app_ifscbank_code);
        app_btn_ifsc_code = view.findViewById(R.id.app_btn_ifsc_code);
        app_branch_name = view.findViewById(R.id.app_branch_name);
        app_primary_address = view.findViewById(R.id.app_primary_address);
        app_pf_districtEd = view.findViewById(R.id.app_pf_districtEd);
        app_alt_bank_spinner_list = view.findViewById(R.id.app_alt_bank_spinner_list);
        app_alt_ifscbank_code = view.findViewById(R.id.app_alt_ifscbank_code);
        app_alt_btn_ifsc_code = view.findViewById(R.id.app_alt_btn_ifsc_code);
        app_alt_primary_address = view.findViewById(R.id.app_alt_primary_address);
        app_alt_pf_districtEd = view.findViewById(R.id.app_alt_pf_districtEd);
        app_cgtmse_radioGrp = view.findViewById(R.id.app_cgtmse_radioGrp);
        app_checkbox_availt_note = view.findViewById(R.id.app_checkbox_availt_note);
        app_spinner_about_us_spinner = view.findViewById(R.id.app_spinner_about_us_spinner);
        app_form_check = view.findViewById(R.id.app_form_check);
        app_btn_updateform = view.findViewById(R.id.app_btn_updateform);

        txt_application_layout = view.findViewById(R.id.txt_application_layout);
        app_txt_communicationLayout = view.findViewById(R.id.app_txt_communicationLayout);
        txtimplementing_agency_layout = view.findViewById(R.id.txtimplementing_agency_layout);
        app_txt_unitlayout = view.findViewById(R.id.app_txt_unitlayout);
        app_txt_projectinfo_Layout = view.findViewById(R.id.app_txt_projectinfo_Layout);
        app_txt_primary_finance_bank_layout = view.findViewById(R.id.app_txt_primary_finance_bank_layout);
        app_txt_altfbank_Layout = view.findViewById(R.id.app_txt_altfbank_Layout);
        app_txt_other_info_Layout = view.findViewById(R.id.app_txt_other_info_Layout);


        cv_application = view.findViewById(R.id.cv_application);
        app_cv_communication_address = view.findViewById(R.id.app_cv_communication_address);
        app_cv_implementing_agency = view.findViewById(R.id.app_cv_implementing_agency);
        app_cv_unitAddress = view.findViewById(R.id.app_cv_unitAddress);
        app_cv_projectinfo = view.findViewById(R.id.app_cv_projectinfo);
        app_cv_primary_Financing_bank = view.findViewById(R.id.app_cv_primary_Financing_bank);
        app_cv_alternate_Financing_bank = view.findViewById(R.id.app_cv_alternate_Financing_bank);
        app_cv_otherInfo = view.findViewById(R.id.app_cv_otherInfo);

        cv_application.setVisibility(View.GONE);
        app_cv_communication_address.setVisibility(View.GONE);
        app_cv_implementing_agency.setVisibility(View.GONE);
        app_cv_unitAddress.setVisibility(View.GONE);
        app_cv_projectinfo.setVisibility(View.GONE);
        app_cv_primary_Financing_bank.setVisibility(View.GONE);
        app_cv_alternate_Financing_bank.setVisibility(View.GONE);
        app_cv_otherInfo.setVisibility(View.GONE);



        allCards = Arrays.asList(cv_application, app_cv_communication_address, app_cv_implementing_agency,
                app_cv_unitAddress, app_cv_projectinfo, app_cv_primary_Financing_bank, app_cv_alternate_Financing_bank,app_cv_otherInfo);

        allTextViews = Arrays.asList(txt_application_layout,app_txt_communicationLayout, txtimplementing_agency_layout,app_txt_unitlayout,
                app_txt_projectinfo_Layout,app_txt_primary_finance_bank_layout,app_txt_altfbank_Layout,app_txt_other_info_Layout);


        closeAllCards();


        txt_application_layout.setOnClickListener(v -> toggleSection(cv_application, txt_application_layout));
        app_txt_communicationLayout.setOnClickListener(v -> toggleSection(app_cv_communication_address, app_txt_communicationLayout));
        txtimplementing_agency_layout.setOnClickListener(v -> toggleSection(app_cv_implementing_agency, txtimplementing_agency_layout));
        app_txt_unitlayout.setOnClickListener(v -> toggleSection(app_cv_unitAddress, app_txt_unitlayout));
        app_txt_projectinfo_Layout.setOnClickListener(v -> toggleSection(app_cv_projectinfo, app_txt_projectinfo_Layout));
        app_txt_primary_finance_bank_layout.setOnClickListener(v -> toggleSection(app_cv_primary_Financing_bank, app_txt_primary_finance_bank_layout));
        app_txt_altfbank_Layout.setOnClickListener(v -> toggleSection(app_cv_alternate_Financing_bank, app_txt_altfbank_Layout));
        app_txt_other_info_Layout.setOnClickListener(v -> toggleSection(app_cv_otherInfo, app_txt_other_info_Layout));

        initData();
//        app_btn_updateform.setOnClickListener(v -> {
//            ApplicantInfoModel applicant = new ApplicantInfoModel();
//            ApplicantDataModel applicantDataModel = new ApplicantDataModel();
//
//            applicant.setApplID(AppConstant.getApplId());
//            applicant.setApplCode();
//            applicant.setAadharNo(applicantDataModel.getAadharNo());
//            applicant.setApplTitle(applicantDataModel.getApplTitle());
//            applicant.setApplName(applicantDataModel.getApplName());
//            applicant.setAgencyID(applicantDataModel.getAgencyID());
//            applicant.setAgencyCode(applicantDataModel.getAgencyCode());
//            applicant.setStateID(applicantDataModel.getStateID());
//            applicant.setStateName(applicantDataModel.getStateName());
//            applicant.setComnStateID(applicantDataModel.getComnStateID());
//            applicant.setComnStateName(applicantDataModel.getComnStateName());
//            applicant.setDistID(applicantDataModel.getDistID());
//            applicant.setDistrictName(applicantDataModel.getDistrictName());
//            applicant.setAgencyOffID(applicantDataModel.getAgencyOffID());
//            applicant.setLegalType(applicantDataModel.getLegalType());
//            applicant.setGender(applicantDataModel.getGender());
//            applicant.setDateOfBirth(applicantDataModel.getDateofBirth());
//            applicant.setAge(applicantDataModel.getAge());
//            applicant.setSocialCatID(applicantDataModel.getSocialCatID());
//            applicant.setSpecialCatID(applicantDataModel.getSpecialCatID());
//            applicant.setQualID(applicantDataModel.getQualID());
//            applicant.setQualDesc(applicantDataModel.getQualDesc());
//            applicant.setComnAddress(applicantDataModel.getComnAddress());
//            applicant.setComnTaluka(applicantDataModel.getComnTaluka());
//            applicant.setComnDistrict(applicantDataModel.setComnDistrict(););
//            applicant.setComnPin(applicantDataModel.getComnPin());
//            applicant.setMobileNo1(applicantDataModel.getMobileNo1());
//            applicant.setMobileNo2(applicantDataModel.getMobileNo2());
//            applicant.setEmail(applicantDataModel.geteMail());
//            applicant.setPanNo(applicantDataModel.getPanNo());
//            applicant.setUnitLocation(applicantDataModel.getUnitLocation());
//            applicant.setUnitAddress(applicantDataModel.getUnitAddress());
//            applicant.setUnitTaluka(applicantDataModel.getUnitTaluka());
//            applicant.setVillageName(applicantDataModel.getVillageName());
//            applicant.setLgdCodeId(applicantDataModel.getLgdCodeId());
//            applicant.setUnitDistrict(applicantDataModel.getUnitDistrict());
//            applicant.setLgdCode(applicantDataModel.getLgdCode());
//            applicant.setUnitPin(applicantDataModel.getUnitPin());
//            applicant.setUnitActivityTypeId("");
//            applicant.setEDPTraining(applicantDataModel.getIsEDPTraining());
//            applicant.setUnitLocationSame(applicantDataModel.getIsUnitLocationSame());
//            applicant.setEdpTrainingInst(applicantDataModel.getEdpTrainingInst());
//            applicant.setCapitalExpd(applicantDataModel.getCapitalExpd());
//            applicant.setWorkingCapital(applicantDataModel.getWorkingCapital());
//            applicant.setTotalProjectCost(applicantDataModel.getTotalProjectCost());
//            applicant.setEmployment(applicantDataModel.getEmployment());
//            applicant.setFinBankID1(applicantDataModel.getFinBankID1());
//            applicant.setFinBank1(applicantDataModel.getFinBank1());
//            applicant.setBankIFSC1(applicantDataModel.getBankIFSC1());
//            applicant.setBankBranch1(applicantDataModel.getBankBranch1());
//            applicant.setBankAddress1(applicantDataModel.getBankAddress1());
//            applicant.setBankDist1(applicantDataModel.getBankDist1());
//            applicant.setFinBankID1(applicantDataModel.getFinBankID1());
//            applicant.setFinBank1(applicantDataModel.getFinBank1());
//            applicant.setBankIFSC2(applicantDataModel.getBankIFSC2());
//            applicant.setBankBranch2(applicantDataModel.getBankBranch2());
//            applicant.setBankDist2(applicantDataModel.getBankDist2());
//            applicant.isAvailCGTMSE(applicantDataModel.getIsAvailCGTMSE());
//            applicant.setPmegpRef(applicantDataModel.getPmegpRef());
//            applicant.setIsAadharVerified(applicantDataModel.getIsAadharVerified());
//            applicant.setIsPanVerified(applicantDataModel.getIsPanVerified());
//            applicant.setDeclrAccept(applicantDataModel.getIsDeclrAccept());
//            applicant.setSchemeID(applicantDataModel.getSchemeID());
//            applicant.setCharAppliAccepted(applicantDataModel.getIsCharAppliAccepted());
//            applicant.setStateCode(applicantDataModel.getStateCode());
//            applicant.setState_Name(applicantDataModel.getState_Name());
//
//
//        });
        return view;
    }

    private void initData() {
        titleList.add(0, "--Select title--");
        titleList.add(1, "Smt.");
        titleList.add(2, "Kum.");
        titleList.add(3, "Ms.");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(),
                R.layout.spinner_selected_item, titleList);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        app_titleSpinner.setAdapter(adapter);
    }

    @Override
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
                    setDataToUI(data);
                }
            }

            @Override
            public void onFailure(Call<ApplicationResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    private void setDataToUI(ApplicantDetailData data) {
        if (data == null) return;


        app_adharcardno.setText(data.getAadharNo());
        app_pannumber.setText(data.getPANNo());
        app_nameofapplicant.setText(data.getApplName());
        app_dob.setText(data.getDateofBirth().equals("null")?"": TrustMethods.convertUnixDateToDate(data.getDateofBirth()));
        app_age.setText(String.valueOf(data.getAge()));
        app_communication_address.setText(data.getComnAddress());
        app_unitaddress.setText(data.getUnitAddress());
        app_unitpincode.setText(data.getUnitPin());


        app_mobile_number.setText(data.getMobileNo1());
        if (data.getMobileNo2() != null)
            app_alternate_mobile_number.setText(data.getMobileNo2());

        app_email.setText(data.geteMail());


        app_capital_exp.setText(String.valueOf(data.getCapitalExpd()));
        app_workingcapital.setText(String.valueOf(data.getWorkingCapital()));
        app_totalexp.setText(String.valueOf(data.getTotalProjectCost()));

        app_employee_count.setText(String.valueOf(data.getEmployment()));


        app_ifscbank_code.setText(data.getBankIFSC1());
        app_branch_name.setText(data.getBankBranch1());
        app_primary_address.setText(data.getBankAddress1());


        app_lgd_code.setText(String.valueOf(data.getLgdCodeId()));

        setSpinnerSelection(app_spinner_gender, data.getGender());
        setSpinnerSelection(app_social_category_spinner, data.getSocialCatID());
        setSpinnerSelection(app_special_category_spinner, data.getSpecialCatID());
        setSpinnerSelection(app_qualificationspinner, data.getQualDesc());
    }

    private void setSpinnerSelection(Spinner spinner, String value) {
        if (value == null) return;
        for (int i = 0; i < spinner.getCount(); i++) {
            if (spinner.getItemAtPosition(i).toString().equalsIgnoreCase(value)) {
                spinner.setSelection(i);
                break;
            }
        }
    }

    private void toggleSection(CardView selectedCard, TextView selectedText) {
        boolean isVisible = selectedCard.getVisibility() == View.VISIBLE;

        closeAllCards();

        if (!isVisible) {
            selectedCard.setVisibility(View.VISIBLE);
            selectedText.setCompoundDrawablesWithIntrinsicBounds(
                    null, null,
                    ContextCompat.getDrawable(getContext(), R.drawable.arrow_down_24),
                    null
            );
        }
    }
    private void closeAllCards() {
        for (CardView card : allCards) {
            card.setVisibility(View.GONE);
        }
        for (TextView txt : allTextViews) {
            txt.setCompoundDrawablesWithIntrinsicBounds(null, null, ContextCompat.getDrawable(getContext(), R.drawable.arrow_up_24), null);
        }
    }
}
