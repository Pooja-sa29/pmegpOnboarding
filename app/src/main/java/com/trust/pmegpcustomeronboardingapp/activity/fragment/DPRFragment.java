package com.trust.pmegpcustomeronboardingapp.activity.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DPRFragment extends BaseFormFragment {
    private ApiServices apiService;
    private TextView txtDprApplicationLayout, txtBuildingLayout, txtAddbuildingRow,txt_add_machinery_row,txt_wages_row,txt_salary_row,txt_raw_material_row,txt_add_sales_row, landTotal,machinery_total,workingCapitalTotal,salesTotal,wagesTotal,rawTotal,salartTotal,rate_of_interest_power;
    private Spinner activitySpinner;
    private RecyclerView rvProduct, rvLandEntry, rvMachineryEntry, rvWorkingCapital,
            rvMeansOfFinancing, rvSalesDetails, rvRawMaterialEntry, rvWagesEntry,rvSalaryEntry,rv_capital_estimates_entry,rv_power_estimate_entry;
    private TextInputLayout txtInputLayout;
    private TextInputEditText landEntry,txt_power_req,into_ofc,onmachinery,payBackPeriod,prj_impl_period,promoter_info,intro_ofc,introduction_txt,aboutBeneficiary;
    String selectedunittype;
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

        initData();
        return view;
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
        txt_power_req.setText(data.getData().getDPRDetail().getPowerRequirement().toString());
        rate_of_interest_power.setText(data.getData().getDPRDetail().getRateOfInterest().toString());
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

        apiService.getDprData(request).enqueue(new retrofit2.Callback<DPRResponse>() {
            @Override
            public void onResponse(Call<DPRResponse> call, retrofit2.Response<DPRResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    DPRDetailData data = response.body().getData();
                    Log.d("DRP_API_RESPONSE", new Gson().toJson(data));
                    setDataToUI(data);
                }
            }

            @Override
            public void onFailure(Call<DPRResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    private void setDataToUI(DPRDetailData data) {


        setSpinnerSelection(activitySpinner, data.getUnitActivityName());
         List<DPRDetailData> dataList = new ArrayList<>();
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
}
