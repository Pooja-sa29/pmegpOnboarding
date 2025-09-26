package com.trust.pmegpcustomeronboardingapp.activity.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class AppConstant {
    private static final String PREFS_NAME = "MyAppPrefs";

    private static String userID;
    private static Boolean isLoggedIn;
    private static String applId;
    private static String applName;

    public static String getUserID() {
        return userID;
    }

    public static void setUserID(String userID) {
        AppConstant.userID = userID;
    }

    public static String getApplName() {
        return applName;
    }

    public static void setApplName(String applName) {
        AppConstant.applName = applName;
    }

    public static Boolean getIsLoggedIn() {
        return isLoggedIn;
    }

    public static void setIsLoggedIn(Boolean isLoggedIn) {
        AppConstant.isLoggedIn = isLoggedIn;
    }

    public static String getApplId() {
        return applId;
    }

    public static void setApplId(String applId) {
        AppConstant.applId = applId;
    }

    public static void loadFromPrefs(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        applId = String.valueOf(prefs.getInt("ApplID", -1));
        userID = prefs.getString("ApplCode", null);
        isLoggedIn = prefs.getBoolean("isLoggedIn", false);
        applName = prefs.getString("ApplName",null);
    }
}
