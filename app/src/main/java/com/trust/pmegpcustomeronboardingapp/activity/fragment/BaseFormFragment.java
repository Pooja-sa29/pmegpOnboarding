package com.trust.pmegpcustomeronboardingapp.activity.fragment;

import androidx.fragment.app.Fragment;

import com.trust.pmegpcustomeronboardingapp.activity.Interface.FragmentNavigationListener;


public class BaseFormFragment extends Fragment {

    protected FragmentNavigationListener navigationListener;

    public void setNavigationListener(FragmentNavigationListener listener) {
        this.navigationListener = listener;
    }
}
