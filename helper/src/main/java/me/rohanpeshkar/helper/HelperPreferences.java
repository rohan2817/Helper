package me.rohanpeshkar.helper;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by rohan on 9/27/17.
 */

public class HelperPreferences {

    private static final String PREFERENCE_NAME = "helper_preferences";

    private static HelperPreferences instance;

    private SharedPreferences mSharedPreferences;


    public static HelperPreferences get(final Context context) {
        if (instance == null) {
            instance = new HelperPreferences(context);
        }
        return instance;
    }

    private HelperPreferences(Context context) {
        mSharedPreferences = context.getSharedPreferences(PREFERENCE_NAME,
                Context.MODE_PRIVATE);
    }

    public void saveString(final String key, final String value) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public void saveInt(final String key, final int value) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public void saveLong(final String key, final long value) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putLong(key, value);
        editor.apply();
    }

    public void saveBoolean(final String key, final boolean value) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public void saveFloat(final String key, final float value) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putFloat(key, value);
        editor.apply();
    }

    public void clear() {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.clear();
        editor.apply();
    }

    public String getString(final String key) {
        return mSharedPreferences.getString(key, null);
    }

    public long getLong(final String key) {
        return mSharedPreferences.getLong(key, 0L);
    }

    public int getInt(final String key) {
        return mSharedPreferences.getInt(key, 0);
    }

    public double getFloat(final String key) {
        return mSharedPreferences.getFloat(key, 0.0F);
    }

    public boolean getBoolean(final String key) {
        return mSharedPreferences.getBoolean(key, false);
    }
}
