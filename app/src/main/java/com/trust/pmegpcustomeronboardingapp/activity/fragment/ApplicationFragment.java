package com.trust.pmegpcustomeronboardingapp.activity.fragment;

import static android.content.Context.MODE_PRIVATE;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.trust.pmegpcustomeronboardingapp.R;
import com.trust.pmegpcustomeronboardingapp.activity.adapter.ProjectInfoAdapter;
import com.trust.pmegpcustomeronboardingapp.activity.model.AgencyModel;
import com.trust.pmegpcustomeronboardingapp.activity.model.AgencyRequest;
import com.trust.pmegpcustomeronboardingapp.activity.model.AgencyResponse;
import com.trust.pmegpcustomeronboardingapp.activity.model.AgencyShortCodeResponse;
import com.trust.pmegpcustomeronboardingapp.activity.model.AgencyShortCodes;
import com.trust.pmegpcustomeronboardingapp.activity.model.ApplicantDataModel;
import com.trust.pmegpcustomeronboardingapp.activity.model.ApplicantDetailData;
import com.trust.pmegpcustomeronboardingapp.activity.model.ApplicantInfoModel;
import com.trust.pmegpcustomeronboardingapp.activity.model.ApplicantRequest;
import com.trust.pmegpcustomeronboardingapp.activity.model.ApplicantUpdateResult;
import com.trust.pmegpcustomeronboardingapp.activity.model.ApplicationResponse;
import com.trust.pmegpcustomeronboardingapp.activity.model.BankModel;
import com.trust.pmegpcustomeronboardingapp.activity.model.DistrictModel;
import com.trust.pmegpcustomeronboardingapp.activity.model.GenderModel;
import com.trust.pmegpcustomeronboardingapp.activity.model.InformationSource;
import com.trust.pmegpcustomeronboardingapp.activity.model.NICGroupModel;
import com.trust.pmegpcustomeronboardingapp.activity.model.QualificationModel;
import com.trust.pmegpcustomeronboardingapp.activity.model.ResultModel;
import com.trust.pmegpcustomeronboardingapp.activity.model.SocialCategory;
import com.trust.pmegpcustomeronboardingapp.activity.model.SpecialCategory;
import com.trust.pmegpcustomeronboardingapp.activity.model.StateModel;
import com.trust.pmegpcustomeronboardingapp.activity.model.SubDistrictRequest;
import com.trust.pmegpcustomeronboardingapp.activity.model.SubDistrictResponce;
import com.trust.pmegpcustomeronboardingapp.activity.model.UnitDetailResponse;
import com.trust.pmegpcustomeronboardingapp.activity.model.UnitTypeModel;
import com.trust.pmegpcustomeronboardingapp.activity.model.VillageDetailModel;
import com.trust.pmegpcustomeronboardingapp.activity.model.VillageDetailRequestModel;
import com.trust.pmegpcustomeronboardingapp.activity.model.VillageDetailResponse;
import com.trust.pmegpcustomeronboardingapp.activity.model.VillageRequest;
import com.trust.pmegpcustomeronboardingapp.activity.retrofitClient.ApiClient;
import com.trust.pmegpcustomeronboardingapp.activity.screens.DashboardScreenActivity;
import com.trust.pmegpcustomeronboardingapp.activity.screens.LoginActivity;
import com.trust.pmegpcustomeronboardingapp.activity.screens.NewApplicantUnitActivity;
import com.trust.pmegpcustomeronboardingapp.activity.services.ApiServices;
import com.trust.pmegpcustomeronboardingapp.activity.utils.AppConstant;
import com.trust.pmegpcustomeronboardingapp.activity.utils.TrustMethods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApplicationFragment extends BaseFormFragment {
    private ProgressDialog progressDialog;

    private ApiServices apiService;
    ApplicantDataModel applicantDataModel;
    private List<CardView> allCards;
    private List<TextView> allTextViews;

    LinearLayout implementing_type_agency_layout;
    TextView agency_type_state,agency_type_pin,agency_type_district,agency_type,agency_type_mobile,agency_type_email,txt_application_layout,app_txt_communicationLayout,txtimplementing_agency_layout,app_txt_unitlayout,app_txt_projectinfo_Layout,app_txt_primary_finance_bank_layout,app_txt_altfbank_Layout,app_txt_other_info_Layout;
    CardView cv_application,app_cv_communication_address,app_cv_implementing_agency,app_cv_unitAddress,app_cv_projectinfo,app_cv_primary_Financing_bank,app_cv_alternate_Financing_bank,app_cv_otherInfo;
    Button app_btn_district_change,app_alt_btn_ifsc_code,app_btn_ifsc_code,app_btn_updateform,app_btn_show_nic_code_list,app_btn_industry_activity,app_btn_edpSelection;
    EditText  app_email,app_mobile_number,app_alternate_mobile_number,app_pin_number,app_adharcardno,app_district,app_taluka_block_name,app_pannumber,app_nameofapplicant,app_dob,app_age,app_communication_address,app_unitaddress,app_unitLoc,app_unitpincode,app_lgd_code,app_edp_training_insti_name,app_capital_exp,app_workingcapital,app_totalexp,app_employee_count,app_ifscbank_code,app_branch_name,app_alt_branch_name,app_primary_address,app_pf_districtEd,app_alt_ifscbank_code,app_alt_primary_address,app_alt_pf_districtEd;
    Spinner app_implementing_agency_txt,app_titleSpinner,app_spinner_about_us_spinner,app_iastateSpinner,app_activityspinner,app_agencydistrictSpinner,app_unitvillagenamespinner,app_unitsubdistrictnameSpinner,app_unitdistrictnameList,app_spinner_gender,app_social_category_spinner,app_special_category_spinner,app_qualificationspinner,app_state_spinner,app_bank_spinner_list,app_alt_bank_spinner_list;
    CheckBox app_agencyTypecheck,app_checkbox_availt_note,app_form_check;
    RadioGroup radioGroup;
    RadioButton yesBtn,noBtn,app_yes_radio,app_No_radio;
    LinearLayout availLayout;
    TextView app_agencyTypeName;
    RecyclerView app_rv_product;
    RadioGroup app_edp_radioGrp,app_edp_subgrp_radioGrp,app_cgtmse_radioGrp;
    ArrayAdapter<String> adapter;
    ArrayAdapter<String> socialCatAdapter;
    List<AgencyModel> agencyModelList;
    List<String> stateNamesList;
    List<String> qualificationNameList;
    List<String> specialCatnameList;
    List<String> socialCatnameList;
    List<UnitTypeModel> unittypeList;
    List<SocialCategory> socialCategoryList;
    List<SpecialCategory> specialCategoryList;
    List<String> informationSourceList;
    List<String> titleList = new ArrayList<String>();
    List<String> genderInfoList;
    List<DistrictModel> districtList;
    List<AgencyRequest> agencyRequestList;
    private boolean isPreselecting = false;
    private boolean isInitialLoad = true;
    String comn_district;
    String unit_district;
    int selectedSubdistrictCode;
    String selectedDistrictName,selectedPincode,selectedVillageName,subdistrictName,selectedNodalCode,agencyName,selectedAgencyCode,selectedAgency_Code,selectedBankName2,alt_selectedCityName,selectedBankName1,selectedCityName,selectedQualDesc,selectedQualCode,selectedSocialCatCode,selectedSpecialCatCode,selectedunittype,selectedStateCode,state_shortCode,state_code,selectedStateCodeIa,statename,state_zonal_code,selectedDistrictCode,districtCode,district_name;
    int selectedagencyoffId,agentId,stateId,districtId,activityUnitType,selectedBankListID,alt_selectedBankListID,selectedBankId2;
    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.layout_application_fragment, container, false);
        apiService = ApiClient.getClient().create(ApiServices.class);

        implementing_type_agency_layout = view.findViewById(R.id.app_implementing_type_agency_layout);
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
        agency_type_mobile = view.findViewById(R.id.agency_type_mobile);
        agency_type_email = view.findViewById(R.id.agency_type_email);
        agency_type= view.findViewById(R.id.agencyTypeName);
        agency_type_district= view.findViewById(R.id.agency_type_district);
        agency_type_pin = view.findViewById(R.id.agency_type_pin);
        agency_type_state = view.findViewById(R.id.agency_type_state);
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
        app_alt_branch_name = view.findViewById(R.id.app_alt_branch_name);
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

         radioGroup = view.findViewById(R.id.app_cgtmse_radioGrp);
         yesBtn = view.findViewById(R.id.app_yes_cgt);
         noBtn = view.findViewById(R.id.app_No_cgt);
         availLayout = view.findViewById(R.id.app_avail_layout);
        app_yes_radio = view.findViewById(R.id.app_yes_radio);
        app_No_radio = view.findViewById(R.id.app_No_radio);

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

        app_rv_product.setLayoutManager(new LinearLayoutManager(getContext()));

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
        app_btn_district_change.setOnClickListener(v -> {
            if (selectedStateCode != null) {
                fetchDistrictList(selectedStateCode);
            }
        });

        txt_application_layout.setOnClickListener(v -> toggleSection(cv_application, txt_application_layout));
        app_txt_communicationLayout.setOnClickListener(v -> toggleSection(app_cv_communication_address, app_txt_communicationLayout));
        txtimplementing_agency_layout.setOnClickListener(v -> toggleSection(app_cv_implementing_agency, txtimplementing_agency_layout));
        app_txt_unitlayout.setOnClickListener(v -> toggleSection(app_cv_unitAddress, app_txt_unitlayout));
        app_txt_projectinfo_Layout.setOnClickListener(v -> toggleSection(app_cv_projectinfo, app_txt_projectinfo_Layout));
        app_txt_primary_finance_bank_layout.setOnClickListener(v -> toggleSection(app_cv_primary_Financing_bank, app_txt_primary_finance_bank_layout));
        app_txt_altfbank_Layout.setOnClickListener(v -> toggleSection(app_cv_alternate_Financing_bank, app_txt_altfbank_Layout));
        app_txt_other_info_Layout.setOnClickListener(v -> toggleSection(app_cv_otherInfo, app_txt_other_info_Layout));

        app_btn_updateform.setOnClickListener(v -> {
            ApplicantInfoModel applicant = new ApplicantInfoModel();
             applicantDataModel = new ApplicantDataModel();
            ApplicantDetailData applicantDetailData = new ApplicantDetailData();

            applicant.setApplID(AppConstant.getApplId());
            applicant.setApplCode(applicantDetailData.getApplCode());
            applicant.setAadharNo(applicantDataModel.getAadharNo());
            applicant.setApplTitle(applicantDataModel.getApplTitle());
            applicant.setApplName(applicantDataModel.getApplName());
            applicant.setAgencyID(applicantDataModel.getAgencyID());
            applicant.setAgencyCode(applicantDataModel.getAgencyCode());
            applicant.setStateID(applicantDataModel.getStateID());


            applicant.setStateName(applicantDataModel.getStateName());
            applicant.setComnStateID(applicantDataModel.getComnStateID());
            applicant.setComnStateName(applicantDataModel.getComnStateName());
            applicant.setComnDistrict(applicantDataModel.getComnDistrict());
            applicant.setDistID(applicantDataModel.getDistID());
            applicant.setDistrictName(applicantDataModel.getDistrictName());
            applicant.setAgencyOffID(applicantDataModel.getAgencyOffID());
            applicant.setLegalType(applicantDataModel.getLegalType());
            applicant.setGender(applicantDataModel.getGender());
            applicant.setDateOfBirth(applicantDataModel.getDateofBirth());
            applicant.setAge(Integer.parseInt(app_age.getText().toString()));
            applicant.setSocialCatID(selectedSocialCatCode!= null ? selectedSocialCatCode : "");
            applicant.setSpecialCatID(selectedSpecialCatCode != null ? selectedSpecialCatCode : "");
            applicant.setQualID(selectedQualCode != null ? selectedQualCode : "");
            applicant.setQualDesc(selectedQualDesc != null ? selectedQualDesc : "");
            applicant.setComnAddress(app_communication_address.getText().toString());
            applicant.setComnTaluka(app_taluka_block_name.getText().toString());
            applicant.setComnDistrict(selectedDistrictName);
            applicant.setComnPin(app_pin_number.getText().toString());
            applicant.setMobileNo1(app_mobile_number.getText().toString());
            applicant.setMobileNo2(app_alternate_mobile_number.getText().toString());
            applicant.setEmail(app_email.getText().toString());
            applicant.setPanNo(app_pannumber.getText().toString());
            applicant.setUnitLocation(app_unitLoc.getText().toString());
            applicant.setUnitAddress(app_unitaddress.getText().toString());
            applicant.setUnitTaluka(subdistrictName);
            applicant.setVillageName(selectedVillageName);
            applicant.setLgdCodeId(Integer.parseInt(app_lgd_code.getText().toString()));
            applicant.setUnitDistrict(district_name);
            applicant.setLgdCode(applicantDataModel.getLgdCode());
            applicant.setUnitPin(app_unitpincode.getText().toString());
            applicant.setUnitActivityTypeId("");
            applicant.setEDPTraining(applicant.isEDPTraining());
            applicant.setUnitLocationSame(applicantDataModel.getIsUnitLocationSame());
            applicant.setEdpTrainingInst(app_edp_training_insti_name.getText().toString());
            applicant.setCapitalExpd(Double.parseDouble(app_capital_exp.getText().toString()));
            applicant.setWorkingCapital(Double.parseDouble(app_workingcapital.getText().toString()));
            applicant.setTotalProjectCost(Double.parseDouble(app_totalexp.getText().toString()));
            applicant.setEmployment(Integer.parseInt(app_employee_count.getText().toString()));
            applicant.setFinBankID1(selectedBankListID);
            applicant.setFinBank1(app_branch_name.getText().toString());
            applicant.setBankIFSC1(app_ifscbank_code.getText().toString());
            applicant.setBankBranch1(app_branch_name.getText().toString());
            applicant.setBankAddress1(app_primary_address.getText().toString());
            applicant.setBankDist1(app_pf_districtEd.getText().toString());

            applicant.setFinBankID2(String.valueOf(alt_selectedBankListID));
            applicant.setFinBank2(app_alt_branch_name.getText().toString());
            applicant.setBankIFSC2(app_alt_btn_ifsc_code.getText().toString());
            applicant.setBankBranch2(app_alt_branch_name.getText().toString());
            applicant.setBankAddress2(app_alt_primary_address.getText().toString());
            applicant.setBankDist2(app_alt_pf_districtEd.getText().toString());
            applicant.isAvailCGTMSE(applicantDataModel.getIsAvailCGTMSE());
            applicant.setPmegpRef(applicantDataModel.getPmegpRef());
            applicant.setIsAadharVerified(applicantDetailData.getIsAadharVerified());
            applicant.setIsPanVerified(applicantDataModel.getIsPanVerified());
            applicant.setDeclrAccept(applicantDataModel.getIsDeclrAccept());
            applicant.setSchemeID(applicantDataModel.getSchemeID());
            applicant.setCharAppliAccepted(applicantDataModel.getIsCharAppliAccepted());
            applicant.setStateCode(state_code);
            applicant.setState_Name(statename);
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Log.d("FINAL_JSON", gson.toJson(applicant));

            SaveApplicationForm(applicant);

        });

        initData();

        return view;
    }

    private void fetchDistrictList(String code) {
        System.out.println("state_code"+code);
        DistrictModel request = new DistrictModel(code,"");
        apiService.getDistrictList(request).enqueue(new Callback<List<DistrictModel>>() {
            @Override
            public void onResponse(Call<List<DistrictModel>> call, Response<List<DistrictModel>> response) {
                if (response.isSuccessful()) {
                     applicantDataModel = new ApplicantDataModel();
                    districtList = response.body();
                    System.out.println("districtList"+districtList.size());

                    showDistrictDialog(districtList);


                }
            }

            @Override
            public void onFailure(Call<List<DistrictModel>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    private void SaveApplicationForm(ApplicantInfoModel applicant) {
        apiService.updateApplicantData(applicant).enqueue(new Callback<ApplicantUpdateResult>() {
            @Override
            public void onResponse(Call<ApplicantUpdateResult> call, Response<ApplicantUpdateResult> response) {
                if (response.isSuccessful() && response.body() != null) {
                    ApplicantUpdateResult status = response.body();

                    Log.d("API_RESPONSE", new Gson().toJson(status));

                    if (status.isSuccess()) {
                        Toast.makeText(getContext(), status.getMessage(), Toast.LENGTH_LONG).show();
                        Intent i = new Intent(getContext(), DashboardScreenActivity.class);
                        startActivity(i);

                    } else {
                        Toast.makeText(getContext(), "Save failed: " + status.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getContext(), "Unexpected response", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ApplicantUpdateResult> call, Throwable t) {
                Toast.makeText(getContext(), "Error1: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void showDistrictDialog(List<DistrictModel> districtList) {
        if (districtList == null || districtList.isEmpty()) {
            Toast.makeText(getContext(), "No districts found", Toast.LENGTH_SHORT).show();
            return;
        }

        String[] districtItems = new String[districtList.size()];
        for (int i = 0; i < districtList.size(); i++) {
            districtItems[i] = districtList.get(i).getDistrictCode() + " ~ " + districtList.get(i).getDistrictName();
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setTitle("Select District");
        builder.setItems(districtItems, (dialog, which) -> {
            DistrictModel selected = districtList.get(which);



            if (app_district == null) {
                app_district = requireActivity().findViewById(R.id.district);
            }

            if (app_district != null) {
                app_district.setText(selected.getDistrictName());
                selectedDistrictName = selected.getDistrictName();
            } else {
                Log.e("DistrictDialog", "No EditText with id 'district' found in fragment or activity layout!");
            }
        });
        builder.setNegativeButton("Cancel", null);
        builder.show();
    }

    private void initData() {
        titleList.add(0, "Shri");
        titleList.add(1, "Smt.");
        titleList.add(2, "Kum.");
        titleList.add(3, "Ms.");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(),
                R.layout.spinner_selected_item, titleList);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        app_titleSpinner.setAdapter(adapter);

        fetchStateList();
        fetchAgencyList("");
        fetchQualificationList();
        fetchSpecialCategoryList();
        fetchSocialCategoryList();
        fetchInformationSourceList();
        fetchUnitTypeData("");
        fetchGenderList();
        fetchBankList();

    }

    private void fetchStateList() {
        apiService.getStateList().enqueue(new Callback<List<StateModel>>() {
            @Override
            public void onResponse(Call<List<StateModel>> call, Response<List<StateModel>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<StateModel> states = response.body();
                    System.out.println("sttatelist" +states.size());

                    stateNamesList = new ArrayList<>();
                    stateNamesList.add(0,"--Select state--");
                    for (StateModel state : states) {
                        stateNamesList.add(state.getStateName());


                    }

                    adapter = new ArrayAdapter<>(getContext(), R.layout.spinner_selected_item, stateNamesList);
                    adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    app_state_spinner.setAdapter(adapter);
//                    setSpinnerToAadharState();



                    ArrayAdapter<String> stateadapter = new ArrayAdapter<>(getContext(), R.layout.spinner_selected_item, stateNamesList);
                    stateadapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    app_iastateSpinner.setAdapter(stateadapter);


                    app_state_spinner.setOnItemSelectedListener(new android.widget.AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(android.widget.AdapterView<?> parent, View view, int position, long id) {
                            if (position > 0) {
                                StateModel selectedState = states.get(position - 1);
                                selectedStateCode = selectedState.getStateCode();
                                System.out.println("Selected stateCode: " + selectedStateCode);
                                applicantDataModel  = new ApplicantDataModel();

                                state_shortCode = selectedState.getStateShortCode(); // "MH"
                                state_code = String.valueOf(selectedState.getStateId());

                            } else {
                                selectedStateCode = null;
                            }
                        }

                        @Override
                        public void onNothingSelected(android.widget.AdapterView<?> parent) {
                            selectedStateCode = null;
                        }
                    });
                    app_iastateSpinner.setOnItemSelectedListener(new android.widget.AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(android.widget.AdapterView<?> parent, View view, int position, long id) {
                            if (position > 0) {
                                StateModel selectedState = states.get(position - 1);
                                selectedStateCodeIa = selectedState.getStateCode();
                                System.out.println("Selected stateCode: " + selectedStateCodeIa);
                                stateId = states.get(position - 1).getStateId();
                                statename = states.get(position -1).getStateName();
                                state_zonal_code = states.get(position-1).getState_zone_code();


                                if (isInitialLoad) {
                                    fetchDistrictListforIA(selectedStateCodeIa,comn_district,unit_district);// keep Nagpur
                                } else {
                                    fetchDistrictListforIA(selectedStateCodeIa, "","");// reset on user selection
                                }
                            } else {
                                selectedStateCodeIa = null;
                            }
                        }

                        @Override
                        public void onNothingSelected(android.widget.AdapterView<?> parent) {
                            selectedStateCode = null;
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<List<StateModel>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
//    private void fetchDistrictListforIA(String selectedStateCode,String preSelectedDistrict) {
//        System.out.println("preSelectedDistrict "+preSelectedDistrict);
//        DistrictModel request = new DistrictModel(selectedStateCode,"");
//        apiService.getDistrictList(request).enqueue(new Callback<List<DistrictModel>>() {
//            @Override
//            public void onResponse(Call<List<DistrictModel>> call, Response<List<DistrictModel>> response) {
//                if (response.isSuccessful() && response.body() != null) {
//                    districtList = response.body();
//                    System.out.println("IA districtList size: " + districtList.size());
//
//                    List<String> districtNames = new ArrayList<>();
//                    districtNames.add(0, "--Select District--");
//                    for (DistrictModel district : districtList) {
//                        districtNames.add(district.getDistrictName());
//
//                    }
//
//                    ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(),
//                            R.layout.spinner_selected_item, districtNames);
//                    adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
//                    app_agencydistrictSpinner.setAdapter(adapter);
//
//                    ArrayAdapter<String> unitAdapter = new ArrayAdapter<>(
//                            getContext(),
//                            R.layout.spinner_selected_item,
//                            districtNames
//                    );
//                    unitAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
//                    app_unitdistrictnameList.setAdapter(unitAdapter);
//
//                    if (preSelectedDistrict != null && !preSelectedDistrict.trim().isEmpty()) {
//                        app_agencydistrictSpinner.post(() -> {
//                            setAgencyDistrictSelection(preSelectedDistrict); // e.g. "Nagpur"
//                        });
//                    }
//                    app_agencydistrictSpinner.setOnItemSelectedListener(new android.widget.AdapterView.OnItemSelectedListener() {
//                        @Override
//                        public void onItemSelected(android.widget.AdapterView<?> parent, View view, int position, long id) {
//                            if (position > 0) {
//                                DistrictModel selectedDistrict = districtList.get(position - 1);
//                                selectedDistrictCode = selectedDistrict.getDistrictCode();
//                                districtId = districtList.get(position - 1).getDistrictId();
//                                districtCode = districtList.get(position - 1).getDistrictCode();
//                                district_name = districtList.get(position - 1).getDistrictName();
//                                System.out.println("Selected IA districtCode: " + selectedDistrictCode+ district_name+districtCode+districtId);
//
//                                for (int i = 0; i < districtList.size(); i++) {
//                                    if (districtList.get(i).getDistrictCode().equals(selectedDistrictCode)) {
//                                        int finalI = i;
//                                        app_unitdistrictnameList.post(() -> {
//                                            app_unitdistrictnameList.setSelection(finalI + 1, true);
//                                            System.out.println("unitdistrictnameListspinner set to position: " + (finalI + 1));
//                                        });
//                                        break;
//                                    }
//                                }
//                                agencyRequestList = new ArrayList<>();
//                                implementing_type_agency_layout.setVisibility(View.VISIBLE);
//                                AgencyRequest agencyRequest = new AgencyRequest(1,stateId,districtId);
//                                agencyRequestList.add(agencyRequest);
//                                fetchSubdistrictList(String.valueOf(districtId));
//                                fetchAgencyOffDetails(agencyRequest);
//
//                            }
//                        }
//
//
//                        @Override
//                        public void onNothingSelected(android.widget.AdapterView<?> parent) {}
//                    });
//
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<DistrictModel>> call, Throwable t) {
//                t.printStackTrace();
//            }
//        });
//
//
//    }
private void fetchDistrictListforIA(String selectedStateCode, String preSelectedComnDistrict, String preSelectedUnitDistrict) {

    DistrictModel request = new DistrictModel(selectedStateCode, "");

    apiService.getDistrictList(request).enqueue(new Callback<List<DistrictModel>>() {
        @Override
        public void onResponse(Call<List<DistrictModel>> call, Response<List<DistrictModel>> response) {
            if (response.isSuccessful() && response.body() != null) {
                districtList = response.body();
                Log.d("API", "IA districtList size: " + districtList.size());

                // prepare district names for spinner
                List<String> districtNames = new ArrayList<>();
                districtNames.add("--Select District--");
                for (DistrictModel district : districtList) {
                    districtNames.add(district.getDistrictName());
                }




                // Agency spinner adapter
                ArrayAdapter<String> agencyAdapter = new ArrayAdapter<>(
                        requireContext(),
                        R.layout.spinner_selected_item,
                        districtNames
                );
                agencyAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
                app_agencydistrictSpinner.setAdapter(agencyAdapter);

                // Unit spinner adapter
                ArrayAdapter<String> unitAdapter = new ArrayAdapter<>(
                        getContext(),
                        R.layout.spinner_selected_item,
                        districtNames
                );
                unitAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
                app_unitdistrictnameList.setAdapter(unitAdapter);

                // --- Preselect agency district ---
                if (preSelectedComnDistrict != null && !preSelectedComnDistrict.trim().isEmpty()) {
                    int index = districtNames.indexOf(preSelectedComnDistrict);
                    if (index >= 0) {
                        isPreselecting = true;
                        app_agencydistrictSpinner.setSelection(index, false);
                        Log.i("SpinnerSelection", "Pre-selecting agency district: " + preSelectedComnDistrict + " at index " + index);
                    }
                }

                // --- Preselect unit district ---
                if (preSelectedUnitDistrict != null && !preSelectedUnitDistrict.trim().isEmpty()) {
                    int index = districtNames.indexOf(preSelectedUnitDistrict);
                    if (index >= 0) {
                        app_unitdistrictnameList.setSelection(index, false);
                        Log.i("SpinnerSelection", "Pre-selecting unit district: " + preSelectedUnitDistrict + " at index " + index);
                    }
                }

                if (preSelectedUnitDistrict != null && !preSelectedUnitDistrict.trim().isEmpty()) {
                    int index = districtNames.indexOf(preSelectedUnitDistrict);
                    if (index >= 0) {
                        app_unitdistrictnameList.setSelection(index, false);
                        Log.i("SpinnerSelection", "Pre-selecting unit district: " + preSelectedUnitDistrict + " at index " + index);
                    }
                }



                // Handle user selection for agency district
                app_agencydistrictSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                        if (position > 0) {
                            DistrictModel selectedDistrict = districtList.get(position - 1);
                            districtId = selectedDistrict.getDistrictId();
                            districtCode = selectedDistrict.getDistrictCode();
                            district_name = selectedDistrict.getDistrictName();

                            Log.d("SpinnerSelection", "User selected: " + district_name +" "+districtId);

                            app_unitdistrictnameList.setSelection(position, false);


                            agencyRequestList = new ArrayList<>();
                            implementing_type_agency_layout.setVisibility(View.VISIBLE);
                            AgencyRequest agencyRequest = new AgencyRequest(1, stateId, districtId);
                            agencyRequestList.add(agencyRequest);

                            fetchSubdistrictList(String.valueOf(districtId),"");
                            fetchAgencyOffDetails(agencyRequest);
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {}
                });
            }
        }

        @Override
        public void onFailure(Call<List<DistrictModel>> call, Throwable t) {
            t.printStackTrace();
        }
    });
}


    private void fetchAgencyOffDetails(AgencyRequest agencyRequest) {
        apiService.getAgencyOffDetails(agencyRequest).enqueue(new Callback<List<AgencyResponse>>() {
            @Override
            public void onResponse(Call<List<AgencyResponse>> call, Response<List<AgencyResponse>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<AgencyResponse> agencyResponses = response.body();
                    System.out.println("agencyResponses" +agencyResponses.size());


                    if (agencyResponses != null && !agencyResponses.isEmpty()) {
                        AgencyResponse agency = agencyResponses.get(0);

                        selectedagencyoffId = agency.getAgencyOffId();
                        for (int i = 0; i < agencyResponses.size(); i++) {
                            agency_type_mobile.setText(agencyResponses.get(i).getAgencyOffContactNo());
                            agency_type_email.setText(agencyResponses.get(i).getAgencyOffContactEmail());
                        }

                        app_agencyTypeName.setText(agencyName + "-" + district_name + "-" + state_zonal_code);
                        agency_type_state.setText(statename);
                        agency_type_district.setText(district_name);
                        agency_type_pin.setText(selectedPincode);
                    } else {
                        Log.w("AgencyFetch", "Agency response list is empty!");
                        Toast.makeText(getContext(), "No agency details found", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Log.e("AgencyFetch", "Response failed or body is null");
                }

            }

            @Override
            public void onFailure(Call<List<AgencyResponse>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    private void fetchSubdistrictList(String code,String preSelectedSubdistrictDistrict) {
        System.out.println("code_d"+code);
        SubDistrictRequest request = new SubDistrictRequest(code);
        apiService.GetSubDistricts(request).enqueue(
                new Callback<List<SubDistrictResponce>>() {
                    @Override
                    public void onResponse(Call<List<SubDistrictResponce>> call, Response<List<SubDistrictResponce>> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            List<SubDistrictResponce> subDistrictSource = response.body();
                            List<String> subDistrictInfoList = new ArrayList<>();
                            subDistrictInfoList.add(0, "--Select Sub-District--");

                            for (SubDistrictResponce model : subDistrictSource) {
                                subDistrictInfoList.add(model.getSubdistrict_name());

                            }

                            ArrayAdapter<String> adapter = new ArrayAdapter<>(
                                    getContext(),
                                    R.layout.spinner_selected_item,
                                    subDistrictInfoList
                            );
                            adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
                            app_unitsubdistrictnameSpinner.setAdapter(adapter);

                            int selectedIndex = 0;
                            if (preSelectedSubdistrictDistrict != null && !preSelectedSubdistrictDistrict.isEmpty()) {
                                for (int i = 1; i < subDistrictInfoList.size(); i++) { // start at 1
                                    if (subDistrictInfoList.get(i).equalsIgnoreCase(preSelectedSubdistrictDistrict.trim())) {
                                        selectedIndex = i;
                                        break;
                                    }
                                }
                            }
                            app_unitsubdistrictnameSpinner.setSelection(selectedIndex, false);


                            app_unitsubdistrictnameSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                    if (position > 0){
                                        SubDistrictResponce selectedDistrict = subDistrictSource.get(position - 1);
                                        int subdistrictId = selectedDistrict.getDistrictId();
                                        System.out.println("subdistrictId"+subdistrictId);
                                         selectedSubdistrictCode = subDistrictSource.get(position - 1).getSubdistrict_code();
                                        subdistrictName = subDistrictSource.get(position - 1).getSubdistrict_name();
                                        System.out.println("subdistrictId"+subdistrictId+selectedSubdistrictCode);
                                        fetchVillageList(String.valueOf(selectedSubdistrictCode));
                                    }

                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {

                                }
                            });

                        }
                    }

                    @Override
                    public void onFailure(Call<List<SubDistrictResponce>> call, Throwable t) {
                        t.printStackTrace();
                    }
                }
        );
    }

    private void fetchVillageList(String code) {
        System.out.println("code 1"+code );
        VillageRequest request = new VillageRequest(code);

        apiService.getVillages(request).enqueue(new Callback<List<VillageDetailModel>>() {
            @Override
            public void onResponse(Call<List<VillageDetailModel>> call, Response<List<VillageDetailModel>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<VillageDetailModel> villageList = response.body();


                    List<String> villageNames = new ArrayList<>();
                    for (VillageDetailModel village : villageList) {
                        villageNames.add(village.getVillageName());
                    }

                    ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(),
                            android.R.layout.simple_spinner_item, villageNames);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    app_unitvillagenamespinner.setAdapter(adapter);


//                    if (preSelectedVillage != null && !preSelectedVillage.trim().isEmpty()) {
//                        int index = -1;
//                        for (int i = 0; i < villageList.size(); i++) {
//                            if (villageList.get(i).getVillageName().equalsIgnoreCase(preSelectedVillage)) {
//                                index = i;
//                                break;
//                            }
//                        }
//                        if (index >= 0) {
//                            app_unitvillagenamespinner.setSelection(index, false);
//                            Log.i("SpinnerSelection", "Pre-selecting village: "
//                                    + preSelectedVillage + " at index " + index);
//                        }
//                    }

                    app_unitvillagenamespinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            if (position >= 0 && position < villageList.size()) {
                                VillageDetailModel villageDetailModel= villageList.get(position);
                                String villageCode = villageDetailModel.getVillageCode();
                                System.out.println("villagecode"+villageCode);
                                selectedVillageName = villageDetailModel.getVillageName();

                                fetchVillageDetails(villageCode);
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                            app_pin_number.setText("");
                            app_unitLoc.setText("");
                            app_lgd_code.setText("");
                        }
                    });
                } else {
                    Toast.makeText(getContext(), "No villages found", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<VillageDetailModel>> call, Throwable t) {
                Toast.makeText(getContext(), "Error2: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void fetchVillageDetails(String villageCode) {
        VillageDetailRequestModel request = new VillageDetailRequestModel(villageCode);
        apiService.getVillageDetails(request).enqueue(new Callback<UnitDetailResponse>() {
            @Override
            public void onResponse(Call<UnitDetailResponse> call, Response<UnitDetailResponse> response) {
                if (response.isSuccessful() && response.body() != null && response.body().getData() != null) {
                    VillageDetailResponse village = response.body().getData();
                    Log.d("API_RESPONSE", new Gson().toJson(response.body()));

                    app_lgd_code.setText(String.valueOf(village.getLgdCodeId()));
                    app_pin_number.setText(village.getPincode());
                    app_unitLoc.setText(village.getRuralUrban());
                    selectedPincode = village.getPincode();
                } else {
                    Toast.makeText(getContext(), "Village details not found", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<UnitDetailResponse> call, Throwable t) {
                Toast.makeText(getContext(), "Error3: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void fetchAgencyList(String preselectAgencyCode) {
        apiService.getAgencyList().enqueue(new Callback<List<AgencyModel>>() {
            @Override
            public void onResponse(Call<List<AgencyModel>> call, Response<List<AgencyModel>> response) {
                if (response.isSuccessful() && response.body() != null) {
                     agencyModelList = response.body();
                    System.out.println("agencyList" +agencyModelList.size());

                    List<String> agencyNames = new ArrayList<>();
                    agencyNames.add(0,"--Select Agency--");
                    for (AgencyModel agencyModel : agencyModelList) {
                        agencyNames.add(agencyModel.getAgency_code());


                    }

                    ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), R.layout.spinner_selected_item, agencyNames);
                    adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    app_implementing_agency_txt.setAdapter(adapter);

                    if (preselectAgencyCode != null) {
                        setSpinnerSelection(app_implementing_agency_txt, preselectAgencyCode);
                    }

                    app_implementing_agency_txt.setOnItemSelectedListener(new android.widget.AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(android.widget.AdapterView<?> parent, View view, int position, long id) {
                            if (position > 0) {
                                AgencyModel selectedAgency = agencyModelList.get(position - 1);
                                selectedAgency_Code = selectedAgency.getAgency_code();
                                agentId = Integer.valueOf(selectedAgency.getAgencyId());
                                if (selectedAgencyCode != null && !selectedAgencyCode.isEmpty()) {
                                    String filterAgencyCodeTxt = selectedAgencyCode.split("\\s|\\(")[0];
                                    agencyName = filterAgencyCodeTxt;
                                } else {
                                    agencyName = "";
                                }

                                System.out.println("Selected agencyCode: " + selectedAgencyCode+" "+agentId);
                                fetchAgencyShortCode(selectedAgency);


                            } else {
                                selectedAgencyCode = null;
                            }
                        }

                        @Override
                        public void onNothingSelected(android.widget.AdapterView<?> parent) {
                            selectedAgencyCode = null;
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<List<AgencyModel>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }


    private void fetchAgencyShortCode(AgencyModel agencyModel) {
        System.out.println("agency id " + agencyModel.getAgencyId());
        AgencyModel request = new AgencyModel(agencyModel.getAgencyId());

        apiService.getAgencyShortCode(request).enqueue(new Callback<AgencyShortCodeResponse>() {
            @Override
            public void onResponse(Call<AgencyShortCodeResponse> call, Response<AgencyShortCodeResponse> response) {
                if (response.isSuccessful() && response.body() != null && response.body().isSuccess()) {
                    List<AgencyShortCodes> data = response.body().getData();
                    if (!data.isEmpty()) {
                        AgencyShortCodes agencyShortCodes = data.get(0);
                        selectedAgencyCode = agencyShortCodes.getAgencyCode();
                        selectedNodalCode = agencyShortCodes.getShortCode();
                        System.out.println("nodal code " + selectedNodalCode + " " + selectedAgencyCode);
                    }
                } else {
                    Log.e("DEBUG", "Failed to fetch nodal code");
                }
            }

            @Override
            public void onFailure(Call<AgencyShortCodeResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    private void fetchBankList() {
        apiService.getBankList().enqueue(new Callback<List<BankModel>>() {
            @Override
            public void onResponse(Call<List<BankModel>> call, Response<List<BankModel>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<BankModel> bankModelList = response.body();
                    System.out.println("agencyList" + bankModelList.size());

                    List<String> bankName = new ArrayList<>();
                    bankName.add(0, "--Select Bank name--");
                    for (BankModel bankModel : bankModelList) {
                        bankName.add(bankModel.getBankName());
                    }

                    ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(),
                            R.layout.spinner_selected_item, bankName);
                    adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);

                    // Set adapter for primary bank spinner
                    app_bank_spinner_list.setAdapter(adapter);
                    app_bank_spinner_list.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            if (position > 0) {
                                BankModel bankModel = bankModelList.get(position - 1);
                                selectedBankListID = bankModel.getBankListId();
                                selectedCityName = district_name;
                                selectedBankName1 = bankModel.getBankName();

                                // Check if same bank is selected in alternate bank
                                if (alt_selectedBankListID != 0 && selectedBankListID == alt_selectedBankListID) {
                                    Toast.makeText(getContext(),
                                            "Primary and Alternate Bank cannot be the same",
                                            Toast.LENGTH_SHORT).show();
                                    app_bank_spinner_list.setSelection(0); // reset selection
                                    selectedBankListID = 0;
                                    selectedBankName1 = null;
                                }
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {}
                    });

                    // Set adapter for alternate bank spinner
                    app_alt_bank_spinner_list.setAdapter(adapter);
                    app_alt_bank_spinner_list.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            if (position > 0) {
                                BankModel bankModel = bankModelList.get(position - 1);
                                alt_selectedBankListID = bankModel.getBankListId();
                                alt_selectedCityName = district_name;
                                selectedBankId2 = bankModel.getBankListId();
                                selectedBankName2 = bankModel.getBankName();

                                // Check if same bank is selected in primary bank
                                if (selectedBankListID != 0 && selectedBankListID == alt_selectedBankListID) {
                                    Toast.makeText(getContext(),
                                            "Primary and Alternate Bank cannot be the same",
                                            Toast.LENGTH_SHORT).show();
                                    app_alt_bank_spinner_list.setSelection(0); // reset selection
                                    alt_selectedBankListID = 0;
                                    selectedBankName2 = null;
                                }
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {}
                    });
                }
            }

            @Override
            public void onFailure(Call<List<BankModel>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    private void fetchQualificationList() {
        apiService.getQualificationList("QUAL").enqueue(new Callback<List<QualificationModel>>() {
            @Override
            public void onResponse(Call<List<QualificationModel>> call, Response<List<QualificationModel>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<QualificationModel> qualificationModelList = response.body();
                    System.out.println("qualificationModelList" +qualificationModelList.size());

                    qualificationNameList = new ArrayList<>();
                    qualificationNameList.add(0,"--Select Qualification--");
                    for (QualificationModel qualificationModel : qualificationModelList) {
                        qualificationNameList.add(qualificationModel.getLk_desc());


                    }

                    ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(), R.layout.spinner_selected_item, qualificationNameList);
                    adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    app_qualificationspinner.setAdapter(adapter);
                    app_qualificationspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            QualificationModel qualificationModel = qualificationModelList.get(position);
                            selectedQualCode = qualificationModel.getLk_shortCode();
                            selectedQualDesc = qualificationModel.getLk_desc();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });

                }
            }

            @Override
            public void onFailure(Call<List<QualificationModel>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    private void fetchSocialCategoryList() {
        apiService.getSocialCategory("SPCCT").enqueue(new Callback<List<SocialCategory>>() {
            @Override
            public void onResponse(Call<List<SocialCategory>> call, Response<List<SocialCategory>> response) {
                if (response.isSuccessful() && response.body() != null) {
                     socialCategoryList = response.body();
                    System.out.println("socialCategoryList" +socialCategoryList.size());



                    socialCatnameList = new ArrayList<>();
                    socialCatnameList.add(0,"--Select Social Category--");
                    for (SocialCategory socialCategorymodel : socialCategoryList) {
                        socialCatnameList.add(socialCategorymodel.getLk_desc());


                    }

                     socialCatAdapter = new ArrayAdapter<>(getContext(), R.layout.spinner_selected_item, socialCatnameList);
                    socialCatAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    app_social_category_spinner.setAdapter(socialCatAdapter);
                    app_social_category_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            if (position == 0) {
                                selectedSocialCatCode = null;
                            } else {
                                SocialCategory socialCategory = socialCategoryList.get(position - 1);
                                selectedSocialCatCode = socialCategory.getLk_shortCode();
                            }

                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });


                }
            }

            @Override
            public void onFailure(Call<List<SocialCategory>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
    private void fetchSpecialCategoryList() {
        apiService.getSpecialCategory("SPCLCT").enqueue(new Callback<List<SpecialCategory>>() {
            @Override
            public void onResponse(Call<List<SpecialCategory>> call, Response<List<SpecialCategory>> response) {
                if (response.isSuccessful() && response.body() != null) {
                     specialCategoryList = response.body();
                    System.out.println("qualificationModelList" +specialCategoryList.size());

                    specialCatnameList = new ArrayList<>();
                    specialCatnameList.add(0,"--Select Special Category--");
                    for (SpecialCategory specialCategorymodel : specialCategoryList) {
                        specialCatnameList.add(specialCategorymodel.getLk_desc());


                    }

                    ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), R.layout.spinner_selected_item, specialCatnameList);
                    adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    app_special_category_spinner.setAdapter(adapter);
                    app_special_category_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                            SpecialCategory specialCategory = specialCategoryList.get(position);
//                            selectedSpecialCatCode= specialCategory.getLk_shortCode();
                            if (position == 0) {
                                selectedSpecialCatCode = null;
                            } else {
                                SpecialCategory specialCategory = specialCategoryList.get(position - 1);
                                selectedSpecialCatCode = specialCategory.getLk_shortCode();
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });

                }
            }

            @Override
            public void onFailure(Call<List<SpecialCategory>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    private void fetchInformationSourceList() {
        apiService.getInformationSource("INFOSRC").enqueue(new Callback<List<InformationSource>>() {
            @Override
            public void onResponse(Call<List<InformationSource>> call, Response<List<InformationSource>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<InformationSource> informationSource = response.body();
                    System.out.println("informationSourceList" +informationSource.size());

                    informationSourceList = new ArrayList<>();
                    informationSourceList.add(0,"--Select Information Source--");
                    for (InformationSource informationSourceModel : informationSource) {
                        informationSourceList.add(informationSourceModel.getLk_desc());


                    }

                    ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), R.layout.spinner_selected_item, informationSourceList);
                    adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    app_spinner_about_us_spinner.setAdapter(adapter);


                }
            }

            @Override
            public void onFailure(Call<List<InformationSource>> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }
    private void fetchGenderList() {
        apiService.getGender("GEND").enqueue(new Callback<List<GenderModel>>() {
            @Override
            public void onResponse(Call<List<GenderModel>> call, Response<List<GenderModel>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<GenderModel> genderSource = response.body();
                    System.out.println("Gender" +genderSource.size());

                    genderInfoList = new ArrayList<>();
                    genderInfoList.add(0,"--Select Gender--");
                    for (GenderModel genderModel : genderSource) {
                        genderInfoList.add(genderModel.getLk_desc());


                    }

                    ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), R.layout.spinner_selected_item, genderInfoList);
                    adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    app_spinner_gender.setAdapter(adapter);


                }
            }

            @Override
            public void onFailure(Call<List<GenderModel>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
    private void fetchUnitTypeData(String preSelectedUnitActivityName) {
        apiService.getUnitType().enqueue(new Callback<List<UnitTypeModel>>() {
            @Override
            public void onResponse(Call<List<UnitTypeModel>> call, Response<List<UnitTypeModel>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    unittypeList = response.body();
                    System.out.println("agencyList" +unittypeList.size());

                    List<String> unitNameList = new ArrayList<>();
                    unitNameList.add(0,"--Select Agency--");
                    for (UnitTypeModel unitTypeModel : unittypeList) {
                        unitNameList.add(unitTypeModel.getSchemeName());


                    }

                    ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), R.layout.spinner_selected_item, unitNameList);
                    adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    app_activityspinner.setAdapter(adapter);

                    if (preSelectedUnitActivityName != null && !preSelectedUnitActivityName.trim().isEmpty()) {
                        app_activityspinner.post(() -> {
                            setUnitTypeSpinnerSelection(app_activityspinner, unitNameList, preSelectedUnitActivityName);
                        });
                    }

                    app_activityspinner.setOnItemSelectedListener(new android.widget.AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(android.widget.AdapterView<?> parent, View view, int position, long id) {
                            if (position > 0) {
                                UnitTypeModel selectedUnit = unittypeList.get(position - 1);
                                selectedunittype = selectedUnit.getSchemeName();
                                activityUnitType = selectedUnit.getActivityType();
                                System.out.println("Selected unittype: " + selectedunittype+" "+activityUnitType);
                            } else {
                                selectedunittype = null;
                            }
                        }

                        @Override
                        public void onNothingSelected(android.widget.AdapterView<?> parent) {
                            selectedunittype = null;
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<List<UnitTypeModel>> call, Throwable t) {
                t.printStackTrace();
            }
        });
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

        progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Please wait, Loading Application data...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        apiService.getApplicantData(request).enqueue(new retrofit2.Callback<ApplicationResponse>() {
            @Override
            public void onResponse(Call<ApplicationResponse> call, retrofit2.Response<ApplicationResponse> response) {
                progressDialog.dismiss();
                if (response.isSuccessful() && response.body() != null) {
                    ApplicantDetailData data = response.body().getData();
                    SharedPreferences prefs = getContext().getSharedPreferences("MyAppPrefs", MODE_PRIVATE);
                    SharedPreferences.Editor editor = prefs.edit();
                    editor.putString("ApplName", data.getApplName());
                    editor.apply();

                    Log.d("API_RESPONSE", new Gson().toJson(data));


                    setDataToUI(data);
                }
            }

            @Override
            public void onFailure(Call<ApplicationResponse> call, Throwable t) {
                progressDialog.dismiss();
                System.out.println("print "+t.getMessage());
                t.printStackTrace();
            }
        });
    }

    private void setDataToUI(ApplicantDetailData data) {
        if (data == null) return;
        System.out.println("data_applicant "+new Gson().toJson(data));

        app_adharcardno.setText(data.getAadharNo());
        app_pannumber.setText(data.getPANNo());
        app_nameofapplicant.setText(data.getApplName());
        app_dob.setText(data.getDateofBirth().equals("null")?"": TrustMethods.convertUnixDateToDate(data.getDateofBirth()));
        app_age.setText(String.valueOf(data.getAge()));
        app_communication_address.setText(data.getComnAddress());
        app_district.setText(data.getComnDistrict());

        app_taluka_block_name.setText(data.getComnTaluka());
        app_pin_number.setText(data.getComnPin());
        app_unitaddress.setText(data.getUnitAddress());
        app_unitpincode.setText(data.getUnitPin());
        app_unitLoc.setText(data.getUnitLocation());



        app_mobile_number.setText(data.getMobileNo1());
        if (data.getMobileNo2() != null)
            app_alternate_mobile_number.setText(data.getMobileNo2());

        app_email.setText(data.geteMail());


        app_capital_exp.setText(String.valueOf(data.getCapitalExpd()));
        app_workingcapital.setText(String.valueOf(data.getWorkingCapital()));
        app_totalexp.setText(String.valueOf(data.getTotalProjectCost()));

        app_employee_count.setText(String.valueOf(data.getEmployment()));
        System.out.println("finbank1 "+data.getFinBank1()+","+data.getFinBank2()+" "+data.getUnitTaluka()+" "+data.getVillage_Name());

        if(data.getFinBank1() != null){
            setSpinnerSelection(app_bank_spinner_list,data.getFinBank1());
        }


        app_ifscbank_code.setText(data.getBankIFSC1());
        app_branch_name.setText(data.getBankBranch1());
        app_primary_address.setText(data.getBankAddress1());
        app_pf_districtEd.setText(data.getBankDist1());

        System.out.println("alt_bank"+data.getBankIFSC2()+ " "+data.getBankBranch2()+" "+data.getBankAddress2()+" "+data.getBankDist2());


        if(data.getFinBank2() != null){
            setSpinnerSelection(app_alt_bank_spinner_list,data.getFinBank2());
        }
        app_alt_ifscbank_code.setText(data.getBankIFSC2() != null ? data.getBankIFSC2() : "");
        app_alt_branch_name.setText(data.getBankBranch2() != null ? data.getBankBranch2() : "");
        app_alt_primary_address.setText(data.getBankAddress2() != null ? data.getBankAddress2() :"");
        app_alt_pf_districtEd.setText(data.getBankDist2() != null ? data.getBankDist2() : "");

        app_lgd_code.setText(String.valueOf(data.getLgdCodeId()));

        String genderCode = data.getGender();
        String genderText = null;
        if ("M".equalsIgnoreCase(genderCode)) genderText = "Male";
        else if ("F".equalsIgnoreCase(genderCode)) genderText = "Female";
        else if ("O".equalsIgnoreCase(genderCode)) genderText = "Other";


        if(data.getComnStateName() != null){
            setSpinnerSelection(app_state_spinner, data.getComnStateName());

        }
        if(data.getState_Name() != null){
            setSpinnerSelection(app_iastateSpinner, data.getStateName());

        }


        System.out.println("Data---"+data.getComnDistrict() +" "+data.getUnitDistrict() +" "+data.getDistID());
         comn_district = data.getComnDistrict();
         unit_district = data.getUnitDistrict();
        if (data.getComnDistrict() != null) {
            fetchDistrictListforIA(data.getState_Code(),data.getComnDistrict(),data.getUnitDistrict());
            isInitialLoad = true;
        }

        if(data.getUnitTaluka() != null){
            fetchSubdistrictList(String.valueOf(data.getDistID()),data.getUnitTaluka());
        }

        if(data.getVillage_Name()!=null){
//            fetchVillageList("",data.getVillage_Name());
            setSpinnerSelection(app_unitvillagenamespinner,data.getVillage_Name());
        }
        if (data.getAgencyCode() != null) {
            setAgencySelection(data.getAgencyCode());
        }
        if (genderText != null) {
            setSpinnerSelection(app_spinner_gender, genderText);
        }

        if (data.getSocialCatID() != null) {
            setSocialCategorySelection(data.getSocialCatID());
        }

        if (data.getSpecialCatID() != null) {
            setSpecialCategorySelection(data.getSpecialCatID());
        }

        setSpinnerSelection(app_qualificationspinner, data.getQualDesc());

        System.out.println("activity_type "+data.getUnitActivityType());//type is null
        if (data.getUnitActivityType()!= null) {
            fetchUnitTypeData(data.getUnitActivityType());
        }
        List<NICGroupModel> selectedList   = new ArrayList<>();
        selectedList.add(new NICGroupModel(data.getUnitActivityName(), data.getProdDescr()));
        selectedList.add(new NICGroupModel(data.getUnitActivityName2(), data.getProdDescr2()));
        selectedList.add(new NICGroupModel(data.getUnitActivityName3(), data.getProdDescr3()));




        ProjectInfoAdapter projectInfoAdapter = new ProjectInfoAdapter(selectedList);
        app_rv_product.setAdapter(projectInfoAdapter);



        if (data.isEDPTraining()) {
            app_yes_radio.setChecked(true);
            app_No_radio.setChecked(false);
        } else {
            app_yes_radio.setChecked(false);
            app_No_radio.setChecked(true);
        }


//            if (app_yes_radio.isChecked()) {
//                app_edp_subgrp_radioGrp.setVisibility(View.VISIBLE);
//               app_edp_training_insti_name.setVisibility(View.VISIBLE);
//
//
//            }else if(app_No_radio.isChecked()){
//                app_edp_subgrp_radioGrp.setVisibility(View.VISIBLE);
//                app_edp_training_insti_name.setVisibility(View.VISIBLE);
//                app_btn_edpSelection.setVisibility(View.VISIBLE);
//
//            }


        System.out.println("app_checkbox "+data.isAvailCGTMSE());
        if (data.isAvailCGTMSE()) {
            yesBtn.setChecked(true);
            availLayout.setVisibility(View.VISIBLE);
            app_checkbox_availt_note.setChecked(true);
        } else {
            noBtn.setChecked(true);
            availLayout.setVisibility(View.GONE);
            app_checkbox_availt_note.setChecked(false);
        }
        radioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.app_yes_cgt) {
                availLayout.setVisibility(View.VISIBLE);
            } else if (checkedId == R.id.app_No_cgt) {
                availLayout.setVisibility(View.GONE);
                app_checkbox_availt_note.setChecked(false); // optional
            }
        });


    }



    private void setUnitActivityTypeSelection(String unit) {
        if (unit == null || districtList == null || districtList.isEmpty()) return;

        for (int i = 0; i < districtList.size(); i++) {
            DistrictModel districtModel = districtList.get(i);
            String target = unit.trim();
            String item = districtModel.getDistrictName();
            if (target.equalsIgnoreCase(unit.trim()) ||
                    target.toUpperCase().startsWith(unit.trim().toUpperCase())) {
                int spinnerIndex = i + 1;
                Log.i("SpinnerSelection", "Pre-selecting unit district: " + item + " at index " + spinnerIndex);
                app_unitdistrictnameList.setSelection(spinnerIndex, false);
                return;
            }
        }
    }

    private void setAgencySelection(String agencyCode) {
        if (agencyCode == null || agencyModelList == null) return;

        for (int i = 0; i < agencyModelList.size(); i++) {
            AgencyModel agency = agencyModelList.get(i);
            String code = agency.getAgency_code();

            if (code.equalsIgnoreCase(agencyCode.trim()) ||
                    code.toUpperCase().startsWith(agencyCode.trim().toUpperCase())) {

                app_implementing_agency_txt.setSelection(i + 1); // +1 for "--Select Agency--"
                return;
            }
        }

        Log.w("SpinnerSelection", "Agency not found in list: " + agencyCode);
    }

    private void setSocialCategorySelection(String code) {
        if (code == null || socialCategoryList == null) return;

        for (int i = 0; i < socialCategoryList.size(); i++) {
            SocialCategory cat = socialCategoryList.get(i);
            if (cat.getLk_shortCode().equalsIgnoreCase(code)) {
                app_social_category_spinner.setSelection(i + 1);
                break;
            }
        }
    }
    private void setSpecialCategorySelection(String code) {
        if (code == null ||  specialCategoryList == null) return;

        for (int i = 0; i < specialCategoryList.size(); i++) {
            SpecialCategory cat = specialCategoryList.get(i);
            if (cat.getLk_shortCode().equalsIgnoreCase(code)) {
                app_special_category_spinner.setSelection(i + 1);
                break;
            }
        }
    }

    private void setSpinnerSelection(Spinner spinner, String value) {
        if (value == null || value.trim().isEmpty()) return;
        SpinnerAdapter adapter = spinner.getAdapter();
        if (adapter == null) return;

        for (int i = 0; i < adapter.getCount(); i++) {
            String item = adapter.getItem(i).toString().trim();
            if (item.equalsIgnoreCase(value.trim())) {
                spinner.setSelection(i);
                return;
            }
        }

        // Debug if not found
        Log.w("Spinner", "Value not found in spinner: " + value);
    }

    private void setUnitTypeSpinnerSelection(Spinner spinner, List<String> items, String valueToSelect) {
        if (valueToSelect == null || valueToSelect.trim().isEmpty()) return;

        String target = valueToSelect.trim().toLowerCase(Locale.ROOT);
        for (int i = 0; i < items.size(); i++) {
            String item = items.get(i);
            if (item != null && item.trim().toLowerCase(Locale.ROOT).equals(target)) {
                spinner.setSelection(i, false);
                Log.i("SpinnerSelection", "Pre-selecting: " + item + " at index " + i);
                return;
            }
        }
        Log.w("SpinnerSelection", "Value not found in spinner: " + valueToSelect);
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
