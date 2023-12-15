package com.example.salon;
import android.app.Activity;
import android.content.Intent;
public class NavigationManager {
    public static void navigateToNotifications(Activity currentActivity) {
        Intent intent = new Intent(currentActivity, NotiActivity.class);
        currentActivity.startActivity(intent);
    }
    public static void navigateToHome(Activity currentActivity) {
        Intent intent = new Intent(currentActivity, HomeActivity.class);
        currentActivity.startActivity(intent);
    }
    public static void navigateToCart(Activity currentActivity) {
        Intent intent = new Intent(currentActivity, Shopping.class);
        currentActivity.startActivity(intent);
    }
    public static void navigateToHistory(Activity currentActivity) {
        Intent intent = new Intent(currentActivity, History.class);
        currentActivity.startActivity(intent);
    }
    public  static  void navigateToProfile (Activity currenActivity) {
        Intent intent = new Intent(currenActivity, Profile.class);
        currenActivity.startActivity(intent);
    }

}
