package com.trust.pmegpcustomeronboardingapp.activity.utils;

import android.text.Editable;
import android.text.TextWatcher;

/**
 * A simple TextWatcher to reduce boilerplate code.
 * Only override afterTextChanged if you just want to react to text changes.
 */
public abstract class SimpleTextWatcher implements TextWatcher {
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        // No need to implement
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        // No need to implement
    }

    @Override
    public abstract void afterTextChanged(Editable s);
}

