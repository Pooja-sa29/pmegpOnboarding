package com.trust.pmegpcustomeronboardingapp.activity.utils;

import android.view.View;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

public class Validator {

    public static void scrollToView(ScrollView scrollView, View view) {
        // Post ensures scrolling happens after layout
        scrollView.post(() -> scrollView.smoothScrollTo(0, view.getTop()));
    }
    public static boolean isEmpty(EditText editText, String errorMsg,ScrollView scrollView) {
        String value = editText.getText().toString().trim();
        if (value.isEmpty()) {
            editText.setError(errorMsg);
            editText.requestFocus();
            scrollToView(scrollView, editText);

            return false; // invalid
        }
        return true; // valid
    }

    public static boolean isNumber(EditText editText, String errorMsg,ScrollView scrollView) {
        String value = editText.getText().toString().trim();
        if (value.isEmpty()) {
            editText.setError(errorMsg);
            editText.requestFocus();
            scrollToView(scrollView, editText);
            return false;
        }
        try {
            Double.parseDouble(value);
            return true; // valid
        } catch (NumberFormatException e) {
            editText.setError(errorMsg);
            editText.requestFocus();
            return false; // invalid
        }
    }

    public static boolean isEmail(EditText editText, String errorMsg,ScrollView scrollView) {
        String value = editText.getText().toString().trim();
        if (value.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(value).matches()) {
            editText.setError(errorMsg);
            editText.requestFocus();
            scrollToView(scrollView, editText);

            return false; // invalid
        }
        return true; // valid
    }

    public static boolean isSpinnerSelected(Spinner spinner, String errorMsg) {
        if (spinner.getSelectedItemPosition() == 0) {
            // Prevent crash if view is null
            TextView errorText = (TextView) spinner.getSelectedView();
            if (errorText != null) {
                errorText.setError(errorMsg);
            }
            spinner.requestFocus();
            return false; // invalid
        }
        return true; // valid
    }
}
