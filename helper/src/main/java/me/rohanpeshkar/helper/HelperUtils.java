package me.rohanpeshkar.helper;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is a Utility class, it contains most of the utility methods that are required by developers.
 * It has methods to print log to console, checking permissions for android 6 and above,
 * handling soft keyboard. Detailed use of methods can be seen on methods.
 * Created by Rohan on 9/27/17.
 */

public class HelperUtils {

    private static String LOG_TAG = "HelperLog";

    /**
     * Method to update the log tag value, current is HelperLog
     *
     * @param customTag - String Custom tag to be updated
     */
    public static void updateTag(String customTag) {
        if (!TextUtils.isEmpty(customTag)) {
            LOG_TAG = customTag;
        }
    }

    /**
     * Method to log error to logcat
     *
     * @param error - String error
     */
    public static void logError(String error) {
        Log.e(LOG_TAG, error);
    }

    /**
     * Method to log debug message to logcat
     *
     * @param debug - String message
     */
    public static void logDebug(String debug) {
        Log.d(LOG_TAG, debug);
    }

    /**
     * Method to log verbose message to logcat
     *
     * @param verbose - String message
     */
    public static void logVerbose(String verbose) {
        Log.v(LOG_TAG, verbose);
    }

    /**
     * Method to log info message to logcat
     *
     * @param info - String message
     */
    public static void logInfo(String info) {
        Log.i(LOG_TAG, info);
    }


    /**
     * Method to check whether App has permissions, it is executed if android version is 6 & above
     * Need to send array of permissions.
     *
     * @param context     -  context of the activity
     * @param permissions - permissions array
     * @return - Has permissions or not
     */
    public static boolean hasPermissions(Context context, String... permissions) {
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && context != null &&
                permissions != null) {
            for (String permission : permissions) {
                if (ActivityCompat.checkSelfPermission(context, permission)
                        != PackageManager.PERMISSION_GRANTED) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * This method retrieves all the permissions declared in the application's manifest.
     * It returns a non null array of permissions that can be declared.
     *
     * @param activity the Activity necessary to check what permissions we have.
     * @return a non null array of permissions that are declared in the application manifest.
     */
    @NonNull
    public static synchronized String[] getManifestPermissions(@NonNull final Activity activity) {
        PackageInfo packageInfo = null;
        List<String> list = new ArrayList<String>(1);
        try {
            packageInfo = activity.getPackageManager().getPackageInfo(activity.getPackageName(),
                    PackageManager.GET_PERMISSIONS);
        } catch (PackageManager.NameNotFoundException e) {
            logError(e.getMessage());
        }
        if (packageInfo != null) {
            String[] permissions = packageInfo.requestedPermissions;
            if (permissions != null) {
                Collections.addAll(list, permissions);
            }
        }
        return list.toArray(new String[list.size()]);
    }

    /**
     * Method to hide soft keyboard from any view
     *
     * @param view    - View from which Keyboard to hide
     * @param context - Context of the calling activity
     */
    public static void hideKeyboard(View view, Context context) {
        InputMethodManager
                inputMethodManager = (InputMethodManager) context.getSystemService(
                Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    /**
     * Method to forcefully show the soft keyboard.
     *
     * @param view    - View on which keyboard is to be shown
     * @param context - Context of the calling activity
     */
    public static void showKeyboard(View view, Context context) {
        InputMethodManager inputMethodManager = (InputMethodManager)
                context.getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.showSoftInput(view, InputMethodManager.SHOW_FORCED);
    }


}
