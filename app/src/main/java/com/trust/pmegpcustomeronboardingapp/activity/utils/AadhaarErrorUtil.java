package com.trust.pmegpcustomeronboardingapp.activity.utils;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

public class AadhaarErrorUtil {

    private static HashMap<String, String> errorMap = new HashMap<>();

    public static void loadErrors(Context context) {
        try {
            InputStream is = context.getAssets().open("AadharError.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            String json = new String(buffer, StandardCharsets.UTF_8);

            JSONObject jsonObject = new JSONObject(json);
            JSONArray errors = jsonObject.getJSONArray("errors");

            for (int i = 0; i < errors.length(); i++) {
                JSONObject obj = errors.getJSONObject(i);
                String code = obj.getString("code");
                String description = obj.getString("description");
                errorMap.put(code, description);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getDescription(String code) {
        if (errorMap.containsKey(code)) {
            return errorMap.get(code);
        }
        return "Unknown Error (" + code + ")";
    }
}
