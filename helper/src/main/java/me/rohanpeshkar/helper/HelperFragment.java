package me.rohanpeshkar.helper;

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
 * Created by rohan on 9/27/17.
 */

public abstract class HelperFragment extends Fragment {

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

    protected abstract Fragment getFragment();

    protected abstract void start();

    protected abstract
    @LayoutRes
    int getLayout();

    protected void goTo(Class clazz) {
        Intent intent = new Intent(getFragment().getActivity(), clazz);
        startActivity(intent);
    }

    protected void showToast(String message) {
        Toast.makeText(getFragment().getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    protected void showToast(String message, int length) {
        Toast.makeText(getActivity(), message, length).show();
    }

}
