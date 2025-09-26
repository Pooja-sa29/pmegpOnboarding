package com.trust.pmegpcustomeronboardingapp.activity.fragment;

import static android.content.Intent.getIntent;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.Gson;
import com.trust.pmegpcustomeronboardingapp.R;
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
import com.trust.pmegpcustomeronboardingapp.activity.model.ApplicantDetailData;
import com.trust.pmegpcustomeronboardingapp.activity.model.ApplicantRequest;
import com.trust.pmegpcustomeronboardingapp.activity.model.ApplicationResponse;
import com.trust.pmegpcustomeronboardingapp.activity.model.BuildingItem;
import com.trust.pmegpcustomeronboardingapp.activity.model.DPRDetailData;
import com.trust.pmegpcustomeronboardingapp.activity.model.DPRResponse;
import com.trust.pmegpcustomeronboardingapp.activity.model.DRPMasterData;
import com.trust.pmegpcustomeronboardingapp.activity.model.MachineryItem;
import com.trust.pmegpcustomeronboardingapp.activity.model.NICGroupModel;
import com.trust.pmegpcustomeronboardingapp.activity.model.UnitTypeModel;
import com.trust.pmegpcustomeronboardingapp.activity.retrofitClient.ApiClient;
import com.trust.pmegpcustomeronboardingapp.activity.screens.NewApplicantUnitActivity;
import com.trust.pmegpcustomeronboardingapp.activity.services.ApiServices;
import com.trust.pmegpcustomeronboardingapp.activity.utils.AppConstant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DPRFragment extends BaseFormFragment {
    private ApiServices apiService;
    private ProgressDialog progressDialog;
    private TextView txtDprApplicationLayout, txtBuildingLayout, txt_MACHINERY_layout,txt_working_capitallayout,txt_financing_details_Layout,txt_salesDetails_layout,txt_raw_material_Layout,txt_beneficiary_Layout,txt_introduction_Layout,txt_imp_agency_Layout,txt_promoter_details_Layout,txt_ofc_intro_Layout,txt_depreciation_Layout,txt_power_estimate_Layout,txt_working_capital_Layout,txt_salary_details_Layout,txt_wages_Layout,txtAddbuildingRow,txt_add_machinery_row,txt_wages_row,txt_salary_row,txt_raw_material_row,txt_add_sales_row, landTotal,machinery_total,workingCapitalTotal,salesTotal,wagesTotal,rawTotal,salartTotal,rate_of_interest_power;
    private Spinner activitySpinner;
    Button btn_updateform;

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


        btn_updateform.setOnClickListener(v -> {
            SaveApplicationForm();
        });
        initData();
        return view;
    }

    private void SaveApplicationForm() {


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
