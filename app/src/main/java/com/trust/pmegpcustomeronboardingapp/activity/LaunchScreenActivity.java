package com.trust.pmegpcustomeronboardingapp.activity;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.trust.pmegpcustomeronboardingapp.R;
import com.trust.pmegpcustomeronboardingapp.activity.screens.LoginActivity;
import com.trust.pmegpcustomeronboardingapp.activity.screens.NewApplicantUnitActivity;
import com.trust.pmegpcustomeronboardingapp.activity.screens.RegisteredApplicantActivity;

public class LaunchScreenActivity extends AppCompatActivity {

    private ImageView imageView;
    private CardView newUserCardview,registerCardView,existingUnitCardview,registerApllicantLogincardView;
    private Handler handler = new Handler(Looper.getMainLooper());

    // Image resources
    private int[] imageList = {
            R.drawable.pmegp_bg_img1,
            R.drawable.pmegp_bg_img2,
            R.drawable.pmegp_bg_img3,
            R.drawable.pmegp_bg_img4
    };

    private int currentIndex = 0;
    private final long interval = 3000; // 3 seconds

    private final Runnable imageSwitcher = new Runnable() {
        @Override
        public void run() {
            Animation fadeOut = AnimationUtils.loadAnimation(LaunchScreenActivity.this, android.R.anim.fade_out);
            Animation fadeIn = AnimationUtils.loadAnimation(LaunchScreenActivity.this, android.R.anim.fade_in);

            imageView.startAnimation(fadeOut);
            imageView.setImageResource(imageList[currentIndex]);
            imageView.startAnimation(fadeIn);

            currentIndex = (currentIndex + 1) % imageList.length;
            handler.postDelayed(this, interval);
        }
    };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_screen);
        imageView = findViewById(R.id.bg_imgview);
        imageView.setImageResource(imageList[currentIndex]);

        newUserCardview = findViewById(R.id.cardview1);
        registerCardView = findViewById(R.id.cardview2);
        existingUnitCardview = findViewById(R.id.cardview3);
        registerApllicantLogincardView = findViewById(R.id.cardview4);

        handler.postDelayed(imageSwitcher, interval);
        newUserCardview.setOnClickListener(v -> {
              Intent i = new Intent(LaunchScreenActivity.this, NewApplicantUnitActivity.class);
              startActivity(i);
        });
        registerCardView.setOnClickListener(v -> {
            Intent i1 = new Intent(LaunchScreenActivity.this, LoginActivity.class);
            startActivity(i1);
        });
        existingUnitCardview.setOnClickListener(v -> {
            Intent i2 = new Intent(LaunchScreenActivity.this, RegisteredApplicantActivity.class);
            startActivity(i2);
        });
        registerApllicantLogincardView.setOnClickListener(v -> {
            Intent i3 = new Intent(LaunchScreenActivity.this,LoginActivity.class);
            startActivity(i3);
        });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(imageSwitcher);
    }
}
