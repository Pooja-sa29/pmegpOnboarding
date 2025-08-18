package com.trust.pmegpcustomeronboardingapp.activity.screens;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.trust.pmegpcustomeronboardingapp.R;
import com.trust.pmegpcustomeronboardingapp.activity.utils.TrustMethods;

import java.util.Random;

public class LoginActivity extends AppCompatActivity {
    EditText userId,password,captcha_txt;
    TextView captcha_text_view;
    Button btn_login;
    ImageView refresh_captcha;
    String currentCaptcha;
    String captcha_code;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);

        initComponent();

    }
    private void initComponent() {
        userId = findViewById(R.id.userId);
        password = findViewById(R.id.password);
        captcha_txt = findViewById(R.id.edittxt_captcha);
        btn_login = findViewById(R.id.btnLogin);
        captcha_text_view = findViewById(R.id.tvCaptchaText);
        refresh_captcha = findViewById(R.id.imgRefreshCaptcha);

        currentCaptcha = generateCaptcha(5);
        captcha_text_view.setText(currentCaptcha);

        refresh_captcha.setOnClickListener(v -> {
            currentCaptcha = generateCaptcha(5);
            captcha_text_view.setText(currentCaptcha);
        });

        btn_login.setOnClickListener(v -> {

            TrustMethods.hideKeyboard(LoginActivity.this);

            String enteredCodeCaptcha = captcha_txt.getText().toString().trim();
            String password_code = password.getText().toString().trim();
            String user_Id = userId.getText().toString().trim();

            user_Id = userId.getText().toString();
            password_code = password.getText().toString();
            captcha_code = captcha_txt.getText().toString();


            String encryptedPassword = password_code;

//            if (user_Id.equalsIgnoreCase("")) {
//                userId.setError("UserID is empty");
//            }else if(password_code.equalsIgnoreCase("")){
//                password.setError("Password is empty");
//            }else if(!enteredCodeCaptcha.equalsIgnoreCase(currentCaptcha)) {
//                captcha_txt.setError("Captcha does not match");
//            }else{
//                new LoginAsyncTask(user_Id,encryptedPassword).execute();
                Intent i = new Intent(LoginActivity.this,DashboardScreenActivity.class);
                startActivity(i);
//            }
        });
    }

    private String generateCaptcha(int length) {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder captcha = new StringBuilder();

        Random random = new Random();
        for (int i = 0; i < length; i++) {
            captcha.append(chars.charAt(random.nextInt(chars.length())));
        }
        return captcha.toString();
    }
}
