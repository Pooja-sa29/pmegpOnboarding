package com.trust.pmegpcustomeronboardingapp.activity.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
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
import com.trust.pmegpcustomeronboardingapp.R;
import com.trust.pmegpcustomeronboardingapp.activity.adapter.AcadamicAdapter;
import com.trust.pmegpcustomeronboardingapp.activity.adapter.ActivityAdapter;
import com.trust.pmegpcustomeronboardingapp.activity.adapter.ApplicantAgeAdapter;
import com.trust.pmegpcustomeronboardingapp.activity.adapter.BankRelationAdapter;
import com.trust.pmegpcustomeronboardingapp.activity.adapter.ColSecurityAdapter;
import com.trust.pmegpcustomeronboardingapp.activity.adapter.CreditHistoryAdapter;
import com.trust.pmegpcustomeronboardingapp.activity.adapter.DecrAdapter;
import com.trust.pmegpcustomeronboardingapp.activity.adapter.DependenciesAdapter;
import com.trust.pmegpcustomeronboardingapp.activity.adapter.EmployementAdapter;
import com.trust.pmegpcustomeronboardingapp.activity.adapter.ExperienceAdapter;
import com.trust.pmegpcustomeronboardingapp.activity.adapter.GovtRegAdapter;
import com.trust.pmegpcustomeronboardingapp.activity.adapter.HouseAdapter;
import com.trust.pmegpcustomeronboardingapp.activity.adapter.IncomeAdapter;
import com.trust.pmegpcustomeronboardingapp.activity.adapter.InsuranceAdapter;
import com.trust.pmegpcustomeronboardingapp.activity.adapter.Locationadapter;
import com.trust.pmegpcustomeronboardingapp.activity.adapter.MarketingAdapter;
import com.trust.pmegpcustomeronboardingapp.activity.adapter.OtherResAdapter;
import com.trust.pmegpcustomeronboardingapp.activity.adapter.RepaymentAdapter;
import com.trust.pmegpcustomeronboardingapp.activity.adapter.ResidingAdapter;
import com.trust.pmegpcustomeronboardingapp.activity.adapter.SkillAdapter;
import com.trust.pmegpcustomeronboardingapp.activity.model.ApplicantRequest;
import com.trust.pmegpcustomeronboardingapp.activity.model.DRPMasterData;
import com.trust.pmegpcustomeronboardingapp.activity.model.ScoreCard;
import com.trust.pmegpcustomeronboardingapp.activity.retrofitClient.ApiClient;
import com.trust.pmegpcustomeronboardingapp.activity.services.ApiServices;
import com.trust.pmegpcustomeronboardingapp.activity.utils.AppConstant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;

public class ScoreCardFragment extends BaseFormFragment {
    private ApiServices apiService;
    TextView tv_name, tv_applicant_id, tv_total_marks, tv_marks_secured, tv_percentage;
    ApplicantAgeAdapter applicantAgeAdapter;
    DependenciesAdapter depAdapter;
    HouseAdapter houseAdapter;
    ResidingAdapter residingAdapter;
    AcadamicAdapter acadamicAdapter;
    ExperienceAdapter experienceAdapter;
    IncomeAdapter incomeAdapter;
    OtherResAdapter otherResAdapter;
    InsuranceAdapter insuranceAdapter;
    BankRelationAdapter bankRelationAdapter;
    CreditHistoryAdapter creditHistoryAdapter;
    Locationadapter locationadapter;
    SkillAdapter skillAdapter;
    MarketingAdapter marketingAdapter;
    ActivityAdapter activityAdapter;
    GovtRegAdapter govtRegAdapter;
    RepaymentAdapter repaymentAdapter;
    EmployementAdapter employementAdapter;
    DecrAdapter decrAdapter;
    ColSecurityAdapter colSecurityAdapter;

    CardView cv_personal_details,cv_security_details,cv_firm_details;
    TextView section_title,security_title,newFirm_title;

    private List<CardView> allCards;
    private List<TextView> allTextViews;


    List<ScoreCard.ScoreParameter> applicantList = new ArrayList<>();
    List<ScoreCard.ScoreParameter> dependenciesList = new ArrayList<>();
    List<ScoreCard.ScoreParameter> houseList = new ArrayList<>();
    List<ScoreCard.ScoreParameter> residingList = new ArrayList<>();
    List<ScoreCard.ScoreParameter> academicList = new ArrayList<>();
    List<ScoreCard.ScoreParameter> experienceList = new ArrayList<>();
    List<ScoreCard.ScoreParameter> otherResList = new ArrayList<>();
    List<ScoreCard.ScoreParameter> incomeList = new ArrayList<>();
    List<ScoreCard.ScoreParameter> insuranceList = new ArrayList<>();
    List<ScoreCard.ScoreParameter> bankRelationList = new ArrayList<>();
    List<ScoreCard.ScoreParameter> creditHistoryList = new ArrayList<>();
    List<ScoreCard.ScoreParameter> locationList = new ArrayList<>();
    List<ScoreCard.ScoreParameter> skillList = new ArrayList<>();
    List<ScoreCard.ScoreParameter> marketingList = new ArrayList<>();
    List<ScoreCard.ScoreParameter> activityList = new ArrayList<>();
    List<ScoreCard.ScoreParameter> govtRegList = new ArrayList<>();
    List<ScoreCard.ScoreParameter> repaymentList = new ArrayList<>();
    List<ScoreCard.ScoreParameter> employmentList = new ArrayList<>();
    List<ScoreCard.ScoreParameter> dscrList = new ArrayList<>();
    List<ScoreCard.ScoreParameter> collateralList = new ArrayList<>();

    RecyclerView rv_applicant, rv_dependency, rv_house, rv_residing, rv_acadamic, rv_exptrade, rv_income_tax, rv_insurance_policy, rv_otherSource,rv_security_covg,rv_lendingBank,rv_credit_history,rv_location,rv_skill,rv_marketing,rv_lineOfActivity,rv_salesReg,rv_repayment,rv_emp_generation,rv_dscr;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        apiService = ApiClient.getClient().create(ApiServices.class);
        String applIdStr = AppConstant.getApplId();


        int applicationId = Integer.parseInt(applIdStr);
        System.out.println("applicationId" + applicationId);
        getScoreCard(applicationId);
    }

    private void getScoreCard(int appId) {
        ApplicantRequest request = new ApplicantRequest(appId);


        apiService.getScoreCardData(request).enqueue(new Callback<ScoreCard>() {
            @Override
            public void onResponse(Call<ScoreCard> call, retrofit2.Response<ScoreCard> response) {
                if (response.isSuccessful() && response.body() != null) {
                    ScoreCard data = response.body();
                    Log.d("SCORE_master_API_RESPONSE", new Gson().toJson(data));
                    setScoreCardDatatoUI(data);
                }
            }

            @Override
            public void onFailure(Call<ScoreCard> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    private void setScoreCardDatatoUI(ScoreCard data) {

        //Applicant data
        tv_name.setText(data.getApplicant().getApplName());
        tv_applicant_id.setText(data.getApplicant().getApplCode());
        tv_total_marks.setText(data.getMaximumMarks());
//        tv_marks_secured.setText(data.getMarksSecured());
        int m1 = Integer.parseInt(data.getMarksSecured());
        int m2 = Integer.parseInt(data.getMaximumMarks());
        if (m2 != 0) {
            float percent = (m1 * 100f) / m2;
            tv_percentage.setText(String.format(Locale.getDefault(), "%.2f%%", percent));
        } else {
            tv_percentage.setText("N/A");
        }
        //age


        for (ScoreCard.ScoreParameter param : data.getScoreParameters()) {
            switch (param.getScrParameter()) {
                case "Applicant's Age :":
                    applicantList.add(param);
                    break;
                case "No. of dependencies":
                    dependenciesList.add(param);
                    break;
                case "Owning a house/parental house":
                    houseList.add(param);
                    break;
                case "Residing at the same address / location":
                    residingList.add(param);
                    break;
                case "Academic Qualifications":
                    academicList.add(param);
                    break;
                case "Experience in the line of trade":
                    experienceList.add(param);
                    break;
                case "Any other source of income including family":
                    otherResList.add(param);
                    break;

                case "Assessed for Income Tax":
                    incomeList.add(param);
                    break;
                case "Having Life Insurance policy (PMSBY, PMJJBY, APY or any other insurance policy)":
                    insuranceList.add(param);
                    break;
                case "Relationship with lending bank ( Opening Date of Bank Account) (dd-mmm-yyyy)":
                    bankRelationList.add(param);
                    break;
                case "Credit History":
                    creditHistoryList.add(param);
                    break;
                case "Location Advantage (availability of infrastructure, raw materials, labour, proximity to markets etc.)":
                    locationList.add(param);
                    break;
                case "Skill Certification Course / RSETI / ITS / Computer knowledge":
                    skillList.add(param);
                    break;
                case "Marketing Tie ups for sale of products":
                    marketingList.add(param);
                    break;
                case "Line of Activity":
                    activityList.add(param);
                    break;
                case "Registered with Govt. authorities viz for sales Tax/Vat/licence from local bodies/shop act etc.":
                    govtRegList.add(param);
                    break;
                case "Repayment period (not applicable for only working capital loans).":
                    repaymentList.add(param);
                    break;
                case "Employment Generation":
                    employmentList.add(param);
                    break;
                case "Avg. DSCR (not applicable for working capital loans)":
                    dscrList.add(param);
                    break;
                case "Collateral Securities Coverage:":
                    collateralList.add(param);
                    break;
            }


            applicantAgeAdapter = new ApplicantAgeAdapter(applicantList);
            rv_applicant.setAdapter(applicantAgeAdapter);

            depAdapter = new DependenciesAdapter(dependenciesList);
            rv_dependency.setAdapter(depAdapter);

            houseAdapter = new HouseAdapter(houseList);
            rv_house.setAdapter(houseAdapter);

            residingAdapter = new ResidingAdapter(residingList);
            rv_residing.setAdapter(residingAdapter);

            acadamicAdapter = new AcadamicAdapter(academicList);
            rv_acadamic.setAdapter(acadamicAdapter);

            experienceAdapter = new ExperienceAdapter(experienceList);
            rv_exptrade.setAdapter(experienceAdapter);

            otherResAdapter = new OtherResAdapter(otherResList);
            rv_otherSource.setAdapter(otherResAdapter);

            incomeAdapter = new IncomeAdapter(incomeList);
            rv_income_tax.setAdapter(incomeAdapter);

            insuranceAdapter = new InsuranceAdapter(insuranceList);
            rv_insurance_policy.setAdapter(insuranceAdapter);

            // new venture/firm

            bankRelationAdapter = new BankRelationAdapter(bankRelationList);
            rv_lendingBank.setAdapter(bankRelationAdapter);

            creditHistoryAdapter = new CreditHistoryAdapter(creditHistoryList);
            rv_credit_history.setAdapter(creditHistoryAdapter);

            locationadapter = new Locationadapter(locationList);
            rv_location.setAdapter(locationadapter);

            skillAdapter = new SkillAdapter(skillList);
            rv_skill.setAdapter(skillAdapter);

            marketingAdapter = new MarketingAdapter(marketingList);
            rv_marketing.setAdapter(marketingAdapter);

            activityAdapter = new ActivityAdapter(activityList);
            rv_lineOfActivity.setAdapter(activityAdapter);

            govtRegAdapter = new GovtRegAdapter(govtRegList);
            rv_salesReg.setAdapter(govtRegAdapter);

            repaymentAdapter = new RepaymentAdapter(repaymentList);
            rv_repayment.setAdapter(repaymentAdapter);

            employementAdapter = new EmployementAdapter(employmentList);
            rv_emp_generation.setAdapter(employementAdapter);

            decrAdapter = new DecrAdapter(dscrList);
            rv_dscr.setAdapter(decrAdapter);


            //security
            colSecurityAdapter = new ColSecurityAdapter(collateralList);
            rv_security_covg.setAdapter(colSecurityAdapter);


        }


    }

    @SuppressLint("MissingInflatedId")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_score_fragment, container, false);
        tv_name = view.findViewById(R.id.tv_name);
        tv_applicant_id = view.findViewById(R.id.tv_applicant_id);
        tv_total_marks = view.findViewById(R.id.tv_total_marks);
        tv_percentage = view.findViewById(R.id.tv_percentage);


        section_title = view.findViewById(R.id.section_title);
        security_title = view.findViewById(R.id.security_title);
        newFirm_title = view.findViewById(R.id.newFirm_title);

        cv_personal_details = view.findViewById(R.id.cv_personal_details);
        cv_security_details = view.findViewById(R.id.cv_security_details);
        cv_firm_details = view.findViewById(R.id.cv_firm_details);

        cv_personal_details.setVisibility(View.GONE);
        cv_security_details.setVisibility(View.GONE);
        cv_firm_details.setVisibility(View.GONE);



        rv_applicant = view.findViewById(R.id.rv_applicant);
        rv_dependency = view.findViewById(R.id.rv_dependency_count);
        rv_house = view.findViewById(R.id.rv_owninghouse);
        rv_residing = view.findViewById(R.id.rv_residing);
        rv_acadamic = view.findViewById(R.id.rv_acadamic);
        rv_exptrade = view.findViewById(R.id.rv_exptrade);
        rv_otherSource = view.findViewById(R.id.rv_otherSource);
        rv_income_tax = view.findViewById(R.id.rv_income_tax);
        rv_insurance_policy = view.findViewById(R.id.rv_insurance_policy);

        rv_lendingBank =view.findViewById(R.id.rv_lendingBank);
        rv_credit_history = view.findViewById(R.id.rv_credit_history);
        rv_location = view.findViewById(R.id.rv_location);
        rv_skill = view.findViewById(R.id.rv_skill);
        rv_marketing = view.findViewById(R.id.rv_marketing);
        rv_lineOfActivity = view.findViewById(R.id.rv_lineOfActivity);
        rv_salesReg = view.findViewById(R.id.rv_salesReg);
        rv_repayment = view.findViewById(R.id.rv_repayment);
        rv_emp_generation = view.findViewById(R.id.rv_emp_generation);
        rv_dscr = view.findViewById(R.id.rv_dscr);

        rv_security_covg = view.findViewById(R.id.rv_security_covg);

        rv_applicant.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_dependency.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_house.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_acadamic.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_exptrade.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_residing.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_otherSource.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_income_tax.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_insurance_policy.setLayoutManager(new LinearLayoutManager(getContext()));

        rv_lendingBank.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_credit_history.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_location.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_skill.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_marketing.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_lineOfActivity.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_salesReg.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_repayment.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_emp_generation.setLayoutManager(new LinearLayoutManager(getContext()));
        rv_dscr.setLayoutManager(new LinearLayoutManager(getContext()));

        rv_security_covg.setLayoutManager(new LinearLayoutManager(getContext()));

        allCards = Arrays.asList(cv_personal_details,cv_firm_details,cv_security_details);
        allTextViews = Arrays.asList(section_title,newFirm_title,security_title);

        closeAllCards();


        section_title.setOnClickListener(v -> toggleSection(cv_personal_details,section_title ));
        newFirm_title.setOnClickListener(v -> toggleSection(cv_firm_details,newFirm_title ));
        security_title.setOnClickListener(v -> toggleSection(cv_security_details,security_title ));

        return view;
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
