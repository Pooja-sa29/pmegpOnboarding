package com.trust.pmegpcustomeronboardingapp.activity.fragment;


import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.trust.pmegpcustomeronboardingapp.R;
import com.trust.pmegpcustomeronboardingapp.activity.Interface.BaseDprItem;
import com.trust.pmegpcustomeronboardingapp.activity.adapter.NewBuildingAdapter;
import com.trust.pmegpcustomeronboardingapp.activity.adapter.NewDetailsOfSalesAdapter;
import com.trust.pmegpcustomeronboardingapp.activity.adapter.NewMachineryAdapter;
import com.trust.pmegpcustomeronboardingapp.activity.adapter.NewMeansOfFinancingAdapter;
import com.trust.pmegpcustomeronboardingapp.activity.adapter.NewRawMaterialAdapter;
import com.trust.pmegpcustomeronboardingapp.activity.adapter.NewSalaryDetailAdapter;
import com.trust.pmegpcustomeronboardingapp.activity.adapter.NewWagesAdapter;
import com.trust.pmegpcustomeronboardingapp.activity.adapter.NewWorkingCapitalAdapter;
import com.trust.pmegpcustomeronboardingapp.activity.adapter.NewWorkingCapitalEstimatesAdapter;
import com.trust.pmegpcustomeronboardingapp.activity.adapter.NewWorkingPowerEstimatesAdapter;
import com.trust.pmegpcustomeronboardingapp.activity.adapter.ProductAdapter;
import com.trust.pmegpcustomeronboardingapp.activity.model.ApplicantDPROnly;
import com.trust.pmegpcustomeronboardingapp.activity.model.ApplicantDataModel;
import com.trust.pmegpcustomeronboardingapp.activity.model.ApplicantRequest;
import com.trust.pmegpcustomeronboardingapp.activity.model.BuildingItem;
import com.trust.pmegpcustomeronboardingapp.activity.model.DPRDetailData;
import com.trust.pmegpcustomeronboardingapp.activity.model.DPRResponse;
import com.trust.pmegpcustomeronboardingapp.activity.model.DPRUpdateRequest;
import com.trust.pmegpcustomeronboardingapp.activity.model.DRPMasterData;
import com.trust.pmegpcustomeronboardingapp.activity.model.DprResult;
import com.trust.pmegpcustomeronboardingapp.activity.model.DprSaveRequestData;
import com.trust.pmegpcustomeronboardingapp.activity.model.MachineryItem;
import com.trust.pmegpcustomeronboardingapp.activity.model.UnitTypeModel;
import com.trust.pmegpcustomeronboardingapp.activity.retrofitClient.ApiClient;
import com.trust.pmegpcustomeronboardingapp.activity.screens.DashboardScreenActivity;
import com.trust.pmegpcustomeronboardingapp.activity.services.ApiServices;
import com.trust.pmegpcustomeronboardingapp.activity.utils.AppConstant;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DPRFragment extends BaseFormFragment {
    private ApiServices apiService;
    private ProgressDialog progressDialog;
    private TextView txtDprApplicationLayout, txtBuildingLayout, txt_MACHINERY_layout,txt_working_capitallayout,txt_financing_details_Layout,txt_salesDetails_layout,txt_raw_material_Layout,txt_beneficiary_Layout,txt_introduction_Layout,txt_imp_agency_Layout,txt_promoter_details_Layout,txt_ofc_intro_Layout,txt_depreciation_Layout,txt_power_estimate_Layout,txt_working_capital_Layout,txt_salary_details_Layout,txt_wages_Layout,txtAddbuildingRow,txt_add_machinery_row,txt_wages_row,txt_salary_row,txt_raw_material_row,txt_add_sales_row, landTotal,machinery_total,workingCapitalTotal,salesTotal,wagesTotal,rawTotal,salartTotal,rate_of_interest_power;
    private Spinner activitySpinner;
    Button btn_updateform,btn_saveform;
    DRPMasterData dprDrpMasterData;
    DPRDetailData dprDetailData;
    DprSaveRequestData dprSaveRequestData;

    CardView cv_dpr,cv_building_details,cv_machinery_details,cv_working_capital,cv_means_of_financing,cv_sales_details,cv_raw_material_details,cv_wages_details,cv_salary_details,cv_workking_capital_details,cv_power_estimates,cv_depreciation,cv_intro_ofc,cv_promoter,cv_implementing_agency,cv_intro,cv_abt_beneficiary;
    private RecyclerView rvProduct, rvLandEntry, rvMachineryEntry, rvWorkingCapital,
            rvMeansOfFinancing, rvSalesDetails, rvRawMaterialEntry, rvWagesEntry,rvSalaryEntry,rv_capital_estimates_entry,rv_power_estimate_entry;
    private TextInputLayout txtInputLayout;
    private TextInputEditText landEntry,txt_power_req,into_ofc,onmachinery,payBackPeriod,prj_impl_period,promoter_info,intro_ofc,introduction_txt,aboutBeneficiary;
    String selectedunittype;
    private List<CardView> allCards;
    private List<TextView> allTextViews;
    int activityUnitType;
    ProductAdapter productAdapter;
    NewBuildingAdapter newBuildingAdapter;
    NewMachineryAdapter newMachineryAdapter;
    NewWorkingCapitalAdapter newWorkingCapitalAdapter;
    NewMeansOfFinancingAdapter newMeansOfFinancingAdapter;
    NewDetailsOfSalesAdapter newDetailsOfSalesAdapter;
    NewRawMaterialAdapter newRawaterialAdapter;
    NewSalaryDetailAdapter newSalaryDetailAdapter;
    NewWorkingCapitalEstimatesAdapter newWorkingCapitalEstimatesAdapter;
    NewWorkingPowerEstimatesAdapter newWorkingPowerEstimatesAdapter;

    NewWagesAdapter newWagesAdapter;
    List<BuildingItem> buildingList;
    List<MachineryItem> machineryList;
    List<DRPMasterData.WorkingCapitalDetail> workingCapitalList;
    List<DRPMasterData.MeansOfFinancing> meansOfFinanceList;
    List<DRPMasterData.DetailsOfSale> detailsOfSaleList;
    List<DRPMasterData.RawMaterial> rawMaterialList;
    List<DRPMasterData.WagesDetail> wagesDetailList;
    List<DRPMasterData.SalaryDetail> salaryDetailList;
    List<DRPMasterData.WorkingCapitalEstimate> workingCapitalEstimateList;
    List<DRPMasterData.PowerEstimateExpenditure> powerEstimateExpenditureList;


    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.layout_dpr_fragment, container, false);


        apiService = ApiClient.getClient().create(ApiServices.class);
        txtDprApplicationLayout = view.findViewById(R.id.txt_dpr_application_layout);
        txtBuildingLayout = view.findViewById(R.id.txt_building_Layout);
        txt_MACHINERY_layout = view.findViewById(R.id.txt_MACHINERY_layout);
        txt_working_capitallayout = view.findViewById(R.id.txt_working_capitallayout);
        txt_financing_details_Layout = view.findViewById(R.id.txt_financing_details_Layout);
        txt_salesDetails_layout = view.findViewById(R.id.txt_salesDetails_layout);
        txt_raw_material_Layout = view.findViewById(R.id.txt_raw_material_Layout);
        txt_wages_Layout = view.findViewById(R.id.txt_wages_Layout);
        txt_beneficiary_Layout = view.findViewById(R.id.txt_beneficiary_Layout);
        txt_introduction_Layout = view.findViewById(R.id.txt_introduction_Layout);
        txt_imp_agency_Layout = view.findViewById(R.id.txt_imp_agency_Layout);
        txt_promoter_details_Layout = view.findViewById(R.id.txt_promoter_details_Layout);
        txt_ofc_intro_Layout = view.findViewById(R.id.txt_ofc_intro_Layout);
        txt_depreciation_Layout = view.findViewById(R.id.txt_depreciation_Layout);
        txt_power_estimate_Layout = view.findViewById(R.id.txt_power_estimate_Layout);
        txt_working_capital_Layout = view.findViewById(R.id.txt_working_capital_Layout);
        txt_salary_details_Layout = view.findViewById(R.id.txt_salary_details_Layout);

        txtAddbuildingRow = view.findViewById(R.id.txt_add_row);
        txt_add_machinery_row = view.findViewById(R.id.txt_add_machinery_row);
        txt_add_sales_row = view.findViewById(R.id.txt_add_sales_row);
        txt_raw_material_row = view.findViewById(R.id.txt_raw_material_row);
        txt_wages_row = view.findViewById(R.id.txt_wages_row);
        txt_salary_row = view.findViewById(R.id.txt_salary_details_row);
        txt_power_req = view.findViewById(R.id.edp_training_insti_name);
        landTotal = view.findViewById(R.id.land_total);
        machinery_total = view.findViewById(R.id.machinery_total);
        salesTotal = view.findViewById(R.id.sales_total);
        rawTotal = view.findViewById(R.id.Raw_material_total);
        wagesTotal = view.findViewById(R.id.worker_total_amt);
        salartTotal = view.findViewById(R.id.amount_total);
        rate_of_interest_power = view.findViewById(R.id.rate_of_interest_power);
        workingCapitalTotal = view.findViewById(R.id.working_capital_total);
        into_ofc = view.findViewById(R.id.onBuilding);
        onmachinery = view.findViewById(R.id.onmachinery);
        payBackPeriod = view.findViewById(R.id.payBackPeriod);
        prj_impl_period = view.findViewById(R.id.prj_impl_period);
        intro_ofc = view.findViewById(R.id.intro_ofc);
        promoter_info = view.findViewById(R.id.promoter_info);
        introduction_txt = view.findViewById(R.id.intro);
        aboutBeneficiary = view.findViewById(R.id.beneficiary_details);

        activitySpinner = view.findViewById(R.id.activityspinner);
        btn_saveform = view.findViewById(R.id.btn_saveform);
        btn_updateform = view.findViewById(R.id.btn_updateform);
        rvProduct = view.findViewById(R.id.rv_product);
        rvLandEntry = view.findViewById(R.id.rv_land_entry);
        rvMachineryEntry = view.findViewById(R.id.rv_machinery_entry);
        rvWorkingCapital = view.findViewById(R.id.rv_working_capital);
        rvMeansOfFinancing = view.findViewById(R.id.rv_means_of_financing);
        rvSalesDetails = view.findViewById(R.id.rv_sales_details);
        rvRawMaterialEntry = view.findViewById(R.id.rv_raw_material_entry);
        rvWagesEntry = view.findViewById(R.id.rv_wages_entry);
        rvSalaryEntry = view.findViewById(R.id.rv_salary_details_entry);
        rv_capital_estimates_entry = view.findViewById(R.id.rv_capital_estimates_entry);
        rv_power_estimate_entry = view.findViewById(R.id.rv_power_estimates);

        rvProduct.setLayoutManager(new LinearLayoutManager(getContext()));
        rvLandEntry.setLayoutManager(new LinearLayoutManager(getContext()));
        rvMachineryEntry.setLayoutManager(new LinearLayoutManager(getContext()));
        rvWorkingCapital.setLayoutManager(new LinearLayoutManager(getContext()));
        rvMeansOfFinancing.setLayoutManager(new LinearLayoutManager(getContext()));
        rvSalesDetails.setLayoutManager(new LinearLayoutManager(getContext()));
        rvRawMaterialEntry.setLayoutManager(new LinearLayoutManager(getContext()));
        rvWagesEntry.setLayoutManager(new LinearLayoutManager(getContext()));
        rvSalaryEntry.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_capital_estimates_entry.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_power_estimate_entry.setLayoutManager(new LinearLayoutManager(getContext()));


        txtInputLayout = view.findViewById(R.id.txt_inputlayout);
        landEntry = view.findViewById(R.id.Land_entry);

        activitySpinner.setEnabled(false);


        cv_dpr = view.findViewById(R.id.cv_dpr);
        cv_building_details = view.findViewById(R.id.cv_building_details);
        cv_machinery_details = view.findViewById(R.id.cv_machinery_details);
        cv_working_capital = view.findViewById(R.id.cv_working_capital);
        cv_means_of_financing = view.findViewById(R.id.cv_means_of_financing);
        cv_sales_details = view.findViewById(R.id.cv_sales_details);
        cv_raw_material_details = view.findViewById(R.id.cv_raw_material_details);
        cv_wages_details = view.findViewById(R.id.cv_wages_details);
        cv_salary_details = view.findViewById(R.id.cv_salary_details);
        cv_workking_capital_details = view.findViewById(R.id.cv_workking_capital_details);
        cv_power_estimates = view.findViewById(R.id.cv_power_estimates);
        cv_depreciation = view.findViewById(R.id.cv_depreciation);
        cv_intro_ofc = view.findViewById(R.id.cv_intro_ofc);
        cv_promoter = view.findViewById(R.id.cv_promoter);
        cv_implementing_agency = view.findViewById(R.id.cv_implementing_agency);
        cv_intro = view.findViewById(R.id.cv_intro);
        cv_abt_beneficiary = view.findViewById(R.id.cv_abt_beneficiary);

        cv_dpr.setVisibility(View.GONE);
        cv_building_details.setVisibility(View.GONE);
        cv_machinery_details.setVisibility(View.GONE);
        cv_working_capital.setVisibility(View.GONE);
        cv_means_of_financing.setVisibility(View.GONE);
        cv_sales_details.setVisibility(View.GONE);
        cv_raw_material_details.setVisibility(View.GONE);
        cv_wages_details.setVisibility(View.GONE);
        cv_salary_details.setVisibility(View.GONE);
        cv_workking_capital_details.setVisibility(View.GONE);
        cv_power_estimates.setVisibility(View.GONE);
        cv_depreciation.setVisibility(View.GONE);
        cv_intro_ofc.setVisibility(View.GONE);
        cv_promoter.setVisibility(View.GONE);
        cv_implementing_agency.setVisibility(View.GONE);
        cv_intro.setVisibility(View.GONE);
        cv_abt_beneficiary.setVisibility(View.GONE);



        allCards = Arrays.asList(cv_dpr,cv_building_details,cv_machinery_details,cv_working_capital,cv_means_of_financing,cv_sales_details,cv_raw_material_details,cv_wages_details,cv_salary_details,cv_workking_capital_details,cv_power_estimates,cv_depreciation,cv_intro_ofc,cv_promoter,cv_implementing_agency,cv_intro,cv_abt_beneficiary);

        allTextViews = Arrays.asList(txtDprApplicationLayout, txtBuildingLayout, txtAddbuildingRow,txt_add_machinery_row,txt_wages_row,txt_salary_row,txt_raw_material_row,txt_add_sales_row, landTotal,machinery_total,workingCapitalTotal,salesTotal,wagesTotal,rawTotal,salartTotal,rate_of_interest_power);


        closeAllCards();


        txtDprApplicationLayout.setOnClickListener(v -> toggleSection(cv_dpr,txtDprApplicationLayout ));
        txtBuildingLayout.setOnClickListener(v -> toggleSection(cv_building_details,txtBuildingLayout ));
        txt_MACHINERY_layout.setOnClickListener(v -> toggleSection(cv_machinery_details,txt_MACHINERY_layout));
        txt_working_capitallayout.setOnClickListener(v -> toggleSection(cv_working_capital,txt_working_capitallayout));
        txt_financing_details_Layout.setOnClickListener(v -> toggleSection(cv_means_of_financing,txt_financing_details_Layout));
        txt_salesDetails_layout.setOnClickListener(v -> toggleSection(cv_sales_details,txt_salesDetails_layout ));
        txt_raw_material_Layout.setOnClickListener(v -> toggleSection(cv_raw_material_details,txt_raw_material_Layout));
        txt_wages_Layout.setOnClickListener(v -> toggleSection(cv_wages_details,txt_wages_Layout ));
        txt_salary_details_Layout.setOnClickListener(v -> toggleSection(cv_salary_details, txt_salary_details_Layout));
        txt_working_capital_Layout.setOnClickListener(v -> toggleSection(cv_workking_capital_details,txt_working_capital_Layout ));
        txt_power_estimate_Layout.setOnClickListener(v -> toggleSection(cv_power_estimates, txt_power_estimate_Layout));
        txt_depreciation_Layout.setOnClickListener(v -> toggleSection(cv_depreciation,txt_depreciation_Layout));
        txt_ofc_intro_Layout.setOnClickListener(v -> toggleSection(cv_intro_ofc, txt_ofc_intro_Layout));
        txt_promoter_details_Layout.setOnClickListener(v -> toggleSection(cv_promoter, txt_promoter_details_Layout));
        txt_imp_agency_Layout.setOnClickListener(v -> toggleSection(cv_implementing_agency,txt_imp_agency_Layout ));
        txt_introduction_Layout.setOnClickListener(v -> toggleSection(cv_intro,txt_introduction_Layout ));
        txt_beneficiary_Layout.setOnClickListener(v -> toggleSection(cv_abt_beneficiary,txt_beneficiary_Layout ));





        btn_saveform.setOnClickListener(v -> {

                dprSaveRequestData = new DprSaveRequestData();
                DRPMasterData.Data data = dprDrpMasterData.getData();
            DRPMasterData.DPRDetail detail;
            if (data.getDPRDetail() == null) {
                detail = new DRPMasterData.DPRDetail();
            } else {
                detail = data.getDPRDetail();
            }

                detail.setApplID(Integer.parseInt(AppConstant.getApplId()));
                detail.setApplCode(detail.getApplCode());
                detail.setOnBuilding(detail.getOnBuilding());
                detail.setOnMachinery(detail.getOnMachinery());
                detail.setLand(detail.getLand());
                detail.setPowerRequirement(detail.getPowerRequirement());
                detail.setRateOfInterest(detail.getRateOfInterest());
                detail.setIntroduction(detail.getIntroduction());
                detail.setAboutBeneficiary(detail.getAboutBeneficiary());
                detail.setCreatedOn(detail.getCreatedOn());
                detail.setModifyOn(detail.getModifyOn());
                detail.setPayBackPeriod(detail.getPayBackPeriod());
                detail.setProjectImplementationPeriod(detail.getProjectImplementationPeriod());
                detail.setIntroductionOffice(detail.getIntroductionOffice());
                detail.setAboutThePromoter(detail.getAboutThePromoter());
                dprSaveRequestData.setDPRDetail(detail);

                //Applicants
                DprSaveRequestData.Applicant applicant = new DprSaveRequestData.Applicant();
                applicant.setDPRVerified(true);


                List<DprSaveRequestData.Applicant> applicants = new ArrayList<>();
                applicants.add(applicant);
                dprSaveRequestData.setApplicant(applicants);

                //Building

                List<DRPMasterData.BuildingDetail> buildingDetails = new ArrayList<>();
                for(int i = 0; i < buildingDetails.size();i++){
                    DRPMasterData.BuildingDetail buildingDetail = buildingDetails.get(i);
                    buildingDetails.get(i).setApplID(buildingDetail.getApplID());
                    buildingDetails.get(i).setApplCode(buildingDetail.getApplCode());
                    buildingDetails.get(i).setParticulars(buildingDetail.getParticulars());
                    buildingDetails.get(i).setArea(buildingDetail.getArea());
                    buildingDetails.get(i).setRatePerSqFt(buildingDetail.getRatePerSqFt());
                    buildingDetails.get(i).setAmount(buildingDetail.getAmount());
                    buildingDetails.get(i).setCreatedOn(buildingDetail.getCreatedOn());
                    buildingDetails.get(i).setModifyOn(buildingDetail.getModifyOn());
                }
                dprSaveRequestData.setBuildingDetails(buildingDetails);

                //Machinery
                List<DRPMasterData.MachineryDetail> machineryDetails = new ArrayList<>();
                for(int i = 0; i < machineryDetails.size();i++){
                    DRPMasterData.MachineryDetail machineryDetail = machineryDetails.get(i);
                    machineryDetails.get(i).setApplID(machineryDetail.getApplID());
                    machineryDetails.get(i).setApplCode(machineryDetail.getApplCode());
                    machineryDetails.get(i).setParticulars(machineryDetail.getParticulars());
                    machineryDetails.get(i).setQuantity(machineryDetail.getQuantity());
                    machineryDetails.get(i).setRate(machineryDetail.getRate());
                    machineryDetails.get(i).setAmount(machineryDetail.getAmount());
                    machineryDetails.get(i).setCreatedOn(machineryDetail.getCreatedOn());
                    machineryDetails.get(i).setModifyOn(machineryDetail.getModifyOn());
                }
                dprSaveRequestData.setMachineryDetails(machineryDetails);


                //working capital detail
                List<DRPMasterData.WorkingCapitalDetail> workingCapitalDetails = new ArrayList<>();
                for(int i = 0; i < workingCapitalDetails.size();i++){
                    DRPMasterData.WorkingCapitalDetail workingCapitalDetail = workingCapitalDetails.get(i);
                    workingCapitalDetails.get(i).setApplID(workingCapitalDetail.getApplID());
                    workingCapitalDetails.get(i).setApplCode(workingCapitalDetail.getApplCode());
                    workingCapitalDetails.get(i).setParticulars(workingCapitalDetail.getParticulars());
                    workingCapitalDetails.get(i).setAmount(workingCapitalDetail.getAmount());
                    workingCapitalDetails.get(i).setCreatedOn(workingCapitalDetail.getCreatedOn());
                    workingCapitalDetails.get(i).setModifyOn(workingCapitalDetail.getModifyOn());
                }
                dprSaveRequestData.setWorkingCapitalDetails(workingCapitalDetails);

                //MeansOfFinancing
                List<DRPMasterData.MeansOfFinancing> meansOfFinancingList = new ArrayList<>();
                for(int i = 0; i < meansOfFinancingList.size();i++){
                    DRPMasterData.MeansOfFinancing meansOfFinancing = meansOfFinancingList.get(i);
                    meansOfFinancingList.get(i).setApplID(meansOfFinancing.getApplID());
                    meansOfFinancingList.get(i).setApplCode(meansOfFinancing.getApplCode());
                    meansOfFinancingList.get(i).setParticulars(meansOfFinancing.getParticulars());
                    meansOfFinancingList.get(i).setPercentage(meansOfFinancing.getPercentage());
                    meansOfFinancingList.get(i).setCreatedOn(meansOfFinancing.getCreatedOn());
                    meansOfFinancingList.get(i).setModifyOn(meansOfFinancing.getModifyOn());
                }
                dprSaveRequestData.setMeansOfFinancing(meansOfFinancingList);

           //DetailsOfSales
                List<DRPMasterData.DetailsOfSale> detailsOfSalesList = new ArrayList<>();
                for(int i = 0; i < detailsOfSalesList.size();i++){
                    DRPMasterData.DetailsOfSale detailsOfSales = detailsOfSalesList.get(i);
                    detailsOfSalesList.get(i).setApplID(detailsOfSales.getApplID());
                    detailsOfSalesList.get(i).setApplCode(detailsOfSales.getApplCode());
                    detailsOfSalesList.get(i).setParticulars(detailsOfSales.getParticulars());
                    detailsOfSalesList.get(i).setRatePerUnit(detailsOfSales.getRatePerUnit());
                    detailsOfSalesList.get(i).setQuantity(detailsOfSales.getQuantity());
                    detailsOfSalesList.get(i).setAmount(detailsOfSales.getAmount());
                    detailsOfSalesList.get(i).setCreatedOn(detailsOfSales.getCreatedOn());
                    detailsOfSalesList.get(i).setModifyOn(detailsOfSales.getModifyOn());
                }
                dprSaveRequestData.setDetailsOfSales(detailsOfSalesList);

                //RawMaterials
                List<DRPMasterData.RawMaterial> rawMaterialList1 = new ArrayList<>();
                for(int i = 0; i < detailsOfSalesList.size();i++){
                    DRPMasterData.RawMaterial rawMaterial = rawMaterialList1.get(i);
                    rawMaterialList1.get(i).setApplID(rawMaterial.getApplID());
                    rawMaterialList1.get(i).setApplCode(rawMaterial.getApplCode());
                    rawMaterialList1.get(i).setParticulars(rawMaterial.getParticulars());
                    rawMaterialList1.get(i).setRatePerUnit(rawMaterial.getRatePerUnit());
                    rawMaterialList1.get(i).setRequiredUnit(rawMaterial.getRequiredUnit());
                    rawMaterialList1.get(i).setAmount(rawMaterial.getAmount());
                    rawMaterialList1.get(i).setCreatedOn(rawMaterial.getCreatedOn());
                    rawMaterialList1.get(i).setModifyOn(rawMaterial.getModifyOn());
                }
                dprSaveRequestData.setRawMaterials(rawMaterialList1);

                //WagesDetails
                List<DRPMasterData.WagesDetail> wagesDetailList1 = new ArrayList<>();
                for(int i = 0; i < detailsOfSalesList.size();i++){
                    DRPMasterData.WagesDetail wagesDetail = wagesDetailList1.get(i);
                    wagesDetailList1.get(i).setApplID(wagesDetail.getApplID());
                    wagesDetailList1.get(i).setApplCode(wagesDetail.getApplCode());
                    wagesDetailList1.get(i).setParticulars(wagesDetail.getParticulars());
                    wagesDetailList1.get(i).setNoOfWorkers(wagesDetail.getNoOfWorkers());
                    wagesDetailList1.get(i).setWagesPerMonth(wagesDetail.getWagesPerMonth());
                    wagesDetailList1.get(i).setAmount(wagesDetail.getAmount());
                    wagesDetailList1.get(i).setCreatedOn(wagesDetail.getCreatedOn());
                    wagesDetailList1.get(i).setModifyOn(wagesDetail.getModifyOn());
                }
                dprSaveRequestData.setWagesDetails(wagesDetailList1);


               //SalaryDetails
                List<DRPMasterData.SalaryDetail> salaryDetailList1 = new ArrayList<>();
                for(int i = 0; i < salaryDetailList1.size();i++){
                    DRPMasterData.SalaryDetail salaryDetail = salaryDetailList1.get(i);
                    salaryDetailList1.get(i).setApplID(salaryDetail.getApplID());
                    salaryDetailList1.get(i).setApplCode(salaryDetail.getApplCode());
                    salaryDetailList1.get(i).setParticulars(salaryDetail.getParticulars());
                    salaryDetailList1.get(i).setNoOfStaff(salaryDetail.getNoOfStaff());
                    salaryDetailList1.get(i).setWagesPerMonth(salaryDetail.getWagesPerMonth());
                    salaryDetailList1.get(i).setAmount(salaryDetail.getAmount());
                    salaryDetailList1.get(i).setCreatedOn(salaryDetail.getCreatedOn());
                    salaryDetailList1.get(i).setModifyOn(salaryDetail.getModifyOn());
                }
                dprSaveRequestData.setSalaryDetails(salaryDetailList1);

                //WorkingCapitalEstimate
                List<DRPMasterData.WorkingCapitalEstimate> workingCapitalEstimateList1 = new ArrayList<>();
                for(int i = 0; i < salaryDetailList1.size();i++){
                    DRPMasterData.WorkingCapitalEstimate workingCapitalEstimate = workingCapitalEstimateList1.get(i);
                    workingCapitalEstimateList1.get(i).setApplID(workingCapitalEstimate.getApplID());
                    workingCapitalEstimateList1.get(i).setApplCode(workingCapitalEstimate.getApplCode());
                    workingCapitalEstimateList1.get(i).setParticulars(workingCapitalEstimate.getParticulars());
                    workingCapitalEstimateList1.get(i).setNoOfDays(workingCapitalEstimate.getNoOfDays());
                    workingCapitalEstimateList1.get(i).setCreatedOn(workingCapitalEstimate.getCreatedOn());
                    workingCapitalEstimateList1.get(i).setModifyOn(workingCapitalEstimate.getModifyOn());
                }
                dprSaveRequestData.setWorkingCapitalEstimate(workingCapitalEstimateList1);


                //PowerEstimateExpenditure
                List<DRPMasterData.PowerEstimateExpenditure> powerEstimateExpenditures = new ArrayList<>();
                for(int i = 0; i < powerEstimateExpenditures.size();i++){
                    DRPMasterData.PowerEstimateExpenditure powerEstimateExpenditure = powerEstimateExpenditures.get(i);
                    powerEstimateExpenditures.get(i).setApplID(powerEstimateExpenditure.getApplID());
                    powerEstimateExpenditures.get(i).setApplCode(powerEstimateExpenditure.getApplCode());
                    powerEstimateExpenditures.get(i).setParticulars(powerEstimateExpenditure.getParticulars());
                    powerEstimateExpenditures.get(i).setCost(powerEstimateExpenditure.getCost());
                    powerEstimateExpenditures.get(i).setAmountInRs(powerEstimateExpenditure.getAmountInRs());
                    powerEstimateExpenditures.get(i).setCreatedOn(powerEstimateExpenditure.getCreatedOn());
                    powerEstimateExpenditures.get(i).setModifyOn(powerEstimateExpenditure.getModifyOn());
                }
                dprSaveRequestData.setPowerEstimateExpenditure(powerEstimateExpenditures);





                Log.d("SAVE_REQUEST", new Gson().toJson(dprSaveRequestData));

                SaveApplicationForm(dprSaveRequestData);  // correct object

        });
        btn_updateform.setOnClickListener(v -> {
                prepareAndUpdateApplication();
        });
        initData();
        return view;
    }


    private void updateApplicationForm(DPRUpdateRequest dprDrpMasterData) {
        Log.d("TAG", "updateApplicationForm: "+dprDrpMasterData);
        apiService.updateDprData(dprDrpMasterData).enqueue(new Callback<DprResult>() {
            @Override
            public void onResponse(Call<DprResult> call, Response<DprResult> response) {
                if (response.isSuccessful() && response.body() != null) {
                    DprResult status = response.body();

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
            public void onFailure(Call<DprResult> call, Throwable t) {
                Toast.makeText(getContext(), "Error1: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void SaveApplicationForm(DprSaveRequestData dprDrpMasterData) {
        apiService.saveDprData(dprDrpMasterData).enqueue(new Callback<DprResult>() {
            @Override
            public void onResponse(Call<DprResult> call, Response<DprResult> response) {
                if (response.isSuccessful() && response.body() != null) {
                    DprResult status = response.body();

                    Log.d("API_RESPONSE22", new Gson().toJson(status));

                    if (status.isSuccess()) {

                        btn_updateform.setVisibility(View.VISIBLE);
                        btn_saveform.setVisibility(View.GONE);
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
            public void onFailure(Call<DprResult> call, Throwable t) {
                Toast.makeText(getContext(), "Error1: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }


    private void prepareAndUpdateApplication(){

        DPRUpdateRequest dprUpdateRequest = new DPRUpdateRequest();

        DRPMasterData.Data data = dprDrpMasterData.getData();
        DRPMasterData.DPRDetail dprDetail=data.getDPRDetail();
        dprDetail.setApplID(dprDetail.getApplID());
        dprDetail.setApplCode(dprDetail.getApplCode());
        dprDetail.setOnBuilding(into_ofc.getText().toString());
        dprDetail.setOnMachinery(onmachinery.getText().toString());
        dprDetail.setLand(landEntry.getText().toString());
        dprDetail.setPowerRequirement(txt_power_req.getText().toString());
        dprDetail.setRateOfInterest(rate_of_interest_power.getText().toString());
        dprDetail.setIntroduction(introduction_txt.getText().toString().trim());
        dprDetail.setAboutBeneficiary(aboutBeneficiary.getText().toString().trim());
        dprDetail.setCreatedOn(dprDetail.getCreatedOn());
        dprDetail.setModifyOn(dprDetailData.getModifyOn());
        dprDetail.setPayBackPeriod(payBackPeriod.getText().toString().trim());
        dprDetail.setProjectImplementationPeriod(prj_impl_period.getText().toString().trim());
        dprDetail.setIntroductionOffice(intro_ofc.getText().toString().trim());
        dprDetail.setAboutThePromoter(promoter_info.getText().toString().trim());
        dprUpdateRequest.setDprDetail(dprDetail);

        ApplicantDPROnly applicant = new ApplicantDPROnly(1);
        dprUpdateRequest.setApplicant(applicant);

        List<DRPMasterData.BuildingDetail> buildingDetails = newBuildingAdapter.getUpdatedList();
        for(int i = 0; i < buildingDetails.size();i++){
            DRPMasterData.BuildingDetail buildingDetail = buildingDetails.get(i);
            buildingDetails.get(i).setApplID(buildingDetail.getApplID());
            buildingDetails.get(i).setApplCode(buildingDetail.getApplCode());
            buildingDetails.get(i).setParticulars(buildingDetail.getParticulars());
            buildingDetails.get(i).setArea(buildingDetail.getArea());
            buildingDetails.get(i).setRatePerSqFt(buildingDetail.getRatePerSqFt());
            buildingDetails.get(i).setAmount(buildingDetail.getAmount());
            buildingDetails.get(i).setCreatedOn(buildingDetail.getCreatedOn());
            buildingDetails.get(i).setModifyOn(buildingDetail.getModifyOn());
        }
        dprUpdateRequest.setBuildingDetails(buildingDetails);

        List<DRPMasterData.MachineryDetail> machineryDetails = newMachineryAdapter.getUpdatedList();
        for(int i = 0; i < machineryDetails.size();i++){
            DRPMasterData.MachineryDetail machineryDetail = machineryDetails.get(i);
            machineryDetails.get(i).setApplID(machineryDetail.getApplID());
            machineryDetails.get(i).setApplCode(machineryDetail.getApplCode());
            machineryDetails.get(i).setParticulars(machineryDetail.getParticulars());
            machineryDetails.get(i).setQuantity(machineryDetail.getQuantity());
            machineryDetails.get(i).setRate(machineryDetail.getRate());
            machineryDetails.get(i).setAmount(machineryDetail.getAmount());
            machineryDetails.get(i).setCreatedOn(machineryDetail.getCreatedOn());
            machineryDetails.get(i).setModifyOn(machineryDetail.getModifyOn());
        }
        dprUpdateRequest.setMachineryDetails(machineryDetails);

        List<DRPMasterData.WorkingCapitalDetail> workingCapitalDetails = newWorkingCapitalAdapter.getUpdatedList();
        for(int i = 0; i < workingCapitalDetails.size();i++){
            DRPMasterData.WorkingCapitalDetail workingCapitalDetail = workingCapitalDetails.get(i);
            workingCapitalDetails.get(i).setApplID(workingCapitalDetail.getApplID());
            workingCapitalDetails.get(i).setApplCode(workingCapitalDetail.getApplCode());
            workingCapitalDetails.get(i).setParticulars(workingCapitalDetail.getParticulars());
            workingCapitalDetails.get(i).setAmount(workingCapitalDetail.getAmount());
            workingCapitalDetails.get(i).setCreatedOn(workingCapitalDetail.getCreatedOn());
            workingCapitalDetails.get(i).setModifyOn(workingCapitalDetail.getModifyOn());
        }
        dprUpdateRequest.setWorkingCapitalDetails(workingCapitalDetails);


        List<DRPMasterData.MeansOfFinancing> meansOfFinancings = newMeansOfFinancingAdapter.getUpdatedList();
        for(int i = 0; i < meansOfFinancings.size();i++){
            DRPMasterData.MeansOfFinancing meansOfFinancing = meansOfFinancings.get(i);
            meansOfFinancings.get(i).setApplID(meansOfFinancing.getApplID());
            meansOfFinancings.get(i).setApplCode(meansOfFinancing.getApplCode());
            meansOfFinancings.get(i).setParticulars(meansOfFinancing.getParticulars());
            meansOfFinancings.get(i).setPercentage(meansOfFinancing.getPercentage());
            meansOfFinancings.get(i).setCreatedOn(meansOfFinancing.getCreatedOn());
            meansOfFinancings.get(i).setModifyOn(meansOfFinancing.getModifyOn());
        }
        dprUpdateRequest.setMeansOfFinancing(meansOfFinancings);


        List<DRPMasterData.DetailsOfSale> detailsOfSales = newDetailsOfSalesAdapter.getUpdatedList();
        for(int i = 0; i < detailsOfSales.size();i++){
            DRPMasterData.DetailsOfSale detailsOfSale = detailsOfSales.get(i);
            detailsOfSales.get(i).setApplID(detailsOfSale.getApplID());
            detailsOfSales.get(i).setApplCode(detailsOfSale.getApplCode());
            detailsOfSales.get(i).setParticulars(detailsOfSale.getParticulars());
            detailsOfSales.get(i).setRatePerUnit(detailsOfSale.getRatePerUnit());
            detailsOfSales.get(i).setQuantity(detailsOfSale.getQuantity());
            detailsOfSales.get(i).setAmount(detailsOfSale.getAmount());
            detailsOfSales.get(i).setCreatedOn(detailsOfSale.getCreatedOn());
            detailsOfSales.get(i).setModifyOn(detailsOfSale.getModifyOn());
        }
        dprUpdateRequest.setDetailsOfSales(detailsOfSales);

        List<DRPMasterData.RawMaterial> rawMaterials = newRawaterialAdapter.getUpdatedList();
        for(int i = 0; i < rawMaterials.size();i++){
            DRPMasterData.RawMaterial rawMaterial = rawMaterials.get(i);
            rawMaterials.get(i).setApplID(rawMaterial.getApplID());
            rawMaterials.get(i).setApplCode(rawMaterial.getApplCode());
            rawMaterials.get(i).setParticulars(rawMaterial.getParticulars());
            rawMaterials.get(i).setUnit(rawMaterial.getUnit());
            rawMaterials.get(i).setRatePerUnit(rawMaterial.getRatePerUnit());
            rawMaterials.get(i).setRequiredUnit(rawMaterial.getRequiredUnit());
            rawMaterials.get(i).setAmount(rawMaterial.getAmount());
            rawMaterials.get(i).setCreatedOn(rawMaterial.getCreatedOn());
            rawMaterials.get(i).setModifyOn(rawMaterial.getModifyOn());
        }
        dprUpdateRequest.setRawMaterials(rawMaterials);

        List<DRPMasterData.WagesDetail> wagesDetails = newWagesAdapter.getUpdatedList();
        for(int i = 0; i < wagesDetails.size();i++){
            DRPMasterData.WagesDetail wagesDetail = wagesDetails.get(i);
            wagesDetails.get(i).setApplID(wagesDetail.getApplID());
            wagesDetails.get(i).setApplCode(wagesDetail.getApplCode());
            wagesDetails.get(i).setParticulars(wagesDetail.getParticulars());
            wagesDetails.get(i).setNoOfWorkers(wagesDetail.getNoOfWorkers());
            wagesDetails.get(i).setWagesPerMonth(wagesDetail.getWagesPerMonth());
            wagesDetails.get(i).setAmount(wagesDetail.getAmount());
            wagesDetails.get(i).setCreatedOn(wagesDetail.getCreatedOn());
            wagesDetails.get(i).setModifyOn(wagesDetail.getModifyOn());
        }
        dprUpdateRequest.setWagesDetails(wagesDetails);


        List<DRPMasterData.SalaryDetail> salaryDetails = newSalaryDetailAdapter.getUpdatedList();
        for(int i = 0; i < salaryDetails.size();i++){
            DRPMasterData.SalaryDetail salaryDetail = salaryDetails.get(i);
            salaryDetails.get(i).setApplID(salaryDetail.getApplID());
            salaryDetails.get(i).setApplCode(salaryDetail.getApplCode());
            salaryDetails.get(i).setParticulars(salaryDetail.getParticulars());
            salaryDetails.get(i).setNoOfStaff(salaryDetail.getNoOfStaff());
            salaryDetails.get(i).setWagesPerMonth(salaryDetail.getWagesPerMonth());
            salaryDetails.get(i).setAmount(salaryDetail.getAmount());
            salaryDetails.get(i).setCreatedOn(salaryDetail.getCreatedOn());
            salaryDetails.get(i).setModifyOn(salaryDetail.getModifyOn());
        }
        dprUpdateRequest.setSalaryDetails(salaryDetails);

        List<DRPMasterData.WorkingCapitalEstimate> workingCapitalEstimates = newWorkingCapitalEstimatesAdapter.getUpdatedList();
        for(int i = 0; i < workingCapitalEstimates.size();i++){
            DRPMasterData.WorkingCapitalEstimate workingCapitalEstimate = workingCapitalEstimates.get(i);
            workingCapitalEstimates.get(i).setApplID(workingCapitalEstimate.getApplID());
            workingCapitalEstimates.get(i).setApplCode(workingCapitalEstimate.getApplCode());
            workingCapitalEstimates.get(i).setParticulars(workingCapitalEstimate.getParticulars());
            workingCapitalEstimates.get(i).setNoOfDays(workingCapitalEstimate.getNoOfDays());
            workingCapitalEstimates.get(i).setCreatedOn(workingCapitalEstimate.getCreatedOn());
            workingCapitalEstimates.get(i).setModifyOn(workingCapitalEstimate.getModifyOn());
        }
        dprUpdateRequest.setWorkingCapitalEstimate(workingCapitalEstimates);

        List<DRPMasterData.PowerEstimateExpenditure> powerEstimateExpenditures = newWorkingPowerEstimatesAdapter.getUpdatedList();
        for(int i = 0; i < powerEstimateExpenditures.size();i++){
            DRPMasterData.PowerEstimateExpenditure powerEstimateExpenditure = powerEstimateExpenditures.get(i);
            powerEstimateExpenditures.get(i).setApplID(powerEstimateExpenditure.getApplID());
            powerEstimateExpenditures.get(i).setApplCode(powerEstimateExpenditure.getApplCode());
            powerEstimateExpenditures.get(i).setParticulars(powerEstimateExpenditure.getParticulars());
            powerEstimateExpenditures.get(i).setCost(powerEstimateExpenditure.getCost());
            powerEstimateExpenditures.get(i).setAmountInRs(powerEstimateExpenditure.getAmountInRs());
            powerEstimateExpenditures.get(i).setCreatedOn(powerEstimateExpenditure.getCreatedOn());
            powerEstimateExpenditures.get(i).setModifyOn(powerEstimateExpenditure.getModifyOn());
        }
        dprUpdateRequest.setPowerEstimateExpenditure(powerEstimateExpenditures);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Log.d("FINAL_UPDATE_REQUEST", gson.toJson(dprUpdateRequest));


        updateApplicationForm(dprUpdateRequest);
    }


    private <T extends BaseDprItem> void applyCommonFields(List<T> list, int applId, String applCode, String createdOn) {
        if (list != null) {
            for (T item : list) {
                item.setApplID(applId);
                item.setApplCode(applCode);
                item.setCreatedOn(createdOn);
                item.setModifyOn(null);
            }
        }
    }



    private void initData() {

        fetchUnitTypeData();

        //Building entry
      buildingList = new ArrayList<>();
         newBuildingAdapter = new NewBuildingAdapter(buildingList,total -> {
             landTotal.setText(String.valueOf(total));
         });
        rvLandEntry.setAdapter(newBuildingAdapter);

        txtAddbuildingRow.setOnClickListener(v -> {
            BuildingItem newItem = new BuildingItem("", "", "", "");
            newBuildingAdapter.addRow(newItem);

        });

        //Machinery Entry
          machineryList = new ArrayList<>();
        newMachineryAdapter = new NewMachineryAdapter(machineryList,total -> {
            machinery_total.setText(String.valueOf(total));
        });
        rvMachineryEntry.setAdapter(newMachineryAdapter);

        txt_add_machinery_row.setOnClickListener(v -> {
            MachineryItem newItem = new MachineryItem("", "", "", "");
            newMachineryAdapter.addRow(newItem);
            rvMachineryEntry.smoothScrollToPosition(newMachineryAdapter.getItemCount() - 1);
        });

        //Working Capital entry
        workingCapitalList = new ArrayList<>();
        newWorkingCapitalAdapter = new NewWorkingCapitalAdapter(workingCapitalList, total -> {
            workingCapitalTotal.setText(String.format("%.2f", total)
            );
        });

        rvWorkingCapital.setAdapter(newWorkingCapitalAdapter);

        //means of financing entry
        meansOfFinanceList = new ArrayList<>();
        newMeansOfFinancingAdapter = new NewMeansOfFinancingAdapter(meansOfFinanceList);


        rvMeansOfFinancing.setAdapter(newMeansOfFinancingAdapter);

        //details of sales entry
        detailsOfSaleList = new ArrayList<>();
        newDetailsOfSalesAdapter = new NewDetailsOfSalesAdapter(detailsOfSaleList, total -> {
            salesTotal.setText(String.format("%.2f", total)); // Always show two decimals
        });
        rvSalesDetails.setAdapter(newDetailsOfSalesAdapter);
        rvSalesDetails.setLayoutManager(new LinearLayoutManager(getContext()));

        txt_add_sales_row.setOnClickListener(v -> {
            DRPMasterData.DetailsOfSale newItem =
                    new DRPMasterData.DetailsOfSale("", 0, 0, 0);
            newDetailsOfSalesAdapter.addRow(newItem);
        });

        //details of raw entry
        rawMaterialList = new ArrayList<>();
        newRawaterialAdapter = new NewRawMaterialAdapter(rawMaterialList, total -> {
            rawTotal.setText(String.format("%.2f", total)); // Always show two decimals
        });
        rvRawMaterialEntry.setAdapter(newRawaterialAdapter);
        rvRawMaterialEntry.setLayoutManager(new LinearLayoutManager(getContext()));

        txt_raw_material_row.setOnClickListener(v -> {
            DRPMasterData.RawMaterial newItem =
                    new DRPMasterData.RawMaterial("", 0, 0, 0,0);
            newRawaterialAdapter.addRow(newItem);
        });
        //details of wages entry
        wagesDetailList = new ArrayList<>();
        newWagesAdapter = new NewWagesAdapter(wagesDetailList, total -> {
            wagesTotal.setText(String.format("%.2f", total)); // Always show two decimals
        });
        rvWagesEntry.setAdapter(newWagesAdapter);
        rvWagesEntry.setLayoutManager(new LinearLayoutManager(getContext()));

        txt_wages_row.setOnClickListener(v -> {
            DRPMasterData.WagesDetail newItem =
                    new DRPMasterData.WagesDetail("", 0, 0, 0);
            newWagesAdapter.addRow(newItem);
        });

        //details of salary entry
        salaryDetailList = new ArrayList<>();
        newSalaryDetailAdapter = new NewSalaryDetailAdapter(salaryDetailList, total -> {
            salartTotal.setText(String.format("%.2f", total)); // Always show two decimals
        });
        rvSalaryEntry.setAdapter(newSalaryDetailAdapter);
        rvSalaryEntry.setLayoutManager(new LinearLayoutManager(getContext()));

        txt_salary_row.setOnClickListener(v -> {
            DRPMasterData.SalaryDetail newItem =
                    new DRPMasterData.SalaryDetail("", 0, 0, 0);
            newSalaryDetailAdapter.addRow(newItem);
        });

        //details of cap estimate entry
        workingCapitalEstimateList = new ArrayList<>();
        newWorkingCapitalEstimatesAdapter = new NewWorkingCapitalEstimatesAdapter(workingCapitalEstimateList, total -> {
            salartTotal.setText(String.format("%.2f", total)); // Always show two decimals
        });
        rv_capital_estimates_entry.setAdapter(newWorkingCapitalEstimatesAdapter);
        rv_capital_estimates_entry.setLayoutManager(new LinearLayoutManager(getContext()));

        //details of power estimate entry
        powerEstimateExpenditureList = new ArrayList<>();
        newWorkingPowerEstimatesAdapter = new NewWorkingPowerEstimatesAdapter(powerEstimateExpenditureList, total -> {
            salartTotal.setText(String.format("%.2f", total)); // Always show two decimals
        });
        rv_power_estimate_entry.setAdapter(newWorkingPowerEstimatesAdapter);
        rv_power_estimate_entry.setLayoutManager(new LinearLayoutManager(getContext()));



    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        apiService = ApiClient.getClient().create(ApiServices.class);

        String applIdStr = AppConstant.getApplId();


        int applicationId = Integer.parseInt(applIdStr);

        System.out.println("applicationId"+applicationId);
        getDPRData(applicationId);
        getSavedDPRMasterData(applicationId);
    }



    private void getSavedDPRMasterData(int applicationId) {
        ApplicantRequest request = new ApplicantRequest(applicationId);


        apiService.getSavedDPRMasterData(request).enqueue(new Callback<DRPMasterData>() {
            @Override
            public void onResponse(Call<DRPMasterData> call, retrofit2.Response<DRPMasterData> response) {
                if (response.isSuccessful() && response.body() != null) {
                    DRPMasterData data = response.body();
                    Log.d("DRP_master_API_RESPONSE", new Gson().toJson(data));
                    dprDrpMasterData = data;
                    setMasterDataToUI(data);
                }
            }

            @Override
            public void onFailure(Call<DRPMasterData> call, Throwable t) {

                t.printStackTrace();
            }
        });
    }

    private void setMasterDataToUI(DRPMasterData data) {
        if (data == null) return;
        if (data.getData().getBuildingDetails() != null && !data.getData().getBuildingDetails().isEmpty()) {
            buildingList.clear();
            for (DRPMasterData.BuildingDetail building : data.getData().getBuildingDetails()) {
                BuildingItem item = new BuildingItem(
                        building.getParticulars() != null ? building.getParticulars() : "",
                        String.valueOf(building.getArea()),
                        String.valueOf(building.getRatePerSqFt()),
                        String.valueOf(building.getAmount())
                );
                buildingList.add(item);
            }
            newBuildingAdapter.notifyDataSetChanged();
            newBuildingAdapter.calculateTotal();
        }

        if (data.getData().getMachineryDetails() != null && !data.getData().getMachineryDetails().isEmpty()) {
            machineryList.clear();
            for (DRPMasterData.MachineryDetail machinery : data.getData().getMachineryDetails()) {
                MachineryItem item = new MachineryItem(
                        machinery.getParticulars() != null ? machinery.getParticulars() : "",
                        String.valueOf(machinery.getRate()),
                        "",
                        String.valueOf(machinery.getAmount())
                );
                machineryList.add(item);
            }
            newMachineryAdapter.notifyDataSetChanged();
            newMachineryAdapter.calculateTotal();
        }
        if (data.getData().getWorkingCapitalDetails() != null && !data.getData().getWorkingCapitalDetails().isEmpty()) {
            workingCapitalList.clear();
            for (DRPMasterData.WorkingCapitalDetail workingCapitalDetail : data.getData().getWorkingCapitalDetails()) {
                DRPMasterData.WorkingCapitalDetail item = new DRPMasterData.WorkingCapitalDetail(
                        workingCapitalDetail.getParticulars() != null ? workingCapitalDetail.getParticulars() : "",
                        Double.valueOf(workingCapitalDetail.getAmount())

                );
                workingCapitalList.add(item);
            }
            newWorkingCapitalAdapter.notifyDataSetChanged();
        }

        if (data.getData().getMeansOfFinancing() != null && !data.getData().getMeansOfFinancing().isEmpty()) {
            meansOfFinanceList.clear();
            for (DRPMasterData.MeansOfFinancing meansOfFinancing : data.getData().getMeansOfFinancing()) {
                DRPMasterData.MeansOfFinancing item = new DRPMasterData.MeansOfFinancing(
                        meansOfFinancing.getParticulars() != null ? meansOfFinancing.getParticulars() : "",
                        Double.valueOf(meansOfFinancing.getPercentage())

                );
                meansOfFinanceList.add(item);
            }
            newMeansOfFinancingAdapter.notifyDataSetChanged();
        }

        if (data.getData().getDetailsOfSales() != null && !data.getData().getDetailsOfSales().isEmpty()) {
            detailsOfSaleList.clear();
            for (DRPMasterData.DetailsOfSale machinery : data.getData().getDetailsOfSales()) {
                DRPMasterData.DetailsOfSale item = new DRPMasterData.DetailsOfSale(
                        machinery.getParticulars() != null ? machinery.getParticulars() : "",
                        machinery.getQuantity(),
                        machinery.getRatePerUnit(),
                        Double.valueOf(machinery.getAmount())
                );
                detailsOfSaleList.add(item);
            }
            newDetailsOfSalesAdapter.notifyDataSetChanged();
            newDetailsOfSalesAdapter.calculateTotal();
        }

        if (data.getData().getRawMaterials() != null && !data.getData().getRawMaterials().isEmpty()){
            rawMaterialList.clear();
            for (DRPMasterData.RawMaterial material : data.getData().getRawMaterials()) {
                DRPMasterData.RawMaterial item = new DRPMasterData.RawMaterial(
                        material.getParticulars() != null ? material.getParticulars() : "",
                        material.getUnit(),
                        material.getRatePerUnit(),
                        material.getAmount(),
                        material.getRequiredUnit()
                );
                rawMaterialList.add(item);
            }
            newRawaterialAdapter.notifyDataSetChanged();
            newRawaterialAdapter.calculateTotal();

        }

        if (data.getData().getWagesDetails() != null && !data.getData().getWagesDetails().isEmpty()){
            wagesDetailList.clear();
            for (DRPMasterData.WagesDetail material : data.getData().getWagesDetails()) {
                DRPMasterData.WagesDetail item = new DRPMasterData.WagesDetail(
                        material.getParticulars() != null ? material.getParticulars() : "",
                        material.getNoOfWorkers(),
                        material.getWagesPerMonth(),
                        material.getAmount()
                );
                wagesDetailList.add(item);
            }
            newWagesAdapter.notifyDataSetChanged();
            newWagesAdapter.calculateTotal();

        }
        if (data.getData().getSalaryDetails() != null && !data.getData().getSalaryDetails().isEmpty()){
            salaryDetailList.clear();
            for (DRPMasterData.SalaryDetail material : data.getData().getSalaryDetails()) {
                DRPMasterData.SalaryDetail item = new DRPMasterData.SalaryDetail(
                        material.getParticulars() != null ? material.getParticulars() : "",
                        material.getNoOfStaff(),
                        material.getWagesPerMonth(),
                        material.getAmount()
                );
                salaryDetailList.add(item);
            }
            newSalaryDetailAdapter.notifyDataSetChanged();
            newSalaryDetailAdapter.calculateTotal();

        }

        if (data.getData().getWorkingCapitalEstimate() != null && !data.getData().getWorkingCapitalEstimate().isEmpty()){
            workingCapitalEstimateList.clear();
            for (DRPMasterData.WorkingCapitalEstimate material : data.getData().getWorkingCapitalEstimate()) {
                DRPMasterData.WorkingCapitalEstimate item = new DRPMasterData.WorkingCapitalEstimate(
                        material.getParticulars() != null ? material.getParticulars() : "",
                        material.getNoOfDays()
                );
                workingCapitalEstimateList.add(item);
            }
            newWorkingCapitalEstimatesAdapter.notifyDataSetChanged();

        }
        String powerReq = null;
        if (data != null
                && data.getData() != null
                && data.getData().getDPRDetail() != null) {
            powerReq = data.getData().getDPRDetail().getPowerRequirement();
        }
        txt_power_req.setText(powerReq != null ? powerReq : "");
        String roi = null;
        if (data != null
                && data.getData() != null
                && data.getData().getDPRDetail() != null
                && data.getData().getDPRDetail().getRateOfInterest() != null) {
            roi = data.getData().getDPRDetail().getRateOfInterest().toString();
        }

        rate_of_interest_power.setText(roi != null ? roi : "");

        if (data.getData().getPowerEstimateExpenditure() != null && !data.getData().getPowerEstimateExpenditure().isEmpty()){
            powerEstimateExpenditureList.clear();
            for (DRPMasterData.PowerEstimateExpenditure material : data.getData().getPowerEstimateExpenditure()) {
                DRPMasterData.PowerEstimateExpenditure item = new DRPMasterData.PowerEstimateExpenditure(
                        material.getParticulars() != null ? material.getParticulars() : "",
                        material.getCost(),
                        material.getAmountInRs()
                );
                powerEstimateExpenditureList.add(item);
            }
            newWorkingPowerEstimatesAdapter.notifyDataSetChanged();


            into_ofc.setText(data.getData().getDPRDetail().getOnBuilding());
            onmachinery.setText(data.getData().getDPRDetail().getOnMachinery());
            payBackPeriod.setText(data.getData().getDPRDetail().getPayBackPeriod());
            prj_impl_period.setText(data.getData().getDPRDetail().getProjectImplementationPeriod());
            intro_ofc.setText(data.getData().getDPRDetail().getIntroductionOffice());
            promoter_info.setText(data.getData().getDPRDetail().getAboutThePromoter());


            introduction_txt.setText(data.getData().getDPRDetail().getIntroduction());
            aboutBeneficiary.setText(data.getData().getDPRDetail().getAboutBeneficiary());

        }

    }

    private void getDPRData(int applicationId) {

        ApplicantRequest request = new ApplicantRequest(applicationId);
        progressDialog = new ProgressDialog(getContext());
        progressDialog.setMessage("Please wait, Loading DPR Data...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        apiService.getDprData(request).enqueue(new retrofit2.Callback<DPRResponse>() {
            @Override
            public void onResponse(Call<DPRResponse> call, retrofit2.Response<DPRResponse> response) {
                progressDialog.dismiss();
                if (response.isSuccessful() && response.body() != null) {
                    DPRDetailData data = response.body().getData();
                    Log.d("DRP_API_RESPONSE", new Gson().toJson(data));
                    dprDetailData = data;
                    setDataToUI(data);
                }
            }

            @Override
            public void onFailure(Call<DPRResponse> call, Throwable t) {
                progressDialog.dismiss();
                t.printStackTrace();
            }
        });
    }

    private void setDataToUI(DPRDetailData data) {


        if (data != null && data.getUnitActivityName() != null) {
            setSpinnerSelection(activitySpinner, data.getUnitActivityName());
        } else {
            Log.e("TAG", "Data or UnitActivityName is null");
        }         List<DPRDetailData> dataList = new ArrayList<>();
         dataList.add(data);
        productAdapter = new ProductAdapter(dataList);
        rvProduct.setAdapter(productAdapter);
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

    private void fetchUnitTypeData() {
        apiService.getUnitType().enqueue(new Callback<List<UnitTypeModel>>() {
            @Override
            public void onResponse(Call<List<UnitTypeModel>> call, Response<List<UnitTypeModel>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<UnitTypeModel> unittypeList = response.body();
                    System.out.println("agencyList" +unittypeList.size());

                    List<String> unitNameList = new ArrayList<>();

                    for (UnitTypeModel unitTypeModel : unittypeList) {
                        unitNameList.add(unitTypeModel.getSchemeName());


                    }

                    ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), R.layout.spinner_selected_item, unitNameList);
                    adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
                    activitySpinner.setAdapter(adapter);

                    activitySpinner.setOnItemSelectedListener(new android.widget.AdapterView.OnItemSelectedListener() {
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
