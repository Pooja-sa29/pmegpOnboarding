package com.trust.pmegpcustomeronboardingapp.activity.screens;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.JsonObject;
import com.trust.pmegpcustomeronboardingapp.R;
import com.trust.pmegpcustomeronboardingapp.activity.model.LoginRequest;
import com.trust.pmegpcustomeronboardingapp.activity.model.LoginResponse;
import com.trust.pmegpcustomeronboardingapp.activity.model.ResultModel;
import com.trust.pmegpcustomeronboardingapp.activity.retrofitClient.ApiClient;
import com.trust.pmegpcustomeronboardingapp.activity.services.ApiServices;
import com.trust.pmegpcustomeronboardingapp.activity.utils.AppConstant;
import com.trust.pmegpcustomeronboardingapp.activity.utils.TrustMethods;

import org.json.JSONObject;

import java.nio.charset.StandardCharsets;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    EditText userId,password,captcha_txt;
    TextView captcha_text_view;
    Button btn_login;
    ImageView refresh_captcha;
    String currentCaptcha;
    String captcha_code;
    ApiServices apiService;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        apiService = ApiClient.getClient().create(ApiServices.class);
        AppConstant.loadFromPrefs(this);
        initComponent();
        SharedPreferences prefs = getSharedPreferences("MyAppPrefs", MODE_PRIVATE);
        boolean isLoggedIn = prefs.getBoolean("isLoggedIn", false);
        if (isLoggedIn) {
            startActivity(new Intent(this, DashboardScreenActivity.class));
            finish();
        }
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

            if (user_Id.equalsIgnoreCase("")) {
                userId.setError("UserID is empty");
            }else if(password_code.equalsIgnoreCase("")){
                password.setError("Password is empty");
            }else if(!enteredCodeCaptcha.equalsIgnoreCase(currentCaptcha)) {
                captcha_txt.setError("Captcha does not match");
            }else{
                loginAuthentication(user_Id, password_code);

            }
        });
    }

    private void loginAuthentication(String user_Id, String password_code) {
        try {
            JSONObject loginJson = new JSONObject();
            loginJson.put("UserID", user_Id.trim());
            loginJson.put("Password", password_code.trim());

            String encodedData = Base64.encodeToString(
                    loginJson.toString().getBytes(StandardCharsets.UTF_8),
                    Base64.NO_WRAP
            );
            Log.d("LoginDebug", "Raw JSON: " + loginJson.toString());
            Log.d("LoginDebug", "Encoded Data: " + encodedData);

            LoginRequest requestBody = new LoginRequest();
            requestBody.setData(encodedData);

            apiService.loginAuthentication(requestBody).enqueue(new Callback<LoginResponse>() {
                @Override
                public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                    if (response.isSuccessful() && response.body() != null) {
                        LoginResponse result = response.body();

                        Log.d("LoginDebug", "status: " + result.isSuccess()
                                + ", ApplCode: " + result.getApplCode()
                                + ", ApplID: " + result.getApplID()
                                + ", message: " + result.getMessage());

                        if (result.isSuccess()) {
                            SharedPreferences prefs = getSharedPreferences("MyAppPrefs", MODE_PRIVATE);
                            SharedPreferences.Editor editor = prefs.edit();
                            editor.putBoolean("isLoggedIn", true);
                            editor.putInt("ApplID", result.getApplID());
                            editor.putString("ApplCode", result.getApplCode());
                            editor.apply();

                            String applId = String.valueOf(result.getApplID());
                            AppConstant.setApplId(applId);
                            AppConstant.setUserID(result.getApplCode());
                            AppConstant.setIsLoggedIn(true);
                            Toast.makeText(LoginActivity.this, result.getMessage(), Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(LoginActivity.this, DashboardScreenActivity.class));
                            finish();
                        } else {
                            Toast.makeText(LoginActivity.this, result.getMessage(), Toast.LENGTH_SHORT).show();

                            EditText passwordField = findViewById(R.id.password);
                            passwordField.setText("");
                        }
                    } else {
                        Toast.makeText(LoginActivity.this, "Invalid server response", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<LoginResponse> call, Throwable t) {
                    Toast.makeText(LoginActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Encoding error", Toast.LENGTH_SHORT).show();
        }
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
