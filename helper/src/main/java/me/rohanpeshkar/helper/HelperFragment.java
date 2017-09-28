package me.rohanpeshkar.helper;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatDelegate;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import butterknife.ButterKnife;

/**
 * This is Abstract HelperFragment, it contains boilerplate code necessary for creating a
 * new fragment. A new fragment should be created by extending HelperFragment which will help in
 * setting the layout, initializing ButterKnife for binding views. This class also has methods which
 * can come handy if there is need to show a toast or go to a new activity. It avoids
 * writing of the boilerplate code and use direct methods given. Details about every method can be
 * found at corresponding method.
 * Created by Rohan on 9/27/17.
 */

public abstract class HelperFragment extends Fragment {

    /**
     * Progress dialog to show a progress dialog, deprecated currently
     */
    private ProgressDialog mProgressDialog;


    /*Static block for handling vector images */
    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(getLayout(), container, false);
        ButterKnife.bind(getFragment(), rootView);
        start();
        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    /**
     * Abstract Method to get fragment instance, needs to be
     * implemented by child class fragment.
     *
     * @return - Fragment instance
     */
    protected abstract Fragment getFragment();

    /**
     * Abstract Method to start the actual functionality of fragment, avoids writing of
     * {@code onCreateView()} method. This method needs to be implemented by child class fragment
     */
    protected abstract void start();

    /**
     * Abstract Method to get layout file to set the view, avoids writing of code to
     * inflate the layout view in every fragment,  needs to be implemented by child class.
     *
     * @return - Layout resource id to set the view
     */
    protected abstract
    @LayoutRes
    int getLayout();

    /**
     * Method to launch new activity, this method will save hassle of creating new intent object
     * every time. It can be used directly as {@code goTo(SampleActivity.class)}
     *
     * @param clazz - Class object of the activity to launch
     */
    protected void launch(Class clazz) {
        Intent intent = new Intent(getFragment().getActivity(), clazz);
        startActivity(intent);
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
     * Method to show toast, can be used from fragment directly
     *
     * @param message - Message to show
     */
    protected void showToast(String message) {
        Toast.makeText(getFragment().getActivity(), message, Toast.LENGTH_SHORT).show();
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
        mProgressDialog = new ProgressDialog(getFragment().getActivity());
        mProgressDialog.setCancelable(isCancelable);
        mProgressDialog.setMessage(message);
        mProgressDialog.show();
    }

    /**
     * Method to dismiss the progress dialog, checks for the condition that {@code showProgress()}
     * method is called and activity is not finishing to avoid exceptions
     */
    protected void dismissProgressDialog() {
        if (mProgressDialog != null && !getFragment().getActivity().isFinishing()) {
            mProgressDialog.dismiss();
        }
    }

}
