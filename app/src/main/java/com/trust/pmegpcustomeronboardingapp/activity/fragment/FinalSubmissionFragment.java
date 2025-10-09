package com.trust.pmegpcustomeronboardingapp.activity.fragment;

import static android.app.Activity.RESULT_CANCELED;
import static android.app.Activity.RESULT_OK;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.MediaRouteButton;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.text.method.ScrollingMovementMethod;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.trust.pmegpcustomeronboardingapp.BuildConfig;
import com.trust.pmegpcustomeronboardingapp.R;
import com.trust.pmegpcustomeronboardingapp.activity.adapter.DocumentAdapter;
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
import com.trust.pmegpcustomeronboardingapp.activity.model.BuildingItem;
import com.trust.pmegpcustomeronboardingapp.activity.model.DistrictModel;
import com.trust.pmegpcustomeronboardingapp.activity.model.Document;
import com.trust.pmegpcustomeronboardingapp.activity.model.GenderModel;
import com.trust.pmegpcustomeronboardingapp.activity.model.InformationSource;
import com.trust.pmegpcustomeronboardingapp.activity.model.PidDataModel;
import com.trust.pmegpcustomeronboardingapp.activity.model.QualificationModel;
import com.trust.pmegpcustomeronboardingapp.activity.model.ScoreCard;
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
import com.trust.pmegpcustomeronboardingapp.activity.model.faceDetectionResult;
import com.trust.pmegpcustomeronboardingapp.activity.retrofitClient.ApiClient;
import com.trust.pmegpcustomeronboardingapp.activity.screens.NewApplicantUnitActivity;
import com.trust.pmegpcustomeronboardingapp.activity.services.ApiServices;
import com.trust.pmegpcustomeronboardingapp.activity.utils.AppConstant;
import com.trust.pmegpcustomeronboardingapp.activity.utils.CryptoEncryption;
import com.trust.pmegpcustomeronboardingapp.activity.utils.TrustMethods;

import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FinalSubmissionFragment extends Fragment {

    private static final int RD_SERVICE_REQUEST = 1001;
    private static final int LOCAL_MATCH_REQ = 1002;
    private static final String TAG = "LocalFaceMatch";
    private static final String FACERD_PACKAGE = "in.gov.uidai.facerd";
    private static final String FACERD_ACTION = "in.gov.uidai.rdservice.face.CAPTURE";
    private ActivityResultLauncher<Intent> faceLauncher;
    private ApiServices apiService;
    private ProgressDialog progressDialog;
    ApplicantDataModel applicantDataModel;
    private List<CardView> allCards;
    private List<TextView> allTextViews;

    LinearLayout implementing_type_agency_layout;
    TextView agency_type_state, agency_type_pin, agency_type_district, agency_type, agency_type_mobile, agency_type_email, txt_application_layout, app_txt_communicationLayout, txtimplementing_agency_layout, app_txt_unitlayout, app_txt_projectinfo_Layout, app_txt_primary_finance_bank_layout, app_txt_altfbank_Layout, app_txt_other_info_Layout, app_txt_unload_doc_Layout, app_txt_score_card_Layout, app_txt_faceDetection_Layout;
    CardView cv_application, app_cv_communication_address, app_cv_implementing_agency, app_cv_unitAddress, app_cv_projectinfo, app_cv_primary_Financing_bank, app_cv_alternate_Financing_bank, app_cv_otherInfo, app_cv_doc_upload, app_cv_score_card, app_cv_faceDetection_card;
    Button app_btn_district_change, app_alt_btn_ifsc_code, app_btn_ifsc_code, app_btn_updateform, app_btn_show_nic_code_list, app_btn_industry_activity, app_btn_edpSelection;
    EditText app_email, app_mobile_number, app_alternate_mobile_number, app_pin_number, app_adharcardno, app_district, app_taluka_block_name, app_pannumber, app_nameofapplicant, app_dob, app_age, app_communication_address, app_unitaddress, app_unitLoc, app_unitpincode, app_lgd_code, app_edp_training_insti_name, app_capital_exp, app_workingcapital, app_totalexp, app_employee_count, app_ifscbank_code, app_branch_name, app_alt_branch_name, app_primary_address, app_pf_districtEd, app_alt_ifscbank_code, app_alt_primary_address, app_alt_pf_districtEd;
    Spinner app_implementing_agency_txt, app_titleSpinner, app_spinner_about_us_spinner, app_iastateSpinner, app_activityspinner, app_agencydistrictSpinner, app_unitvillagenamespinner, app_unitsubdistrictnameSpinner, app_unitdistrictnameList, app_spinner_gender, app_social_category_spinner, app_special_category_spinner, app_qualificationspinner, app_state_spinner, app_bank_spinner_list, app_alt_bank_spinner_list;
    CheckBox app_agencyTypecheck, app_checkbox_availt_note, app_form_check;
    ImageButton img_facedetection, img_biometrics;
    RadioGroup radioGroup;
    RadioButton yesBtn, noBtn;
    LinearLayout availLayout;
    TextView app_agencyTypeName;
    RecyclerView app_rv_product, rv_documents;
    RadioGroup app_edp_radioGrp, app_edp_subgrp_radioGrp, app_cgtmse_radioGrp;
    DocumentAdapter documentAdapter;
    List<Document> docList;
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
    private static final String FACE_RD_PACKAGE = "in.gov.uidai.facerd";


    String selectedDistrictName, selectedPincode, selectedVillageName, subdistrictName, selectedNodalCode, agencyName, selectedAgencyCode, selectedAgency_Code, selectedBankName2, alt_selectedCityName, selectedBankName1, selectedCityName, selectedQualDesc, selectedQualCode, selectedSocialCatCode, selectedSpecialCatCode, selectedunittype, selectedStateCode, state_shortCode, state_code, selectedStateCodeIa, statename, state_zonal_code, selectedDistrictCode, districtCode, district_name;
    int selectedagencyoffId, agentId, stateId, districtId, activityUnitType, selectedBankListID, alt_selectedBankListID, selectedBankId2;
    String aadhaarNumber;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

//    private void sendPidDataToServer(String pidData) {
//        // Example: Retrofit call
//        Call<ResponseBody> call = apiService.sendFaceAuthData("123412341234", pidData);
//        call.enqueue(new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                if (response.isSuccessful()) {
//                    Toast.makeText(requireContext(), "Authentication success", Toast.LENGTH_SHORT).show();
//                } else {
//                    Toast.makeText(requireContext(), "Authentication failed", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable t) {
//                Toast.makeText(requireContext(), "Server error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
//    }

    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_final_submission_fragment, container, false);
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
        agency_type = view.findViewById(R.id.agencyTypeName);
        agency_type_district = view.findViewById(R.id.agency_type_district);
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
        rv_documents = view.findViewById(R.id.rv_documents);
        img_facedetection = view.findViewById(R.id.img_facedetection);
        img_biometrics = view.findViewById(R.id.img_biometrics);
        rv_documents.setLayoutManager(new LinearLayoutManager(getContext()));

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

        txt_application_layout = view.findViewById(R.id.txt_application_layout);
        app_txt_communicationLayout = view.findViewById(R.id.app_txt_communicationLayout);
        txtimplementing_agency_layout = view.findViewById(R.id.txtimplementing_agency_layout);
        app_txt_unitlayout = view.findViewById(R.id.app_txt_unitlayout);
        app_txt_projectinfo_Layout = view.findViewById(R.id.app_txt_projectinfo_Layout);
        app_txt_primary_finance_bank_layout = view.findViewById(R.id.app_txt_primary_finance_bank_layout);
        app_txt_altfbank_Layout = view.findViewById(R.id.app_txt_altfbank_Layout);
        app_txt_other_info_Layout = view.findViewById(R.id.app_txt_other_info_Layout);
        app_txt_unload_doc_Layout = view.findViewById(R.id.app_txt_unload_doc_Layout);
        app_txt_score_card_Layout = view.findViewById(R.id.app_txt_score_card_Layout);
        app_txt_faceDetection_Layout = view.findViewById(R.id.app_txt_faceDetection_Layout);

        cv_application = view.findViewById(R.id.cv_application);
        app_cv_communication_address = view.findViewById(R.id.app_cv_communication_address);
        app_cv_implementing_agency = view.findViewById(R.id.app_cv_implementing_agency);
        app_cv_unitAddress = view.findViewById(R.id.app_cv_unitAddress);
        app_cv_projectinfo = view.findViewById(R.id.app_cv_projectinfo);
        app_cv_primary_Financing_bank = view.findViewById(R.id.app_cv_primary_Financing_bank);
        app_cv_alternate_Financing_bank = view.findViewById(R.id.app_cv_alternate_Financing_bank);
        app_cv_otherInfo = view.findViewById(R.id.app_cv_otherInfo);
        app_cv_doc_upload = view.findViewById(R.id.app_cv_doc_upload);
        app_cv_score_card = view.findViewById(R.id.app_cv_score_card);
        app_cv_faceDetection_card = view.findViewById(R.id.app_cv_faceDetection_card);


        cv_application.setVisibility(View.GONE);
        app_cv_communication_address.setVisibility(View.GONE);
        app_cv_implementing_agency.setVisibility(View.GONE);
        app_cv_unitAddress.setVisibility(View.GONE);
        app_cv_projectinfo.setVisibility(View.GONE);
        app_cv_primary_Financing_bank.setVisibility(View.GONE);
        app_cv_alternate_Financing_bank.setVisibility(View.GONE);
        app_cv_otherInfo.setVisibility(View.GONE);
        app_cv_doc_upload.setVisibility(View.GONE);
        app_cv_score_card.setVisibility(View.GONE);
        app_cv_faceDetection_card.setVisibility(View.GONE);


        allCards = Arrays.asList(cv_application, app_cv_communication_address, app_cv_implementing_agency,
                app_cv_unitAddress, app_cv_projectinfo, app_cv_primary_Financing_bank, app_cv_alternate_Financing_bank, app_cv_otherInfo, app_cv_doc_upload, app_cv_score_card, app_cv_faceDetection_card);

        allTextViews = Arrays.asList(txt_application_layout, app_txt_communicationLayout, txtimplementing_agency_layout, app_txt_unitlayout,
                app_txt_projectinfo_Layout, app_txt_primary_finance_bank_layout, app_txt_altfbank_Layout, app_txt_other_info_Layout, app_txt_unload_doc_Layout, app_txt_score_card_Layout, app_txt_faceDetection_Layout);


        closeAllCards();
        app_btn_district_change.setOnClickListener(v -> {
            if (selectedStateCode != null) {
                fetchDistrictList(selectedStateCode);
            }
        });

        img_biometrics.setOnClickListener(v -> {

        });


        txt_application_layout.setOnClickListener(v -> toggleSection(cv_application, txt_application_layout));
        app_txt_communicationLayout.setOnClickListener(v -> toggleSection(app_cv_communication_address, app_txt_communicationLayout));
        txtimplementing_agency_layout.setOnClickListener(v -> toggleSection(app_cv_implementing_agency, txtimplementing_agency_layout));
        app_txt_unitlayout.setOnClickListener(v -> toggleSection(app_cv_unitAddress, app_txt_unitlayout));
        app_txt_projectinfo_Layout.setOnClickListener(v -> toggleSection(app_cv_projectinfo, app_txt_projectinfo_Layout));
        app_txt_primary_finance_bank_layout.setOnClickListener(v -> toggleSection(app_cv_primary_Financing_bank, app_txt_primary_finance_bank_layout));
        app_txt_altfbank_Layout.setOnClickListener(v -> toggleSection(app_cv_alternate_Financing_bank, app_txt_altfbank_Layout));
        app_txt_other_info_Layout.setOnClickListener(v -> toggleSection(app_cv_otherInfo, app_txt_other_info_Layout));
        app_txt_unload_doc_Layout.setOnClickListener(v -> toggleSection(app_cv_doc_upload, app_txt_unload_doc_Layout));
        app_txt_score_card_Layout.setOnClickListener(v -> toggleSection(app_cv_score_card, app_txt_score_card_Layout));
        app_txt_faceDetection_Layout.setOnClickListener(v -> toggleSection(app_cv_faceDetection_card, app_txt_faceDetection_Layout));

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
            applicant.setAge(applicantDataModel.getAge());
            applicant.setSocialCatID(applicantDataModel.getSocialCatID());
            applicant.setSpecialCatID(applicantDataModel.getSpecialCatID());
            applicant.setQualID(applicantDataModel.getQualID());
            applicant.setQualDesc(applicantDataModel.getQualDesc());
            applicant.setComnAddress(applicantDataModel.getComnAddress());
            applicant.setComnTaluka(applicantDataModel.getComnTaluka());
            applicant.setComnDistrict(applicantDataModel.getComnDistrict());
            applicant.setComnPin(applicantDataModel.getComnPin());
            applicant.setMobileNo1(applicantDataModel.getMobileNo1());
            applicant.setMobileNo2(applicantDataModel.getMobileNo2());
            applicant.setEmail(applicantDataModel.geteMail());
            applicant.setPanNo(applicantDataModel.getPanNo());
            applicant.setUnitLocation(applicantDataModel.getUnitLocation());
            applicant.setUnitAddress(applicantDataModel.getUnitAddress());
            applicant.setUnitTaluka(applicantDataModel.getUnitTaluka());
            applicant.setVillageName(applicantDataModel.getVillageName());
            applicant.setLgdCodeId(applicantDataModel.getLgdCodeId());
            applicant.setUnitDistrict(applicantDataModel.getUnitDistrict());
            applicant.setLgdCode(applicantDataModel.getLgdCode());
            applicant.setUnitPin(applicantDataModel.getUnitPin());
            applicant.setUnitActivityTypeId("");
            applicant.setEDPTraining(applicantDataModel.getIsEDPTraining());
            applicant.setUnitLocationSame(applicantDataModel.getIsUnitLocationSame());
            applicant.setEdpTrainingInst(applicantDataModel.getEdpTrainingInst());
            applicant.setCapitalExpd(applicantDataModel.getCapitalExpd());
            applicant.setWorkingCapital(applicantDataModel.getWorkingCapital());
            applicant.setTotalProjectCost(applicantDataModel.getTotalProjectCost());
            applicant.setEmployment(applicantDataModel.getEmployment());
            applicant.setFinBankID1(applicantDataModel.getFinBankID1());
            applicant.setFinBank1(applicantDataModel.getFinBank1());
            applicant.setBankIFSC1(applicantDataModel.getBankIFSC1());
            applicant.setBankBranch1(applicantDataModel.getBankBranch1());
            applicant.setBankAddress1(applicantDataModel.getBankAddress1());
            applicant.setBankDist1(applicantDataModel.getBankDist1());
            applicant.setFinBankID1(applicantDataModel.getFinBankID1());
            applicant.setFinBank1(applicantDataModel.getFinBank1());
            applicant.setBankIFSC2(applicantDataModel.getBankIFSC2());
            applicant.setBankBranch2(applicantDataModel.getBankBranch2());
            applicant.setBankDist2(applicantDataModel.getBankDist2());
            applicant.isAvailCGTMSE(applicantDataModel.getIsAvailCGTMSE());
            applicant.setPmegpRef(applicantDataModel.getPmegpRef());
            applicant.setIsAadharVerified(applicantDataModel.getIsAadharVerified());
            applicant.setIsPanVerified(applicantDataModel.getIsPanVerified());
            applicant.setDeclrAccept(applicantDataModel.getIsDeclrAccept());
            applicant.setSchemeID(applicantDataModel.getSchemeID());
            applicant.setCharAppliAccepted(applicantDataModel.getIsCharAppliAccepted());
            applicant.setStateCode(applicantDataModel.getStateCode());
            applicant.setState_Name(applicantDataModel.getState_Name());
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Log.d("FINAL_JSON", gson.toJson(applicant));

//            SaveApplicationForm(applicant);

        });

        initData();

        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        apiService = ApiClient.getClient().create(ApiServices.class);

        String applIdStr = AppConstant.getApplId();


        int applicationId = Integer.parseInt(applIdStr);
        System.out.println("applicationId" + applicationId);
        getApplicantData(applicationId);
        faceLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    Intent data = result.getData();

                    if (result.getResultCode() == Activity.RESULT_OK && data != null) {
                        String pidData = data.getStringExtra("PID_DATA");

                        if (pidData != null) {
                            Log.d("FaceRD", "PID_DATA: " + pidData);
                            Toast.makeText(requireContext(), "FaceRD Success", Toast.LENGTH_LONG).show();
                        } else {
                            Log.e("FaceRD", "Result OK but PID_DATA missing");
                        }
                    } else {
                        Log.e("FaceRD", "FaceRD cancelled/failed, resultCode=" + result.getResultCode() + " " + data);

                        if (data != null) {
                            String errorCode = data.getStringExtra("ERROR_CODE");
                            String errorInfo = data.getStringExtra("ERR_INFO");
                            String errCode = data.getStringExtra("ERR_CODE");
                            String errInfo = data.getStringExtra("errInfo");
                            String pidData = data.getStringExtra("PID_DATA");

                            Log.e("FaceRD", "ERROR_CODE=" + errorCode +
                                    ", ERR_INFO=" + errorInfo +
                                    ", ERR_CODE=" + errCode +
                                    ", errInfo=" + errInfo);

                            if (pidData != null) {
                                Log.e("FaceRD", "PID_DATA (may contain error XML): " + pidData);

                                if (pidData.contains("<Resp")) {
                                    try {
                                        int codeStart = pidData.indexOf("errCode=\"");
                                        int infoStart = pidData.indexOf("errInfo=\"");
                                        String parsedCode = (codeStart > 0)
                                                ? pidData.substring(codeStart + 9, pidData.indexOf("\"", codeStart + 9))
                                                : null;
                                        String parsedInfo = (infoStart > 0)
                                                ? pidData.substring(infoStart + 9, pidData.indexOf("\"", infoStart + 9))
                                                : null;

                                        Log.e("FaceRD", "Parsed error: code=" + parsedCode + ", info=" + parsedInfo);
                                        Toast.makeText(requireContext(),
                                                "FaceRD Error: " + parsedInfo,
                                                Toast.LENGTH_LONG).show();
                                    } catch (Exception e) {
                                        Log.e("FaceRD", "Failed to parse error XML", e);
                                    }
                                }
                            }
                        } else {
                            Log.e("FaceRD", "No data returned at all");

                        }
                    }
                }
        );

        img_facedetection.setOnClickListener(v -> startFaceCapture());

    }

    private void startFaceCapture() {

        if (isDebuggingEnabled(requireContext())) {
            Toast.makeText(requireContext(),
                    "Please disable USB/Wireless debugging before Aadhaar face capture.",
                    Toast.LENGTH_LONG).show();
            return;
        }

        if (isDeviceRooted()) {
            Toast.makeText(requireContext(),
                    "Face capture is not allowed on rooted devices.",
                    Toast.LENGTH_LONG).show();
            return;
        }

        String pidOptions = buildPidOptionsXml();
        Log.i("11","pid" +pidOptions.toString());
        Intent intent = new Intent("in.gov.uidai.rdservice.face.CAPTURE");
        intent.putExtra("request", pidOptions);

        try {
            startActivityForResult(intent, RD_SERVICE_REQUEST);
        } catch (Exception e) {
            Log.e(TAG, "FaceRD not available", e);
            Toast.makeText(getContext(),
                    "Aadhaar Face RD Service is NOT installed. Please install from Play Store.",
                    Toast.LENGTH_LONG).show();
            openPlayStoreForFaceRD();
        }
    }

    private boolean isDebuggingEnabled(Context context) {
        return (Settings.Secure.getInt(context.getContentResolver(),
                Settings.Secure.ADB_ENABLED, 0) == 1);
    }

    private boolean isDeviceRooted() {
        String[] paths = {"/system/app/Superuser.apk", "/sbin/su", "/system/bin/su",
                "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su",
                "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su"};
        for (String path : paths) {
            if (new File(path).exists()) return true;
        }
        return false;
    }
    private void startLocalFaceMatch() {
        String xmlRequest = buildLocalFaceMatchXml();
        Intent intent = new Intent("in.gov.uidai.rdservice.face.LOCAL_FACE_MATCH");
        intent.putExtra("request", xmlRequest);

        try {
            startActivityForResult(intent, LOCAL_MATCH_REQ);
        } catch (Exception e) {
            Toast.makeText(getContext(), "Install FaceRD app from Play Store", Toast.LENGTH_LONG).show();
            Log.e(TAG, "FaceRD not available", e);
            openPlayStoreForFaceRD();
        }
    }

    private String buildLocalFaceMatchXml() {
        String requestId = UUID.randomUUID().toString().replace("-", "");
        String doc1 = "RHVtbXlEb2Mx";
        String doc2 = "RHVtbXlEb2My";
        return "<localFaceMatchRequest requestId=\"" + requestId + "\" language=\"en\" enableAutoCapture=\"true\" encryptResponse=\"n\">" +
                "<Document1 docType=\"AADHAAR\" auaCode=\"\">" + doc1 + "</Document1>" +
                "<Document2 docType=\"PHOTO\" auaCode=\"123456\">" + doc2 + "</Document2>" +
                "<Signature>DummySignature</Signature>" +
                "</localFaceMatchRequest>";
    }


    private void openPlayStoreForFaceRD() {
        try {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + FACE_RD_PACKAGE)));
        } catch (android.content.ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + FACE_RD_PACKAGE)));
        }
    }



    private String buildPidOptionsXml() {
        String txnId = UUID.randomUUID().toString().replace("-", "");
        return "<PidOptions ver=\"1.0\" env=\"P\">" +
                "<Opts fCount=\"1\" fType=\"0\" format=\"0\" pidVer=\"2.0\" timeout=\"20000\" wadh=\"E0jzJ/P8UopUHAieZn8CKqS4WPMi5ZSYXgfnlfkWjrc=\"/>" +
                "<CustOpts>" +
                "<Param name=\"txnId\" value=\"" + txnId + "\"/>" +
                "<Param name=\"language\" value=\"en\"/>" +
                "<Param name=\"auaCode\" value=\"123456\"/>" +
                "<Param name=\"callBackUrl\" value=\"\"/>" +
                "<Param name=\"auaAuthToken\" value=\"DUMMY_TOKEN\"/>" +
                "<Param name=\"cameraUsage\" value=\"front\"/>" +
                "</CustOpts>" +
                "<BioData/>" +
                "<Signature/>" +
                "</PidOptions>";
    }


    private void sendPidDataToBackend(PidDataModel pidDataModel) {
        String encryptionKey = BuildConfig.ENCRYPTION_KEY;
        System.out.println("Encryption-key"+encryptionKey);
        Toast.makeText(getContext(), "Encryption-key"+encryptionKey, Toast.LENGTH_SHORT).show();
        String encrypted="";
        String decrypted="";
        try {
             encrypted = CryptoEncryption.encryptString(aadhaarNumber, encryptionKey);
             decrypted = CryptoEncryption.decryptString(encrypted, encryptionKey);
            Log.d("CRYPTO", "Encrypted: " + encrypted);
            Log.d("CRYPTO", "Decrypted: " + decrypted);
        } catch (Exception ex) {
            Log.e("CRYPTO", "Error", ex);
        }

        apiService.validateFaceRecognition(pidDataModel).enqueue(new Callback<faceDetectionResult>() {
            @Override
            public void onResponse(Call<faceDetectionResult> call, retrofit2.Response<faceDetectionResult> response) {
                progressDialog.dismiss();
                if (response.isSuccessful() && response.body() != null) {
                    faceDetectionResult data = response.body();
                   Log.i("1122 ","response pid=="+data.toString());
                    Toast.makeText(getContext(), "response pid=="+data.toString(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<faceDetectionResult> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(getContext(), "response pid=="+t.getMessage(), Toast.LENGTH_LONG).show();

                t.printStackTrace();
            }
        });
    }
@Override
public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if (requestCode == RD_SERVICE_REQUEST) {
        if (resultCode == RESULT_OK && data != null) {
            String pidJson = data.getStringExtra("response"); // JSON format

            if (pidJson != null && !pidJson.isEmpty()) {
                String pidXml = convertJsonToXml(pidJson); // Convert JSON → XML
                logLongString("PID_XML", pidXml);
                showXmlDialog("PID XML", pidXml);
//                sendPidDataToBackend(pidData);
            } else {
                Toast.makeText(requireContext(), "No PID data received", Toast.LENGTH_SHORT).show();
            }
        }
    }

    if (requestCode == LOCAL_MATCH_REQ) {
        if (resultCode == RESULT_OK && data != null) {
            String response = data.getStringExtra("RESPONSE");
            Log.d(TAG, "Match Response: " + response);
            Toast.makeText(getContext(), "Match Response: " + response, Toast.LENGTH_SHORT).show();
        } else {
            String error = (data != null) ? data.getStringExtra("RESPONSE") : "No response";
            Log.e(TAG, "Local Match failed: " + error);
        }
    }
}

    private String convertJsonToXml(String jsonString) {
        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            return "<Pid>" + jsonToXml(jsonObject) + "</Pid>";
        } catch (Exception e) {
            Log.e(TAG, "Error converting JSON to XML", e);
            return jsonString;
        }
    }

    private String jsonToXml(JSONObject jsonObject) {
        StringBuilder xml = new StringBuilder();
        Iterator<String> keys = jsonObject.keys();
        while (keys.hasNext()) {
            String key = keys.next();
            Object value = jsonObject.opt(key);
            if (value instanceof JSONObject) {
                xml.append("<").append(key).append(">")
                        .append(jsonToXml((JSONObject) value))
                        .append("</").append(key).append(">");
            } else {
                xml.append("<").append(key).append(">")
                        .append(value.toString())
                        .append("</").append(key).append(">");
            }
        }
        return xml.toString();
    }


//    @Override
//    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (requestCode == RD_SERVICE_REQUEST) {
//            if (resultCode == RESULT_OK && data != null) {
////                String pidData = data.getStringExtra("response");
//                String pidData = data.getStringExtra("PIDXML");
//                if (pidData != null) {
//                    logLongString("PID_DATA", pidData);
//                }
//
//                if (pidData != null && pidData.contains("PID_CREATED")) {
//                    Toast.makeText(requireContext(), "Face captured successfully!", Toast.LENGTH_SHORT).show();
//
//                    showXmlDialog("PID XML", pidData);
//
//
////                    sendPidDataToBackend(pidData);
//
//                } else {
//                    Log.e(TAG, "Capture failed: " + pidData);
//                    Toast.makeText(requireActivity(), "Face capture failed. Please try again.", Toast.LENGTH_SHORT).show();
//                }
//            } else {
//                String error = (data != null) ? data.getStringExtra("response") : "No response";
//                Log.e(TAG, "Capture failed: " + error);
//                Toast.makeText(getContext(), "Face capture failed.", Toast.LENGTH_SHORT).show();
//            }
//        }
//
//        if (requestCode == LOCAL_MATCH_REQ) {
//            if (resultCode == RESULT_OK && data != null) {
//                String response = data.getStringExtra("RESPONSE");
//                Log.d(TAG, "Match Response: " + response);
//                Toast.makeText(getContext(), "Match Response: " + response, Toast.LENGTH_SHORT).show();
//            } else {
//                String error = (data != null) ? data.getStringExtra("RESPONSE") : "No response";
//                Log.e(TAG, "Local Match failed: " + error);
//            }
//        }
//    }

    private void logLongString(String tag, String message) {
        if (message == null) return;

        int maxLogSize = 4000;
        for (int i = 0; i <= message.length() / maxLogSize; i++) {
            int start = i * maxLogSize;
            int end = Math.min((i + 1) * maxLogSize, message.length());
            Log.d(tag, message.substring(start, end));
        }
    }


    private void showXmlDialog(String title, String xmlContent) {
        try {
            AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
            builder.setTitle(title);

            // Create a scrollable TextView for XML content
            TextView textView = new TextView(requireContext());
            textView.setText(xmlContent);
            textView.setTextIsSelectable(true);
            textView.setPadding(50, 30, 50, 30);
            textView.setTextSize(14);
            textView.setVerticalScrollBarEnabled(true);
            textView.setMovementMethod(new ScrollingMovementMethod());

            ScrollView scrollView = new ScrollView(requireContext());
            scrollView.addView(textView);

            builder.setView(scrollView);

            builder.setPositiveButton("OK", (dialog, which) -> dialog.dismiss());
            builder.setNegativeButton("Copy", (dialog, which) -> {
                ClipboardManager clipboard = (ClipboardManager) requireContext().getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip = ClipData.newPlainText("PID XML", xmlContent);
                clipboard.setPrimaryClip(clip);
                Toast.makeText(requireContext(), "PID XML copied to clipboard", Toast.LENGTH_SHORT).show();
            });

            AlertDialog dialog = builder.create();
            dialog.show();

            // Optional: Adjust dialog size
            if (dialog.getWindow() != null) {
                dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            }

        } catch (Exception e) {
            Log.e("showXmlDialog", "Error showing XML dialog", e);
            Toast.makeText(requireContext(), "Failed to display PID XML", Toast.LENGTH_SHORT).show();
        }
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

        fetchStateList();
        fetchAgencyList("");
        fetchQualificationList();
        fetchSpecialCategoryList();
        fetchSocialCategoryList();
        fetchInformationSourceList();
        fetchUnitTypeData("");
        fetchGenderList();
        fetchBankList();
//        fetchDocList();


    }

    private void fetchDocList() {

         docList = new ArrayList<>();

        documentAdapter = new DocumentAdapter(docList);
        DocumentAdapter adapter = new DocumentAdapter(docList);
        rv_documents.setAdapter(adapter);
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
                                    fetchDistrictListforIA(selectedStateCodeIa, "",""); // reset on user selection
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
                            getContext(),
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

                    // Handle user selection for agency district
                    app_agencydistrictSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                            if (position > 0) {
                                DistrictModel selectedDistrict = districtList.get(position - 1);
                                districtId = selectedDistrict.getDistrictId();
                                districtCode = selectedDistrict.getDistrictCode();
                                district_name = selectedDistrict.getDistrictName();

                                Log.d("SpinnerSelection", "User selected: " + district_name);

                                app_unitdistrictnameList.setSelection(position, false);

                                agencyRequestList = new ArrayList<>();
                                implementing_type_agency_layout.setVisibility(View.VISIBLE);
                                AgencyRequest agencyRequest = new AgencyRequest(1, stateId, districtId);
                                agencyRequestList.add(agencyRequest);

                                fetchSubdistrictList(String.valueOf(districtId));
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

    private void fetchSubdistrictList(String code) {
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

                            app_unitsubdistrictnameSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                    if (position > 0){
                                        SubDistrictResponce selectedDistrict = subDistrictSource.get(position - 1);
                                        int subdistrictId = selectedDistrict.getDistrictId();
                                        System.out.println("subdistrictId"+subdistrictId);
                                        int selectedSubdistrictCode = subDistrictSource.get(position - 1).getSubdistrict_code();
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
                Toast.makeText(getContext(), "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
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
                Toast.makeText(getContext(), "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
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
    private void getApplicantData(int applId) {
        ApplicantRequest request = new ApplicantRequest(applId);

        progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Please wait, Loading DPR Data...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        apiService.getApplicantData(request).enqueue(new retrofit2.Callback<ApplicationResponse>() {
            @Override
            public void onResponse(Call<ApplicationResponse> call, retrofit2.Response<ApplicationResponse> response) {
                progressDialog.dismiss();

                if (response.isSuccessful() && response.body() != null) {
                    ApplicantDetailData data = response.body().getData();
                    Log.d("API_RESPONSE", new Gson().toJson(data));


                    setDataToUI(data);
                }
            }

            @Override
            public void onFailure(Call<ApplicationResponse> call, Throwable t) {
                progressDialog.dismiss();

                t.printStackTrace();
            }
        });
    }

    private void setDataToUI(ApplicantDetailData data) {
        if (data == null) return;
        System.out.println("data_applicant "+new Gson().toJson(data));
        aadhaarNumber = data.getAadharNo();
        Toast.makeText(getContext(), "aadhaarNumber "+aadhaarNumber, Toast.LENGTH_LONG).show();

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


        app_ifscbank_code.setText(data.getBankIFSC1());
        app_branch_name.setText(data.getBankBranch1());
        app_primary_address.setText(data.getBankAddress1());
        app_pf_districtEd.setText(data.getBankDist1());

        System.out.println("alt_bank"+data.getBankIFSC2()+ " "+data.getBankBranch2()+" "+data.getBankAddress2()+" "+data.getBankDist2());

        app_alt_btn_ifsc_code.setText(data.getBankIFSC2() != null ? data.getBankIFSC2() : "");
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


        System.out.println("Data---"+data.getComnDistrict() +" "+data.getUnitDistrict());
        comn_district = data.getComnDistrict();
        unit_district = data.getUnitDistrict();
        if (data.getComnDistrict() != null) {
            fetchDistrictListforIA(data.getState_Code(),data.getComnDistrict(),data.getUnitDistrict());
            isInitialLoad = true;
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
        if (value == null || spinner.getAdapter() == null) return;

        for (int i = 0; i < spinner.getCount(); i++) {
            String item = spinner.getItemAtPosition(i).toString().trim();
            if (item.equalsIgnoreCase(value.trim())) {
                spinner.setSelection(i);
                return;
            }
        }

        Log.w("SpinnerSelection", "Value not found in spinner: " + value);
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
