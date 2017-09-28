package me.rohanpeshkar.helpersample;

import android.support.v4.app.Fragment;

import butterknife.OnClick;
import me.rohanpeshkar.helper.HelperFragment;

/**
 * This class is a SampleFragment class created by extending HelperFragment
 * Created by Rohan on 9/27/17.
 */

public class SampleFragment extends HelperFragment {


    @Override
    protected void start() {
        /* Actual logic for fragment goes here, the code
         which is written in onCreateView() */
    }

    @Override
    protected Fragment getFragment() {
        return this;
    }

    @OnClick(R.id.btn_show_toast)
    void onClickShowToast() {
        //Directly called showToast method
        showToast(AppConstants.TOAST_MSG_FRAGMENT);
    }

    @OnClick(R.id.btn_show_progress)
    void onClickShowProgress() {
        //Showing progress dialog
        showProgressDialog(AppConstants.PROGRESS_MSG_FRAGMENT, true);
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_sample;
    }
}
