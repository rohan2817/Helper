package me.rohanpeshkar.helper;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import butterknife.ButterKnife;

/**
 * This is Abstract HelperActivity, it contains boilerplate code necessary for creating a
 * new activity. A new activity should be created by extending HelperActivity which will help in
 * setting the layout, initializing ButterKnife for binding views. This class also has methods which
 * can come handy if there is need to show a toast, progress dialog or go to a new activity. It avoids
 * writing of the boilerplate code and use direct methods given. Details about every method can be
 * found at corresponding method.
 * Created by Rohan on 9/27/17.
 */

public abstract class HelperActivity extends AppCompatActivity {

    /**
     * Toolbar Layout to use this you need to include default_toolbar in your activity
     */
    Toolbar mToolbar;

    /**
     * Progress dialog to show a progress dialog, deprecated currently
     */
    private ProgressDialog mProgressDialog;

    /* Static block to handle vector images */
    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ButterKnife.bind(getActivity());
        configureToolbar();
        create();
    }

    /**
     * Abstract Method to get activity instance, needs to be
     * implemented by child class
     *
     * @return - Implementing Activity instance
     */
    protected abstract Activity getActivity();

    /**
     * Abstract Method to get layout file to set the view, avoids to write
     * setContentView in every activity, needs to be implemented by child class
     *
     * @return - Layout File value for the implementing activity
     */
    protected abstract
    @LayoutRes
    int getLayout();

    /**
     * Abstract Method to confirm whether toolbar is to be configured or not,
     * needs to be implemented by child activity. If returned true toolbar will be configured
     * if returned false toolbar will not be configured. If passed true, {@code default_toolbar}
     * should be included in layout.
     *
     * @return - Boolean value
     */
    protected abstract boolean isToolbarPresent();

    /**
     * Abstract method called in Base OnCreate, actual logic of OnCreate of child activity
     * to be written in this method
     */
    protected abstract void create();

    /**
     * Method to configure toolbar, this will set toolbar as support action bar
     * if {@code isToolbarPresent()} returns true.
     */
    private void configureToolbar() {
        if (isToolbarPresent()) {
            mToolbar = findViewById(R.id.default_toolbar);
            setSupportActionBar(mToolbar);
        }
    }

    /**
     * Method to set title on the configured supportActionBar/Toolbar
     *
     * @param title - String title to be set
     */
    protected void setTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    /**
     * Method to enable back button on activity action bar, this will work if
     * {@code parentActivity} is defined in {@code AndroidManifest.xml}
     */
    protected void enableHome() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    /**
     * Method to launch new activity, this method will save hassle of creating new intent object
     * every time. It can be used directly as {@code goTo(SampleActivity.class)}
     *
     * @param clazz - Class object of the activity to launch
     */
    protected void launch(Class clazz) {
        getActivity().startActivity(new Intent(getActivity(), clazz));
    }

    /**
     * Method to get new intent of an activity to launch, used when there is need to pass some
     * extras to new activity. It returns Intent object for an activity to be launched.
     *
     * @param clazz - Class object of the activity to get intent
     * @return - Intent Object
     */
    protected Intent getNewIntent(Class clazz) {
        return new Intent(getActivity(), clazz);
    }

    /**
     * Method to show toast, can be used from activity directly
     *
     * @param message - Message to show
     */
    protected void showToast(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    /**
     * Method to show toast with customised time i.e LONG or SHORT.
     *
     * @param message - Message to show
     * @param length  - SHORT or LONG, must be {@code Toast.LENGTH_SHORT} or {@code Toast.LENGTH_LONG}
     */
    protected void showToast(String message, int length) {
        Toast.makeText(getActivity(), message, length).show();
    }

    /**
     * Method to show progress dialog with message and isCancelable boolean, uses the deprecated
     * Progress Dialog as of now.
     *
     * @param message      - Message to display on progress dialog
     * @param isCancelable - isCancelable boolean value
     */
    protected void showProgressDialog(String message, boolean isCancelable) {
        mProgressDialog = new ProgressDialog(getActivity());
        mProgressDialog.setCancelable(isCancelable);
        mProgressDialog.setMessage(message);
        mProgressDialog.show();
    }

    /**
     * Method to dismiss the progress dialog, checks for the condition that {@code showProgress()}
     * method is called and activity is not finishing to avoid exceptions
     */
    protected void dismissProgressDialog() {
        if (mProgressDialog != null && !getActivity().isFinishing()) {
            mProgressDialog.dismiss();
        }
    }

    /**
     * Method to handle on click of back button, avoiding launching of previous activity again
     *
     * @param item - Menu Item
     * @return - boolean
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            getActivity().onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
