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

This is the abstract activity which can be used to create activities with different methods included.It helps making activity's code clean and readable.

## HelperFragment

This is the abstract fragment which can be used to create fragments faster without writing the boilerplate code and has different methods which can come handy. It helps making fragment's code clean and readable.

## HelperUtils

This is an utility class which contains different utility methods to write log, check permissions for Android M & above, hide & show keyboard.

## HelperPreferences

Most widely used way to store key values in local storage in android is use of `SharedPreferences`. To make it easy to store and retrieve values from `SharedPreferences` this class will come in handy.

## HelperStyles

Finding the correct styles for different use cases is difficult, to solve this ready Helper styles can be used. Included styles take care of pre-lollipop & post-lollipop devices.






