package com.trust.pmegpcustomeronboardingapp.activity.utils;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.graphics.Color;
import android.view.inputmethod.InputMethodManager;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.google.android.material.snackbar.Snackbar;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class TrustMethods extends Activity {
    public static void showSnackBarMessage(String message, CoordinatorLayout coordinatorLayout) {
        Snackbar snackbar = Snackbar.make(coordinatorLayout, message, 7000);
        snackbar.setActionTextColor(Color.RED);
        snackbar.show();
    }

    public static String convertUnixDateToDate(String date){
        if (date==null || date.trim().isEmpty() || date.equals("null")){
            return "";
        }else {
            String unixdate = date.replaceAll("[^0-9-]", "");
            long millis = Long.parseLong(unixdate);
            Instant instant = Instant.ofEpochMilli(millis);
            ZonedDateTime zdt = instant.atZone(ZoneId.systemDefault()); // Use device's default timezone
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            return zdt.format(formatter);
        }
    }

    public static void showDatePickerDialog(EditText text) {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog datePickerDialog = new DatePickerDialog(text.getContext(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                String date = dayOfMonth + "/" + (monthOfYear + 1) + "/" + year;
                text.setText(date);
            }
        }, year, month, day);

        datePickerDialog.show();
    }

    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        if (imm != null && activity.getCurrentFocus() != null) {
            imm.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
        }
    }

    public static String convertToWords(String amt) {
        if (amt == null || amt.trim().isEmpty() || amt.equals("null")) return "";

        String[] parts = amt.split("\\.");
        long rupees = Long.parseLong(parts[0]);
        int paisa = (parts.length > 1) ? Integer.parseInt((parts[1] + "00").substring(0, 2)) : 0;

        String rupeePart = (rupees == 0) ? "Zero" : convertThreeDigitGroup(rupees);
        String result = "Rupees" + (rupees != 1 ? "s " : " ") + rupeePart.trim();

        if (paisa > 0) {
            String paisaPart = convertThreeDigitGroup(paisa).trim();
            result += " and " + paisaPart + " Paisa";
        }

        return result + " Only";
    }

    private static String convertThreeDigitGroup(long num) {
        if (num == 0) return "";

        String[] units = {
                "", "One", "Two", "Three", "Four", "Five", "Six", "Seven",
                "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen",
                "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"
        };

        String[] tens = {
                "", "", "Twenty", "Thirty", "Forty", "Fifty",
                "Sixty", "Seventy", "Eighty", "Ninety"
        };

        String[] multiplier = {
                "", "Thousand", "Lakh", "Crore" // Indian numbering system
        };

        StringBuilder result = new StringBuilder();
        int group = 0;

        while (num > 0) {
            int value;
            if (group == 1) {
                value = (int)(num % 100);
                num /= 100;
            } else {
                value = (int)(num % 1000);
                num /= 1000;
            }

            if (value != 0) {
                StringBuilder temp = new StringBuilder();

                int hundreds = value / 100;
                int remainder = value % 100;

                if (hundreds != 0) {
                    temp.append(units[hundreds]).append(" Hundred");
                    if (remainder != 0) temp.append(" And ");
                    else temp.append(" ");
                }

                if (remainder >= 20) {
                    temp.append(tens[remainder / 10]).append(" ");
                    if (remainder % 10 != 0) {
                        temp.append(units[remainder % 10]).append(" ");
                    }
                } else if (remainder > 0) {
                    temp.append(units[remainder]).append(" ");
                }

                if (!multiplier[group].isEmpty()) {
                    temp.append(multiplier[group]).append(" ");
                }

                result.insert(0, temp);
            }

            group++;
        }

        return result.toString();
    }
}
