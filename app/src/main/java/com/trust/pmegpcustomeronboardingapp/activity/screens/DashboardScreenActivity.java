package com.trust.pmegpcustomeronboardingapp.activity.screens;

import static com.trust.pmegpcustomeronboardingapp.R.id.stepLabel;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.trust.pmegpcustomeronboardingapp.R;
import com.trust.pmegpcustomeronboardingapp.activity.Interface.FragmentNavigationListener;
import com.trust.pmegpcustomeronboardingapp.activity.fragment.ApplicationFragment;
import com.trust.pmegpcustomeronboardingapp.activity.fragment.BaseFormFragment;
import com.trust.pmegpcustomeronboardingapp.activity.fragment.DPRFragment;
import com.trust.pmegpcustomeronboardingapp.activity.fragment.FinalSubmissionFragment;
import com.trust.pmegpcustomeronboardingapp.activity.fragment.LoanSanctionFragment;
import com.trust.pmegpcustomeronboardingapp.activity.fragment.ScoreCardFragment;
import com.trust.pmegpcustomeronboardingapp.activity.fragment.UnderProcessFragment;
import com.trust.pmegpcustomeronboardingapp.activity.fragment.UploadDocumentsFragment;
import com.trust.pmegpcustomeronboardingapp.activity.model.ApplicantDetailData;
import com.trust.pmegpcustomeronboardingapp.activity.model.LoginResponse;
import com.trust.pmegpcustomeronboardingapp.activity.utils.AppConstant;

public class DashboardScreenActivity extends AppCompatActivity implements FragmentNavigationListener{

    private Fragment[] formSteps ;
    TextView userId;
    RelativeLayout relativeLayout;
    LinearLayout linearLayout1,linearLayout2;
    private final String[] fragmentNames = new String[] {
            "Application",
            "DPR",
            "Score Card",
            "Upload Documents",
            "Final Submission",
            "Under Process",
            "Loan Sanction",

    };
    private int currentStep = 0;
    private LinearLayout stepLayout;
    private int[] stepIcons = {
            R.drawable.check_circle_24,
            R.drawable.check_circle_24,
            R.drawable.check_circle_24,
            R.drawable.check_circle_24,
            R.drawable.check_circle_24,
            R.drawable.check_circle_24,
            R.drawable.check_circle_24,
            R.drawable.check_circle_24,
            R.drawable.check_circle_24,
            R.drawable.check_circle_24
    };
    TextView fragment_name;
    TextView appId,appName,appDoc;
    ApplicantDetailData applicantDetailData;
    HorizontalScrollView stepScrollView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_screen);

        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        AppConstant.loadFromPrefs(this);
         applicantDetailData = new ApplicantDetailData();

        userId = findViewById(R.id.userId);
        appId = findViewById(R.id.appId);
        appName = findViewById(R.id.appName);
        appDoc = findViewById(R.id.appDoc);
        stepLayout =findViewById(R.id.stepLayout);
        stepScrollView = findViewById(R.id.stepScrollView);
        fragment_name = findViewById(R.id.fragment_name);
        relativeLayout = findViewById(R.id.layout_relative);
        linearLayout1 = findViewById(R.id.welcome_txt_layout);
        linearLayout2 = findViewById(R.id.welcome_layout);
        linearLayout1.setVisibility(View.VISIBLE);
        linearLayout2.setVisibility(View.VISIBLE);
//         if (AppConstant.getIsLoggedIn().equals(true)) {
             userId.setText("Welcome, Your Application ID is " + AppConstant.getUserID());
//         }

        appId.setText(AppConstant.getUserID());
        appName.setText(applicantDetailData.getApplName());
        appDoc.setText("");
        toolbar.setOnMenuItemClickListener(item -> {
            int id = item.getItemId();
            if (id == R.id.menu_home) {
                stepScrollView.setVisibility(View.GONE);
                relativeLayout.setVisibility(View.GONE);
                linearLayout1.setVisibility(View.VISIBLE);
                linearLayout2.setVisibility(View.VISIBLE);
                return true;
            } else if (id == R.id.menu_edit) {

                stepScrollView.setVisibility(View.VISIBLE);
                relativeLayout.setVisibility(View.VISIBLE);
                linearLayout1.setVisibility(View.GONE);
                linearLayout2.setVisibility(View.GONE);
                setupStepper();
                updateFragment();
                return true;
            } else if (id == R.id.menu_submit) {
                return true;
            } else if (id == R.id.menu_status) {
                return true;
            } else if (id == R.id.menu_training) {
                return true;
            } else if (id == R.id.menu_grievance) {
                return true;
            } else if (id == R.id.menu_upload) {
                return true;
            } else if (id == R.id.menu_sanction) {
                return true;
            } else if (id == R.id.menu_others) {
                return true;
            } else if (id == R.id.menu_logout) {
                logoutUser();
                return true;
            }
            return false;
        });


        formSteps = new Fragment[]{
                new ApplicationFragment(),
                new DPRFragment(),
                new ScoreCardFragment(),
                new UploadDocumentsFragment(),
                new FinalSubmissionFragment(),
                new UnderProcessFragment(),
                new LoanSanctionFragment()
        };


    }

    private void logoutUser() {
        SharedPreferences preferences = getSharedPreferences("MyAppPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.apply();

        Toast.makeText(this, "Session expired. Please log in again.", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.nav_menu, menu);
        return true;
    }
    @SuppressLint("MissingInflatedId")
    private void setupStepper() {
        stepLayout.removeAllViews();
        LayoutInflater inflater = LayoutInflater.from(this);

        for (int i = 0; i < formSteps.length; i++) {
            View stepView = inflater.inflate(R.layout.layout_step_item, stepLayout, false);
            ImageView icon = stepView.findViewById(R.id.stepIcon);
           TextView label = stepView.findViewById(stepLabel);
            View line = stepView.findViewById(R.id.line);

            int index = i;


            icon.setImageResource(stepIcons[i]);
            label.setText(fragmentNames[i]);


            if (i == currentStep) {
                icon.setBackground(ContextCompat.getDrawable(this, R.drawable.active_shape_circle));
                label.setTextColor(ContextCompat.getColor(this, R.color.black)); // Active color
            } else {
                icon.setBackground(ContextCompat.getDrawable(this, R.drawable.inactive_shape_circle));
                label.setTextColor(ContextCompat.getColor(this, R.color.colorFentBlack)); // Inactive color
            }

            icon.setOnClickListener(v -> {

                currentStep = index;
                updateFragment();
            });

            if (i == formSteps.length - 1) {
                line.setVisibility(View.GONE);
            }

            stepLayout.addView(stepView);

            if (i == currentStep) {
                stepView.post(() -> scrollToStep(stepView));
            }
        }
    }


    private void updateFragment() {
        Fragment fragment = formSteps[currentStep];
        if (fragment instanceof BaseFormFragment) {
            ((BaseFormFragment) fragment).setNavigationListener((FragmentNavigationListener) this);        }

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.formFragmentContainer, fragment)
                .commit();

        updateStepperUI();

        if(currentStep < fragmentNames.length) {
            fragment_name.setText(fragmentNames[currentStep]);
            fragment_name.setVisibility(View.VISIBLE);
        }
        else
            fragment_name.setVisibility(View.GONE);


    }

    private void updateStepperUI() {
        setupStepper();
    }
    private void scrollToStep(View target) {
        int scrollX = target.getLeft() - (stepScrollView.getWidth() / 2) + (target.getWidth() / 2);
        stepScrollView.smoothScrollTo(scrollX, 0);
    }

    @Override
    public void onNextStep() {

    }

    @Override
    public void onPreviousStep() {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}
