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
import com.trust.pmegpcustomeronboardingapp.activity.adapter.NewMachineryAdapter;
import com.trust.pmegpcustomeronboardingapp.activity.adapter.ProductAdapter;
import com.trust.pmegpcustomeronboardingapp.activity.model.ApplicantDetailData;
import com.trust.pmegpcustomeronboardingapp.activity.model.ApplicantRequest;
import com.trust.pmegpcustomeronboardingapp.activity.model.ApplicationResponse;
import com.trust.pmegpcustomeronboardingapp.activity.model.BuildingItem;
import com.trust.pmegpcustomeronboardingapp.activity.model.DPRDetailData;
import com.trust.pmegpcustomeronboardingapp.activity.model.DPRResponse;
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
    private TextView txtDprApplicationLayout, txtBuildingLayout, txtAddbuildingRow,txt_add_machinery_row, landTotal,machinery_total;
    private Spinner activitySpinner;
    private RecyclerView rvProduct, rvLandEntry, rvMachineryEntry, rvWorkingCapital,
            rvMeansOfFinancing, rvSalesDetails, rvRawMaterialEntry, rvWagesEntry;
    private TextInputLayout txtInputLayout;
    private TextInputEditText landEntry;
    String selectedunittype;
    int activityUnitType;
    ProductAdapter productAdapter;
    NewBuildingAdapter newBuildingAdapter;
    NewMachineryAdapter newMachineryAdapter;
    List<BuildingItem> buildingList;
    List<MachineryItem> machineryList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.layout_dpr_fragment, container, false);


        apiService = ApiClient.getClient().create(ApiServices.class);
        txtDprApplicationLayout = view.findViewById(R.id.txt_dpr_application_layout);
        txtBuildingLayout = view.findViewById(R.id.txt_building_Layout);
        txtAddbuildingRow = view.findViewById(R.id.txt_add_row);
        txt_add_machinery_row = view.findViewById(R.id.txt_add_machinery_row);
        landTotal = view.findViewById(R.id.land_total);
        machinery_total = view.findViewById(R.id.machinery_total);

        activitySpinner = view.findViewById(R.id.activityspinner);

        rvProduct = view.findViewById(R.id.rv_product);
        rvLandEntry = view.findViewById(R.id.rv_land_entry);
        rvMachineryEntry = view.findViewById(R.id.rv_machinery_entry);
        rvWorkingCapital = view.findViewById(R.id.rv_working_capital);
        rvMeansOfFinancing = view.findViewById(R.id.rv_means_of_financing);
        rvSalesDetails = view.findViewById(R.id.rv_sales_details);
        rvRawMaterialEntry = view.findViewById(R.id.rv_raw_material_entry);
        rvWagesEntry = view.findViewById(R.id.rv_wages_entry);

        rvProduct.setLayoutManager(new LinearLayoutManager(getContext()));
        rvLandEntry.setLayoutManager(new LinearLayoutManager(getContext()));
        rvMachineryEntry.setLayoutManager(new LinearLayoutManager(getContext()));
        rvWorkingCapital.setLayoutManager(new LinearLayoutManager(getContext()));
        rvMeansOfFinancing.setLayoutManager(new LinearLayoutManager(getContext()));
        rvSalesDetails.setLayoutManager(new LinearLayoutManager(getContext()));
        rvRawMaterialEntry.setLayoutManager(new LinearLayoutManager(getContext()));
        rvWagesEntry.setLayoutManager(new LinearLayoutManager(getContext()));


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

        });



    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        apiService = ApiClient.getClient().create(ApiServices.class);

        String applIdStr = AppConstant.getApplId();


        int applicationId = Integer.parseInt(applIdStr);
        System.out.println("applicationId"+applicationId);
        getDPRData(applicationId);

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
