package com.trust.pmegpcustomeronboardingapp.activity.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Button;

import com.trust.pmegpcustomeronboardingapp.R;
import com.trust.pmegpcustomeronboardingapp.activity.adapter.IndustryListAdapter;
import com.trust.pmegpcustomeronboardingapp.activity.model.BankModel;
import com.trust.pmegpcustomeronboardingapp.activity.model.NICDevisionModel;
import com.trust.pmegpcustomeronboardingapp.activity.model.NICGroupModel;
import com.trust.pmegpcustomeronboardingapp.activity.model.UnitTypeIdModel;
import com.trust.pmegpcustomeronboardingapp.activity.model.UnitTypeModel;
import com.trust.pmegpcustomeronboardingapp.activity.retrofitClient.ApiClient;
import com.trust.pmegpcustomeronboardingapp.activity.screens.NewApplicantUnitActivity;
import com.trust.pmegpcustomeronboardingapp.activity.services.ApiServices;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class IndustryDataDialogFragment extends DialogFragment {

    int activityUnitType;
    private RecyclerView recyclerView;
    private String[] nicCodes = {};
    private String[] descriptions = {};
    ApiServices apiService;
    String   nicgroup_code;
    Spinner division_spinner,group_spinner,class_spinner;
    private OnIndustrySelectedListener listener;
    Button closeButton,selectButton;
    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        activityUnitType = getArguments().getInt("unitType");
        System.out.println("Selected agencyCode:1"+activityUnitType);
        View view = inflater.inflate(R.layout.fragment_dialog_industry_data, container, false);

        recyclerView = view.findViewById(R.id.recyslerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
         closeButton = view.findViewById(R.id.close_btn);
         selectButton = view.findViewById(R.id.select_btn);
        division_spinner = view.findViewById(R.id.division_spinner);
        group_spinner = view.findViewById(R.id.group_spinner);
        class_spinner = view.findViewById(R.id.class_spinner);


        apiService = ApiClient.getClient().create(ApiServices.class);
        fetchDevisionData(activityUnitType);


        selectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (recyclerView.getAdapter() instanceof IndustryListAdapter) {
                    IndustryListAdapter adapter = (IndustryListAdapter) recyclerView.getAdapter();
                    List<NICGroupModel> selectedItems = new ArrayList<>();

                        for (NICGroupModel item : adapter.getClassList()) {
                            if (item.isChecked()) {

                                selectedItems.add(item);
                            }
                        }
                        adapter.updateList(selectedItems);
                        if (listener != null) {
                            listener.onIndustrySelected(selectedItems);
                        }



                    dismiss();
                }
            }

        });

        closeButton.setOnClickListener(v -> dismiss());
        
        return view;
    }

    public interface OnIndustrySelectedListener {
        void onIndustrySelected(List<NICGroupModel> selectedList);
    }
    public void setOnIndustrySelectedListener(OnIndustrySelectedListener listener) {
        this.listener = listener;
    }
    @Override
    public void onStart() {
        super.onStart();


        if (getDialog() != null) {

            Window window = getDialog().getWindow();
            if (window != null) {
                WindowManager.LayoutParams params = window.getAttributes();
                params.width = (int) (getResources().getDisplayMetrics().widthPixels * 1);  // 85% of screen width
                params.height = (int) (getResources().getDisplayMetrics().widthPixels * 2); // You can adjust this if needed
                window.setAttributes(params);
            }
        }
    }

    private void fetchDevisionData(int activityUnitType) {

            UnitTypeIdModel request = new UnitTypeIdModel(activityUnitType);

            apiService.getNICDevisionData(request).enqueue(new Callback<List<NICDevisionModel>>() {
                @Override
                public void onResponse(Call<List<NICDevisionModel>> call, Response<List<NICDevisionModel>> response) {
                    if (response.isSuccessful() && response.body() != null) {
                        List<NICDevisionModel> nicDevisionModelList = response.body();
                        System.out.println("nic-list-division size: " + nicDevisionModelList.size());


                        if (nicDevisionModelList.size() > 0) {
                            List<String> divisionList = new ArrayList<>();
                            divisionList.add("--Select Division--");


                            for (NICDevisionModel nicDevision : nicDevisionModelList) {
                                divisionList.add(nicDevision.getNic_desc());
                            }


                            ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, divisionList);
                            adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
                            division_spinner.setAdapter(adapter);


                            division_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                @Override
                                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                    if (position > 0) {
                                        System.out.println("Selected Division: " + parent.getItemAtPosition(position).toString());
                                        NICDevisionModel devisionModel = nicDevisionModelList.get(position -1);
                                        String nic_code = devisionModel.getNic_code();

                                        fetchGroupData(nic_code);
                                    }
                                }

                                @Override
                                public void onNothingSelected(AdapterView<?> parent) {

                                }
                            });
                        } else {
                            System.out.println("No NIC Division data found.");

                        }
                    } else {
                        System.out.println("API response unsuccessful or body is null.");
                    }
                }

                @Override
                public void onFailure(Call<List<NICDevisionModel>> call, Throwable t) {

                    System.out.println("API call failed: " + t.getMessage());
                    t.printStackTrace();
                }
            });


    }
    private void fetchGroupData(String nicCode) {

        NICDevisionModel request = new NICDevisionModel(nicCode);

        apiService.getNICGroupData(request).enqueue(new Callback<List<NICGroupModel>>() {
            @Override
            public void onResponse(Call<List<NICGroupModel>> call, Response<List<NICGroupModel>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<NICGroupModel> nicGroupModelList = response.body();
                    System.out.println("nic-list-group size: " + nicGroupModelList.size());


                    if (nicGroupModelList.size() > 0) {
                        List<String> groupList = new ArrayList<>();
                        groupList.add("--Select Group--");


                        for (NICGroupModel nicDevision : nicGroupModelList) {
                            groupList.add(nicDevision.getNic_desc());
                        }


                        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, groupList);
                        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
                        group_spinner.setAdapter(adapter);


                        group_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                if (position > 0) {
                                    System.out.println("Selected group: " + parent.getItemAtPosition(position).toString());
                                    NICGroupModel groupModel = nicGroupModelList.get(position -1);
                                     nicgroup_code = groupModel.getNic_code();
                                    fetchClassData(nicgroup_code);
                                }
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {

                            }
                        });
                    } else {
                        System.out.println("No NIC Group data found.");

                    }
                } else {
                    System.out.println("API response unsuccessful or body is null.");
                }
            }

            @Override
            public void onFailure(Call<List<NICGroupModel>> call, Throwable t) {

                System.out.println("API call failed: " + t.getMessage());
                t.printStackTrace();
            }
        });


    }
    private void fetchClassData(String nicCode) {

        NICDevisionModel request = new NICDevisionModel(nicCode);

        apiService.getNICClassData(request).enqueue(new Callback<List<NICGroupModel>>() {
            @Override
            public void onResponse(Call<List<NICGroupModel>> call, Response<List<NICGroupModel>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<NICGroupModel> nicGroupModelList = response.body();
                    System.out.println("nic-list-group size: " + nicGroupModelList.size());


                    if (nicGroupModelList.size() > 0) {
                        List<String> groupList = new ArrayList<>();
                        groupList.add("--Select class--");


                        for (NICGroupModel nicDevision : nicGroupModelList) {
                            groupList.add(nicDevision.getNic_desc());
                        }


                        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, groupList);
                        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
                        class_spinner.setAdapter(adapter);


                        class_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                if (position > 0) {
                                    System.out.println("Selected group: " + parent.getItemAtPosition(position).toString());
                                    NICGroupModel groupModel = nicGroupModelList.get(position -1);
                                    String nic_code = groupModel.getNic_code();
                                    fetchNicData(nic_code);

                                }
                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {

                            }
                        });
                    } else {
                        System.out.println("No NIC  data found.");

                    }
                } else {
                    System.out.println("API response unsuccessful or body is null.");
                }
            }

            @Override
            public void onFailure(Call<List<NICGroupModel>> call, Throwable t) {

                System.out.println("API call failed: " + t.getMessage());
                t.printStackTrace();
            }
        });


    }

    private void fetchNicData(String code) {
        NICDevisionModel request = new NICDevisionModel(code);

        apiService.getNICDataList(request).enqueue(new Callback<List<NICGroupModel>>() {
            @Override
            public void onResponse(Call<List<NICGroupModel>> call, Response<List<NICGroupModel>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<NICGroupModel> nicGroupModelList = response.body();
                    System.out.println("nic-list- size: " + nicGroupModelList.size());


                    if (nicGroupModelList.size() > 0) {

                        IndustryListAdapter adapter = new IndustryListAdapter(nicGroupModelList);
                        recyclerView.setAdapter(adapter);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<NICGroupModel>> call, Throwable t) {

                System.out.println("API call failed: " + t.getMessage());
                t.printStackTrace();
            }
        });

    }


}
