package me.rohanpeshkar.helpersample;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;


import me.rohanpeshkar.helper.HelperActivity;

/**
 * Created by rohan on 9/28/17.
 */

public class SecondActivity extends HelperActivity {

    @Override
    protected void create() {
        setTitle(AppConstants.TITLE_SECOND);

        //Show Back Button on Toolbar
        enableHome();

        //Take data from intent if present
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String value = bundle.getString(AppConstants.KEY_INTENT_EXTRA);
            showToast(value);
        }

        loadFragment();
    }

    private void loadFragment() {
        //Load Fragment
        SampleFragment sampleFragment = new SampleFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fml_fragment, sampleFragment);
        fragmentTransaction.commit();
    }

    @Override
    protected Activity getActivity() {
        return this;
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_second;
    }

    @Override
    protected boolean isToolbarPresent() {
        return true;
    }
}
