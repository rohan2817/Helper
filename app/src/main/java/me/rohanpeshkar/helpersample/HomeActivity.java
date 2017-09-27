package me.rohanpeshkar.helpersample;

import android.app.Activity;

import me.rohanpeshkar.helper.HelperActivity;

/**
 * Created by rohan on 9/27/17.
 */

public class HomeActivity extends HelperActivity {

    @Override
    protected void create() {

    }

    @Override
    protected Activity getActivity() {
        return this;
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_home;
    }

    @Override
    public boolean isToolbarPresent() {
        return true;
    }

}
