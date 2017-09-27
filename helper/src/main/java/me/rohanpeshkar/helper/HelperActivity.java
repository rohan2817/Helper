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
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by rohan on 9/27/17.
 */

public abstract class HelperActivity extends AppCompatActivity {

    @Nullable
    @BindView(R2.id.default_toolbar)
    Toolbar mToolbar;

    private ProgressDialog mProgressDialog;

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

    protected abstract Activity getActivity();

    protected abstract
    @LayoutRes
    int getLayout();

    protected abstract boolean isToolbarPresent();

    protected abstract void create();

    private void configureToolbar() {
        if (isToolbarPresent() && mToolbar != null)
            setSupportActionBar(mToolbar);
    }

    protected void setTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    protected void enableHome() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    protected void goTo(Class clazz) {
        getActivity().startActivity(new Intent(getActivity(), clazz));
    }

    protected Intent getNewIntent(Class clazz) {
        return new Intent(getActivity(), clazz);
    }

    protected void showToast(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    protected void showToast(String message, int length) {
        Toast.makeText(getActivity(), message, length).show();
    }

    protected void showProgressDialog(String message, boolean isCancelable) {
        mProgressDialog = new ProgressDialog(getActivity());
        mProgressDialog.setCancelable(isCancelable);
        mProgressDialog.setMessage(message);
        mProgressDialog.show();
    }

    protected void dismissProgressDialog() {
        if (mProgressDialog != null && !getActivity().isFinishing()) {
            mProgressDialog.dismiss();
        }
    }
}
