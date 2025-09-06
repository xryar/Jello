package com.example.jello.navigator

import android.content.Context
import android.content.Intent
import com.example.auth.MainActivity
import com.example.home.HomeActivity
import com.example.navigator.Navigator

class AppNavigator @Inject constructor() : Navigator {

    override fun navigateToFeatureHome(context: Context) {
        val intent = Intent(context, HomeActivity::class.java)
        context.startActivity(intent)
    }

    override fun navigateToFeatureAuth(context: Context) {
        val intent = Intent(context, MainActivity::class.java)
        context.startActivity(intent)
    }

}