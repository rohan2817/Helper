# Helper
An android library containing most of the helper classes every android developer needs

![Current Version](https://img.shields.io/badge/currentVersion-0.0.1-green.svg)   ![Minimum SDK](https://img.shields.io/badge/minSdkVersion-14-orange.svg)

## The Problem
Every Android developer faces few problems while developing Android Apps. Listing down some of them, which I have faced everytime I create a new android project. 

1. The problem of writing boilerplate code while creating Activities, Fragments is annoying. 
2. Need of readymade methods which can come handy such as showing a toast, or showing a progress dialog or launching a new activity.
3. The problem of applying proper styles and themes to activities and handling those for pre-lollipop and post-lollipop.

What if we had a library which takes care of all these problems and let the developers concentrate on writing the actual business logic and create awesome functionalities.

## The Solution

Using the Helper library developer can solve the above mentioned problems. Using this Helper library is pretty simple and is currently in development phase so suggestions are welcomed.

## Pre-requisites

For using this library you need to import `ButterKnife` Library and include Google's Maven repository for latest Support libraries.

You can do that as give below :

In your project's `build.gradle` file include as :
```gradle
allprojects {
    repositories {
        jcenter()
        maven {
            url "https://maven.google.com"
        }
    }
}
```
In your app's `build.gradle` file include as :
```gradle
dependencies{
    //Other dependecies...
    compile 'com.jakewharton:butterknife:<latest-version>'
    annotationProcessor 'com.jakewharton:butterknife-compiler:<latest-version>'
}
```

## Including Helper

Include using gradle dependency
```gradle
dependencies{
    //Other dependecies...
    compile 'me.rohanpeshkar.helper:helper:0.0.1'
}
```

## Usage

### Contents

1. [HelperActivity](https://github.com/rohan2817/Helper#helperactivity)
2. [HelperFragment](https://github.com/rohan2817/Helper#helperfragment)
3. [HelperUtils](https://github.com/rohan2817/Helper#helperutils)
4. [HelperPreferences](https://github.com/rohan2817/Helper#helperpreferences)
5. [HelperStyles](https://github.com/rohan2817/Helper#helperstyles)

## HelperActivity

An abstract activity which can be used to create activities easily without writing the boilerplate code. It comes with methods which are required frequently. It helps in keeping activity's code clean and readable.
Here is sample activity created using `HelperActivity`

```java
public class MainActivity extends HelperActivity {
    @Override
    protected void create() {
        /*Write code for actual activity functionality,
        no need of writing any other initializations*/

        //Set title to actionBar/toolbar
        setTitle("Some Title");
    }

    @Override
    protected Activity getActivity() {
        //Return activity instance
        return this;
    }

    @Override
    protected int getLayout() {
        //Return layout resource id for layout of this activity
        return R.layout.activity_main;
    }

    @Override
    protected boolean isToolbarPresent() {
        //Return true if toolbar is needed
        return true;
    }
}
```

Following is the list of methods readily available in `HelperActivity`

| Method        | Description   |
| :------------- |:-------------| 
|`showToast(String msg)`      | Show a toast for short duration | 
|`showToast(String msg, int length)`      | Show a toast with customised duration i.e `Toast.LONG` or `Toast.SHORT`.      | 
|`setTitle(String title)` | Set title to actionbar/toolbar      |
|`enableHome()`| Enable back button on action bar, this will work if `parentActivity` is defined in `AndroidManifest.xml` |
|`launch(Class clazz)` | Launch a new activity, this method will save hassle of creating new intent object every time. Accepts a `.class` of new activity |
| `getNewIntent(Class clazz)`|Get a new intent of an activity to launch, used when there is a need to pass extras to new activity. It returns Intent object for an activity to be launched.|
|`showProgressDialog(String message, boolean isCancelable)` | Show a progress dialog with message and `isCancelable` boolean, uses the deprecated Progress Dialog as of now.|
|`dismissProgressDialog()` | Dismiss the progress dialog, checks for the condition that `showProgressDialog()` method is called and activity is not finishing to avoid any exceptions.|

More details at [HelperActivity.java](https://github.com/rohan2817/Helper/blob/master/helper/src/main/java/me/rohanpeshkar/helper/HelperActivity.java)

## HelperFragment

An abstract fragment which can be used to create fragments faster without writing the boilerplate code. It comes with methods which are required frequently. It helps in keeping fragment's code clean and readable.
Here is sample fragment created using `HelperFragment`

```java
public class SampleFragment extends HelperFragment {
    @Override
    protected void start() {
        /* Actual logic for fragment goes here, the code
         which is written in onCreateView() */
    }

    @Override
    protected Fragment getFragment() {
        //Return instance of fragment
        return this;
    }

    @Override
    protected int getLayout() {
        //Return layout resource id for fragment layout
        return R.layout.layout_fragment_sample;
    }
}
```

Following is the list of methods readily available in `HelperFragment`

| Method        | Description   |
| :------------- |:-------------| 
|`showToast(String msg)`      | Show a toast for short duration | 
|`showToast(String msg, int length)`      | Show a toast with customised duration i.e `Toast.LONG` or `Toast.SHORT`.      | 
|`launch(Class clazz)` | Launch a new activity, this method will save hassle of creating new intent object every time. Accepts a `.class` of new activity |
| `getNewIntent(Class clazz)`|Get a new intent of an activity to launch, used when there is a need to pass extras to new activity. It returns Intent object for an activity to be launched.|
|`showProgressDialog(String message, boolean isCancelable)` | Show a progress dialog with message and `isCancelable` boolean, uses the deprecated Progress Dialog as of now.|
|`dismissProgressDialog()` | Dismiss the progress dialog, checks for the condition that `showProgressDialog()` method is called and activity is not finishing to avoid any exceptions.|

More details at [HelperFragment.java](https://github.com/rohan2817/Helper/blob/master/helper/src/main/java/me/rohanpeshkar/helper/HelperFragment.java)


## HelperUtils

An utility class containing utility methods like method write log, check permissions for Android M & above, hide & show keyboard.

Following is the list of methods readily available in `HelperUtils`

| Method        | Description   |
| :------------- |:-------------| 
|`logError(String error)`|Log an error message to `Logcat`|
|`logDebug(String debug)`|Log a debug message to `Logcat`|
|`logVerbose(String verbose)`|Log a verbose message to `Logcat`|
|`logInfo(String info)`|Log an info message to `Logcat`|
|`updateTag(String customTag)`|Update the log tag value|
|`hasPermissions(Context context, String... permissions)`|Check whether App has permissions, it is executed if android M & above. Accepts an array of permissions.|
|`getManifestPermissions(@NonNull final Activity activity)`|Retrieves all the permissions declared in the application's manifest. It returns a non null array of permissions that can be declared.|
|`hideKeyboard(View view, Context context)`|Hide soft keyboard from any view|
|`showKeyboard(View view, Context context)`|Method to forcefully show the soft keyboard.|

More details at [HelperUtils.java](https://github.com/rohan2817/Helper/blob/master/helper/src/main/java/me/rohanpeshkar/helper/HelperUtils.java)

## HelperPreferences

Most widely used way to store key values in local storage in android is use of `SharedPreferences`. To make it easy to store and retrieve values from `SharedPreferences` this class will come in handy.

Here is example of how to use this class :
```java
//Save String to Preferences
HelperPreferences.get(this).saveString("SomeKey","SomeValue");

//Get String from Preferences
String valueForKey = HelperPreferences.get(this).getString("SomeKey");

//Clear all the shared preferences
HelperPreferences.get(this).clear();
```

Following is the list of methods readily available in `HelperPreferences`

| Method        | Description   |
| :------------- |:-------------| 
|`get(Context context)`| Get Singleton instance of class|
|`saveString(String key, String value)`|Store `String` value corresponding to a key|
|`saveInt(String key, int value)`|Store `int` value corresponding to a key|
|`saveLong(String key, long value)`|Store `long` value corresponding to a key|
|`saveFloat(String key, float value)`|Store `float` value corresponding to a key|
|`saveBolean(String key, boolean value)`|Store `boolean` value corresponding to a key|
|`getString(String key)`|Get `String` value from preferences for a given Key|
|`getInt(int key)`|Get `int` value from preferences for a given Key|
|`getLong(long key)`|Get `long` value from preferences for a given Key|
|`getFloat(float key)`|Get `float` value from preferences for a given Key|
|`getBoolean(boolean key)`|Get `boolean` value from preferences for a given Key|
|`clear()`|Clear all the shared preferences stored, comes handy in scenarios like logout|

More details at [HelperPreferences.java](https://github.com/rohan2817/Helper/blob/master/helper/src/main/java/me/rohanpeshkar/helper/HelperPreferences.java)

## HelperStyles

Finding the correct styles for different use cases is difficult, to solve this ready Helper styles can be used. Included styles take care of pre-lollipop & post-lollipop devices.

Following is the list of styles available 

| Method        | Description   |
| :------------- |:-------------| 
|`HelperTheme`| App theme which takes care for pre-lollipop & above lollipop devices|
|`HelperTheme.FullScreen`|Theme which makes any activity full screen|
|`HelperTheme.Transperant`|Theme which can be used to make any activity transparent|

More Details at [HelperStyles](https://github.com/rohan2817/Helper/blob/master/helper/src/main/res/values-v21/styles.xml)









