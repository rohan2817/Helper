package me.rohanpeshkar.helpersample;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;

import butterknife.OnClick;
import me.rohanpeshkar.helper.HelperActivity;
import me.rohanpeshkar.helper.HelperPreferences;
import me.rohanpeshkar.helper.HelperUtils;

/**
 * This class is sample activity extending from HelperActivity
 * Created by rohan on 9/27/17.
 */

public class HomeActivity extends HelperActivity {

    @Override
    protected void create() {
        //Write code for actual activity functionality, no need of writing any other initializations

        //Set title to actionBar/toolbar
        setTitle(AppConstants.TITLE_HOME);
    }

    @OnClick(R.id.btn_show_toast)
    void onClickShowToast() {
        //Directly called showToast method
        showToast(AppConstants.TOAST_MSG_ACTIVITY);
    }

    @OnClick(R.id.btn_show_progress)
    void onClickShowProgress() {
        //Showing progress dialog
        showProgressDialog(AppConstants.PROGRESS_MSG_ACTIVITY, true);
    }

    @OnClick(R.id.btn_save_string)
    void onClickSaveString() {
        //Save String to preferences
        HelperPreferences.get(this).saveString(AppConstants.KEY_STRING, AppConstants.VALUE_STRING);
    }

    @OnClick(R.id.btn_get_string)
    void onClickGetString() {

        //Get String from preferences
        String valueForKey = HelperPreferences.get(this).getString(AppConstants.KEY_STRING);

        if (TextUtils.isEmpty(valueForKey)) {
            showToast(AppConstants.ERROR_VALUE_NOT_PRESENT);
            //Log using HelperUtils
            HelperUtils.logError("Value was null");
        } else {
            showToast(valueForKey);
            //Log using HelperUtils
            HelperUtils.logInfo(valueForKey);
        }

    }

    @OnClick(R.id.btn_clear)
    void onClickClearPreferences() {
        //Clear all the shared preferences
        HelperPreferences.get(this).clear();
    }

    @OnClick(R.id.btn_launch_new)
    void onClickLaunchNew() {
        //Directly SecondActivity using launch method
        launch(SecondActivity.class);
    }

    @OnClick(R.id.btn_launch_new_with_extra)
    void onClickLaunchNewWithExtra() {
        //Get Intent, add extra and launch activity
        Intent secondIntent = getNewIntent(SecondActivity.class);
        secondIntent.putExtra(AppConstants.KEY_INTENT_EXTRA, AppConstants.VALUE_INTENT_EXTRA);
        startActivity(secondIntent);
    }


    @Override
    protected Activity getActivity() {
        return this;
    }

    @Override
    protected int getLayout() {
        //Returning layout resource id for layout of this activity
        return R.layout.activity_home;
    }

    @Override
    public boolean isToolbarPresent() {
        //Returning true as toolbar is needed
        return true;
    }

}
