package com.trust.pmegpcustomeronboardingapp.activity.screens;

import static androidx.core.content.ContentProviderCompat.requireContext;
import static java.security.AccessController.getContext;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.trust.pmegpcustomeronboardingapp.R;
import com.trust.pmegpcustomeronboardingapp.activity.adapter.EDPAdapter;
import com.trust.pmegpcustomeronboardingapp.activity.adapter.ProjectInfoAdapter;
import com.trust.pmegpcustomeronboardingapp.activity.fragment.IndustryDataDialogFragment;
import com.trust.pmegpcustomeronboardingapp.activity.model.AdharOtpRequest;
import com.trust.pmegpcustomeronboardingapp.activity.model.AdharOtpResponse;
import com.trust.pmegpcustomeronboardingapp.activity.model.AdharVerificationResponse;
import com.trust.pmegpcustomeronboardingapp.activity.model.AgencyModel;
import com.trust.pmegpcustomeronboardingapp.activity.model.AgencyRequest;
import com.trust.pmegpcustomeronboardingapp.activity.model.AgencyResponse;
import com.trust.pmegpcustomeronboardingapp.activity.model.AgencyShortCodeResponse;
import com.trust.pmegpcustomeronboardingapp.activity.model.AgencyShortCodes;
import com.trust.pmegpcustomeronboardingapp.activity.model.ApplicantDataModel;
import com.trust.pmegpcustomeronboardingapp.activity.model.BankDetailRequest;
import com.trust.pmegpcustomeronboardingapp.activity.model.BankDetailResponce;
import com.trust.pmegpcustomeronboardingapp.activity.model.BankModel;
import com.trust.pmegpcustomeronboardingapp.activity.model.DistrictModel;
import com.trust.pmegpcustomeronboardingapp.activity.model.EDPDetails;
import com.trust.pmegpcustomeronboardingapp.activity.model.EDPRequest;
import com.trust.pmegpcustomeronboardingapp.activity.model.EDPResponse;
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
import com.trust.pmegpcustomeronboardingapp.activity.model.UidRequest;
import com.trust.pmegpcustomeronboardingapp.activity.model.UnitDetailResponse;
import com.trust.pmegpcustomeronboardingapp.activity.model.UnitTypeModel;
import com.trust.pmegpcustomeronboardingapp.activity.model.VillageDetailModel;
import com.trust.pmegpcustomeronboardingapp.activity.model.VillageDetailRequestModel;
import com.trust.pmegpcustomeronboardingapp.activity.model.VillageDetailResponse;
import com.trust.pmegpcustomeronboardingapp.activity.model.VillageRequest;
import com.trust.pmegpcustomeronboardingapp.activity.retrofitClient.ApiClient;
import com.trust.pmegpcustomeronboardingapp.activity.services.ApiServices;
import com.trust.pmegpcustomeronboardingapp.activity.utils.Validator;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewApplicantUnitActivity extends AppCompatActivity {

    ScrollView scrollView;
    CardView cv_basicInfo, cv_correspondenceadd, cv_ImplementingAgency, cv_unitAddress, cv_projectInfo, cv_primaryfbanking, cv_alt_fbanking, cv_otherInfo;
    TextView txt_basic_info, txt_communication_address, txt_imp_agency, txt_unit_add, txt_project_info, txt_primary_fbanking, txt_alt_fbanking, cv_other_info_layout;
    private List<CardView> allCards;
    private List<TextView> allTextViews;
    RecyclerView rv_product_recyclerview;
    ArrayAdapter<String> adapter;
    String apiState = null;
    Spinner state_spinner, implementing_agency_spinner, bankNameSpinner, alternate_finance_spinner, unit_type_spinner, iastateSpinner, iaDistrictSpinner, unitlocationspinner, unitdistrictnameListspinner, qualificationspinner, specialCategorySpinner, socialCategorySpinner, informationSourceSpinner, spinner_gender, titleSpinner, spinner_subdistrict, spinnerVillage;
    Button changeDistrict, btn_edpSelection, btn_submitform, btn_validateaddhar, btn_ifsc_code, alt_btn_ifsc_code, btn_industry_activity;
    ApiServices apiService;
    private ProgressDialog progressDialog;
    String selectedStateCode, state_shortCode, selectedStateCodeIa, selectedAgencyCode, selectedAgency_Code, selectedNodalCode, selectedunittype, selectedDistrictCode;
    List<DistrictModel> districts;
    List<String> stateNamesList;
    List<String> qualificationNameList;
    List<String> specialCatnameList;
    List<String> socialCatnameList;
    List<String> informationSourceList;
    List<String> villageInfoList;
    List<String> genderInfoList;
    List<DistrictModel> districtList;
    List<String> subdistrictModelList;
    List<EDPDetails> EdpDetailList;
    List<AgencyRequest> agencyRequestList;
    List<String> titleList = new ArrayList<String>();
    EditText   ifsc_code,alt_ifscbank_code,address,alt_primary_address,districtName,alt_pf_districtEd,branchName,alt_branch_name,email, lgd_code, edp_training_insti, pin_code, unit_loc, adharcardno, nameofapplicant, uid_dob, uid_age, communication_address, district, taluka_block_name, pin_number, mobile_number, alternate_mobile_number, panNumber, unitlocation, unitaddress, unitPin, capital_exp, workingcapital, totalexp, employee_count;
     TextView capital_exptxt,workingcap_exptxt;
    String correspondence_pincode;
    CheckBox agency_type_check;
    TextView agency_type, agency_type_district, agency_type_pin, agency_type_state, agency_type_mobile, agency_type_email;
    LinearLayout implementing_type_agency_layout;
    String agencyName, edp_name, district_name, statename, subdistrictName, state_zonal_code, nodalCode, gender;
    String districtCode, pinCode, unitLocation, selectedCityName, alt_selectedCityName, selectedSocialCatCode, selectedBankName1, selectedBankName2, selectedNicDesc, selectedNicDesc2, selectedNicDesc3, selectedNicCode, selectedNicCode2, selectedNicCode3, selectedIfsc1, selectedIfsc2, selectedBankDistrict2, selectedBankDistrict1, selectedBankAddress2, selectedBankAddress1, selectedBranch1, selectedBranch2, selectedSpecialCatCode, selectedQualCode, selectedQualDesc, selectedDistrictName, selectedVillageName, selectedPincode;
    int stateId, districtId, state_code, lgdCode, activityUnitType, alt_selectedBankListID, selectedBankListID, selectedBankId2, selectedagencyoffId;
    RadioGroup cgtmse_radioGrp, edp_radioGrp, edp_subgrp_radioGrp;
    CheckBox checkbox_availt_note;
    int cgtmseFlag = 0, agentId;
    private static final String[] tensNames = {
            "", " Ten", " Twenty", " Thirty", " Forty", " Fifty", " Sixty", " Seventy", " Eighty", " Ninety"
    };

    private static final String[] numNames = {
            "", " One", " Two", " Three", " Four", " Five", " Six", " Seven", " Eight", " Nine", " Ten",
            " Eleven", " Twelve", " Thirteen", " Fourteen", " Fifteen", " Sixteen", " Seventeen", " Eighteen", " Nineteen"
    };


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_unit_applicant);

        apiService = ApiClient.getClient().create(ApiServices.class);

        scrollView = findViewById(R.id.scrollView);
        cv_basicInfo = findViewById(R.id.cv_basic_info);
        cv_correspondenceadd = findViewById(R.id.cv_communication_address);
        cv_ImplementingAgency = findViewById(R.id.cv_implementing_agency);
        cv_unitAddress = findViewById(R.id.cv_unitAddress);
        cv_projectInfo = findViewById(R.id.cv_projectinfo);
        cv_primaryfbanking = findViewById(R.id.cv_primary_Financing_bank);
        cv_alt_fbanking = findViewById(R.id.cv_alternate_Financing_bank);
        cv_otherInfo = findViewById(R.id.cv_otherInfo);

        txt_basic_info = findViewById(R.id.txt_basic_layout);
        txt_communication_address = findViewById(R.id.txt_communicationLayout);
        txt_imp_agency = findViewById(R.id.txtimplementing_agency_layout);
        txt_unit_add = findViewById(R.id.txt_unitlayout);
        txt_project_info = findViewById(R.id.txt_projectinfo_Layout);
        txt_primary_fbanking = findViewById(R.id.txt_primary_finance_bank_layout);
        txt_alt_fbanking = findViewById(R.id.txt_altfbank_Layout);
        cv_other_info_layout = findViewById(R.id.txt_other_info_Layout);

        state_spinner = findViewById(R.id.state_spinner);
        bankNameSpinner = findViewById(R.id.bank_spinner_list);
        alternate_finance_spinner = findViewById(R.id.alt_bank_spinner_list);
        implementing_agency_spinner = findViewById(R.id.implementing_agency_txt);
        iastateSpinner = findViewById(R.id.iastateSpinner);
        iaDistrictSpinner = findViewById(R.id.agencydistrictSpinner);
        unitdistrictnameListspinner = findViewById(R.id.unitdistrictnameList);
        specialCategorySpinner = findViewById(R.id.special_category_spinner);
        socialCategorySpinner = findViewById(R.id.social_category_spinner);
        qualificationspinner = findViewById(R.id.qualificationspinner);
        informationSourceSpinner = findViewById(R.id.spinner_about_us_spinner);
        spinner_gender = findViewById(R.id.spinner_gender);
        unit_type_spinner = findViewById(R.id.activityspinner);
        titleSpinner = findViewById(R.id.titleSpinner);
        spinner_subdistrict = findViewById(R.id.unitsubdistrictnameSpinner);
        spinnerVillage = findViewById(R.id.unitvillagenamespinner);
//        unitlocationspinner = findViewById(R.id.unitlocationspinner);
        changeDistrict = findViewById(R.id.btn_district_change);
        btn_edpSelection = findViewById(R.id.btn_edpSelection);
        btn_submitform = findViewById(R.id.btn_submitform);
        btn_validateaddhar = findViewById(R.id.validateaddhar);
        btn_ifsc_code = findViewById(R.id.btn_ifsc_code);
        alt_btn_ifsc_code = findViewById(R.id.alt_btn_ifsc_code);
        btn_industry_activity = findViewById(R.id.btn_industry_activity);
        rv_product_recyclerview = findViewById(R.id.rv_product);
        rv_product_recyclerview.setLayoutManager(new LinearLayoutManager(this));
        adharcardno = findViewById(R.id.adharcardno);
        nameofapplicant = findViewById(R.id.nameofapplicant);
        uid_dob = findViewById(R.id.dob);
        uid_age = findViewById(R.id.age);
        communication_address = findViewById(R.id.communication_address);
        district = findViewById(R.id.district);
        taluka_block_name = findViewById(R.id.taluka_block_name);
        pin_number = findViewById(R.id.pin_number);
        mobile_number = findViewById(R.id.mobile_number);
        alternate_mobile_number = findViewById(R.id.alternate_mobile_number);
        panNumber = findViewById(R.id.pannumber);
        unitlocation = findViewById(R.id.unitLoc);
        unitaddress = findViewById(R.id.unitaddress);
        unitPin = findViewById(R.id.unitpincode);
        capital_exp = findViewById(R.id.capital_exp);
        workingcapital = findViewById(R.id.workingcapital);
        totalexp = findViewById(R.id.totalexp);
        employee_count = findViewById(R.id.employee_count);
        checkbox_availt_note = findViewById(R.id.checkbox_availt_note);

        email = findViewById(R.id.email);
        lgd_code = findViewById(R.id.lgd_code);
        pin_code = findViewById(R.id.unitpincode);
        unit_loc = findViewById(R.id.unitLoc);

        edp_training_insti = findViewById(R.id.edp_training_insti_name);
        agency_type = findViewById(R.id.agencyTypeName);
        agency_type_district = findViewById(R.id.agency_type_district);
        agency_type_pin = findViewById(R.id.agency_type_pin);
        agency_type_state = findViewById(R.id.agency_type_state);
        agency_type_mobile = findViewById(R.id.agency_type_mobile);
        agency_type_email = findViewById(R.id.agency_type_email);
        cgtmse_radioGrp = findViewById(R.id.cgtmse_radioGrp);
        edp_radioGrp = findViewById(R.id.edp_radioGrp);
        edp_subgrp_radioGrp = findViewById(R.id.edp_subgrp_radioGrp);
        implementing_type_agency_layout = findViewById(R.id.implementing_type_agency_layout);

//        unitlocationspinner.setEnabled(false);
//        unitlocationspinner.setClickable(false);

        branchName = findViewById(R.id.branch_name);
        alt_branch_name = findViewById(R.id.alt_branch_name);
        ifsc_code = findViewById(R.id.ifscbank_code);
        alt_ifscbank_code = findViewById(R.id.alt_ifscbank_code);
        address = findViewById(R.id.primary_address);
        alt_primary_address = findViewById(R.id.alt_primary_address);
        districtName = findViewById(R.id.pf_districtEd);
        alt_pf_districtEd = findViewById(R.id.alt_pf_districtEd);

        capital_exptxt= findViewById(R.id.capital_exp_words);
        workingcap_exptxt = findViewById(R.id.workingcapital_words);

        cv_basicInfo.setVisibility(View.VISIBLE);
        cv_correspondenceadd.setVisibility(View.GONE);
        cv_ImplementingAgency.setVisibility(View.GONE);
        cv_unitAddress.setVisibility(View.GONE);
        cv_projectInfo.setVisibility(View.GONE);
        cv_primaryfbanking.setVisibility(View.GONE);
        cv_alt_fbanking.setVisibility(View.GONE);
        cv_otherInfo.setVisibility(View.GONE);
        findViewById(R.id.edp_training_insti_name).setVisibility(View.GONE);

        changeDistrict.setOnClickListener(v -> {
            if (selectedStateCode != null) {
                fetchDistrictList(selectedStateCode);
            }
        });


        btn_validateaddhar.setOnClickListener(v -> {

            getAdharOtp(adharcardno.getText().toString());
        });

        btn_submitform.setOnClickListener(v -> {
            ApplicantDataModel applicant = new ApplicantDataModel();

            //basic info validation

            if (!Validator.isEmpty(adharcardno, "12 digit Aadhar number of the applicant should be filled in.", scrollView)) {
                cv_basicInfo.setVisibility(View.VISIBLE);
                scrollToView(scrollView, cv_basicInfo);
                return;
            }
            if (!Validator.isEmpty(panNumber, "Enter your Pan number", scrollView)) {
                cv_basicInfo.setVisibility(View.VISIBLE);
                scrollToView(scrollView, cv_basicInfo);
                return;
            }
            if (!Validator.isEmpty(nameofapplicant, "Enter applicant name", scrollView)) {
                cv_basicInfo.setVisibility(View.VISIBLE);
                scrollToView(scrollView, cv_basicInfo);
                return;
            }
            if (!Validator.isSpinnerSelected(spinner_gender, "Select gender")) {
                cv_basicInfo.setVisibility(View.VISIBLE);
                scrollToView(scrollView, cv_basicInfo);
                return;
            }
            if (!Validator.isSpinnerSelected(socialCategorySpinner, "Select Social Category")) {
                cv_basicInfo.setVisibility(View.VISIBLE);
                scrollToView(scrollView, cv_basicInfo);
                return;
            }
            if (!Validator.isSpinnerSelected(specialCategorySpinner, "Select Special Category")) {
                cv_basicInfo.setVisibility(View.VISIBLE);
                scrollToView(scrollView, cv_basicInfo);
                return;
            }
            if (!Validator.isSpinnerSelected(qualificationspinner, "Select Qualification")) {
                cv_basicInfo.setVisibility(View.VISIBLE);
                scrollToView(scrollView, cv_basicInfo);
                return;
            }

          // communication info validation
            if (!Validator.isEmpty(communication_address, "Enter Address", scrollView)) {
                cv_correspondenceadd.setVisibility(View.VISIBLE);
                scrollToView(scrollView, cv_correspondenceadd);
                return;
            }
            if (!Validator.isSpinnerSelected(state_spinner, "Select State")) {
                cv_correspondenceadd.setVisibility(View.VISIBLE);
                scrollToView(scrollView, cv_correspondenceadd);
                return;
            }
            if (!Validator.isEmpty(district, "Enter District", scrollView)) {
                cv_correspondenceadd.setVisibility(View.VISIBLE);
                scrollToView(scrollView, cv_correspondenceadd);
                return;
            }
            if (!Validator.isEmpty(taluka_block_name, "Enter Taluka/Block", scrollView)) {
                cv_correspondenceadd.setVisibility(View.VISIBLE);
                scrollToView(scrollView, cv_correspondenceadd);
                return;
            }
            if (!Validator.isEmpty(pin_number, "Enter Pin number", scrollView)) {
                cv_correspondenceadd.setVisibility(View.VISIBLE);
                scrollToView(scrollView, cv_correspondenceadd);
                return;
            }
            if (!Validator.isNumber(mobile_number, "Enter 10 digit primary Mobile number", scrollView)) {
                cv_correspondenceadd.setVisibility(View.VISIBLE);
                scrollToView(scrollView, cv_correspondenceadd);
                return;
            }
            if (!Validator.isEmail(email, "Enter valid email address", scrollView)) {
                cv_correspondenceadd.setVisibility(View.VISIBLE);
                scrollToView(scrollView, cv_correspondenceadd);
                return;
            }

            //implementing agency validation
            if (!Validator.isSpinnerSelected(implementing_agency_spinner, "Select agency")) {
                cv_ImplementingAgency.setVisibility(View.VISIBLE);
                scrollToView(scrollView, cv_ImplementingAgency);
                return;
            }
            if (!Validator.isSpinnerSelected(iastateSpinner, "Select state")) {
                cv_ImplementingAgency.setVisibility(View.VISIBLE);
                scrollToView(scrollView, cv_ImplementingAgency);
                return;
            }
            if (!Validator.isSpinnerSelected(iaDistrictSpinner, "Select district")) {
                cv_ImplementingAgency.setVisibility(View.VISIBLE);
                scrollToView(scrollView, cv_ImplementingAgency);
                return;
            }

            // unit field validation
            if (!Validator.isSpinnerSelected(unitdistrictnameListspinner, "Select district")) {
                cv_unitAddress.setVisibility(View.VISIBLE);
                scrollToView(scrollView, cv_unitAddress);
                return;
            }
            if (!Validator.isSpinnerSelected(spinner_subdistrict, "Select sub-district")) {
                cv_unitAddress.setVisibility(View.VISIBLE);
                scrollToView(scrollView, cv_unitAddress);
                return;
            }
            if (!Validator.isSpinnerSelected(spinnerVillage, "Select village")) {
                cv_unitAddress.setVisibility(View.VISIBLE);
                scrollToView(scrollView, cv_unitAddress);
                return;
            }
            if (!Validator.isEmpty(lgd_code, "Enter lgd code", scrollView)) {
                cv_unitAddress.setVisibility(View.VISIBLE);
                scrollToView(scrollView, cv_unitAddress);
                return;
            }
            if (!Validator.isEmpty(pin_code, "Enter valid Pin code", scrollView)) {
                cv_unitAddress.setVisibility(View.VISIBLE);
                scrollToView(scrollView, cv_unitAddress);
                return;
            }
            if (!Validator.isEmpty(unit_loc, "Enter valid unit location", scrollView)) {
                cv_unitAddress.setVisibility(View.VISIBLE);
                scrollToView(scrollView, cv_unitAddress);
                return;
            }
            if (!Validator.isEmpty(unitaddress, "Enter the official unit address", scrollView)) {
                cv_unitAddress.setVisibility(View.VISIBLE);
                scrollToView(scrollView, cv_unitAddress);
                return;
            }

            //priject info validation
            if (!Validator.isSpinnerSelected(unit_type_spinner, "Select Unit Type")) {
                cv_projectInfo.setVisibility(View.VISIBLE);
                scrollToView(scrollView, cv_projectInfo);
                return;
            }
            if (!Validator.isNumber(capital_exp, "Enter Capital Expenditure", scrollView)) {
                cv_projectInfo.setVisibility(View.VISIBLE);
                scrollToView(scrollView, cv_projectInfo);
                return;
            }
            if (!Validator.isNumber(workingcapital, "Enter Working Capital", scrollView)) {
                cv_projectInfo.setVisibility(View.VISIBLE);
                scrollToView(scrollView, cv_projectInfo);
                return;
            }
            if (!Validator.isNumber(employee_count, "Enter Employment count", scrollView)) {
                cv_projectInfo.setVisibility(View.VISIBLE);
                scrollToView(scrollView, cv_projectInfo);
                return;
            }

           // primary bank validation
            if (!Validator.isSpinnerSelected(bankNameSpinner, "Select Bank")) {
                cv_primaryfbanking.setVisibility(View.VISIBLE);
                scrollToView(scrollView, cv_primaryfbanking);
                return;
            }

            if (!Validator.isEmpty(ifsc_code, "Enter ifsc code", scrollView)) {
                cv_primaryfbanking.setVisibility(View.VISIBLE);
                scrollToView(scrollView, cv_primaryfbanking);
                return;
            }
            if (!Validator.isEmpty(branchName, "Enter branch name", scrollView)) {
                cv_primaryfbanking.setVisibility(View.VISIBLE);
                scrollToView(scrollView, cv_primaryfbanking);
                return;
            }
            if (!Validator.isEmpty(address, "Enter address", scrollView)) {
                cv_primaryfbanking.setVisibility(View.VISIBLE);
                scrollToView(scrollView, cv_primaryfbanking);
                return;
            }
            if (!Validator.isEmpty(districtName, "Enter address", scrollView)) {
                cv_primaryfbanking.setVisibility(View.VISIBLE);
                scrollToView(scrollView, cv_primaryfbanking);
                return;
            }


            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS", Locale.getDefault());

            applicant.setAadharNo(adharcardno.getText().toString().trim());
            System.out.println("adharno" + adharcardno.getText().toString().trim());
            applicant.setApplTitle("0");
            applicant.setApplName(nameofapplicant.getText().toString().trim());
            System.out.println("name" +nameofapplicant.getText().toString().trim());
            applicant.setAgencyID(agentId);
            System.out.println("agentId" + agentId);
            applicant.setAgencyCode(selectedAgencyCode);
            System.out.println("selectedAgencyCode" + selectedAgencyCode);
            applicant.setNodalCode(selectedNodalCode);
            System.out.println("selectedNodalCode" + selectedNodalCode);
            applicant.setStateID(stateId);
            System.out.println("stateId" + stateId);
            applicant.setDistID(districtId);
            System.out.println("districtId" + districtId);
            applicant.setStateCode(state_shortCode);
            System.out.println("selectedStateCode" + state_shortCode);
            applicant.setAgencyOffID(selectedagencyoffId > 0 ? selectedagencyoffId : 0);
            System.out.println("selectedagencyoffId" + selectedagencyoffId);
            applicant.setLegalType("INDIVIDUAL");
            applicant.setGender(gender != null ? gender : "");
            System.out.println("gender" + gender);
            try {
                String inputDate = uid_dob.getText().toString().trim(); // "09-29-1995"

                // Parse input date
                SimpleDateFormat inputFormat = new SimpleDateFormat("MM-dd-yyyy", Locale.getDefault());
                Date date = inputFormat.parse(inputDate);

                // Format to server-required format
                SimpleDateFormat serverFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS", Locale.getDefault());
                String formattedDate = serverFormat.format(date);

                applicant.setDateofBirth(formattedDate);

                System.out.println("Formatted DOB: " + formattedDate);

            } catch (ParseException e) {
                e.printStackTrace();
            }



            applicant.setAge(Integer.parseInt(uid_age.getText().toString()));
            System.out.println("age" + Integer.parseInt(uid_age.getText().toString()));
            applicant.setSocialCatID(selectedSocialCatCode != null ? selectedSocialCatCode : "");
            System.out.println("selectedSocialCatCode" + selectedSocialCatCode);
            applicant.setSpecialCatID(selectedSpecialCatCode != null ? selectedSpecialCatCode : "");
            System.out.println("selectedSpecialCatCode" + selectedSpecialCatCode);
            applicant.setQualID(selectedQualCode != null ? selectedQualCode : "");
            System.out.println("selectedQualCode" + selectedQualCode);

            applicant.setQualDesc(selectedQualDesc != null ? selectedQualDesc : "");
            System.out.println("selectedQualDesc" + selectedQualDesc);


            applicant.setComnAddress(communication_address.getText().toString());
            System.out.println("communication_address" + communication_address.getText().toString());
            applicant.setComnTaluka(taluka_block_name.getText().toString());
            System.out.println("taluka_block_name" + taluka_block_name.getText().toString());

            applicant.setComnDistrict(selectedDistrictName);
            System.out.println("selectedDistrictName" + selectedDistrictName);
            applicant.setComnPin(correspondence_pincode);
            System.out.println("pin_number" +correspondence_pincode);

            applicant.setMobileNo1(mobile_number.getText().toString());
            System.out.println("mobile_number" + mobile_number.getText().toString());

            applicant.setMobileNo2(alternate_mobile_number.getText().toString());
            System.out.println("alternate_mobile_number" + alternate_mobile_number.getText().toString());

            applicant.seteMail(email.getText().toString());
            System.out.println("email" + email.getText().toString());

            applicant.setPanNo(panNumber.getText().toString());
            System.out.println("panNumber" + panNumber.getText().toString());

            applicant.setUnitLocation(unit_loc.getText().toString());
            System.out.println("unit_loc" + unit_loc.getText().toString());

            applicant.setUnitAddress(unitaddress.getText().toString());
            System.out.println("unitaddress" + unitaddress.getText().toString());

            applicant.setUnitTaluka(subdistrictName);
            System.out.println("subdistrictName" + subdistrictName);

            applicant.setUnitDistrict(district_name);
            System.out.println("district_name" + district_name);

            applicant.setUnitPin(pin_code.getText().toString());
            System.out.println("pin_code" + pin_code);

            applicant.setUnitActivityType(null);


            applicant.setUnitActivityName(selectedNicCode);
            System.out.println("selectedNicCode" + selectedNicCode);
            applicant.setProdDescr(selectedNicDesc3);
            System.out.println("selectedNicDesc3" + selectedNicDesc3);

            applicant.setIsEDPTraining(1);
            applicant.setEdpTrainingInst(edp_name);
            System.out.println("edp_name" + edp_name);

            applicant.setCapitalExpd(Double.parseDouble(capital_exp.getText().toString()));
            System.out.println("capital_exp" + Double.parseDouble(capital_exp.getText().toString()));

            applicant.setWorkingCapital(Double.parseDouble(workingcapital.getText().toString()));
            System.out.println("workingcapital" + Double.parseDouble(workingcapital.getText().toString()));

            applicant.setTotalProjectCost(Double.parseDouble(totalexp.getText().toString()));
            System.out.println("totalexp" + Double.parseDouble(totalexp.getText().toString()));

            applicant.setEmployment(Integer.parseInt(employee_count.getText().toString()));
            System.out.println("employee_count" + Double.parseDouble(employee_count.getText().toString()));

            applicant.setFinBankID1(selectedBankListID);
            System.out.println("selectedBankListID" + selectedBankListID);

            applicant.setFinBank1(selectedBranch1);
            System.out.println("selectedBranch1" + selectedBranch1);

            applicant.setBankIFSC1(selectedIfsc1);
            System.out.println("selectedIfsc1" + selectedIfsc1);

            applicant.setBankBranch1(selectedBankAddress1);
            System.out.println("selectedBankAddress1" + selectedBankAddress1);

            applicant.setBankAddress1(selectedBankAddress1);
            System.out.println("selectedBankAddress1" + selectedBankAddress1);

            applicant.setBankDist1(selectedBankDistrict1);
            System.out.println("selectedBankDistrict1" + selectedBankDistrict1);


            applicant.setFinBankID2(selectedBankListID);
            System.out.println("selectedBankDistrict1" + selectedBankDistrict1);

            applicant.setFinBank2(selectedBranch2);
            System.out.println("selectedBranch2" + selectedBranch2);

            applicant.setBankIFSC2(selectedIfsc2);
            System.out.println("selectedIfsc2" + selectedIfsc2);

            applicant.setBankBranch2(selectedBankAddress2);
            System.out.println("selectedBankAddress2" + selectedBankAddress2);

            applicant.setBankAddress2(selectedBankAddress2);
            System.out.println("selectedBankAddress2" + selectedBankAddress2);

            applicant.setBankDist2(selectedBankDistrict2);
            System.out.println("selectedBankDistrict2" + selectedBankDistrict2);


            applicant.setIsAvailCGTMSE(1);
            applicant.setPmegpRef("Implementing Agencies(KVIC/KVIB/DIC)");
            applicant.setIsDeclrAccept(1);

            String currentDate = sdf.format(new Date());
            applicant.setCreatedOn(currentDate);
            applicant.setFinalSubDate(null);
            applicant.setIsFinalSub(null);
            applicant.setModifyOn(null);
            applicant.setModifyBy(null);

            applicant.setIsAadharVerified(1);
            applicant.setIsPanVerified(1);
            applicant.setIsUnitLocationSame(1);
            applicant.setSchemeWrkFlowID(2);
            applicant.setIsAltnBank(1);
            applicant.setUserType("APPL");
            applicant.setStateName(statename);
            System.out.println("statename" + statename);

            applicant.setDistrictName(district_name);
            System.out.println("district_name" + district_name);

            applicant.setSchemeID(1);
            applicant.setIsUnderAlternativeBank(0);
            applicant.setIsAltBankRejected(0);

            applicant.setUnitActivityName2(selectedNicCode);
            System.out.println("selectedNicCode" + selectedNicCode);

            applicant.setProdDescr2(selectedNicDesc);
            System.out.println("selectedNicDesc" + selectedNicDesc);

            applicant.setUnitActivityName3(selectedNicCode2);
            System.out.println("selectedNicCode2" + selectedNicCode2);

            applicant.setProdDescr3(selectedNicDesc3);
            System.out.println("selectedNicDesc3" + selectedNicDesc3);

            applicant.setIsCharAppliAccepted(1);

            applicant.setComnStateID(27);
            applicant.setComnStateName(statename);
            System.out.println("statename" + statename);

            applicant.setMaskAadharNo("XXXX XXXX 2019");
            applicant.setState_Code(stateId);
            System.out.println("stateId" + stateId);

            applicant.setState_Name(statename);
            System.out.println("statename" + statename);

            applicant.setLgdCode(535843);
            applicant.setTrainingMode(0);
            applicant.setVillageName(selectedVillageName);
            System.out.println("selectedVillageName" + selectedVillageName);

            applicant.setLgdCodeId(Integer.parseInt(lgd_code.getText().toString()));
            System.out.println("lgd_code" + Integer.parseInt(lgd_code.getText().toString()));

            applicant.setIsGenerateChallan(0);
            applicant.setIsDPRVerified(0);
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Log.d("FINAL_JSON", gson.toJson(applicant));

            SaveApplicationForm(applicant);
        });

        btn_ifsc_code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedBankListID != 0 && selectedCityName != null) {
                    showBankIfscDetails(selectedBankListID, selectedCityName, true);
                }

            }
        });
        alt_btn_ifsc_code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (alt_selectedBankListID != 0 && alt_selectedCityName != null) {
                    if (alt_selectedBankListID == selectedBankListID) {
                        Toast.makeText(NewApplicantUnitActivity.this,
                                "Alternate bank must be different from Primary bank", Toast.LENGTH_SHORT).show();
                    } else {
                        showBankIfscDetails(alt_selectedBankListID, alt_selectedCityName, false);
                    }
                }


            }
        });


        btn_industry_activity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IndustryDataDialogFragment dialogFragment = new IndustryDataDialogFragment();
                Bundle args = new Bundle();
                args.putInt("unitType", activityUnitType);
                dialogFragment.setArguments(args);


                dialogFragment.setOnIndustrySelectedListener(new IndustryDataDialogFragment.OnIndustrySelectedListener() {
                    @Override
                    public void onIndustrySelected(List<NICGroupModel> selectedList) {
                        for (int i = 0; i < selectedList.size(); i++) {
                            NICGroupModel model = selectedList.get(i);
                            Log.d("SelectedIndustry", "NIC Code: " + model.getNic_code() + ", Desc: " + model.getNic_desc());
                            if (i == 0) {
                                selectedNicCode = model.getNic_code();
                                selectedNicDesc = model.getNic_desc();
                            } else if (i == 1) {
                                selectedNicCode2 = model.getNic_code();
                                selectedNicDesc2 = model.getNic_desc();
                            } else if (i == 2) {
                                selectedNicCode3 = model.getNic_code();
                                selectedNicDesc3 = model.getNic_desc();
                            }
                        }

                        ProjectInfoAdapter adapter = new ProjectInfoAdapter(selectedList);
                        rv_product_recyclerview.setAdapter(adapter);
                    }

                });

                dialogFragment.show(getSupportFragmentManager(), "industryDataDialog");
            }
        });


        allCards = Arrays.asList(cv_basicInfo, cv_correspondenceadd, cv_ImplementingAgency,
                cv_unitAddress, cv_projectInfo, cv_primaryfbanking, cv_alt_fbanking, cv_otherInfo);

        allTextViews = Arrays.asList(txt_basic_info, txt_communication_address, txt_imp_agency,
                txt_unit_add, txt_project_info, txt_primary_fbanking, txt_alt_fbanking, cv_other_info_layout);


        closeAllCards();

        toggleSection(cv_basicInfo, txt_basic_info);
        txt_basic_info.setOnClickListener(v -> toggleSection(cv_basicInfo, txt_basic_info));
        txt_communication_address.setOnClickListener(v -> toggleSection(cv_correspondenceadd, txt_communication_address));
        txt_imp_agency.setOnClickListener(v -> toggleSection(cv_ImplementingAgency, txt_imp_agency));
        txt_unit_add.setOnClickListener(v -> toggleSection(cv_unitAddress, txt_unit_add));
        txt_project_info.setOnClickListener(v -> toggleSection(cv_projectInfo, txt_project_info));
        txt_primary_fbanking.setOnClickListener(v -> toggleSection(cv_primaryfbanking, txt_primary_fbanking));
        txt_alt_fbanking.setOnClickListener(v -> toggleSection(cv_alt_fbanking, txt_alt_fbanking));
        cv_other_info_layout.setOnClickListener(v -> toggleSection(cv_otherInfo, cv_other_info_layout));

        initData();
    }
    private void scrollToView(ScrollView scrollView, View targetView) {
        scrollView.post(() -> scrollView.smoothScrollTo(0, targetView.getTop()));
    }
    public int calculateAge(String dobString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        LocalDate dob = LocalDate.parse(dobString, formatter);
        LocalDate today = LocalDate.now();
        return Period.between(dob, today).getYears();
    }

    private void setupAutoCalculation() {
        TextWatcher watcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                calculateTotal();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        };

        capital_exp.addTextChangedListener(watcher);
        workingcapital.addTextChangedListener(watcher);
    }

    private boolean validate(double capVal, double workingVal) {

        if (workingVal > capVal) {
            workingcapital.setError("For Manufacturing, Working Capital must be less than or equal to 35% of Total Project Cost.");
            return false;
        }
        return true;
    }

    private void calculateTotal() {
        String cap = capital_exp.getText() != null ? capital_exp.getText().toString().trim() : "";
        String working_cap = workingcapital.getText() != null ? workingcapital.getText().toString().trim() : "";

        double capVal = cap.isEmpty() ? 0.0 : Double.parseDouble(cap);
        double workingVal = working_cap.isEmpty() ? 0.0 : Double.parseDouble(working_cap);

        if (!validate(capVal, workingVal)) {
            workingcapital.setText(""); // clear invalid input
            totalexp.setText(String.valueOf(capVal)); // only cap value considered
            return;
        }

        double total_exp = capVal + workingVal;
        totalexp.setText(String.valueOf(total_exp));

        capital_exptxt.setText(convert((long) capVal));
        workingcap_exptxt.setText(convert((long) workingVal));
    }

    private double parseDoubleSafe(String s) {
        try {
            return Double.parseDouble(s.trim());
        } catch (Exception e) {
            return 0.0;
        }
    }

    private int parseIntSafe(String s) {
        try {
            return Integer.parseInt(s.trim());
        } catch (Exception e) {
            return 0;
        }
    }

    private void getAdharOtp(String adhharno) {
        UidRequest uidNo = new UidRequest(adhharno);

        progressDialog = new ProgressDialog(NewApplicantUnitActivity.this);
        progressDialog.setMessage("Requesting OTP...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        apiService.getAdharOtp(uidNo).enqueue(new Callback<AdharOtpResponse>() {
            @Override
            public void onResponse(Call<AdharOtpResponse> call, Response<AdharOtpResponse> response) {
                progressDialog.dismiss();

                if (response.isSuccessful() && response.body() != null) {
                    AdharOtpResponse status = response.body();

                    Log.d("API_RESPONSE", new Gson().toJson(status));

                    if (status.isSuccess()) {
                        String guidKey = status.getGuidKey();
                        showOtpDialog(guidKey);
                    } else {


                        if (status.getData().getCode().equals("952")) {
                            Toast.makeText(NewApplicantUnitActivity.this, "Too many OTP requests. Please wait a while before retrying.", Toast.LENGTH_LONG).show();
                        } else if (status.getData().getCode().equals("953")) {
                            Toast.makeText(NewApplicantUnitActivity.this, "Exceeded Maximum OTP generation Limit.", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(NewApplicantUnitActivity.this,
                                    "Error : Unable to Connect to Remote Server",
                                    Toast.LENGTH_LONG).show();
                        }

                    }
                } else {
                    progressDialog.dismiss();
                    Toast.makeText(NewApplicantUnitActivity.this, "Unexpected response", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<AdharOtpResponse> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(NewApplicantUnitActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @SuppressLint("MissingInflatedId")
    private void showOtpDialog(String key) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);

        View dialogView = getLayoutInflater().inflate(R.layout.dialog_otp, null);
        builder.setView(dialogView);

        CheckBox checkBox = dialogView.findViewById(R.id.consent_checkbox);
        TextView consentText = dialogView.findViewById(R.id.tvConsent);
        EditText etOtp = dialogView.findViewById(R.id.etOtp);
        Button btnSubmit = dialogView.findViewById(R.id.btnSubmit);
        Button btnCancle = dialogView.findViewById(R.id.btnCancle);
        btnSubmit.setEnabled(false);
        consentText.setText(
                "I hereby give my consent to use Aadhaar OTP authentication for eKYC to apply for the PMEGP loan. " +
                "I understand that by performing this authentication, the basic demographic details such as my name, " +
                "date of birth, gender, and address as registered with UIDAI may be shared by UIDAI.\n\n" +
                "Aadhaar OTP has been sent on registered mobile number. Enter Aadhaar OTP:");

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
        System.out.println("checkBox.isChecked() "+checkBox.isChecked());
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                btnSubmit.setEnabled(isChecked);
            }
        });

        btnSubmit.setOnClickListener(v -> {
            String otp = etOtp.getText().toString().trim();
            if (otp.isEmpty()) {
                etOtp.setError("Enter OTP");
            } else {
                alertDialog.dismiss();

                AdharOtpRequest adharOtpRequest = new AdharOtpRequest();
                adharOtpRequest.setAadhaarNo(adharcardno.getText().toString());
                adharOtpRequest.setOtp(otp);
                adharOtpRequest.setGuidKey(key);

                verifyOtp(adharOtpRequest);
            }
        });
        btnCancle.setOnClickListener(v -> {
            alertDialog.dismiss();
        });
    }

    private void verifyOtp(AdharOtpRequest otp) {

        progressDialog = new ProgressDialog(NewApplicantUnitActivity.this);
        progressDialog.setMessage("Verifying OTP...");
        progressDialog.setCancelable(false);
        progressDialog.show();
        apiService.verifyOtp(otp).enqueue(new Callback<AdharVerificationResponse>() {
            @Override
            public void onResponse(Call<AdharVerificationResponse> call, Response<AdharVerificationResponse> response) {
                progressDialog.dismiss();

                if (response.isSuccessful() && response.body() != null) {
                    AdharVerificationResponse status = response.body();

                    Log.d("API_RESPONSE", new Gson().toJson(status));
                    Toast.makeText(NewApplicantUnitActivity.this, "OTP Verified Successfully", Toast.LENGTH_SHORT).show();

                    if (status.isSuccess()) {
                        nameofapplicant.setText(status.getData().getName());
                        uid_dob.setText(status.getData().getDob());
                        String dob = uid_dob.getText().toString().trim();
                        int age = calculateAge(dob);
                        uid_age.setText(String.valueOf(age));
                        Log.d("AGE", "Age = " + age);
                        gender = status.getData().getGender();
                        communication_address.setText(status.getData().getHouse() + " ," + status.getData().getLandmark() + "," + status.getData().getLoc());
                        apiState = status.getData().getState(); // "Maharashtra"
                        setSpinnerToAadharState();

                        district.setText(status.getData().getDist());
                        taluka_block_name.setText(status.getData().getSubdist());
                        pin_number.setText(status.getData().getPincode());
                        correspondence_pincode = pin_number.getText().toString();

                        if (gender != null) {
                            if (gender.equalsIgnoreCase("M")) {
                                spinner_gender.setSelection(1);

                                int position = titleList.indexOf("Mr.");
                                if (position >= 0) titleSpinner.setSelection(position);
                            } else if (gender.equalsIgnoreCase("F")) {
                                spinner_gender.setSelection(2);

                                titleSpinner.setSelection(0);
                            } else {
                                spinner_gender.setSelection(3);

                                titleSpinner.setSelection(0);
                            }
                        }
                    } else {
                        progressDialog.dismiss();
                        Toast.makeText(NewApplicantUnitActivity.this, " ", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    progressDialog.dismiss();
                    Toast.makeText(NewApplicantUnitActivity.this, "Unexpected response", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<AdharVerificationResponse> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(NewApplicantUnitActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }


    private void SaveApplicationForm(ApplicantDataModel applicantDataModel) {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait,...");
        progressDialog.setCancelable(false);
        progressDialog.show();
        apiService.saveForm(applicantDataModel).enqueue(new Callback<ResultModel>() {
            @Override
            public void onResponse(Call<ResultModel> call, Response<ResultModel> response) {
                progressDialog.dismiss();

                if (response.isSuccessful() && response.body() != null) {
                    ResultModel status = response.body();

                    Log.d("API_RESPONSE", new Gson().toJson(status));

                    if (status.isSuccess()) {
                        Toast.makeText(NewApplicantUnitActivity.this, status.getMessage(), Toast.LENGTH_LONG).show();

                        SharedPreferences prefs = getSharedPreferences("MyAppPrefs", MODE_PRIVATE);
                        SharedPreferences.Editor editor = prefs.edit();
                        editor.putInt("ApplID", status.getApplID());
                        editor.putString("UserID", status.getUserID());
                        editor.putString("Password", status.getPassword());
                        editor.apply();
                        Intent i = new Intent(NewApplicantUnitActivity.this, LoginActivity.class);
                        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK); // clears back stack
                        startActivity(i);
                    } else {
                        Toast.makeText(NewApplicantUnitActivity.this, "Save failed: " + status.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(NewApplicantUnitActivity.this, "Unexpected response", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResultModel> call, Throwable t) {
                progressDialog.dismiss();

                Toast.makeText(NewApplicantUnitActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void fetchDistrictList(String code) {
        System.out.println("state_code" + code);
        DistrictModel request = new DistrictModel(code, "");
        apiService.getDistrictList(request).enqueue(new Callback<List<DistrictModel>>() {
            @Override
            public void onResponse(Call<List<DistrictModel>> call, Response<List<DistrictModel>> response) {
                if (response.isSuccessful()) {
                    districts = response.body();
                    System.out.println("districtList" + districts.size());
                    showDistrictDialog(districts);


                }
            }

            @Override
            public void onFailure(Call<List<DistrictModel>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    private void showDistrictDialog(List<DistrictModel> districtList) {
        if (districtList == null || districtList.isEmpty()) {
            Toast.makeText(this, "No districts found", Toast.LENGTH_SHORT).show();
            return;
        }

        String[] districtItems = new String[districtList.size()];
        for (int i = 0; i < districtList.size(); i++) {
            districtItems[i] = districtList.get(i).getDistrictCode() + " ~ " + districtList.get(i).getDistrictName();
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Select District");
        builder.setItems(districtItems, (dialog, which) -> {
            DistrictModel selected = districtList.get(which);
            EditText districtname = findViewById(R.id.district);
            districtname.setText(selected.getDistrictName());
            selectedDistrictName = selected.getDistrictName();

        });
        builder.setNegativeButton("Cancel", null);
        builder.show();
    }

    private void initData() {

        fetchStateList();
        fetchAgencyList();
        fetchQualificationList();
        fetchSpecialCategoryList();
        fetchSocialCategoryList();
        fetchInformationSourceList();
        fetchUnitTypeData();
        fetchGenderList();
        fetchBankList();


        setupAutoCalculation();


        titleList.add(0, "--Select title--");
        titleList.add(1, "Smt.");
        titleList.add(2, "Kum.");
        titleList.add(3, "Ms.");
        titleList.add(4, "Mr.");

        ArrayAdapter<String> adapter = new ArrayAdapter<>(NewApplicantUnitActivity.this,
                R.layout.spinner_selected_item, titleList);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        titleSpinner.setAdapter(adapter);


        cgtmse_radioGrp.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.yes_cgt) {
                cgtmseFlag = 1;
                findViewById(R.id.avail_layout).setVisibility(View.VISIBLE);
                findViewById(R.id.edp_radioGrp).setVisibility(View.GONE);
                findViewById(R.id.txt_inputlayout).setVisibility(View.GONE);

            } else if (checkedId == R.id.No_cgt) {
                cgtmseFlag = 0;
                findViewById(R.id.avail_layout).setVisibility(View.GONE);
                findViewById(R.id.edp_radioGrp).setVisibility(View.GONE);
                findViewById(R.id.txt_inputlayout).setVisibility(View.GONE);


            }
        });

        edp_radioGrp.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.yes_radio) {
                findViewById(R.id.edp_subgrp_radioGrp).setVisibility(View.VISIBLE);
                findViewById(R.id.edp_training_insti_name).setVisibility(View.VISIBLE);


            } else if (checkedId == R.id.No_radio) {
                findViewById(R.id.edp_subgrp_radioGrp).setVisibility(View.GONE);
                findViewById(R.id.edp_training_insti_name).setVisibility(View.GONE);

            }
        });

        edp_subgrp_radioGrp.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.online_radio) {
                findViewById(R.id.txt_inputlayout).setVisibility(View.VISIBLE);
                edp_training_insti.setText("UDYAMI- Samadhan Portal");
                btn_edpSelection.setVisibility(View.GONE);
            } else if (checkedId == R.id.offline_radio) {
                findViewById(R.id.txt_inputlayout).setVisibility(View.VISIBLE);
                edp_training_insti.setText("EDP training Instn. name");
                btn_edpSelection.setVisibility(View.VISIBLE);
                btn_edpSelection.setOnClickListener(v -> {
                    showEdpDialog();

                });
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


    private void fetchSubdistrictList(String code) {
        System.out.println("code_d" + code);
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
                                    NewApplicantUnitActivity.this,
                                    R.layout.spinner_selected_item,
                                    subDistrictInfoList
                            );
                            adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
                            spinner_subdistrict.setAdapter(adapter);

                            spinner_subdistrict.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                    if (position > 0) {
                                        SubDistrictResponce selectedDistrict = subDistrictSource.get(position - 1);
                                        int subdistrictId = selectedDistrict.getDistrictId();
                                        System.out.println("subdistrictId" + subdistrictId);
                                        int selectedSubdistrictCode = subDistrictSource.get(position - 1).getSubdistrict_code();
                                        subdistrictName = subDistrictSource.get(position - 1).getSubdistrict_name();
                                        System.out.println("subdistrictId" + subdistrictId + selectedSubdistrictCode);
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
        VillageRequest request = new VillageRequest(code);

        apiService.getVillages(request).enqueue(new Callback<List<VillageDetailModel>>() {
            @Override
            public void onResponse(Call<List<VillageDetailModel>> call, Response<List<VillageDetailModel>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<VillageDetailModel> villageList = response.body();

                    List<String> villageNames = new ArrayList<>();
                    villageNames.add(0, "--Select Village--");

                    for (VillageDetailModel village : villageList) {
                        villageNames.add(village.getVillageName());
                    }

                    ArrayAdapter<String> adapter = new ArrayAdapter<>(NewApplicantUnitActivity.this,
                            android.R.layout.simple_spinner_item, villageNames);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spinnerVillage.setAdapter(adapter);

                    spinnerVillage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            if (position >= 0 && position < villageList.size()) {
                                VillageDetailModel villageDetailModel = villageList.get(position);
                                String villageCode = villageDetailModel.getVillageCode();
                                System.out.println("villagecode" + villageCode);
                                selectedVillageName = villageDetailModel.getVillageName();

                                fetchVillageDetails(villageCode);
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                            pin_code.setText("");
                            unit_loc.setText("");
                            lgd_code.setText("");
                        }
                    });
                } else {
                    Toast.makeText(NewApplicantUnitActivity.this, "No villages found", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<VillageDetailModel>> call, Throwable t) {
                Toast.makeText(NewApplicantUnitActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
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

                    lgd_code.setText(String.valueOf(village.getLgdCodeId()));
                    pin_code.setText(village.getPincode());
                    unit_loc.setText(village.getRuralUrban());
                    selectedPincode = village.getPincode();
                } else {
                    Toast.makeText(NewApplicantUnitActivity.this, "Village details not found", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<UnitDetailResponse> call, Throwable t) {
                Toast.makeText(NewApplicantUnitActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void showEdpDialog() {
        apiService.getEDPData(new EDPRequest(String.valueOf(stateId)))
                .enqueue(new Callback<EDPResponse>() {
                    @Override
                    public void onResponse(Call<EDPResponse> call, Response<EDPResponse> response) {
                        if (response.isSuccessful() && response.body() != null && response.body().isSuccess()) {
                            List<EDPDetails> edpList = response.body().getData();

                            if (edpList == null || edpList.isEmpty()) {
                                Toast.makeText(NewApplicantUnitActivity.this, "No EDP found", Toast.LENGTH_SHORT).show();
                                return;
                            }

                            AlertDialog.Builder builder = new AlertDialog.Builder(NewApplicantUnitActivity.this);
                            View dialogView = getLayoutInflater().inflate(R.layout.dialog_edp_list, null);
                            builder.setView(dialogView);
                            AlertDialog dialog = builder.create();

                            RecyclerView rvEdpList = dialogView.findViewById(R.id.rv_edp_list);
                            rvEdpList.setLayoutManager(new LinearLayoutManager(NewApplicantUnitActivity.this));
                            EDPAdapter adapter = new EDPAdapter(edpList, selected -> {
                                TextInputEditText etEdpName = findViewById(R.id.edp_training_insti_name);
                                etEdpName.setText(selected.getOff_name());
                                edp_name = selected.getOff_name();
                                dialog.dismiss();
                            });
                            rvEdpList.setAdapter(adapter);

                            dialogView.findViewById(R.id.btn_close).setOnClickListener(v -> dialog.dismiss());
                            dialog.show();
                        } else {
                            Toast.makeText(NewApplicantUnitActivity.this, "No EDP found", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<EDPResponse> call, Throwable t) {
                        t.printStackTrace();
                        Toast.makeText(NewApplicantUnitActivity.this, "Error loading data", Toast.LENGTH_SHORT).show();
                    }
                });
    }


    private void fetchGenderList() {
        apiService.getGender("GEND").enqueue(new Callback<List<GenderModel>>() {
            @Override
            public void onResponse(Call<List<GenderModel>> call, Response<List<GenderModel>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<GenderModel> genderSource = response.body();
                    System.out.println("Gender" + genderSource.size());

                    genderInfoList = new ArrayList<>();
                    genderInfoList.add(0, "--Select Gender--");
                    for (GenderModel genderModel : genderSource) {
                        genderInfoList.add(genderModel.getLk_desc());


                    }

                    ArrayAdapter<String> adapter = new ArrayAdapter<>(NewApplicantUnitActivity.this, R.layout.spinner_selected_item, genderInfoList);
                    adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    spinner_gender.setAdapter(adapter);


                }
            }

            @Override
            public void onFailure(Call<List<GenderModel>> call, Throwable t) {
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
                    System.out.println("informationSourceList" + informationSource.size());

                    informationSourceList = new ArrayList<>();
                    informationSourceList.add(0, "--Select Information Source--");
                    for (InformationSource informationSourceModel : informationSource) {
                        informationSourceList.add(informationSourceModel.getLk_desc());


                    }

                    ArrayAdapter<String> adapter = new ArrayAdapter<>(NewApplicantUnitActivity.this, R.layout.spinner_selected_item, informationSourceList);
                    adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    informationSourceSpinner.setAdapter(adapter);


                }
            }

            @Override
            public void onFailure(Call<List<InformationSource>> call, Throwable t) {
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
                    System.out.println("agencyResponses" + agencyResponses.size());
                    AgencyResponse agency = agencyResponses.get(0);

                    selectedagencyoffId = agency.getAgencyOffId();
                    for (int i = 0; i < agencyRequestList.size(); i++) {
                        if (agencyRequestList.size() != 0) {

                            agency_type_mobile.setText(agencyResponses.get(i).getAgencyOffContactNo());
                            agency_type_email.setText(agencyResponses.get(i).getAgencyOffContactEmail());

                        }
                    }

                    agency_type.setText(agencyName + "-" + district_name + "-" + state_zonal_code);
                    agency_type_state.setText(statename);
                    agency_type_district.setText(district_name);


                }
            }

            @Override
            public void onFailure(Call<List<AgencyResponse>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    private void fetchSocialCategoryList() {
        apiService.getSocialCategory("SPCCT").enqueue(new Callback<List<SocialCategory>>() {
            @Override
            public void onResponse(Call<List<SocialCategory>> call, Response<List<SocialCategory>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<SocialCategory> socialCategoryList = response.body();
                    System.out.println("socialCategoryList" + socialCategoryList.size());


                    socialCatnameList = new ArrayList<>();
                    socialCatnameList.add(0, "--Select Social Category--");
                    for (SocialCategory socialCategorymodel : socialCategoryList) {
                        socialCatnameList.add(socialCategorymodel.getLk_desc());


                    }

                    ArrayAdapter<String> adapter = new ArrayAdapter<>(NewApplicantUnitActivity.this, R.layout.spinner_selected_item, socialCatnameList);
                    adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    socialCategorySpinner.setAdapter(adapter);
                    socialCategorySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            SocialCategory socialCategory = socialCategoryList.get(position);
                            selectedSocialCatCode = socialCategory.getLk_shortCode();
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
                    List<SpecialCategory> specialCategoryList = response.body();
                    System.out.println("qualificationModelList" + specialCategoryList.size());

                    specialCatnameList = new ArrayList<>();
                    specialCatnameList.add(0, "--Select Special Category--");
                    for (SpecialCategory specialCategorymodel : specialCategoryList) {
                        specialCatnameList.add(specialCategorymodel.getLk_desc());


                    }

                    ArrayAdapter<String> adapter = new ArrayAdapter<>(NewApplicantUnitActivity.this, R.layout.spinner_selected_item, specialCatnameList);
                    adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    specialCategorySpinner.setAdapter(adapter);
                    specialCategorySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            SpecialCategory specialCategory = specialCategoryList.get(position);
                            selectedSpecialCatCode = specialCategory.getLk_shortCode();
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

    private void fetchQualificationList() {
        apiService.getQualificationList("QUAL").enqueue(new Callback<List<QualificationModel>>() {
            @Override
            public void onResponse(Call<List<QualificationModel>> call, Response<List<QualificationModel>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<QualificationModel> qualificationModelList = response.body();
                    System.out.println("qualificationModelList" + qualificationModelList.size());

                    qualificationNameList = new ArrayList<>();
                    qualificationNameList.add(0, "--Select Qualification--");
                    for (QualificationModel qualificationModel : qualificationModelList) {
                        qualificationNameList.add(qualificationModel.getLk_desc());


                    }

                    ArrayAdapter<String> adapter = new ArrayAdapter<>(NewApplicantUnitActivity.this, R.layout.spinner_selected_item, qualificationNameList);
                    adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    qualificationspinner.setAdapter(adapter);
                    qualificationspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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

    private void fetchAgencyList() {
        apiService.getAgencyList().enqueue(new Callback<List<AgencyModel>>() {
            @Override
            public void onResponse(Call<List<AgencyModel>> call, Response<List<AgencyModel>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<AgencyModel> agencyModelList = response.body();
                    System.out.println("agencyList" + agencyModelList.size());

                    List<String> agencyNames = new ArrayList<>();
                    agencyNames.add(0, "--Select Agency--");
                    for (AgencyModel agencyModel : agencyModelList) {
                        agencyNames.add(agencyModel.getAgency_code());


                    }

                    ArrayAdapter<String> adapter = new ArrayAdapter<>(NewApplicantUnitActivity.this, R.layout.spinner_selected_item, agencyNames);
                    adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    implementing_agency_spinner.setAdapter(adapter);

                    implementing_agency_spinner.setOnItemSelectedListener(new android.widget.AdapterView.OnItemSelectedListener() {
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
                                    agencyName = ""; // Or handle appropriately
                                }

                                System.out.println("Selected agencyCode: " + selectedAgencyCode + " " + agentId);
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

                    ArrayAdapter<String> adapter = new ArrayAdapter<>(NewApplicantUnitActivity.this,
                            R.layout.spinner_selected_item, bankName);
                    adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);

                    // Set adapter for primary bank spinner
                    bankNameSpinner.setAdapter(adapter);
                    bankNameSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            if (position > 0) {
                                BankModel bankModel = bankModelList.get(position - 1);
                                selectedBankListID = bankModel.getBankListId();
                                selectedCityName = district_name;
                                selectedBankName1 = bankModel.getBankName();

                                // Check if same bank is selected in alternate bank
                                if (alt_selectedBankListID != 0 && selectedBankListID == alt_selectedBankListID) {
                                    Toast.makeText(NewApplicantUnitActivity.this,
                                            "Primary and Alternate Bank cannot be the same",
                                            Toast.LENGTH_SHORT).show();
                                    bankNameSpinner.setSelection(0); // reset selection
                                    selectedBankListID = 0;
                                    selectedBankName1 = null;
                                }
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                        }
                    });

                    // Set adapter for alternate bank spinner
                    alternate_finance_spinner.setAdapter(adapter);
                    alternate_finance_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
                                    Toast.makeText(NewApplicantUnitActivity.this,
                                            "Primary and Alternate Bank cannot be the same",
                                            Toast.LENGTH_SHORT).show();
                                    alternate_finance_spinner.setSelection(0); // reset selection
                                    alt_selectedBankListID = 0;
                                    selectedBankName2 = null;
                                }
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<List<BankModel>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

//    private void fetchBankList() {
//        apiService.getBankList().enqueue(new Callback<List<BankModel>>() {
//            @Override
//            public void onResponse(Call<List<BankModel>> call, Response<List<BankModel>> response) {
//                if (response.isSuccessful() && response.body() != null) {
//                    List<BankModel> bankModelList = response.body();
//                    System.out.println("agencyList" +bankModelList.size());
//
//                    List<String> bankName = new ArrayList<>();
//                    bankName.add(0,"--Select Bank name--");
//                    for (BankModel bankModel : bankModelList) {
//                        bankName.add(bankModel.getBankName());
//
//
//                    }
//
//                    ArrayAdapter<String> adapter = new ArrayAdapter<>(NewApplicantUnitActivity.this, R.layout.spinner_selected_item, bankName);
//                    adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
//                    bankNameSpinner.setAdapter(adapter);
//                    bankNameSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//                        @Override
//                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                            if (position > 0) {
//                                BankModel bankModel = bankModelList.get(position - 1);
//                                selectedBankListID = bankModel.getBankListId();
//                                selectedCityName = district_name;
//                                selectedBankName1 = bankModel.getBankName();
//                            }
//                        }
//
//                        @Override
//                        public void onNothingSelected(AdapterView<?> parent) {
//
//                        }
//                    });
//                    alternate_finance_spinner.setAdapter(adapter);
//                    alternate_finance_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//                        @Override
//                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                            if (position > 0) {
//                                BankModel bankModel = bankModelList.get(position - 1);
//                                alt_selectedBankListID = bankModel.getBankListId();
//                                alt_selectedCityName = district_name;
//                                selectedBankId2 = bankModel.getBankListId();
//                                selectedBankName2 = bankModel.getBankName();
//                            }
//                        }
//
//                        @Override
//                        public void onNothingSelected(AdapterView<?> parent) {
//
//                        }
//                    });
//
//
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<BankModel>> call, Throwable t) {
//                t.printStackTrace();
//            }
//        });
//    }

    private void showBankIfscDetails(int b_id, String b_name, boolean isPrimary) {
        BankDetailRequest request = new BankDetailRequest(b_id, b_name);
        apiService.getBankDetailsData(request).enqueue(new Callback<List<BankDetailResponce>>() {
            @Override
            public void onResponse(Call<List<BankDetailResponce>> call, Response<List<BankDetailResponce>> response) {
                if (response.isSuccessful() && response.body() != null && response.body() != null) {
                    List<BankDetailResponce> bankDetailResponceList = response.body();
                    Log.d("API_RESPONSE", new Gson().toJson(response.body()));
                    showDialogForBankDetails(bankDetailResponceList, isPrimary);

                } else {
                    Toast.makeText(NewApplicantUnitActivity.this, "bank details not found", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<BankDetailResponce>> call, Throwable t) {
                Toast.makeText(NewApplicantUnitActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showDialogForBankDetails(List<BankDetailResponce> bankDetailResponceList, boolean isPrimary) {
        ApplicantDataModel applicant = new ApplicantDataModel();

        if (bankDetailResponceList == null || bankDetailResponceList.isEmpty()) {
            Toast.makeText(this, "No districts found", Toast.LENGTH_SHORT).show();
            return;
        }

        String[] bankItems = new String[bankDetailResponceList.size()];
        for (int i = 0; i < bankDetailResponceList.size(); i++) {
            bankItems[i] = bankDetailResponceList.get(i).getIFSCCode() + " ~ " + bankDetailResponceList.get(i).getBranchName();
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Select District");
        builder.setItems(bankItems, (dialog, which) -> {
            BankDetailResponce selected = bankDetailResponceList.get(which);



            if (isPrimary) {
                branchName.setText(selected.getBranchName());
                ifsc_code.setText(selected.getIFSCCode());
                address.setText(selected.getAddress());
                districtName.setText(selected.getCityName());

                selectedIfsc1 = ifsc_code.getText().toString();
                selectedBranch1 = branchName.getText().toString();
                selectedBankAddress1 = address.getText().toString();
                selectedBankDistrict1 = districtName.getText().toString();

                applicant.setFinBankID1(selectedBankListID);
                applicant.setFinBank1(selectedBranch1);
                applicant.setBankIFSC1(selectedIfsc1);
                applicant.setBankBranch1(selectedBankAddress1);
                applicant.setBankAddress1(selectedBankAddress1);
                applicant.setBankDist1(selectedBankDistrict1);
            } else {

                alt_branch_name.setText(selected.getBranchName());
                alt_ifscbank_code.setText(selected.getIFSCCode());
                alt_primary_address.setText(selected.getAddress());
                alt_pf_districtEd.setText(selected.getCityName());

                selectedIfsc2 = ifsc_code.getText().toString();
                selectedBranch2 = branchName.getText().toString();
                selectedBankAddress2 = address.getText().toString();
                selectedBankDistrict2 = districtName.getText().toString();

                applicant.setFinBankID2(alt_selectedBankListID);
                applicant.setFinBank2(selectedBranch2);
                applicant.setBankIFSC2(selectedIfsc2);
                applicant.setBankBranch2(selectedBankAddress2);
                applicant.setBankAddress2(selectedBankAddress2);
                applicant.setBankDist2(selectedBankDistrict2);
            }

        });
        builder.setNegativeButton("Cancel", null);
        builder.show();
    }

    private void fetchUnitTypeData() {
        apiService.getUnitType().enqueue(new Callback<List<UnitTypeModel>>() {
            @Override
            public void onResponse(Call<List<UnitTypeModel>> call, Response<List<UnitTypeModel>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<UnitTypeModel> unittypeList = response.body();
                    System.out.println("agencyList" + unittypeList.size());

                    List<String> unitNameList = new ArrayList<>();
                    unitNameList.add(0, "--Select Agency--");
                    for (UnitTypeModel unitTypeModel : unittypeList) {
                        unitNameList.add(unitTypeModel.getSchemeName());


                    }

                    ArrayAdapter<String> adapter = new ArrayAdapter<>(NewApplicantUnitActivity.this, R.layout.spinner_selected_item, unitNameList);
                    adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    unit_type_spinner.setAdapter(adapter);

                    unit_type_spinner.setOnItemSelectedListener(new android.widget.AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(android.widget.AdapterView<?> parent, View view, int position, long id) {
                            if (position > 0) {
                                UnitTypeModel selectedUnit = unittypeList.get(position - 1);
                                selectedunittype = selectedUnit.getSchemeName();
                                activityUnitType = selectedUnit.getActivityType();
                                System.out.println("Selected unittype: " + selectedunittype + " " + activityUnitType);
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


    private void fetchStateList() {
        apiService.getStateList().enqueue(new Callback<List<StateModel>>() {
            @Override
            public void onResponse(Call<List<StateModel>> call, Response<List<StateModel>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<StateModel> states = response.body();
                    System.out.println("sttatelist" + states.size());

                    stateNamesList = new ArrayList<>();
                    stateNamesList.add(0, "--Select state--");
                    for (StateModel state : states) {
                        stateNamesList.add(state.getStateName());


                    }

                    adapter = new ArrayAdapter<>(NewApplicantUnitActivity.this, R.layout.spinner_selected_item, stateNamesList);
                    adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    state_spinner.setAdapter(adapter);
                    setSpinnerToAadharState();

                    ArrayAdapter<String> stateadapter = new ArrayAdapter<>(NewApplicantUnitActivity.this, R.layout.spinner_selected_item, stateNamesList);
                    stateadapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    iastateSpinner.setAdapter(stateadapter);


                    state_spinner.setOnItemSelectedListener(new android.widget.AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(android.widget.AdapterView<?> parent, View view, int position, long id) {
                            if (position > 0) {
                                StateModel selectedState = states.get(position - 1);
                                selectedStateCode = selectedState.getStateCode();
                                System.out.println("Selected stateCode: " + selectedStateCode);
                                ApplicantDataModel applicant = new ApplicantDataModel();

                                state_shortCode = selectedState.getStateShortCode(); // "MH"
                                state_code = selectedState.getStateId();

                            } else {
                                selectedStateCode = null;
                            }
                        }

                        @Override
                        public void onNothingSelected(android.widget.AdapterView<?> parent) {
                            selectedStateCode = null;
                        }
                    });
                    iastateSpinner.setOnItemSelectedListener(new android.widget.AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(android.widget.AdapterView<?> parent, View view, int position, long id) {
                            if (position > 0) {
                                StateModel selectedState = states.get(position - 1);
                                selectedStateCodeIa = selectedState.getStateCode();
                                System.out.println("Selected stateCode: " + selectedStateCodeIa);
                                stateId = states.get(position - 1).getStateId();
                                statename = states.get(position - 1).getStateName();
                                state_zonal_code = states.get(position - 1).getState_zone_code();

                                fetchDistrictListforIA(selectedStateCodeIa);

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

    private void setSpinnerToAadharState() {
        if (apiState != null) {
            for (int i = 0; i < stateNamesList.size(); i++) {
                if (stateNamesList.get(i).equalsIgnoreCase(apiState.trim())) {
                    state_spinner.setSelection(i);
                    break;
                }
            }
        }
    }

    private void fetchDistrictListforIA(String selectedStateCode) {

        DistrictModel request = new DistrictModel(selectedStateCode, "");
        apiService.getDistrictList(request).enqueue(new Callback<List<DistrictModel>>() {
            @Override
            public void onResponse(Call<List<DistrictModel>> call, Response<List<DistrictModel>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    districtList = response.body();
                    System.out.println("IA districtList size: " + districtList.size());

                    List<String> districtNames = new ArrayList<>();
                    districtNames.add(0, "--Select District--");
                    for (DistrictModel district : districtList) {
                        districtNames.add(district.getDistrictName());

                    }

                    ArrayAdapter<String> adapter = new ArrayAdapter<>(NewApplicantUnitActivity.this,
                            R.layout.spinner_selected_item, districtNames);
                    adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    iaDistrictSpinner.setAdapter(adapter);

                    ArrayAdapter<String> unitAdapter = new ArrayAdapter<>(
                            NewApplicantUnitActivity.this,
                            R.layout.spinner_selected_item,
                            districtNames
                    );
                    unitAdapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    unitdistrictnameListspinner.setAdapter(unitAdapter);


                    iaDistrictSpinner.setOnItemSelectedListener(new android.widget.AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(android.widget.AdapterView<?> parent, View view, int position, long id) {
                            if (position > 0) {
                                DistrictModel selectedDistrict = districtList.get(position - 1);
                                selectedDistrictCode = selectedDistrict.getDistrictCode();
                                districtId = districtList.get(position - 1).getDistrictId();
                                districtCode = districtList.get(position - 1).getDistrictCode();
                                district_name = districtList.get(position - 1).getDistrictName();
                                System.out.println("Selected IA districtCode: " + selectedDistrictCode + district_name + districtCode + districtId);

                                for (int i = 0; i < districtList.size(); i++) {
                                    if (districtList.get(i).getDistrictCode().equals(selectedDistrictCode)) {
                                        int finalI = i;
                                        unitdistrictnameListspinner.post(() -> {
                                            unitdistrictnameListspinner.setSelection(finalI + 1, true);
                                            System.out.println("unitdistrictnameListspinner set to position: " + (finalI + 1));
                                        });
                                        break;
                                    }
                                }
                                agencyRequestList = new ArrayList<>();
                                implementing_type_agency_layout.setVisibility(View.VISIBLE);
                                AgencyRequest agencyRequest = new AgencyRequest(1, stateId, districtId);
                                agencyRequestList.add(agencyRequest);
                                fetchSubdistrictList(String.valueOf(districtId));
                                fetchAgencyOffDetails(agencyRequest);

                            }
                        }


                        @Override
                        public void onNothingSelected(android.widget.AdapterView<?> parent) {
                        }
                    });

                }
            }

            @Override
            public void onFailure(Call<List<DistrictModel>> call, Throwable t) {
                t.printStackTrace();
            }
        });


    }


    private void toggleSection(CardView selectedCard, TextView selectedText) {
        boolean isVisible = selectedCard.getVisibility() == View.VISIBLE;

        closeAllCards();

        if (!isVisible) {
            selectedCard.setVisibility(View.VISIBLE);
            selectedText.setCompoundDrawablesWithIntrinsicBounds(
                    null, null,
                    ContextCompat.getDrawable(this, R.drawable.arrow_down_24),
                    null
            );
        }
    }

    private void closeAllCards() {
        for (CardView card : allCards) {
            card.setVisibility(View.GONE);
        }
        for (TextView txt : allTextViews) {
            txt.setCompoundDrawablesWithIntrinsicBounds(null, null, ContextCompat.getDrawable(this, R.drawable.arrow_up_24), null);
        }
    }
    private String convertLessThanOneThousand(int number) {
        String current;
        if (number % 100 < 20) {
            current = numNames[number % 100];
            number /= 100;
        } else {
            current = numNames[number % 10];
            number /= 10;
            current = tensNames[number % 10] + current;
            number /= 10;
        }
        if (number == 0) return current;
        return numNames[number] + " Hundred" + current;
    }

    public String convert(long number) {
        if (number == 0) { return "Zero"; }

        String snumber = Long.toString(number);

        String mask = "000000000000";
        DecimalFormat df = new DecimalFormat(mask);
        snumber = df.format(number);

        int billions = Integer.parseInt(snumber.substring(0,3));
        int millions = Integer.parseInt(snumber.substring(3,6));
        int hundredThousands = Integer.parseInt(snumber.substring(6,9));
        int thousands = Integer.parseInt(snumber.substring(9,12));

        String tradBillions = (billions == 0) ? "" : convertLessThanOneThousand(billions) + " Billion ";
        String tradMillions = (millions == 0) ? "" : convertLessThanOneThousand(millions) + " Million ";
        String tradHundredThousands = (hundredThousands == 0) ? "" :
                (hundredThousands == 1 ? "One Thousand " : convertLessThanOneThousand(hundredThousands) + " Thousand ");
        String tradThousand = convertLessThanOneThousand(thousands);

        return (tradBillions + tradMillions + tradHundredThousands + tradThousand).trim();
    }
}