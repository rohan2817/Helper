package me.rohanpeshkar.helper;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * This is SharedPreferences Helper class. Using this class it will be easy to
 * store and retrieve values from SharedPreferences. It has methods to store
 * different data type values
 * Created by Rohan on 9/27/17.
 */

public class HelperPreferences {

    private static final String PREFERENCE_NAME = "helper_preferences";

    private static HelperPreferences instance;

    private SharedPreferences mSharedPreferences;


    /**
     * Method to Get instance of Singleton {@code HelperPreferences } class
     *
     * @param context - Context of the calling activity/application
     * @return - Instance of HelperPreferences
     */
    public static HelperPreferences get(final Context context) {
        if (instance == null) {
            instance = new HelperPreferences(context);
        }
        return instance;
    }

    /**
     * Private Constructor, initializing shared preferences
     *
     * @param context - Context to initialize preferences
     */
    private HelperPreferences(Context context) {
        mSharedPreferences = context.getSharedPreferences(PREFERENCE_NAME,
                Context.MODE_PRIVATE);
    }

    /**
     * Method to store {@code String} value corresponding to a key
     *
     * @param key   - Key
     * @param value - String value to be stored
     */
    public void saveString(final String key, final String value) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    /**
     * Method to store {@code int} value corresponding to a key
     *
     * @param key   - Key
     * @param value - int value to be stored
     */
    public void saveInt(final String key, final int value) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    /**
     * Method to store {@code long} value corresponding to a key
     *
     * @param key   - Key
     * @param value - long value to be stored
     */
    public void saveLong(final String key, final long value) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putLong(key, value);
        editor.apply();
    }

    /**
     * Method to store {@code boolean} value corresponding to a key
     *
     * @param key   - Key
     * @param value - boolean value to be stored
     */
    public void saveBoolean(final String key, final boolean value) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    /**
     * Method to store {@code float} value corresponding to a key
     *
     * @param key   - Key
     * @param value - Float value to be stored
     */
    public void saveFloat(final String key, final float value) {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putFloat(key, value);
        editor.apply();
    }

    /**
     * Method to clear all the shared preferences stored, this will be helpful in
     * scenarios like logout
     */
    public void clear() {
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.clear();
        editor.apply();
    }

    /**
     * Method to get {@code String} value from preferences for a given Key
     *
     * @param key - Key to fetch the value
     * @return - Actual value, returns null if not found
     */
    public String getString(final String key) {
        return mSharedPreferences.getString(key, null);
    }

    /**
     * Method to get {@code long} value from preferences for a given Key
     *
     * @param key - Key to fetch the value
     * @return - Actual value, returns 0 if not found
     */
    public long getLong(final String key) {
        return mSharedPreferences.getLong(key, 0L);
    }

    /**
     * Method to get {@code int} value from preferences for a given Key
     *
     * @param key - Key to fetch the value
     * @return - Actual value, returns 0 if not found
     */
    public int getInt(final String key) {
        return mSharedPreferences.getInt(key, 0);
    }

    /**
     * Method to get {@code float} value from preferences for a given Key
     *
     * @param key - Key to fetch the value
     * @return - Actual value, returns 0 if not found
     */
    public double getFloat(final String key) {
        return mSharedPreferences.getFloat(key, 0.0F);
    }

    /**
     * Method to get {@code boolean} value from preferences for a given Key
     *
     * @param key - Key to fetch the value
     * @return - Actual value, returns false if not found
     */
    public boolean getBoolean(final String key) {
        return mSharedPreferences.getBoolean(key, false);
    }
}
