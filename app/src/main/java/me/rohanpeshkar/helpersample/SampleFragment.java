package me.rohanpeshkar.helpersample;

import android.support.v4.app.Fragment;

import me.rohanpeshkar.helper.HelperFragment;

/**
 * Created by rohan on 9/27/17.
 */

public class SampleFragment extends HelperFragment {


    @Override
    protected Fragment getFragment() {
        return this;
    }

    @Override
    protected void start() {

    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_sample;
    }
}
