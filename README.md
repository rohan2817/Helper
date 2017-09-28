# Helper
An android library containing most of the helper classes every android developer needs

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

Helper is hosted currently on maven so need to include maven repo and dependency as given below :

In your project's `build.gradle` file include as :
```gradle
allprojects {
    repositories {
        jcenter()
        //Other Urls
        maven { url 'https://dl.bintray.com/rohan2817/maven' }
    }
}
```
In your app's `build.gradle` file include as :
```gradle
dependencies{
    //Other dependecies...
    compile 'me.rohanpeshkar.helper:helper:0.0.1'
}
```

## Usage

